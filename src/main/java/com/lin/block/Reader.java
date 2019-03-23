package com.lin.block;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lin.dao.BlockDao;
import com.lin.dao.BlockDataSourceParamDao;
import com.lin.dao.DataSourceDao;
import com.lin.dao.DataSourceParamDao;
import com.lin.dao.ExecuteDao;
import com.lin.dao.ExecuteParamDao;
import com.lin.dao.NextDao;
import com.lin.dao.NextRequirementDao;
import com.lin.dao.ParamDao;
import com.lin.dao.PluginDao;
import com.lin.dao.PluginMethodDao;
import com.lin.dao.ProcessDao;
import com.lin.entity.BlockDataSourceParamEntity;
import com.lin.entity.BlockEntity;
import com.lin.entity.DataSourceEntity;
import com.lin.entity.DataSourceParamEntity;
import com.lin.entity.ExecuteEntity;
import com.lin.entity.ExecuteParamEntity;
import com.lin.entity.NextEntity;
import com.lin.entity.NextRequirementEntity;
import com.lin.entity.ParamEntity;
import com.lin.entity.PluginEntity;
import com.lin.entity.PluginMethodEntity;
import com.lin.entity.ProcessEntity;
import com.lin.interfacePackage.AbstractPlugin;

public class Reader {
//	@Autowired
//	BlockDao blockDao;
//	@Autowired
//	ExecuteDao executeDao;
//	@Autowired
//	ExecuteParamDao executeParamDao;
//	@Autowired
//	NextDao nextDao;
//	@Autowired
//	NextRequirementDao nextRequirementDao;
//	@Autowired
//	PluginDao pluginDao;
//	@Autowired
//	PluginMethodDao pluginMethodDao;
//	// @Autowired
//	// PluginMethodParamDao pluginMethodParamDao;
//	@Autowired
//	ProcessDao processDao;
//	@Autowired
//	ParamDao paramDao;
//	@Autowired
//	DataSourceDao dataSourceDao;
//	@Autowired
//	DataSourceParamDao dataSourceParamDao;
//	@Autowired
//	BlockDataSourceParamDao blockDataSourceParamDao;
//
//	
//
//	// public List<Block> read(String s) throws DocumentException {
//	// SAXReader reader = new SAXReader();
//	// Document d = reader.read(new StringReader(s));
//	// Element root = d.getRootElement();
//	// if (root != null) {
//	// List<Element> processElement = root.elements("block");
//	// List<Block> processes = new ArrayList<Block>();
//	// for (Element process : processElement) { // 初始化process
//	// Block bp = new Block();
//	//
//	// String name = process.elementText("name");
//	// List<Element> executeElements = process.element("execute").elements();
//	// List<Element> nextElements = process.element("nexts").elements();
//	//
//	// List<Execute> executes = new ArrayList<Execute>();
//	// List<Next> nexts = new ArrayList<Next>();
//	//
//	// for (Element execute : executeElements) { // 初始化execute
//	// Execute be = new Execute(plugin, method, params, exeParams);
//	// executes.add(be);
//	// }
//	//
//	// for (Element next : nextElements) { // 初始化execute
//	// Next be = new Next();
//	//
//	// nexts.add(be);
//	// }
//	// bp.name = name;
//	// bp.executes = executes;
//	// bp.nexts = nexts;
//	// processes.add(bp);
//	// }
//	// return processes;
//	// } else {
//	// return null;
//	// }
//	// }
//
//	public Process read(Integer processId) throws IllegalAccessException, InvocationTargetException {
//		Process process = new Process();
//
//		ProcessEntity pe = processDao.findById(processId);
//		List<BlockEntity> blockEntity = blockDao.findByProcess(processId);
//		List<Block> blocks = new ArrayList<Block>();
//		for (BlockEntity be : blockEntity) {
//			List<ExecuteEntity> exeEnList = executeDao.findByBlock(be.getId());
//			List<Execute> eList = new ArrayList<Execute>();
//			for (ExecuteEntity e : exeEnList) {
//				PluginMethodEntity method = pluginMethodDao.findById(e.getMethod());
//				PluginMethod me = new PluginMethod();
//				BeanUtils.copyProperties(me, method);
//
//				
//				PluginEntity ple = pluginDao.findById(method.getPlugin());
//
//				// ParamEntity forPramaEn = paramDao.findById(e.getForParams());
//				// Param forParam = new Param();
//				// BeanUtils.copyProperties(forParam, forPramaEn);
//
//				List<ExecuteParamEntity> epeList = executeParamDao.findByExecute(e.getId());
//				List<ExecuteParam> epList = new ArrayList<ExecuteParam>();
//				for (ExecuteParamEntity epe : epeList) {
//					ExecuteParam ep = new ExecuteParam();
//					ep.setPluginMethodParam(epe.getPluginMethodParam());
//					// ep.setParamType(epe.getParamType());
//
//					ep.setParam(epe.getParam());
//
//					epList.add(ep);
//				}
//
//				Execute ex = new Execute(ple, me, epList, this);
//				eList.add(ex);
//			}
//
//			List<NextEntity> nextEnList = nextDao.findByBlock(be.getId());
//			List<Next> nList = new ArrayList<Next>();
//			for (NextEntity n : nextEnList) {
//
//				List<NextRequirement> nextRequirmentList = new ArrayList<NextRequirement>();
//				List<NextRequirementEntity> nreList = nextRequirementDao.findByNext(n.getId());
//				for (NextRequirementEntity nre : nreList) {
//					NextRequirement nr = new NextRequirement();
//					nr.setMethod(nre.getMethod());
//					if (nre.getPattern() != null)
//						nr.setPattern(Pattern.compile(nre.getPattern()));
//
//					nr.setParam1(nre.getParam1());
//
//					nr.setParam2(nre.getParam2());
//					nextRequirmentList.add(nr);
//				}
//
//				Next next = new Next();
//				next.setValue(n.getValue());
//				next.setPosition(n.getPosition());
//				next.setRequirements(nextRequirmentList);
//				nList.add(next);
//			}
//
//			DataSource dataClass = null;
//			if (be.getDataSource() > 0) {
//				try {
//					DataSourceEntity en = dataSourceDao.findById(be.getDataSource());
//					dataClass = (DataSource) Class.forName(en.getClassName()).newInstance();
//					List<BlockDataSourceParamEntity> bdspl = blockDataSourceParamDao.findByBlock(be.getId());
//					for (BlockDataSourceParamEntity bdsp : bdspl) {
//						ParamEntity pramaEn = paramDao.findById(bdsp.getParam());
//						DataSourceParamEntity dspe = dataSourceParamDao.findById(bdsp.getDataSourceParam());
//						Field field = dataClass.getClass().getDeclaredField(dspe.getName());
//						field.setAccessible(true);
//						field.set(dataClass, pramaEn.getParamValue());
//					}
//				} catch (IllegalArgumentException | NoSuchFieldException | SecurityException | InstantiationException
//						| ClassNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//			Block block = new Block(be.getId(), be.getName(), eList, nList, dataClass);
//			blocks.add(block);
//		}
//		process.setBlocks(blocks);
//		process.setName(pe.getName());
//
//		// if (pe.getResponse() > 0) {
//		// ParamEntity pramaEn = paramDao.findById(pe.getResponse());
//		// Param param = new Param();
//		// BeanUtils.copyProperties(param, pramaEn);
//		// process.setResponse(param);
//		// }
//
//		process.setStartBlock(pe.getStartBlock());
//
//		return process;
//	}
//
//	public AbstractPlugin getClassInstance(PluginEntity plugin) {
//		// TODO Auto-generated method stub
//		for (AbstractPlugin ob : classList) {
//			if (ob.getClass().getName().equals(plugin.getClassName())) {
//				return ob;
//			}
//		}
//
//		URLClassLoader classLoader = null;
//		try {
//			System.out.println(plugin.getFileName());
//			File file = new File(plugin.getFileName());
//			URL url = file.toURI().toURL();
//			classLoader = new URLClassLoader(new URL[] { url });
//			Class clz = classLoader.loadClass(plugin.getClassName());
//			AbstractPlugin ob = null;
//			ob = (AbstractPlugin) clz.newInstance();
//			classList.add(ob);
//			return ob;
//		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (classLoader != null) {
//				try {
//					classLoader.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return null;
//	}

}
