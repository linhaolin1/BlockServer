package com.lin.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.jolbox.bonecp.BoneCPDataSource;
import com.lin.NettyServer;
import com.lin.block.ProcessArgument;
import com.lin.block.ProcessArgumentComplex;
import com.lin.block.ProcessIntro;
import com.lin.constants.BlockConstant;
import com.lin.constants.Result;
import com.lin.dao.BlockDao;
import com.lin.dao.DataSourceDao;
import com.lin.dao.DataTableDao;
import com.lin.dao.ExecuteDao;
import com.lin.dao.ExecuteParamDao;
import com.lin.dao.NextDao;
import com.lin.dao.NextRequirementDao;
import com.lin.dao.PluginDao;
import com.lin.dao.PluginMethodDao;
import com.lin.dao.ProcessArgumentComplexDao;
import com.lin.dao.ProcessArgumentDao;
import com.lin.dao.ProcessDao;
import com.lin.entity.BlockEntity;
import com.lin.entity.DataSourceEntity;
import com.lin.entity.ExecuteEntity;
import com.lin.entity.ExecuteParamEntity;
import com.lin.entity.NextEntity;
import com.lin.entity.NextRequirementEntity;
import com.lin.entity.PluginEntity;
import com.lin.entity.PluginMethodEntity;
import com.lin.entity.ProcessArgumentComplexEntity;
import com.lin.entity.ProcessArgumentEntity;
import com.lin.entity.ProcessEntity;
import com.lin.interfacePackage.AbstractPlugin;
import com.lin.interfacePackage.AbstractVariableParamPlugin;
import com.lin.interfacePackage.Annotation.DatabaseTableAnnotation;
import com.lin.interfacePackage.Annotation.InitParam;
import com.lin.interfacePackage.Annotation.PlguinMethodOutputParamAnnotation;
import com.lin.interfacePackage.Annotation.PlguinMethodOutputVariableParamAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodVariableParamAnnotation;
import com.lin.interfacePackage.request.VariableParamReq;
import com.lin.interfacePackage.request.VariableParamResp;
import com.lin.request.req.DelExecuteReq;
import com.lin.request.req.GetExecuteParamsReq;
import com.lin.request.req.GetExecuteVariableParamsReq;
import com.lin.request.req.SaveExecuteParamReq;
import com.lin.request.req.SaveExecuteReq;
import com.lin.request.resp.DelExecuteResp;
import com.lin.request.resp.GetExecuteParamsResp;
import com.lin.request.resp.GetExecuteVariableParamsResp;
import com.lin.request.resp.SaveExecuteParamResp;
import com.lin.request.resp.SaveExecuteResp;
import com.lin.service.ExecuteService;
import com.lin.service.SequenceService;
import com.lin.util.DataLoader;
import com.lin.util.ParamUtil;

@Service
@Transactional
public class ExecuteServiceImpl implements ExecuteService {

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

	private static ConcurrentHashMap<Integer, CopyOnWriteArrayList<AbstractPlugin>> classList = new ConcurrentHashMap<Integer, CopyOnWriteArrayList<AbstractPlugin>>();

	private static ConcurrentHashMap<Integer, CopyOnWriteArrayList<Object>> blockResourceList = new ConcurrentHashMap<Integer, CopyOnWriteArrayList<Object>>();

