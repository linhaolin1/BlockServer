package com.lin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lin.NettyServer;
import com.lin.actions.ProcessAction;
import com.lin.constants.BlockConstant;
import com.lin.dao.*;
import com.lin.entity.*;
import com.lin.nettyserver.http.codec.unspecified.UnspecifiedDecodec;
import com.lin.nettyserver.http.codec.unspecified.UnspecifiedReq;
import com.lin.nettyserver.http.config.IoMapperConfig;
import com.lin.nettyserver.http.config.UrlMapperConfig;
import com.lin.request.req.*;
import com.lin.request.resp.*;
import com.lin.service.ExecuteService;
import com.lin.service.ProcessService;
import com.lin.service.SequenceService;
import com.lin.util.DataloaderInterface;
import com.lin.util.DataloaderPool;
import com.lin.util.EntityListUtil;
import com.lin.util.ParamUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProcessServiceImpl implements ProcessService {

    @Value("${jsPath}")
    String jsPath;

    @Autowired
    ProcessDao processDao;

    @Autowired
    BlockDao blockDao;

    @Autowired
    NextDao nextDao;

    @Autowired
    NextRequirementDao nextRequirementDao;

    @Autowired
    ExecuteDao executeDao;

    @Autowired
    ExecuteService executeService;

    @Autowired
    ProcessArgumentDao processArgumentDao;

    @Autowired
    ExecuteParamDao executeParamDao;

    @Autowired
    ProcessArgumentComplexDao processArgumentComplexDao;

//	@Autowired
//	DynamicRequestDao dynamicRequestDao;

    @Autowired
    SequenceService sequenceService;

    @Autowired
    DataloaderPool dataloaderPool;


    public void executeProcess(ProcessEntity process, DataloaderInterface loader, Long sequenceId)
            throws InvocationTargetException {

        ExportProcessReq req = new ExportProcessReq();
        ExportProcessResp resp = new ExportProcessResp();
        req.setId(process.getId());
        exportProcess(req, resp);

        BlockEntity block = (BlockEntity) EntityListUtil.findFromList(resp.getBlocks(), "id", process.getStartBlock());

        if (block == null) {
            System.out.println("startblock is null, id=" + process.getStartBlock());
        }
        execute(block, loader, sequenceId, resp);
    }

    private void execute(BlockEntity block, DataloaderInterface loader, Long sequenceId, ExportProcessResp resp) throws InvocationTargetException {
        List<NextEntity> nextEntityList;
        while ((nextEntityList = executeService.executeBlock(block, loader, sequenceId, resp)).size() > 0) {

            System.out.println(block.getId());

            block = (BlockEntity) EntityListUtil.findFromList(resp.getBlocks(), "id", nextEntityList.get(0).getValue());
            execute(block, loader, sequenceId, resp);

            List<NextEntity> asyncList = nextEntityList.stream().filter(x -> {
                if (x.getType() > 0) {
                    return true;
                } else {
                    return false;
                }
            }).collect(Collectors.toList());

            for (NextEntity ne : asyncList) {
                new Thread() {
                    public void run() {
                        BlockEntity newBlock = (BlockEntity) EntityListUtil.findFromList(resp.getBlocks(), "id", ne.getValue());
                        DataloaderInterface newLoader = dataloaderPool.claim();
                        for (String key : loader.getKeys()) {
                            newLoader.put(key, loader.get(key));
                        }
                        try {
                            execute(newBlock, newLoader, sequenceId, resp);
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        newLoader.release();
                    }
                }.start();
            }
        }
    }

    @Override
    public void executeProcess(ProcessReq req, ProcessResp resp, Long sequenceId) throws InvocationTargetException {
        // TODO Auto-generated method stub
        Long time = System.currentTimeMillis();

        DataloaderInterface loader = dataloaderPool.claim();
        loader.acquireLock();
        try {
            // DataloaderInterface loader = new JsDataLoader(jsPath);
            sequenceService.save("LOAD JS", 1L, System.currentTimeMillis() - time,
                    req.getProcessId(), null, null, JSON.toJSONString(req.getObject()));
            time = System.currentTimeMillis();
            ProcessEntity process = processDao.findFromTempById(req.getProcessId());


            loader.putAll(req.getObject());
            loader.put(BlockConstant.PROPERITY_KEY_IP, req.getProperty(BlockConstant.PROPERITY_KEY_IP));
            sequenceService.save("LOAD PROCESS", 1L, System.currentTimeMillis() - time,
                    req.getProcessId(), null, null, JSON.toJSONString(req.getObject()));
            time = System.currentTimeMillis();

            executeProcess(process, loader, sequenceId);

            sequenceService.save("EXECUTE PROCESS", 1L, System.currentTimeMillis() - time,
                    req.getProcessId(), null, null, JSON.toJSONString(req.getObject()));
            time = System.currentTimeMillis();
            HashMap map = new HashMap();
            List<ProcessArgumentEntity> args = processArgumentDao.findFromTempByProcess(req.getProcessId());


            for (ProcessArgumentEntity arg : args) {
                if (arg.getType() == BlockConstant.args_type_output) {
                    Object object = loader.parseJsonValue("{" + arg.getName() + "}");
                    map.put(arg.getName(), object);
//                    if (object!=null){
//                        try {
//                            map.put(arg.getName(), JSON.toJSON(object));
//                        } catch (Exception e) {
//                            if (object.toString()!=null){
//                                try {
//                                    map.put(arg.getName(), JSON.parseObject(object.toString()));
//                                }catch (Exception ex){
//                                    map.put(arg.getName(), object.toString());
//                                }
//                            }
//                        }
//                    }
                }
            }
            if (!StringUtils.isBlank(String.valueOf(loader.get(BlockConstant.PROPERITY_KEY_MSG)))) {
                resp.setMsg(String.valueOf(loader.get(BlockConstant.PROPERITY_KEY_MSG)));
            }
            if (!StringUtils.isBlank(String.valueOf(loader.get(BlockConstant.PROPERITY_KEY_RESULT)))) {
                resp.setResult(Integer.parseInt(String.valueOf(loader.get(BlockConstant.PROPERITY_KEY_RESULT))));
            }
            resp.setResponse(map);
            sequenceService.save("OUTPUT PROCESS", 1L, System.currentTimeMillis() - time,
                    req.getProcessId(), null, null, JSON.toJSONString(req.getObject()));
        } finally {
            loader.release();
        }

    }

    @Override
    public void getProcess(GetProcessReq req, GetProcessResp resp) {

        copyFromMainDatabase(req.getId());

        resp.setProcess(processDao.findFromTempById(req.getId()));
        resp.setBlocks(blockDao.findFromTempByProcess(req.getId()));

        List<JSONObject> array = new ArrayList<JSONObject>();
        List<NextEntity> nextList = nextDao.findFromTempByProcess(req.getId());
        for (NextEntity e : nextList) {
            JSONObject ob = (JSONObject) JSON.toJSON(e);
            ob.put("condition", nextRequirementDao.findFromTempByNext(e.getId()));
            array.add(ob);
        }
        resp.setNext(array);
        List<ExecuteEntity> executes = executeDao.findFromTempByBlocks(resp.getBlocks());
        resp.setExecute(executes);

        List<ProcessArgumentEntity> args = processArgumentDao.findFromTempByProcess(req.getId());
        resp.setArgs(args);

        List<ProcessArgumentComplexEntity> complex = processArgumentComplexDao.findByProcess(req.getId());
        resp.setComplex(complex);

    }

    @Override
    public void saveNewProcess(SaveProcessReq req, SaveProcessResp resp) {
        resp.setProcess(saveNewProcess(req.getName()));
    }

    private ProcessEntity saveNewProcess(String name) {
        ProcessEntity process = new ProcessEntity();
        process.setName(name);
        processDao.addToTemp(process);

        BlockEntity startBlock = new BlockEntity();
        BlockEntity endBlock = new BlockEntity();
        startBlock.setProcess(process.getId());
        startBlock.setName(BlockConstant.NAME_BLOCK_START);
        startBlock.setPositionX(160);
        startBlock.setPositionY(80);
        endBlock.setProcess(process.getId());
        endBlock.setName(BlockConstant.NAME_BLOCK_END);
        endBlock.setPositionX(160);
        endBlock.setPositionY(280);
        blockDao.addToTemp(startBlock);
        blockDao.addToTemp(endBlock);

        process.setStartBlock(startBlock.getId());
        process.setEndBlock(endBlock.getId());
        processDao.updateToTemp(process);

//		addNewDynamicRequest("/block-server/dynamic/" + process.getId(), process.getId());
        return process;
    }

    private void addNewDynamicRequest(String url, Integer id) {
//		dynamicRequestDao.deleteByProcess(id);
        if (url.equals("/block-server/"))
            return;

//		dynamicRequestDao.addNewDynamicRequest(url, id);

        IoMapperConfig ioConfig = NettyServer.context.getBean(IoMapperConfig.class);
        UrlMapperConfig urlConfig = NettyServer.context.getBean(UrlMapperConfig.class);
        UnspecifiedDecodec decoder = NettyServer.context.getBean(UnspecifiedDecodec.class);
        urlConfig.addDecodecMapper(url, decoder);
        urlConfig.addClassMapper(url, UnspecifiedReq.class);
        ioConfig.addClass(UnspecifiedReq.class, NettyServer.context.getBean(ProcessAction.class));

        try {
            ioConfig.addMethod(UnspecifiedReq.class, NettyServer.context.getBean(ProcessAction.class).getClass()
                    .getDeclaredMethod("dynamicRequest", UnspecifiedReq.class));
        } catch (BeansException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProcess(DeleteProcessReq req, DeleteProcessResp resp) {
        processDao.deleteFromTemp(req.getProcessId());
    }

    @Override
    public void updateProcess(UpdateProcessReq req, UpdateProcessResp resp) {
        // TODO Auto-generated method stub
        ProcessEntity pe = processDao.findFromTempById(req.getProcessId());
        pe.setName(req.getName());
        pe.setIntro(req.getIntro());
        pe.setUrl(req.getUrl());
        processDao.updateToTemp(pe);
        addNewDynamicRequest("/block-server/" + req.getUrl(), req.getProcessId());

        // processArgumentDao.deleteNotExistArgs(req.getProcessId(),
        // req.getInArgs(), req.getOutArgs());
        //
        // for (ProcessArgumentEntity args : req.getInArgs()) {
        // if (args.getId()==null) {
        // processArgumentDao.addToTemp(args);
        // }
        // }
        //
        // for (ProcessArgumentEntity args : req.getOutArgs()) {
        // if (args.getId() == null) {
        // processArgumentDao.addToTemp(args);
        // }
        // }
        // copyToMainDatabase(req.getProcessId());
        // 查询block临时表 复制到主表
        // 查询next相关临时表 复制到主表
        // 查询execute相关临时表 复制到主表
        // 查询args相关临时表 复制到主表
    }

    private void copyFromMainDatabase(Integer processId) {
        processDao.copyProcessFromMainToTemp(processId);

    }

    private void copyToMainDatabase(Integer processId) {
        processDao.copyProcessFromTempToMain(processId);

    }

    @Override
    public void checkAllLineAvailable(CheckAllLineAvailableReq req, CheckAllLineAvailableResp resp) {
        // TODO Auto-generated method stub
        // 是否都从start起 到end结束
        ProcessEntity process = processDao.findFromTempById(req.getProcessId());
        List<BlockEntity> blocks = blockDao.findFromTempByProcess(req.getProcessId());
        List<NextEntity> nexts = nextDao.findFromTempByProcess(req.getProcessId());
        boolean isNextEnd = isNextEnd(process, getBlock(process.getStartBlock(), blocks), nexts, blocks);
        // 是否存在不可到达的 next
        NextEntity isNextArrived = isConflictNext(nexts);
        // 是否存在没有被处理的next情况
        // 需要定义param的范围

    }

    @Override
    public void checkAllParamAvailable(CheckAllParamAvailableReq req, CheckAllParamAvailableResp resp) {
        // TODO Auto-generated method stub
        // 是否存在没定义的param

        // 如何判断是否允许新值？
        // 如何粗存新值？

        // 允许返回值，不能一次返回多个值
        // 如何设置返回值-》增加一个特殊参数
        ProcessEntity process = processDao.findFromTempById(req.getProcessId());
        List<BlockEntity> blocks = blockDao.findFromTempByProcess(req.getProcessId());
        List<NextEntity> nexts = nextDao.findFromTempByProcess(req.getProcessId());

        for (BlockEntity b : blocks) {
            List<BlockEntity> before = findBeforeBlocks(process, blocks, nexts, b);

        }

    }

    private List<BlockEntity> findBeforeBlocks(ProcessEntity process, List<BlockEntity> blocks, List<NextEntity> nexts,
                                               BlockEntity b) {
        // TODO Auto-generated method stub
        // 查询全部上级线路
        // 全部有线路的block通用param
        // 不通用的block做param交集
        // 查询当前方块里的param里是不是属于上面的param
        // 暂时先这样吧...

        // findAvailableLine(process.getStartBlock(),b.getId(),);

        return null;
    }

    @Override
    public void checkAllBlockAvailable(CheckAllBlockAvailableReq req, CheckAllBlockAvailableResp resp) {
        // TODO Auto-generated method stub
        // 检查是否所有block可到达 除了起始和结束block之外都有连入和连出
        List<BlockEntity> blocks = blockDao.findFromTempByProcess(req.getProcessId());
        List<NextEntity> nexts = nextDao.findFromTempByProcess(req.getProcessId());

        List<BlockEntity> array = new ArrayList<BlockEntity>();
        for (BlockEntity be : blocks) {
            boolean findFrom = false;
            boolean findTo = false;
            for (NextEntity ne : nexts) {
                if (ne.getBlock() == be.getId()) {
                    findTo = true;
                }

                if (ne.getValue() == be.getId()) {
                    findFrom = true;
                }

                if (findFrom && findTo) {
                    break;
                }
            }

            if (!(findFrom && findTo)) {
                array.add(be);
            }
        }

        resp.setArray(array);

    }

    private boolean isNextEnd(ProcessEntity process, BlockEntity be, List<NextEntity> nexts, List<BlockEntity> blocks) {
        List<NextEntity> temp = new ArrayList();
        for (NextEntity n : nexts) {
            if (n.getBlock().equals(be.getId()))
                temp.add(n);
        }

        if (temp.size() == 0 && !be.getId().equals(process.getEndBlock())) {
            return false;
        }

        if (be.getId().equals(process.getEndBlock()))
            return true;

        for (NextEntity n : temp) {
            boolean result = isNextEnd(process, getBlock(n.getValue(), blocks), nexts, blocks);
            if (!result)
                return false;
        }

        return true;
    }

    private BlockEntity getBlock(Integer id, List<BlockEntity> blocks) {
        for (BlockEntity be : blocks) {
            if (be.getId().equals(id))
                return be;
        }
        return null;
    }

    private NextEntity isConflictNext(List<NextEntity> nexts) {
        // 包含？不包含？有交集？ 逆？否？逆否？
        Collections.sort(nexts, new Comparator<NextEntity>() {
            @Override
            public int compare(NextEntity o1, NextEntity o2) {
                // TODO Auto-generated method stub
                return o1.getId().compareTo(o2.getId());
            }
        });

        List<HashMap<String, String>> list = new ArrayList(nexts.size());
        for (int i = 0; i < nexts.size(); i++) {
            // 使param1=参数 param2等于常数
            List<NextRequirementEntity> nres = nextRequirementDao.findFromTempByNext(nexts.get(i).getId());
            // 检查是否该条件已被之前条件包含
            // 区间？
            // 多数组

            HashMap<String, String> map = new HashMap<String, String>();
            for (NextRequirementEntity nr : nres) {

                String param1;
                String param2;
                String method;

                if (ParamUtil.isArgument(nr.getParam1()) && !ParamUtil.isArgument(nr.getParam2())) {
                    param1 = nr.getParam1();
                    param2 = nr.getParam2();
                    method = nr.getMethod();
                } else if (ParamUtil.isArgument(nr.getParam1()) && !ParamUtil.isArgument(nr.getParam2())) {
                    param1 = nr.getParam2();
                    param2 = nr.getParam1();
                    method = ParamUtil.getNegativeMethod(nr.getMethod());
                } else if (!ParamUtil.isArgument(nr.getParam1()) && !ParamUtil.isArgument(nr.getParam2())) {
                    if (ParamUtil.isConflict(nr.getParam1(), nr.getMethod(), nr.getParam2()))
                        return nexts.get(i);
                    else
                        continue;
                } else
                    continue;

                if (map.containsKey(param1 + ":	" + method)) {
                    String value = map.get(param1 + ":	" + method);
                    if (ParamUtil.isConflict(value, method, param2)) {
                        return nexts.get(i);
                    }
                }
                map.put(param1 + ":	" + method, param2);

            }

            boolean isConflict = false;
            for (HashMap<String, String> existMap : list) {
                if (existMap.size() > map.size()) {
                    continue;
                }

                boolean find = false;
                for (String key : existMap.keySet()) {
                    if (!map.containsKey(key)) {
                        find = true;
                        break;
                    }
                }
                if (find)
                    continue;

                boolean conflict = true;
                for (String key : existMap.keySet()) {
                    String method = key.split(":")[1];
                    conflict = conflict && ParamUtil.isConflict(existMap.get(key), method, map.get(key));
                }

                if (conflict)
                    return nexts.get(i);

            }

            list.add(map);
        }

        return null;
    }

    private List<NextEntity> getNextByBlock(Integer block, List<NextEntity> list) {
        List<NextEntity> array = new ArrayList<NextEntity>();
        for (NextEntity ne : list) {
            if (ne.getBlock().equals(block)) {
                array.add(ne);
            }
        }
        return array;
    }

    private void findAvailableLine(Integer sourceBlock, Integer targetBlock, List<Integer> line,
                                   List<List<Integer>> mainLine, List<NextEntity> allNext, Integer endBlock) {

        List<NextEntity> array = getNextByBlock(sourceBlock, allNext);
        for (NextEntity ne : array) {
            List<Integer> newLine = new ArrayList<Integer>();
            newLine.addAll(line);

            if (ne.getValue().equals(endBlock)) {
                return;
            }

            if (ne.getValue().equals(targetBlock)) {
                mainLine.add(newLine);
                return;
            }

            newLine.add(ne.getValue());

            findAvailableLine(ne.getValue(), targetBlock, newLine, mainLine, allNext, endBlock);

        }

    }

    @Override
    public void getProcessList(GetProcessListReq req, GetProcessListResp resp) {
        // TODO Auto-generated method stub
        resp.setProcesses(processDao.findAll());
    }

    @Override
    public void saveProcessArgs(SaveProcessArgsReq req, SaveProcessArgsResp resp) {
        // TODO Auto-generated method stub
        ProcessArgumentEntity pae = new ProcessArgumentEntity();
        pae.setName(req.getName());
        pae.setNecessary(req.getIsNecessary());
        pae.setProcess(req.getProcess());
        pae.setType(req.getBelong().indexOf("process-in-args") >= 0 ? 0 : 1);
        pae.setComplex(req.getIsComplex());
        pae.setMutitype(req.getIsMutitype());

        processArgumentDao.addToTemp(pae);
        if (pae.getComplex() == 1 && req.getColumns().size() > 0) {
            List<ProcessArgumentComplexEntity> ar = new ArrayList<ProcessArgumentComplexEntity>();

            for (String s : req.getColumns()) {
                ProcessArgumentComplexEntity pace = new ProcessArgumentComplexEntity();
                pace.setArgument(pae.getId());
                pace.setName(s);
                processArgumentComplexDao.save(pace);
                ar.add(pace);
            }
            resp.setComplex(ar);
        }

        resp.setId(pae.getId());
    }

    @Override
    public void deleteProcessArgs(DeleteProcessArgsReq req, DeleteProcessArgsResp resp) {
        // TODO Auto-generated method stub
        processArgumentDao.deleteFromTemp(req.getId());
        processArgumentComplexDao.deleteByArgument(req.getId());
    }

    public Integer getProcessByUrl(String url) {
        ProcessEntity p = processDao.findByUrl(url);
        if (p != null) {
            return p.getId();
        } else {
            return 0;
        }
    }

    @Override
    public void exportProcess(ExportProcessReq req, ExportProcessResp resp) {
        // TODO Auto-generated method stub
        System.out.println(req.getId());
        resp.setProcess(processDao.findFromTempById(req.getId()));
        resp.setBlocks(blockDao.findFromTempByProcess(req.getId()));

        List<JSONObject> array = new ArrayList<JSONObject>();
        List<NextEntity> nextList = nextDao.findFromTempByProcess(req.getId());
        resp.setNext(nextList);
        resp.setNextRequirement(nextRequirementDao.findFromTempByProcess(req.getId()));

        List<ExecuteEntity> executes = executeDao.findFromTempByProcess(req.getId());
        resp.setExecute(executes);

        resp.setExecuteParam(executeParamDao.findFromTempByProcess(req.getId()));

        List<ProcessArgumentEntity> args = processArgumentDao.findFromTempByProcess(req.getId());
        resp.setArgs(args);

        List<ProcessArgumentComplexEntity> complex = processArgumentComplexDao.findByProcess(req.getId());
        resp.setComplex(complex);

    }

    @Override
    public void importProcess(ImportProcessReq req, ImportProcessResp resp) {
        // TODO Auto-generated method stub
        ProcessEntity process = new ProcessEntity();
        process.setName(req.getProcess().getName());
        process.setIntro(req.getProcess().getIntro());
        processDao.addToTemp(process);

        for (BlockEntity b : req.getBlocks()) {
            int originId = b.getId();
            b.setId(0);
            b.setProcess(process.getId());
            blockDao.addToTemp(b);
            if (req.getProcess().getStartBlock() == originId) {
                process.setStartBlock(b.getId());
            } else if (req.getProcess().getEndBlock() == originId) {
                process.setEndBlock(b.getId());
            }
            for (ExecuteEntity e : req.getExecute()) {
                if (e.getBlock() == originId) {
                    e.setBlock(b.getId());
                }
            }

            for (NextEntity ne : req.getNext()) {
                if (ne.getBlock() == originId) {
                    ne.setBlock(b.getId());
                }
                if (ne.getValue() == originId) {
                    ne.setValue(b.getId());
                }
            }

        }
        processDao.updateToTemp(process);

        for (ProcessArgumentEntity pae : req.getArgs()) {
            int originId = pae.getId();
            pae.setProcess(process.getId());
            pae.setId(0);
            processArgumentDao.addToTemp(pae);
            for (ProcessArgumentComplexEntity pace : req.getComplex()) {
                if (pace.getArgument() == originId) {
                    pace.setArgument(pae.getId());
                }
            }

        }

        for (ProcessArgumentComplexEntity pace : req.getComplex()) {
            pace.setId(0);
            processArgumentComplexDao.save(pace);
        }

        for (ExecuteEntity e : req.getExecute()) {
            int originId = e.getId();
            e.setId(0);
            executeDao.addToTemp(e);
            for (ExecuteParamEntity ep : req.getExecuteParam()) {
                if (ep.getExecute() == originId) {
                    ep.setExecute(e.getId());
                }
            }
        }

        for (ExecuteParamEntity ep : req.getExecuteParam()) {
            ep.setId(0);
            executeParamDao.addToTemp(ep);
        }

        for (NextEntity ne : req.getNext()) {
            int originId = ne.getId();
            ne.setId(0);
            nextDao.addToTemp(ne);
            for (NextRequirementEntity nr : req.getNextRequirement()) {
                if (nr.getNext() == originId) {
                    nr.setNext(ne.getId());
                }
            }
        }

        for (NextRequirementEntity nr : req.getNextRequirement()) {
            nr.setId(0);
            nextRequirementDao.addToTemp(nr);
        }

    }
}
