package com.lin.service.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONObject;
import com.lin.NettyServer;
import com.lin.block.ProcessArgument;
import com.lin.block.ProcessArgumentComplex;
import com.lin.block.ProcessIntro;
import com.lin.constants.BlockConstant;
import com.lin.constants.Result;
import com.lin.dao.*;
import com.lin.entity.*;
import com.lin.interfacePackage.AbstractPlugin;
import com.lin.interfacePackage.AbstractVariableParamPlugin;
import com.lin.interfacePackage.Annotation.*;
import com.lin.interfacePackage.request.VariableParamReq;
import com.lin.interfacePackage.request.VariableParamResp;
import com.lin.request.req.*;
import com.lin.request.resp.*;
import com.lin.service.ExecuteService;
import com.lin.service.SequenceService;
import com.lin.util.DataloaderInterface;
import com.lin.util.EntityListUtil;
import com.lin.util.FileManager;
import com.lin.util.ParamUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@Transactional(value = "businessTransactionManager", rollbackFor = Exception.class)
public class ExecuteServiceImpl implements ExecuteService {

	@Qualifier("businessDataSource")
	@Autowired
	DataSource dataSource;

	@Autowired
	PluginDao pluginDao;
	@Autowired
	PluginMethodDao pluginMethodDao;

	@Autowired
	ExecuteDao executeDao;

	@Autowired
	ExecuteParamDao executeParamDao;

	@Autowired
	NextDao nextDao;

	@Autowired
	BlockDao blockDao;

	@Autowired
	NextRequirementDao nextRequirementDao;
	@Autowired
	DataSourceDao dataSourceDao;
	@Autowired
	DataTableDao tableDao;

	@Autowired
	ProcessDao processDao;

	@Autowired
	ProcessArgumentDao processArgumentDao;

	@Autowired
	ProcessArgumentComplexDao processArgumentComplexDao;

	@Autowired
	SequenceService sequenceService;

	HttpClientBuilder bu = HttpClientBuilder.create();

	private static ConcurrentHashMap<String, URLClassLoader> classLoaderResourceList = new ConcurrentHashMap<String, URLClassLoader>();
	private static ConcurrentHashMap<Integer, DruidDataSource> dataSourceResourceList = new ConcurrentHashMap<Integer, DruidDataSource>();
	private static ConcurrentHashMap<Integer, CopyOnWriteArrayList<Object>> processResourceList = new ConcurrentHashMap<Integer, CopyOnWriteArrayList<Object>>();
	private static ConcurrentHashMap<Integer, GenericObjectPool<AbstractPlugin>> pluginMap = new ConcurrentHashMap<Integer, GenericObjectPool<AbstractPlugin>>();

