package com.lin.util;

import com.ecwid.consul.v1.ConsulClient;
import com.lin.actions.ProcessAction;
import com.lin.dao.ProcessDao;
import com.lin.entity.ProcessEntity;
import com.lin.nettyserver.http.codec.unspecified.UnspecifiedDecodec;
import com.lin.nettyserver.http.codec.unspecified.UnspecifiedReq;
import com.lin.nettyserver.http.config.IoMapperConfig;
import com.lin.nettyserver.http.config.UrlMapperConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DynamicRequestLoader implements ApplicationContextAware, ApplicationListener {

	private ApplicationContext context;

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		System.out.println("dynamic request init");

		if ((event instanceof ContextRefreshedEvent)) {
			ProcessDao dao = context.getBean(ProcessDao.class);
			IoMapperConfig ioConfig = context.getBean(IoMapperConfig.class);
			UrlMapperConfig urlConfig = context.getBean(UrlMapperConfig.class);
			UnspecifiedDecodec decoder = context.getBean(UnspecifiedDecodec.class);
			ConsulClient client = context.getBean(ConsulClient.class);
			if (dao != null && ioConfig != null && urlConfig != null) {
				List<ProcessEntity> requests = dao.findAll();
				for (ProcessEntity entity : requests) {
					if(StringUtils.isBlank(entity.getUrl())){
						continue;
					}
					urlConfig.addDecodecMapper("/block-server/"+entity.getUrl(), decoder);
					urlConfig.addClassMapper("/block-server/"+entity.getUrl(), UnspecifiedReq.class);
					ioConfig.addClass(UnspecifiedReq.class, context.getBean(ProcessAction.class));
					
					try {
						ioConfig.addMethod(UnspecifiedReq.class, context.getBean(ProcessAction.class).getClass()
								.getDeclaredMethod("dynamicRequest", UnspecifiedReq.class));
					} catch (BeansException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			} else {
				System.out.println("init dynamic request error");
			}

		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.context = applicationContext;

	}

}
