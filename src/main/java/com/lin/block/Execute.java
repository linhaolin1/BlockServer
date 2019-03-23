package com.lin.block;

public class Execute {

//	private PluginEntity plugin;
//	private PluginMethodEntity method;
//	private List<ExecuteParamEntity> exeParams;
//	private Reader reader;
//
//	public Execute(PluginEntity plugin, PluginMethodEntity method, List<ExecuteParamEntity> exeParams, Reader reader) { // 从数据库读取
//		this.plugin = plugin;
//		this.method = method;
//		this.exeParams = exeParams;
//		this.reader = reader;
//	}
//
//	public void execute(DataLoader loader, DataSource dataSource) {
//		// TODO Auto-generated method stub
//		if (plugin.getBelongType() == BlockConstant.innerCall) {
//			innerCall(loader, dataSource);
//		} else if (plugin.getType() == BlockConstant.outerCall) {
//			outerCall(loader, dataSource);
//		}
//	}
//
//	private void innerCall(DataLoader loader, DataSource dataSource) {
//		try {
//			// Class clz = Class.forName(plugin.className);
//			AbstractPlugin exe = reader.getClassInstance(plugin);
//
//			if (exe instanceof AbstractSQLPlugin) {
//				AbstractSQLPlugin sqlexe = (AbstractSQLPlugin) exe;
//				sqlexe.setDataSource(dataSource);
//			}
//
//			Object object = null;
//			Method m = exe.getClass().getMethod(method.getMethodName());
//			Parameter[] parameters = m.getParameters();
//			Object[] params = new Object[parameters.length];
//			for (int i = 0; i < parameters.length; i++) {
//				for (ExecuteParamEntity ep : exeParams) {
//					if (ep.getPluginMethodParam().equals(parameters[i].getName())) {
//						params[i] = loader.parseValue(parameters[i].getType(), ep.getParam());
//						break;
//					}
//				}
//
//			}
//
//			// } else {
//
//			object = m.invoke(exe, params);
//			exe.clearParam();
//			// }
//
//		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
//				| InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return;
//	}
//
//	private void outerCall(DataLoader loader, DataSource dataSource) {
//		BufferedReader br = null;
//		StringBuilder sb = new StringBuilder();
//		try {
//			StringBuilder cmd = new StringBuilder();
//			if (plugin.getLanguage() == BlockConstant.JavaLang) {// java
//				cmd.append("java -jar " + plugin.getFileName());
//				for (ExecuteParamEntity pa : exeParams)
//					cmd.append(" " + loader.parseValue(String.class, pa.getParam()));
//			} else if (plugin.getLanguage() == BlockConstant.CCPLUS) {// C C++调用
//				cmd.append("java -jar " + plugin.getFileName());
//				for (ExecuteParamEntity pa : exeParams)
//					cmd.append(" " + loader.parseValue(String.class, pa.getParam()));
//			} else if (plugin.getLanguage() == BlockConstant.Python) {// PYTHON调用
//				cmd.append("java -jar " + plugin.getFileName());
//				for (ExecuteParamEntity pa : exeParams)
//					cmd.append(" " + loader.parseValue(String.class, pa.getParam()));
//			}
//			java.lang.Process p = Runtime.getRuntime().exec(cmd.toString());
//			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//
//			String line = null;
//
//			while ((line = br.readLine()) != null) {
//				sb.append(line);
//			}
//			// if (method.getType() == BlockConstant.method_type_return) {
//			// String string = sb.toString();
//			// Object changeObject = null;
//			// switch (method.getReturnType()) {
//			// case BlockConstant.method_return_array:
//			// changeObject = JSONArray.fromObject(string);
//			// break;
//			// case BlockConstant.method_return_object:
//			// changeObject = JSONObject.fromObject(string);
//			// break;
//			// case BlockConstant.method_return_simple:
//			// changeObject = string;
//			// break;
//			// }
//
//			// if (string != null && method.getType() ==
//			// BlockConstant.method_type_return) {
//			// switch (plugin.getBelongType()) {
//			// case BlockConstant.plugin_belong_sql:
//			// loader.valueMap.get(BlockConstant.belong_data).put(returnName,
//			// changeObject);
//			// break;
//			// case BlockConstant.plugin_belong_outer:
//			// loader.valueMap.get(BlockConstant.belong_outer).put(returnName,
//			// changeObject);
//			// break;
//			// case BlockConstant.plugin_belong_transform:
//			// loader.valueMap.get(BlockConstant.belong_transform).put(returnName,
//			// changeObject);
//			// break;
//			// default:
//			// break;
//			// }
//			// }
//			// } else {
//			// return;
//			// }
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (br != null) {
//				try {
//					br.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//		}
//		return;
//	}
//
//	public PluginEntity getPlugin() {
//		return plugin;
//	}
//
//	public void setPlugin(PluginEntity plugin) {
//		this.plugin = plugin;
//	}
//
//	public PluginMethodEntity getMethod() {
//		return method;
//	}
//
//	public void setMethod(PluginMethodEntity method) {
//		this.method = method;
//	}
//
//	public List<ExecuteParamEntity> getExeParams() {
//		return exeParams;
//	}
//
//	public void setExeParams(List<ExecuteParamEntity> exeParams) {
//		this.exeParams = exeParams;
//	}

}
