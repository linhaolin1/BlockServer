package com.lin.block;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lin.constants.BlockConstant;
import com.lin.entity.PluginEntity;
import com.lin.interfacePackage.Annotation.PluginAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;
import com.lin.service.PluginService;

public class PluginScanner {
//
//	@Autowired
//	PluginService pluginService;
//
//	public void readJar(String jarPath) throws IOException {
//		JarFile file = new JarFile(jarPath);
//		URLClassLoader classLoader = null;
//		File file2 = new File(jarPath);
//		URL url = file2.toURI().toURL();
//		classLoader = new URLClassLoader(new URL[] { url });
//		Enumeration<JarEntry> entrys = file.entries();
//		while (entrys.hasMoreElements()) {
//			JarEntry entry = entrys.nextElement();
//			if (entry.isDirectory()) {
//
//			} else {
//				if (entry.getName().endsWith(".class")) {
//					try {
//						Class clz = classLoader.loadClass(entry.getName()
//								.substring(0, entry.getName().length() - ".class".length()).replace("/", "."));
//						if (clz.getAnnotation(PluginAnnotation.class) != null) {
//							PluginAnnotation ex = (PluginAnnotation) clz.getAnnotation(PluginAnnotation.class);
//							String name = ex.name();
//							String introduce = ex.introduce();
//							System.out.println("name=" + name + ",introduce=" + introduce);
//
//							// savePlugin;
//							PluginEntity plugin = new PluginEntity();
//							plugin.setClassName(entry.getName());
//							plugin.setFileName(jarPath);
//							plugin.setLanguage(BlockConstant.JavaLang);
//							// pluginService.savePlugin();
//
//							Method[] methods = clz.getDeclaredMethods();
//							for (Method m : methods) {
//								if (m.getAnnotation(PluginMethodAnnotation.class) != null) {
//									PluginMethodAnnotation em = (PluginMethodAnnotation) m
//											.getAnnotation(PluginMethodAnnotation.class);
//
//									// saveMethod
//									Parameter[] params = m.getParameters();
//									for (Parameter p : params) {
//										Annotation annotion = p
//												.getDeclaredAnnotation(PluginMethodParamAnnotation.class);
//										Class type = p.getType();
//										// pluginService.saveMethod();
//									}
//
//									System.out.println(em.name() + ":" + m.getName());
//								}
//							}
//
//						}
//					} catch (ClassNotFoundException | NoClassDefFoundError e) {
//						continue;
//					}
//				}
//			}
//		}
//		classLoader.close();
//	}
//
//	public void readPackage(String packageName) {
//
//	}
//
//	private void readClass() {
//
//		// Map<String, Object> objects =
//		// context.getBeansWithAnnotation(Executor.class);
//		// if (null != objects) {
//		// for (Object o : objects.values()) {
//		// Method[] methods = null;
//		// if (AopUtils.isAopProxy(o)) {
//		// methods = getProxyTargetObject(o).getClass().getDeclaredMethods();
//		// } else {
//		// methods = o.getClass().getDeclaredMethods();
//		// }
//		//
//		// if (null != methods) {
//		// for (Method method : methods) {
//		// if (method.isAnnotationPresent(ExecuteMethod.class)) {
//		// ExecuteMethod methodAnno = (ExecuteMethod)
//		// method.getAnnotation(ExecuteMethod.class);
//		// String name = methodAnno.name();
//		// protocalClassMap.put(msgId, mapperClass);
//		// methodMap.put(msgId, method);
//		// serviceClassMap.put(msgId, o);
//		// }
//		// }
//		// }
//		// }
//		// }
//	}
//
//	public static void main(String[] args) throws IOException {
//		String filePath = "C:\\Users\\Administrator\\workspace\\exampleDatabaseController\\target\\exampleDatabaseController-1.0.jar";
//
//	}
}