	@Override
	public void saveExecuteParam(SaveExecuteParamReq req, SaveExecuteParamResp resp) {
		// TODO Auto-generated method stub
		executeParamDao.deleteFromTempByExecute(req.getExecuteId());

		for (int i = 0; i < req.getParams().size(); i++) {
			JSONObject ob = req.getParams().getJSONObject(i);
			ExecuteParamEntity entity = new ExecuteParamEntity();
			entity.setExecute(req.getExecuteId());
			entity.setPluginMethodParam(ob.getString("name"));
			entity.setParam(ob.getString("value"));
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

	public Integer executeBlock(BlockEntity block, DataLoader loader, Long sequenceId) {
		System.out.println("blockID=" + block.getId());

		execute(block, loader, sequenceId, block.getProcess());
		return next(loader, block);
	}

	private void execute(BlockEntity block, DataLoader loader, Long sequenceId, int processId) {
		// TODO Auto-generated method stub
		List<ExecuteEntity> executes = executeDao.findFromTempByBlock(block.getId());

		for (ExecuteEntity e : executes) {

			PluginMethodEntity method = pluginMethodDao.findById(e.getMethod());
			PluginEntity plugin = pluginDao.findById(method.getPlugin());
			List<ExecuteParamEntity> exeParams = executeParamDao.findMethodParamFromTempByExecute(e.getId());
			ExecuteParamEntity returnParam = executeParamDao.findMethodReturnParamFromTempByExecute(e.getId());

			Execute ee = new Execute(plugin, method, exeParams, returnParam, e, sequenceId, block.getId(), processId);

			ee.execute(loader);
		}
	}

	private Integer next(DataLoader loader, BlockEntity block) {
		List<NextEntity> nexts = nextDao.findFromTempByBlock(block.getId());
		for (NextEntity n : nexts) {
			if (isOk(loader, n)) {
				return n.getValue();
			}
		}
		return -1;
	}

	private boolean isOk(DataLoader loader, NextEntity next) {
		List<NextRequirementEntity> requirements = nextRequirementDao.findFromTempByNext(next.getId());

		for (NextRequirementEntity r : requirements) {
			if (!ParamUtil.isOK(loader, r))
				return false;
		}
		return true;
	}

	public AbstractPlugin getClassInstance(ExecuteEntity execute, PluginEntity plugin) {
		// TODO Auto-generated method stub
		AbstractPlugin instance = null;
		try {
			if ((instance = (AbstractPlugin) NettyServer.context
					.getBean(Class.forName(plugin.getClassName()))) != null) {
				return instance;
			}
		} catch (Exception e) {

		}

		BlockEntity be = blockDao.findFromTempById(execute.getBlock());

		if (!classList.containsKey(execute.getId())) {
			CopyOnWriteArrayList<AbstractPlugin> array = new CopyOnWriteArrayList<AbstractPlugin>();
			classList.put(execute.getId(), array);
		}

		for (AbstractPlugin ob : classList.get(execute.getId())) {
			if (ob.getClass().getName().equals(plugin.getClassName())) {
				instance = ob;
				break;
			}
		}

		ClassLoader cl;
		if (instance == null) {
			URLClassLoader classLoader = null;
			try {
				File file = new File(plugin.getFileName());
				URL url = file.toURI().toURL();
				classLoader = new URLClassLoader(new URL[] { url });
				Class clz = classLoader.loadClass(plugin.getClassName());
				clz.getDeclaredMethods();

				AbstractPlugin ob = null;
				ob = (AbstractPlugin) clz.newInstance();

				classList.get(execute.getId()).add(ob);
				instance = ob;
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
					| MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (classLoader != null) {
					// try {
					// classLoader.close();
					// } catch (IOException e) {
					// e.printStackTrace();
					// }
				}
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

		if (!blockResourceList.contains(block.getId())) {
			CopyOnWriteArrayList<Object> array = new CopyOnWriteArrayList<Object>();
			blockResourceList.put(block.getId(), array);
		}

		for (Object ob : blockResourceList.get(block.getId())) {
			if (clz.isAssignableFrom(ob.getClass())) {
				return ob;
			}
		}

		if (clz.equals(DataSource.class)) {
			if (pe.getDataSource() == null) {
				return dataSource;
			}
			DataSourceEntity dataSource = dataSourceDao.findById(pe.getDataSource());

			// TODO Auto-generated method stub
			BoneCPDataSource cpSource = new BoneCPDataSource();
			cpSource.setJdbcUrl(dataSource.getJdbcUrl());
			cpSource.setDriverClass(dataSource.getClassName());
			cpSource.setUsername(dataSource.getUsername());
			cpSource.setPassword(dataSource.getPassword());
			blockResourceList.get(block.getId()).add(cpSource);
			return cpSource;
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

	private class Execute {

		private PluginEntity plugin;
		private PluginMethodEntity method;
		private List<ExecuteParamEntity> exeParams;
		private ExecuteParamEntity returnParam;
		private ExecuteEntity execute;
		private Long sequenceId;
		private int blockId;
		private int processId;
		private Long time;
		private String remark;

		public Execute(PluginEntity plugin, PluginMethodEntity method, List<ExecuteParamEntity> exeParams,
				ExecuteParamEntity returnParam, ExecuteEntity execute, Long sequenceId, int blockId, int processId) { // 从数据库读取
			this.plugin = plugin;
			this.method = method;
			this.exeParams = exeParams;
			this.returnParam = returnParam;
			this.execute = execute;
			this.sequenceId = sequenceId;
			this.blockId = blockId;
			this.processId = processId;
			time = System.currentTimeMillis();

			JSONObject ob = new JSONObject();
			ob.put("pluginId", plugin.getId());
			ob.put("pluginName", plugin.getName());
			ob.put("methodName", method.getName());
			remark = ob.toJSONString();

		}

		public void execute(DataLoader loader) {
			// TODO Auto-generated method stub
			sequenceService.save(BlockConstant.PROCESS_SEQUENCE_STARTCALL, sequenceId, time, processId, blockId,
					execute.getId(), remark);

			if (plugin.getBelongType() == BlockConstant.innerCall) {
				innerCall(loader);
			} else if (plugin.getType() == BlockConstant.outerCall) {
				outerCall(loader);
			}
		}

		private void innerCall(DataLoader loader) {
			try {
				// Class clz = Class.forName(plugin.className);

				AbstractPlugin exe = getClassInstance(execute, plugin);

				sequenceService.save(BlockConstant.PROCESS_SEQUENCE_LOADCLASS, sequenceId,
						System.currentTimeMillis() - time, processId, blockId, execute.getId(), remark);
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

								if (StringUtils.isBlank(loader.parseValue(ep.getParam()))
										|| "null".equals(loader.parseValue(ep.getParam()))) {
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
										ParameterizedType pt = (ParameterizedType) fc;
										Class genericClass = (Class) pt.getActualTypeArguments()[0];

										list.add(loader.parseValue(ep.getParam()));
									} else {
										list.add(loader.parseValue(ep.getParam()));
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
										ParameterizedType pt = (ParameterizedType) fc;
										Class genericClass = (Class) pt.getActualTypeArguments()[1];

										map.put(ep.getPluginMethodParam(), loader.parseValue(ep.getParam()));
									} else {
										map.put(ep.getPluginMethodParam(), loader.parseValue(ep.getParam()));
									}

								} else {
									f.set(params[0], loader.parseValue(ep.getParam()));
								}
							}

						}
					}
				}

				params[1] = parameters[1].getType().newInstance();

				sequenceService.save(BlockConstant.PROCESS_SEQUENCE_LOADDATA, sequenceId,
						System.currentTimeMillis() - time, processId, blockId, execute.getId(), remark);
				m.invoke(exe, params);
				sequenceService.save(BlockConstant.PROCESS_SEQUENCE_INVOKE, sequenceId,
						System.currentTimeMillis() - time, processId, blockId, execute.getId(), remark);
				Field[] fields2 = parameters[1].getType().getDeclaredFields();

				for (ExecuteParamEntity ep : exeParams) {
					if (ep.getType() != BlockConstant.args_type_output) {
						continue;
					}
					for (Field f : fields2) {
						PlguinMethodOutputParamAnnotation anno = f
								.getAnnotation(PlguinMethodOutputParamAnnotation.class);
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
									loader.put(loader.parseValue(ep.getParam()), map.get(ep.getPluginMethodParam()));
								}
							} else {
								if (f.get(params[1]) == null) {
									loader.put(loader.parseValue(ep.getParam()), "");
								} else {
									loader.put(loader.parseValue(ep.getParam()), f.get(params[1]));
								}

							}
							// }

						}
					}
				}

			} catch (SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return;
		}

		private void outerCall(DataLoader loader) {
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
