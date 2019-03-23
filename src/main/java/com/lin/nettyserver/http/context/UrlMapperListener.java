package com.lin.nettyserver.http.context;

import java.lang.reflect.Method;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.lin.nettyserver.http.annotation.HttpHandler;
import com.lin.nettyserver.http.annotation.RequestMapper;
import com.lin.nettyserver.http.codec.HttpDecodec;
import com.lin.nettyserver.http.config.IoMapperConfig;
import com.lin.nettyserver.http.config.UrlMapperConfig;

public class UrlMapperListener implements ApplicationContextAware, ApplicationListener {
	private final Logger logger = LoggerFactory.getLogger(UrlMapperListener.class);
	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void onApplicationEvent(ApplicationEvent event) {
		if ((event instanceof ContextRefreshedEvent)) {
			injectSpring();
		}
	}

	public void injectSpring() {
		UrlMapperConfig urlMapperConfig = (UrlMapperConfig) this.applicationContext.getBean(UrlMapperConfig.class);
		IoMapperConfig ioMapperConfig = (IoMapperConfig) this.applicationContext.getBean(IoMapperConfig.class);

		if (null != urlMapperConfig) {
			Map<String, Object> objects = this.applicationContext.getBeansWithAnnotation(HttpHandler.class);
			if (null != objects) {
				for (Object o : objects.values()) {
					Method[] methods = o.getClass().getMethods();
					if (null != methods) {
						for (Method method : methods) {
							if (method.isAnnotationPresent(RequestMapper.class)) {
								RequestMapper requestMapper = (RequestMapper) method.getAnnotation(RequestMapper.class);
								String url = requestMapper.url();
								String codecName = requestMapper.codecName();
								Class mapperClass = requestMapper.clazz();
								Object codec = this.applicationContext.getBean(codecName);
								if ((null != codec) && ((codec instanceof HttpDecodec))) {
									urlMapperConfig.addDecodecMapper(url, (HttpDecodec) codec);
									urlMapperConfig.addClassMapper(url, mapperClass);
								}

								ioMapperConfig.addClass(requestMapper.clazz(), o);
								ioMapperConfig.addMethod(requestMapper.clazz(), method);

							}
						}
					}
				}
			}
		} else {
			this.logger.warn("urlMapperConfig isn't configure...");
		}
	}
}