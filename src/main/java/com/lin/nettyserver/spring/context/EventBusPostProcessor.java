package com.lin.nettyserver.spring.context;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class EventBusPostProcessor implements BeanPostProcessor {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private EventBus eventBus;

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Method[] methods = bean.getClass().getMethods();

		for (Method method : methods) {
			Annotation annotation = method.getAnnotation(Subscribe.class);
			if (annotation != null) {
				this.eventBus.register(bean);
				this.logger.debug("Bean {} containing method {} was subscribed to {}",
						new Object[] { beanName, method.getName(), EventBus.class.getCanonicalName() });

				return bean;
			}
		}
		return bean;

	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
