//package com.lin.service.impl;
//
//import java.io.File;
//import java.lang.reflect.Field;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLClassLoader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.jolbox.bonecp.BoneCPDataSource;
//import com.lin.NettyServer;
//import com.lin.block.ProcessArgument;
//import com.lin.block.ProcessArgumentComplex;
//import com.lin.block.ProcessIntro;
//import com.lin.constants.BlockConstant;
//import com.lin.dao.PluginDao;
//import com.lin.dao.PluginMethodDao;
//import com.lin.dao.PluginMethodTestDao;
//import com.lin.entity.BlockEntity;
//import com.lin.entity.DataSourceEntity;
//import com.lin.entity.ExecuteEntity;
//import com.lin.entity.PluginEntity;
//import com.lin.entity.PluginMethodEntity;
//import com.lin.entity.ProcessArgumentComplexEntity;
//import com.lin.entity.ProcessArgumentEntity;
//import com.lin.entity.ProcessEntity;
//import com.lin.entity.TestRecrodEntity;
//import com.lin.interfacePackage.AbstractPlugin;
//import com.lin.interfacePackage.Annotation.InitParam;
//import com.lin.request.req.PluginTestReq;
//import com.lin.request.req.ProcessTestReq;
//import com.lin.request.resp.PluginTestResp;
//import com.lin.request.resp.ProcessTestResp;
//import com.lin.service.TesterService;
//
//public class TesterServiceImpl implements TesterService {
//
//	@Autowired
//	PluginDao pluginDao;
//
//	@Autowired
//	PluginMethodDao pluginMethodDao;
//
//	@Autowired
//	PluginMethodTestDao pluginMethodTestDao;
//
//	@Override
//	public void testPlugin(PluginTestReq req, PluginTestResp resp) {
//		// TODO Auto-generated method stub
//		PluginMethodEntity method=pluginMethodDao.findById(req.getMethod());
//		PluginEntity plugin=pluginDao.findById(method.getPlugin());
//		
//		List<TestRecrodEntity> records=pluginMethodTestDao.findByMethod(req.getMethod());
//		
//		if(records.size()>0){
//			retest(records);
//		}else{
//			
//			
//			
//		}
//		
//		
//		
//		 
//		yes
//		 input and output record
//		 
//		no 
//		  find record and compare
//		  
//		  
//		returnResult
//		
//		
//		
//	}
//
//	private void retest(List<TestRecrodEntity> records) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void testProcess(ProcessTestReq req, ProcessTestResp resp) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public AbstractPlugin getClassInstance(PluginEntity plugin) {
//		// TODO Auto-generated method stub
//		AbstractPlugin instance = null;
//		try {
//			if ((instance = (AbstractPlugin) NettyServer.context
//					.getBean(Class.forName(plugin.getClassName()))) != null) {
//				return instance;
//			}
//		} catch (Exception e) {
//
//		}
//
//		ClassLoader cl;
//		if (instance == null) {
//			URLClassLoader classLoader = null;
//			try {
//				File file = new File(plugin.getFileName());
//				URL url = file.toURI().toURL();
//				classLoader = new URLClassLoader(new URL[] { url });
//				Class clz = classLoader.loadClass(plugin.getClassName());
//				clz.getDeclaredMethods();
//
//				AbstractPlugin ob = null;
//				ob = (AbstractPlugin) clz.newInstance();
//
//				instance = ob;
//			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
//					| MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} finally {
//				if (classLoader != null) {
//					// try {
//					// classLoader.close();
//					// } catch (IOException e) {
//					// e.printStackTrace();
//					// }
//				}
//			}
//		}
//		Field[] fields = instance.getClass().getDeclaredFields();
//		for (Field f : fields) {
//			if (f.getAnnotation(InitParam.class) != null) {
//				f.setAccessible(true);
//				try {
//					f.set(instance, getBlockResource(f.getType()));
//				} catch (IllegalArgumentException | IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//
//		return instance;
//	}
//
//	private Object getBlockResource(Class clz) {
//
//		if (clz.equals(DataSource.class)) {
//			DataSourceEntity dataSource = dataSourceDao.findById(pe.getDataSource());
//			
//			// TODO Auto-generated method stub
//			BoneCPDataSource cpSource = new BoneCPDataSource();
//			cpSource.setJdbcUrl(dataSource.getJdbcUrl());
//			cpSource.setDriverClass(dataSource.getClassName());
//			cpSource.setUsername(dataSource.getUsername());
//			cpSource.setPassword(dataSource.getPassword());
//			blockResourceList.get(block.getId()).add(cpSource);
//			return cpSource;
//		}
//
//		return null;
//
//	}
//
//}
