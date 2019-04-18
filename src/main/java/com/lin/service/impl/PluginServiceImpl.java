package com.lin.service.impl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lin.constants.BlockConstant;
import com.lin.dao.ExecuteParamDao;
import com.lin.dao.PluginDao;
import com.lin.dao.PluginMethodDao;
import com.lin.dao.TestResultDao;
import com.lin.entity.PluginEntity;
import com.lin.entity.PluginMethodEntity;
import com.lin.entity.TestResultEntity;
import com.lin.interfacePackage.AbstractPlugin;
import com.lin.interfacePackage.AbstractVariableParamPlugin;
import com.lin.interfacePackage.Annotation.ParamType;
import com.lin.interfacePackage.Annotation.PluginAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;
import com.lin.request.req.GetAvailablePluginsReq;
import com.lin.request.req.GetPluginMethodReq;
import com.lin.request.req.GetPluginsReq;
import com.lin.request.resp.GetAvailablePluginsResp;
import com.lin.request.resp.GetPluginMethodResp;
import com.lin.request.resp.GetPluginsResp;
import com.lin.service.PluginService;

@Service
@Transactional
public class PluginServiceImpl implements PluginService {

	@Autowired
	PluginDao pluginDao;
	@Autowired
	PluginMethodDao pluginMethodDao;

	@Autowired
	TestResultDao testResultDao;

	@Autowired
	ExecuteParamDao executeParamDao;

