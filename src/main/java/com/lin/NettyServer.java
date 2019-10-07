package com.lin;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import com.lin.util.FileManager;
import org.csource.common.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lin.entity.BlockEntity;
import com.lin.service.PluginService;

public class NettyServer {
	private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);
	public static AbstractApplicationContext context;

	public static void main(String[] args) throws InterruptedException, BeansException, ClassNotFoundException, IOException, MyException {
		context = new ClassPathXmlApplicationContext("spring/spring.xml");
		context.registerShutdownHook();

		logger.info("NettyServer start successful...");
		new Thread(new Runnable() {
			public void run() {
				while (true)
					try {
						Thread.currentThread().sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}).start();

//		PluginService service = context.getBean(PluginService.class);
//		service.savePlugin("D:\\Users\\lion\\workspace\\examplePayPlugin\\target\\examplePayPlugin-1.0.jar",
//				"支付宝", "");
	}
}
