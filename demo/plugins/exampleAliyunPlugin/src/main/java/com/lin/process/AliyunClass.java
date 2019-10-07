package com.lin.process;

import java.util.concurrent.ConcurrentHashMap;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.lin.interfacePackage.AbstractPlugin;
import com.lin.interfacePackage.Annotation.PluginAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodAnnotation;
import com.lin.process.req.SendSmsReq;
import com.lin.process.resp.SendSmsResp;

@PluginAnnotation(name = "阿里云", introduce = "没什么好说的", belongType = 1)
public class AliyunClass extends AbstractPlugin {
	private static ConcurrentHashMap<String, IAcsClient> clientMap = new ConcurrentHashMap<String, IAcsClient>();

	@PluginMethodAnnotation(name = "发送短信")
	public void sendSms(SendSmsReq req, SendSmsResp resp) {
		IAcsClient client = null;
		if (clientMap.containsKey(req.getAppKey())) {
			client = clientMap.get(req.getAppKey());
		} else {
			DefaultProfile profile = DefaultProfile.getProfile(
					req.getRegion() == null ? "cn-hangzhou" : req.getRegion(), req.getAppKey(), req.getAppSecret());
			client = new DefaultAcsClient(profile);
			clientMap.put(req.getAppKey(), client);
		}

		CommonRequest request = new CommonRequest();
		request.setMethod(MethodType.POST);
		request.setDomain("dysmsapi.aliyuncs.com");
		request.setVersion("2017-05-25");
		request.setAction("SendSms");
		request.putQueryParameter("PhoneNumbers", req.getPhoneNumber());
		request.putQueryParameter("SignName", req.getSignName());
		request.putQueryParameter("TemplateCode", req.getTemplateCode());
		request.putQueryParameter("TemplateParam", "{\"code\":" + req.getCode() + "}");
		try {
			CommonResponse response = client.getCommonResponse(request);
			resp.setMsg(response.getData());
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		AliyunClass clz = new AliyunClass();

		SendSmsReq req = new SendSmsReq();
		req.setAppKey("LTAI4FntqmSF8Mh134dcsuDf");
		req.setAppSecret("puQt41d7u9DVSpd8oboworN2V8jGgq");
		req.setCode("133843");
		req.setPhoneNumber("18676347565");
		req.setRegion(null);
		req.setSignName("pddxp验证码");
		req.setTemplateCode("SMS_173666152");

		SendSmsResp resp = new SendSmsResp();

		clz.sendSms(req, resp);
		System.out.println(resp.getMsg());
	}

}
