
组件需要继承AbstractPlugin类，并且注解配置在对应的类和方法上，使得积木通过classloader读取和扫描jar包中的class，保存类名和方法名在数据库中，使得能在业务流程图配置的时候选择该组件
每个组件的方法都需要有2个参数，第一个参数为输入内容类，第二个为输出内容类
```java
import com.lin.interfacePackage.AbstractPlugin;
import com.lin.interfacePackage.Annotation.PluginAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodAnnotation;

@PluginAnnotation(name = "阿里云", introduce = "阿里云工具", belongType = 1)
public class AliyunClass extends AbstractPlugin {

	@PluginMethodAnnotation(name = "发送短信")
	public void sendSms(SendSmsReq req, SendSmsResp resp) {
		...
	}
}

```

同样需要在对应的参数上加上注解，以提供给流程获取
```java
public class SendSmsReq {
	@PluginMethodParamAnnotation(displayName = "appKey", fieldName = "")
	String appKey;
	@PluginMethodParamAnnotation(displayName = "appSecret", fieldName = "")
	String appSecret;
	@PluginMethodParamAnnotation(displayName = "目标号码", fieldName = "")
	String phoneNumber;
	@PluginMethodParamAnnotation(displayName = "验证码", fieldName = "")
	String code;
	...
}

public class SendSmsResp {
	@PlguinMethodOutputParamAnnotation(displayName = "调用结果")
	String msg;
	...
}
```


在一些特殊的情况下需要根据部分参数生成更多的输入/输出参数（比如保存到数据库），则需要组件继承AbstractVariableParamPlugin类并实现getParams方法
```java
@com.lin.interfacePackage.Annotation.PluginAnnotation(name = "测试数据库", introduce = "", belongType = 1)
public class MainClass extends AbstractVariableParamPlugin {


@Override
	public void getParams(VariableParamReq req, VariableParamResp resp) {
		// TODO Auto-generated method stub
		if (req.getMethodName() == null)
			return;

		switch (req.getMethodName()) {
		case "directSql":
			try {
				Integer count = Integer.parseInt(req.getMap().get("设置数量"));
				List<PluginMethodParamAnnotationClass> list = new ArrayList<PluginMethodParamAnnotationClass>();
				for (int i = 1; i <= count; i++) {
					PluginMethodParamAnnotationClass clz = new PluginMethodParamAnnotationClass(String.valueOf(i),
							ParamType.Optional, null, null, null, "map");
					list.add(clz);
				}
				resp.setInArgs(list);
				return;
			} catch (Exception e) {

			}
			break;
			...
```
在流程图中配置组件的默认参数时会触发该方法，通过该方法返回的输入输出参数内容，改变流程图中组件所需要配置的参数