	public void savePlugin(final String fileName, final String name, final String introduce) {
		List<String> classList = null;
		try {
			classList = getClassNameByJar(fileName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (classList == null) {
			return;
		}

		final CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

		ExecutorService executors = Executors.newFixedThreadPool(10);
		URLClassLoader cl;
		try {
			File file = new File(fileName);
			URL url = file.toURI().toURL();
			final URLClassLoader classLoader = new URLClassLoader(new URL[] { url });
			cl=classLoader;
			for (final String className : classList) {
				executors.execute(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Class clz = null;
						try {
							clz = classLoader.loadClass(className);
						} catch (ClassNotFoundException e) {
						}
						PluginAnnotation anno = (PluginAnnotation) clz.getAnnotation(PluginAnnotation.class);
						if (anno != null) {
							try {
								Object instance = clz.newInstance();

								PluginEntity plugin = pluginDao.findByClass(className);
								Method[] methods = clz.getDeclaredMethods();
								if (plugin != null) {
									// if (!checkCompatible(instance,
									// plugin.getId(),
									// methods)) {
									// throw new IllegalArgumentException(" not
									// compatible！");
									// }
									plugin.setIntroduction(introduce);
									plugin.setName(name);
									pluginDao.update(plugin);

								} else {
									plugin = new PluginEntity();
									plugin.setClassName(className);
									plugin.setFileName(fileName);
									plugin.setBelongType(BlockConstant.innerCall);

									plugin.setLanguage(BlockConstant.JavaLang);
									plugin.setIntroduction(introduce);
									plugin.setName(name);
									plugin.setType(BlockConstant.innerCall);
									pluginDao.insert(plugin);
								}

								for (Method method : methods) {

									PluginMethodAnnotation exm = method.getAnnotation(PluginMethodAnnotation.class);
									System.out.println(method.getName() + "  " + (exm == null));
									if (exm == null)
										continue;

									PluginMethodEntity pme = new PluginMethodEntity();
									pme.setMethodName(method.getName());
									pme.setPlugin(plugin.getId());
									Integer existsId = pluginMethodDao.findByPluginAndMethodName(pme);

									if (existsId != null && existsId > 0) {
										pme.setId(existsId);
										pme.setIntroduction(exm.introduce());
										pme.setName(exm.name());
										pluginMethodDao.update(pme);
									} else {
										pme.setIntroduction(exm.introduce());
										pme.setMethodName(method.getName());
										pme.setName(exm.name());
										// testMethod(instance, method);
										pluginMethodDao.insert(pme);
									}

								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						} else {
							;
						}
					}
				});

			}
			executors.shutdown();
			
			while (!executors.isTerminated()) {
				wait(2*1000);
			}
			cl.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void testMethod(Object instance, Method method) {
		PluginMethodAnnotation exm = method.getAnnotation(PluginMethodAnnotation.class);
		if (exm == null) {
			return;
		}
		HashMap<PluginMethodParamAnnotation, TestValue> map = getTestValueArray(instance, method);

		List<TestResultEntity> enableResults = testEnableValues(instance, method, map);
		testUnableValues(instance, method, map);

	}

	private void testUnableValues(Object instance, Method method, HashMap<PluginMethodParamAnnotation, TestValue> map) {
		// TODO Auto-generated method stub

	}

	private List<TestResultEntity> testEnableValues(Object instance, Method method,
			HashMap<PluginMethodParamAnnotation, TestValue> map) {
		// TODO Auto-generated method stub
		PluginMethodAnnotation exm = method.getAnnotation(PluginMethodAnnotation.class);

		Parameter[] parameters = method.getParameters();
		PluginMethodParamAnnotation[] params = new PluginMethodParamAnnotation[parameters.length];
		for (int i = 0; i < parameters.length; i++) {
			params[i] = parameters[i].getAnnotation(PluginMethodParamAnnotation.class);
		}

		AbstractPlugin temp = (AbstractPlugin) instance;
		// boolean allValueTested = false;
		boolean allValueTested = true;
		boolean variableValueTested = true;
		PluginMethodParamAnnotation[] necessary = null;
		HashMap<PluginMethodParamAnnotation, TestValue> variableMap = new HashMap<PluginMethodParamAnnotation, TestValue>();
		List<TestResultEntity> resultArray = new ArrayList<TestResultEntity>();
		while (!allValueTested) {
			TestResultEntity result = new TestResultEntity();

			Long startDate = System.currentTimeMillis();

			StringBuilder sb = new StringBuilder();
			Object[] ob = new Object[parameters.length];
			for (int i = 0; i < parameters.length; i++) {
				ob[i] = map.get(params[i]).getValue(map.get(params[i]).position, true);
				sb.append(parameters[i].getName() + ":" + map.get(params[i]).getValue(map.get(params[i]).position, true)
						+ "|");
			}

			// if (instance instanceof AbstractVariableParamPlugin) {
			// AbstractVariableParamPlugin temp2 = (AbstractVariableParamPlugin)
			// instance;
			//
			// if (variableValueTested) {
			// necessary = temp2.getNecessaryParams(method.getName());
			// variableValueTested = false;
			// for (PluginMethodParamAnnotation pa : necessary) {
			// TestValue test = new TestValue(pa, getTestCorrectValue(pa),
			// getTestIncorrectValue(pa));
			// variableMap.put(pa, test);
			// }
			// }
			//
			// for (PluginMethodParamAnnotation pa : necessary) {
			// temp.setParam(pa.name(),
			// variableMap.get(pa).getValue(variableMap.get(pa).position,
			// true));
			// sb.append(pa.name() + ":" +
			// variableMap.get(pa).getValue(variableMap.get(pa).position, true)
			// + "|");
			// }
			// }

			result.setTestValues(sb.toString());

			try {
				if (method.getReturnType().getName().equals("void")) {

				} else {
					Object resultObject = method.invoke(instance, ob);
					result.setResult(JSON.toJSONString(resultObject));
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				result.setResult(e.getMessage());
			}

			Long endDate = System.currentTimeMillis();
			result.setSpendTime(endDate - startDate);

			// testResultDao.save(result);
			resultArray.add(result);
			// temp.clearParam();

			if (instance instanceof AbstractVariableParamPlugin && !variableValueTested) {
				if (necessary == null) {
					throw new IllegalArgumentException("necessary should not be null!");
				}

				variableMap.get(necessary[necessary.length - 1]).position++;
				for (int i = necessary.length - 1; i >= 0; i--) {
					if (variableMap.get(necessary[i]).position == variableMap.get(necessary[i]).correctValue.length) {
						if (i == 0) {
							variableValueTested = true;
						} else {
							variableMap.get(necessary[i - 1]).position++;
							variableMap.get(necessary[i]).position = 0;
						}
					}
				}

			} else {
				variableMap.clear();

				map.get(params[params.length - 1]).position++;
				for (int i = params.length - 1; i >= 0; i--) {
					if (map.get(params[i]).position == map.get(params[i]).correctValue.length) {
						if (i == 0) {
							allValueTested = true;
						} else {
							map.get(params[i - 1]).position++;
							map.get(params[i]).position = 0;
						}
					}
				}
			}

		}
		return resultArray;

	}

	private HashMap<PluginMethodParamAnnotation, TestValue> getTestValueArray(Object instance, Method method) {
		// TODO Auto-generated method stub
		HashMap<PluginMethodParamAnnotation, TestValue> valueMap = new HashMap<PluginMethodParamAnnotation, TestValue>();

		Parameter[] parameters = method.getParameters();
		PluginMethodParamAnnotation[] params = new PluginMethodParamAnnotation[parameters.length];
		for (int i = 0; i < parameters.length; i++) {
			params[i] = parameters[i].getAnnotation(PluginMethodParamAnnotation.class);
			TestValue test = new TestValue(params[i], getTestCorrectValue(parameters[i], params[i]),
					getTestIncorrectValue(parameters[i], params[i]));
			valueMap.put(params[i], test);
		}

		return valueMap;
	}

	private void saveOrUpdateMethods(Method m) {
		// TODO Auto-generated method stub
		PluginMethodAnnotation exm = m.getAnnotation(PluginMethodAnnotation.class);
		if (exm == null) {
			return;
		}

	}

	private boolean checkCompatible(Object instance, int plugin, Method[] methods) {
		List<PluginMethodEntity> list = pluginMethodDao.findByPlugin(plugin);

		for (Method method : methods) {
			Parameter[] parameters = method.getParameters();
			PluginMethodParamAnnotation[] params = new PluginMethodParamAnnotation[parameters.length];
			for (int i = 0; i < parameters.length; i++) {
				params[i] = parameters[i].getAnnotation(PluginMethodParamAnnotation.class);
			}
			HashMap<PluginMethodParamAnnotation, TestValue> valueMap = new HashMap<PluginMethodParamAnnotation, TestValue>();

			List<TestResultEntity> existsResults = testResultDao.findTestRecord(plugin, method);

			List<TestResultEntity> enableResults = testEnableValues(instance, method, valueMap);
			// compare
			if (existsResults.size() == 0) {

			}

		}

		return false;
	}

	private Object[] getTestCorrectValue(Parameter parameter, PluginMethodParamAnnotation anno) {
		if (anno.isNecessary() == ParamType.Necessary) {

		} else {

		}

		switch (parameter.getType().getName()) {
		case "java.lang.Integer":
			return new Integer[] { anno.size().max(), anno.size().min() };
		case "java.lang.String":
			return new String[] { null, "" };
		case "ArrayList?":
			return new String[] {};
		}
		return null;
	}

	private Object[] getTestIncorrectValue(Parameter parameter, PluginMethodParamAnnotation anno) {
		if (anno.isNecessary() == ParamType.Necessary) {

		} else {

		}

		switch (parameter.getType().getName()) {
		case "java.lang.Integer":
			return new Integer[] { null, 0, anno.size().min() - 1, anno.size().max() + 1 };
		case "java.lang.String":
			return new String[] { null, "" };
		case "ArrayList?":
			return new String[] {};
		}
		return null;
	}

	public static List<String> getClassNameByJar(String jarPath) throws IOException {
		List<String> myClassName = new ArrayList<String>();
		JarFile jarFile = null;
		try {
			jarFile = new JarFile(jarPath);
			Enumeration<JarEntry> entrys = jarFile.entries();
			while (entrys.hasMoreElements()) {
				JarEntry jarEntry = entrys.nextElement();
				String entryName = jarEntry.getName();
				if (entryName.endsWith(".class")) {
					entryName = entryName.replace("/", ".").substring(0, entryName.lastIndexOf("."));
					myClassName.add(entryName);
				}
			}
		} catch (Exception e) {
			// SystemLog.Log(LogType.systemInfo, e.getMessage(), e);
		} finally {
			if (jarFile != null) {
				jarFile.close();
			}
		}
		return myClassName;
	}


	private class TestValue {
		PluginMethodParamAnnotation anno;
		Object[] correctValue;
		Object[] incorrectValue;
		int position = 0;
		boolean type = true;

		public TestValue(PluginMethodParamAnnotation anno, Object[] correctValue, Object[] incorrectValue) {
			this.anno = anno;
			this.correctValue = correctValue;
			this.incorrectValue = incorrectValue;
		}

		public Object getValue(int position, boolean type) {
			if (type) {
				return correctValue[position];
			} else {
				return incorrectValue[position];
			}
		}
	}

	@Override
	public void getPlugins(GetPluginsReq req, GetPluginsResp resp) {
		// TODO Auto-generated method stub
		List<PluginEntity> list = pluginDao.findPlugins(req.getFilterName(), req.getPluginType());
		List<JSONObject> array = new ArrayList<JSONObject>();
		for (PluginEntity pe : list) {
			JSONObject ob = (JSONObject) JSON.toJSON(pe);
			ob.put("methods", pluginMethodDao.findByPlugin(pe.getId()));
			array.add(ob);
		}

		resp.setList(array);
	}

	@Override
	public void getAvailablePlugins(GetAvailablePluginsReq req, GetAvailablePluginsResp resp) {
		// TODO Auto-generated method stub
		List<PluginEntity> list = pluginDao.findByAvailPlugins();
		List<JSONObject> array = new ArrayList<JSONObject>();
		for (PluginEntity pe : list) {
			JSONObject ob = (JSONObject) JSON.toJSON(pe);
			ob.put("methods", pluginMethodDao.findByPlugin(pe.getId()));
			array.add(ob);
		}
		resp.setList(array);

	}

	@Override
	public void getPluginMethods(GetPluginMethodReq req, GetPluginMethodResp resp) {
		// TODO Auto-generated method stub
		resp.setMethods(pluginMethodDao.findByPlugin(req.getPluginId()));
	}
}