	@Override
	public void saveExecuteParam(SaveExecuteParamReq req, SaveExecuteParamResp resp) {
		// TODO Auto-generated method stub
		executeParamDao.deleteFromTempByExecute(req.getExecuteId());

		for (int i = 0; i < req.getParams().size(); i++) {
			JSONObject ob = req.getParams().getJSONObject(i);
			ExecuteParamEntity entity = new ExecuteParamEntity();
			entity.setExecute(req.getExecuteId());
			try {
				entity.setPluginMethodParam(URLDecoder.decode(ob.getString("name"), "utf-8"));
				entity.setParam(URLDecoder.decode(ob.getString("value"), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			entity.setFieldName(ob.getString("fieldName"));
			entity.setType(ob.getInteger("type"));
			executeParamDao.addToTemp(entity);
		}
	}

	@Override
	public void saveExecute(SaveExecuteReq req, SaveExecuteResp resp) {
		// TODO Auto-generated method stub
		ExecuteEntity e = new ExecuteEntity();
		e.setBlock(req.getBlockId());
		e.setMethod(req.getMethodId());
		e.setExecuteName(req.getExecuteName());
		executeDao.addToTemp(e);
		resp.setExecuteId(e.getId());
	}

	@Override
	public void deleteExecute(DelExecuteReq req, DelExecuteResp resp) {
		// TODO Auto-generated method stub
		executeDao.deleteFromTemp(req.getExecuteId());
	}

	@Override
	public void getExecuteVariableParams(GetExecuteVariableParamsReq req, GetExecuteVariableParamsResp resp) {
		// TODO Auto-generated method stub
		ExecuteEntity execute = executeDao.findFromTempById(req.getExecuteId());
		PluginMethodEntity method = pluginMethodDao.findById(execute.getMethod());

		PluginEntity plugin = pluginDao.findById(method.getPlugin());
		Object classObject = getClassInstance(execute, plugin);
		if (classObject == null) {
			resp.setMsg("class not exist");
			resp.setResult(Result.ERROR_SYSTEM);
			return;
		}
		if (!(classObject instanceof AbstractVariableParamPlugin)) {
			resp.setMsg("class is not AbstractVariableParamPlugin");
			resp.setResult(Result.ERROR_SYSTEM);
			
			if (pluginMap.containsKey(plugin.getId())) {
				pluginMap.get(plugin.getId()).returnObject((AbstractPlugin) classObject);
			}
			return;
		}

		AbstractVariableParamPlugin obj = (AbstractVariableParamPlugin) classObject;
		try {
			VariableParamReq varReq = new VariableParamReq();
			VariableParamResp varResp = new VariableParamResp();
			varReq.setMethodName(method.getMethodName());
			varReq.setMap(req.getParams());
			obj.getParams(varReq, varResp);
			resp.setInArgs(varResp.getInArgs());
			resp.setOutArgs(varResp.getOutArgs());
			resp.setExecuteParams(executeParamDao.findFromTempByExecute(req.getExecuteId()));

		} catch (IllegalArgumentException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pluginMap.containsKey(plugin.getId())) {
				pluginMap.get(plugin.getId()).returnObject((AbstractPlugin) classObject);
			}
		}

	}

	@Override
	public void getExecuteParams(GetExecuteParamsReq req, GetExecuteParamsResp resp) {
		// TODO Auto-generated method stub
		PluginMethodEntity method = pluginMethodDao.findById(req.getMethodId());
		PluginEntity plugin = pluginDao.findById(method.getPlugin());
		ExecuteEntity ee = executeDao.findFromTempById(req.getExecuteId());

		JSONObject parms = null;
		Object classObject = getClassInstance(ee, plugin);
		if (classObject == null) {
			resp.setMsg("class not exist");
			resp.setResult(Result.ERROR_SYSTEM);
			return;
		}

		try {
			parms = ParamUtil.getParams(classObject.getClass(), method.getMethodName(), tableDao);
		} catch (IllegalArgumentException | NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pluginMap.containsKey(plugin.getId())) {
				pluginMap.get(plugin.getId()).returnObject((AbstractPlugin) classObject);
			}

		}

		resp.setMethod(method);
		resp.setPlugin(plugin);
		resp.setExecuteParams(executeParamDao.findFromTempByExecute(req.getExecuteId()));

		// if (exe instanceof AbstractVariableParamPlugin) {
		// AbstractVariableParamPlugin exe2 = (AbstractVariableParamPlugin) exe;
		// for (String key : req.getMap().keySet()) {
		// exe2.setParam(key, req.getMap().get(key));
		// }
		//
		// PluginMethodParamAnnotation[] temp =
		// exe2.getNecessaryParams(req.getMethodName());
		// PluginMethodParamAnnotation[] temp2 = new
		// PluginMethodParamAnnotation[temp.length + parms.length];
		// System.arraycopy(parms, 0, temp2, 0, parms.length);
		// System.arraycopy(temp, parms.length, temp2, parms.length,
		// temp.length);
		// parms = temp2;
		//
		// }
		resp.setParams(parms);

	}

	public Integer executeBlock(BlockEntity block, DataloaderInterface loader, Long sequenceId, ExportProcessResp resp)
			throws InvocationTargetException {

		execute(block, loader, sequenceId, block.getProcess(), resp);
		Long time = System.currentTimeMillis();
		Integer i = next(loader, block, resp);

		sequenceService.save(BlockConstant.PROCESS_SEQUENCE_PROCESS_NEXT, sequenceId, System.currentTimeMillis() - time,
				block.getProcess(), null, null, "from block=" + block.getId() + "next block=" + i);

		return i;
	}

	private void execute(BlockEntity block, DataloaderInterface loader, Long sequenceId, int processId,
			ExportProcessResp resp) throws InvocationTargetException {
		// TODO Auto-generated method stub
		Long time = System.currentTimeMillis();
		List<ExecuteEntity> executes = EntityListUtil.findListFromList(resp.getExecute(), "block", block.getId());
		sequenceService.save("load execute", sequenceId, System.currentTimeMillis() - time, processId, null, null,
				null);

		for (ExecuteEntity e : executes) {
			time = System.currentTimeMillis();
			PluginMethodEntity method = pluginMethodDao.findById(e.getMethod());
			PluginEntity plugin = pluginDao.findById(method.getPlugin());
			List<ExecuteParamEntity> exeParams = EntityListUtil.findListFromList(resp.getExecuteParam(), "execute",
					e.getId());

			sequenceService.save("load exe " + e.getId(), sequenceId, System.currentTimeMillis() - time, processId,
					e.getBlock(), e.getId(), null);
			time = System.currentTimeMillis();

			Execute ee = new Execute(plugin, method, exeParams, e, sequenceId, block.getId(), processId,
                    getClassInstance(e, plugin));
			sequenceService.save("init exe " + e.getId(), sequenceId, System.currentTimeMillis() - time, processId,
					e.getBlock(), e.getId(), null);
			time = System.currentTimeMillis();

			ee.execute(loader);

//			sequenceService.save("execute exe " + e.getId(), sequenceId, System.currentTimeMillis() - time, processId,
//					e.getBlock(), e.getId(), null);
		}
	}

	private Integer next(DataloaderInterface loader, BlockEntity block, ExportProcessResp resp) {

		List<NextEntity> nexts = EntityListUtil.findListFromList(resp.getNext(), "block", block.getId());
		for (NextEntity n : nexts) {
			if (isOk(loader, n, resp)) {
				return n.getValue();
			}
		}
		return -1;
	}

	private boolean isOk(DataloaderInterface loader, NextEntity next, ExportProcessResp resp) {
		List<NextRequirementEntity> requirements = EntityListUtil.findListFromList(resp.getNextRequirement(), "next",
				next.getId());

		for (NextRequirementEntity r : requirements) {
			if (!ParamUtil.isOK(loader, r))
				return false;
		}
		return true;
	}

	public GenericObjectPool<AbstractPlugin> generatePool(Class clz) {
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxTotal(50);// 整个池最大值
		config.setMaxIdle(8);// 最大空闲
		config.setMinIdle(0);// 最小空闲
		config.setMaxWaitMillis(2000);// 最大等待时间，-1表示一直等
		config.setBlockWhenExhausted(true);// 当对象池没有空闲对象时，新的获取对象的请求是否阻塞。true阻塞。默认值是true
		config.setTestOnBorrow(false);// 在从对象池获取对象时是否检测对象有效，true是；默认值是false
		config.setTestOnReturn(false);// 在向对象池中归还对象时是否检测对象有效，true是，默认值是false
		config.setTestWhileIdle(false);// 在检测空闲对象线程检测到对象不需要移除时，是否检测对象的有效性。true是，默认值是false
		config.setMinEvictableIdleTimeMillis(10 * 60000L); // 可发呆的时间,10mins
		config.setTestWhileIdle(false); // 发呆过长移除的时候是否test一下先

		PluginFactory pf = new PluginFactory();
		pf.clz = clz;

		GenericObjectPool<AbstractPlugin> pool = new GenericObjectPool<AbstractPlugin>(pf, config);
		return pool;
	}

	public AbstractPlugin getClassInstance(ExecuteEntity execute, PluginEntity plugin) {
		// TODO Auto-generated method stub
		Long time = System.currentTimeMillis();

		AbstractPlugin instance = null;
		try {
			if ((instance = (AbstractPlugin) NettyServer.context
					.getBean(Class.forName(plugin.getClassName()))) != null) {
				return instance;
			}
		} catch (Exception e) {

		}

		BlockEntity be = blockDao.findFromTempById(execute.getBlock());

		if (instance == null) {
			URLClassLoader classLoader = null;

			if (classLoaderResourceList.containsKey(plugin.getClassName())) {
				classLoader = classLoaderResourceList.get(plugin.getClassName());
			}

			try {
				if (classLoader == null) {
					File file = new File(plugin.getFileName());
					URL url = file.toURI().toURL();
					classLoader = new URLClassLoader(new URL[] { url });
					classLoaderResourceList.put(plugin.getClassName(), classLoader);
				}
				Class clz = classLoader.loadClass(plugin.getClassName());
				clz.getDeclaredMethods();
				if (!pluginMap.containsKey(plugin.getId())) {
					pluginMap.put(plugin.getId(), generatePool(clz));
				}

				AbstractPlugin ob = pluginMap.get(plugin.getId()).borrowObject();

				instance = ob;
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
					| MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Field[] fields = instance.getClass().getDeclaredFields();
		for (Field f : fields) {
			if (f.getAnnotation(InitParam.class) != null) {
				f.setAccessible(true);
				try {
					f.set(instance, getBlockResource(be, f.getType()));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return instance;
	}


	private Object getBlockResource(BlockEntity block, Class clz) {

		ProcessEntity pe = processDao.findFromTempById(block.getProcess());

		if (!processResourceList.contains(pe.getId())) {
			CopyOnWriteArrayList<Object> array = new CopyOnWriteArrayList<Object>();
			processResourceList.put(pe.getId(), array);
		}

		// for (Object ob : blockResourceList.get(block.getId())) {
		// if (clz.isAssignableFrom(ob.getClass())) {
		// return ob;
		// }
		// }

		if (clz.equals(FileManager.class)) {
			return NettyServer.context.getBean(FileManager.class);
		}
		if (clz.equals(Connection.class))

		{

			if (pe.getDataSource() == null) {
				return DataSourceUtils.getConnection(dataSource);
			}
			DruidDataSource cpSource = null;

			if (dataSourceResourceList.containsKey(pe.getDataSource())) {
				cpSource = dataSourceResourceList.get(pe.getDataSource());
			}

			if (cpSource == null)
				for (Object processResource : processResourceList.get(pe.getId())) {
					if (processResource instanceof DruidDataSource) {
						cpSource = (DruidDataSource) processResource;
						break;
					}
				}

			if (cpSource == null) {
				DataSourceEntity processDataResource = dataSourceDao.findById(pe.getDataSource());
				// TODO Auto-generated method stub
				cpSource = new DruidDataSource();
				cpSource.setUrl(processDataResource.getJdbcUrl());
				cpSource.setDriverClassName(processDataResource.getClassName());
				cpSource.setUsername(processDataResource.getUsername());
				cpSource.setPassword(processDataResource.getPassword());
				cpSource.setInitialSize(5);
				cpSource.setMaxActive(10);
				processResourceList.get(pe.getId()).add(cpSource);
				dataSourceResourceList.put(pe.getDataSource(), cpSource);
			}
			return DataSourceUtils.getConnection(cpSource);
		}

		if (clz.equals(HttpClient.class)) {
			return bu.build();
		}

		if (clz.equals(ProcessIntro.class)) {

			ProcessIntro pi = new ProcessIntro();
			pi.setName(pe.getName());

			List<ProcessArgumentEntity> argsList = processArgumentDao.findFromTempByProcess(pe.getId());

			List<ProcessArgument> inArgs = new ArrayList<ProcessArgument>();
			List<ProcessArgument> outArgs = new ArrayList<ProcessArgument>();

			List<ProcessArgumentComplexEntity> complex = processArgumentComplexDao.findByProcess(pe.getId());

			for (ProcessArgumentEntity pae : argsList) {
				ProcessArgument pa = new ProcessArgument();
				pa.setName(pae.getName());
				pa.setMutitype(pae.getMutitype());
				pa.setNecessary(pae.getNecessary());
				pa.setType(pae.getType());
				if (pae.getType() == BlockConstant.args_type_input) {
					inArgs.add(pa);
				} else if (pae.getType() == BlockConstant.args_type_output) {
					outArgs.add(pa);
				}

				if (pae.getComplex() == BlockConstant.args_type_complex) {
					List<ProcessArgumentComplex> cm = new ArrayList<ProcessArgumentComplex>();
					for (ProcessArgumentComplexEntity ce : complex) {
						if (ce.getArgument() == pae.getId()) {
							ProcessArgumentComplex argsComplex = new ProcessArgumentComplex();
							argsComplex.setName(ce.getName());
							cm.add(argsComplex);
						}
					}
					pa.setComplex(cm);
				}
			}
			pi.setInArgs(inArgs);
			pi.setOutArgs(outArgs);

			return pi;
		}

		return null;

	}

	public class PluginFactory extends BasePooledObjectFactory<AbstractPlugin> {

		Class<AbstractPlugin> clz;

		// 创建对象
		@Override
		public AbstractPlugin create() throws Exception {
			return clz.newInstance();
		}

		// 包装对象
		@Override
		public PooledObject<AbstractPlugin> wrap(AbstractPlugin arg0) {
			return new DefaultPooledObject<AbstractPlugin>(arg0);
		}

		// 在获取对象返回之前可以进行的操作
		@Override
		public void activateObject(PooledObject<AbstractPlugin> p) throws Exception {
			super.activateObject(p);
		}

		// 在归还对象之前可以进行的操作
		@Override
		public void passivateObject(PooledObject<AbstractPlugin> p) throws Exception {
			super.passivateObject(p);
		}
	}

	private class Execute {

		private PluginEntity plugin;
		private PluginMethodEntity method;
		private List<ExecuteParamEntity> exeParams;
		private ExecuteEntity execute;
		private Long sequenceId;
		private int blockId;
		private int processId;
		private Long time;
		private String remark;
		AbstractPlugin exe;

		public Execute(PluginEntity plugin, PluginMethodEntity method, List<ExecuteParamEntity> exeParams,
				ExecuteEntity execute, Long sequenceId, int blockId, int processId, AbstractPlugin exe) { // 从数据库读取
			this.plugin = plugin;
			this.method = method;
			this.exeParams = exeParams;
			this.execute = execute;
			this.sequenceId = sequenceId;
			this.blockId = blockId;
			this.processId = processId;
			time = System.currentTimeMillis();
			this.exe = exe;
			JSONObject ob = new JSONObject();
			ob.put("pluginId", plugin.getId());
			ob.put("pluginName", plugin.getName());
			ob.put("methodName", method.getName());
			remark = ob.toJSONString();

		}

		public void execute(DataloaderInterface loader) throws InvocationTargetException {
			// TODO Auto-generated method stub
			sequenceService.save(BlockConstant.PROCESS_SEQUENCE_STARTCALL, sequenceId, time, processId, blockId,
					execute.getId(), remark);

			if (plugin.getBelongType() == BlockConstant.innerCall) {
				innerCall(loader);
			} else if (plugin.getType() == BlockConstant.outerCall) {
				outerCall(loader);
			}
		}

		private void innerCall(DataloaderInterface loader) throws InvocationTargetException {
			try {
				// Class clz = Class.forName(plugin.className);

				sequenceService.save(BlockConstant.PROCESS_SEQUENCE_LOADCLASS, sequenceId,
						System.currentTimeMillis() - time, processId, blockId, execute.getId(), remark);
				time = System.currentTimeMillis();

				Method m = null;
				Method[] methods = exe.getClass().getDeclaredMethods();
				for (Method me : methods) {
					if (me.getName().equals(method.getMethodName())) {
						m = me;
					}
				}

				if (m == null) {
					System.out.println("method error");
					System.out.println(method.getMethodName());
					return;
				}

				Parameter[] parameters = m.getParameters();
				Object[] params = new Object[parameters.length];
				if (parameters.length != 2) {
					throw new IllegalArgumentException("parameter size not equals two ");
				}
				params[0] = parameters[0].getType().newInstance();
				Field[] fields = parameters[0].getType().getDeclaredFields();

				// 某种标识的直接从map放进dataloader
				Map<String,String> executeParamMap=new HashMap<String,String>();
				for (ExecuteParamEntity ep : exeParams) {
					if (ep.getType() != BlockConstant.args_type_input) {
						continue;
					}

					for (Field f : fields) {
						if (f.getAnnotation(PluginMethodParamAnnotation.class) != null
								|| f.getAnnotation(DatabaseTableAnnotation.class) != null
								|| f.getAnnotation(PluginMethodVariableParamAnnotation.class) != null) {
							if (f.getName().equals(ep.getFieldName())) {
								executeParamMap.put(ep.getParam(),ep.getParam());
							}
						}
					}
				}


				for (ExecuteParamEntity ep : exeParams) {
					if (ep.getType() != BlockConstant.args_type_input) {
						continue;
					}

					for (Field f : fields) {
						if (f.getAnnotation(PluginMethodParamAnnotation.class) != null
								|| f.getAnnotation(DatabaseTableAnnotation.class) != null
								|| f.getAnnotation(PluginMethodVariableParamAnnotation.class) != null) {
							if (f.getName().equals(ep.getFieldName())) {
								f.setAccessible(true);
								String value=loader.parseValue(ep.getParam());

								if (StringUtils.isBlank(value)
										|| "null".equals(value)) {
									continue;
								}

								if (List.class.isAssignableFrom(f.getType())) {
									if (f.get(params[0]) == null) {
										List list = new ArrayList();
										f.set(params[0], list);
									}
									List list = (List) f.get(params[0]);
									Type fc = f.getGenericType();
									if ((fc instanceof ParameterizedType)) {
//										ParameterizedType pt = (ParameterizedType) fc;
//										Class genericClass = (Class) pt.getActualTypeArguments()[0];

										list.add(value);
									} else {
										list.add(value);
									}
								}

								else if (Map.class.isAssignableFrom(f.getType())) {
									if (f.get(params[0]) == null) {
										HashMap map = new HashMap();
										f.set(params[0], map);
									}
									Map map = (Map) f.get(params[0]);
									Type fc = f.getGenericType();
									if ((fc instanceof ParameterizedType)) {
//										ParameterizedType pt = (ParameterizedType) fc;
//										Class genericClass = (Class) pt.getActualTypeArguments()[1];

										map.put(ep.getPluginMethodParam(), value);
									} else {
										map.put(ep.getPluginMethodParam(), value);
									}

								} else {
									f.set(params[0], value);
								}
							}

						}
					}
				}

				sequenceService.save(BlockConstant.PROCESS_SEQUENCE_LOADDATA+"-REAL LOAD", sequenceId,
						System.currentTimeMillis() - time, processId, blockId, execute.getId(), remark);

				params[1] = parameters[1].getType().newInstance();
				//批量写入


				Map<String,Object> outputMap=new HashMap<String,Object>();

				time = System.currentTimeMillis();
				m.invoke(exe, params);
				sequenceService.save(BlockConstant.PROCESS_SEQUENCE_INVOKE, sequenceId,
						System.currentTimeMillis() - time, processId, blockId, execute.getId(), remark);
				time = System.currentTimeMillis();
				Field[] fields2 = parameters[1].getType().getDeclaredFields();

				for (ExecuteParamEntity ep : exeParams) {
					if (ep.getType() != BlockConstant.args_type_output) {
						continue;
					}
					for (Field f : fields2) {
						if (f.getAnnotation(PlguinMethodOutputParamAnnotation.class) == null
								&& f.getAnnotation(PlguinMethodOutputVariableParamAnnotation.class) == null)
							continue;
						if (f.getName().equals(ep.getFieldName())) {
							f.setAccessible(true);

							if (StringUtils.isBlank(ep.getParam()))
								continue;

							if (Map.class.isAssignableFrom(f.getType())
									&& f.getAnnotation(PlguinMethodOutputVariableParamAnnotation.class) != null) {
								Map map = (Map) f.get(params[1]);
								if (ep.getPluginMethodParam() != null) {
									outputMap.put(loader.parseValue(ep.getParam()), map.get(ep.getPluginMethodParam()));
								}
							} else {
								if (f.get(params[1]) == null) {
									outputMap.put(loader.parseValue(ep.getParam()), "");
								} else {
									outputMap.put(loader.parseValue(ep.getParam()), f.get(params[1]));
								}
							}
							// }

						}
					}
				}
				loader.putAll(outputMap);

				sequenceService.save(BlockConstant.PROCESS_SEQUENCE_OUTPUTDATA, sequenceId,
						System.currentTimeMillis() - time, processId, blockId, execute.getId(), remark);

			} catch (SecurityException | IllegalAccessException | IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (pluginMap.containsKey(plugin.getId())) {
					pluginMap.get(plugin.getId()).returnObject(exe);
				}
			}

			return;
		}

		private void outerCall(DataloaderInterface loader) {
			BufferedReader br = null;
			StringBuilder sb = new StringBuilder();
			try {
				StringBuilder cmd = new StringBuilder();
				if (plugin.getLanguage() == BlockConstant.JavaLang) {// java
					cmd.append("java -jar " + plugin.getFileName());
					for (ExecuteParamEntity pa : exeParams)
						cmd.append(" " + loader.parseValue(pa.getParam()));
				} else if (plugin.getLanguage() == BlockConstant.CCPLUS) {// C
																			// C++调用
					cmd.append("java -jar " + plugin.getFileName());
					for (ExecuteParamEntity pa : exeParams)
						cmd.append(" " + loader.parseValue(pa.getParam()));
				} else if (plugin.getLanguage() == BlockConstant.Python) {// PYTHON调用
					cmd.append("java -jar " + plugin.getFileName());
					for (ExecuteParamEntity pa : exeParams)
						cmd.append(" " + loader.parseValue(pa.getParam()));
				}
				java.lang.Process p = Runtime.getRuntime().exec(cmd.toString());
				br = new BufferedReader(new InputStreamReader(p.getInputStream()));

				String line = null;

				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				// if (method.getType() == BlockConstant.method_type_return) {
				// String string = sb.toString();
				// Object changeObject = null;
				// switch (method.getReturnType()) {
				// case BlockConstant.method_return_array:
				// changeObject = JSONArray.fromObject(string);
				// break;
				// case BlockConstant.method_return_object:
				// changeObject = JSONObject.fromObject(string);
				// break;
				// case BlockConstant.method_return_simple:
				// changeObject = string;
				// break;
				// }

				// if (string != null && method.getType() ==
				// BlockConstant.method_type_return) {
				// switch (plugin.getBelongType()) {
				// case BlockConstant.plugin_belong_sql:
				// loader.valueMap.get(BlockConstant.belong_data).put(returnName,
				// changeObject);
				// break;
				// case BlockConstant.plugin_belong_outer:
				// loader.valueMap.get(BlockConstant.belong_outer).put(returnName,
				// changeObject);
				// break;
				// case BlockConstant.plugin_belong_transform:
				// loader.valueMap.get(BlockConstant.belong_transform).put(returnName,
				// changeObject);
				// break;
				// default:
				// break;
				// }
				// }
				// } else {
				// return;
				// }

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
			return;
		}

	}

}
