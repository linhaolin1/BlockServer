package com.lin.entity;

public class PluginMethodEntity extends AbstractEntity {
	private Integer plugin = 0;
	private String name;
	private String methodName;
	private String introduction; // 输入 输出说明
	private Integer returnType = 0; // 1:数组 2：对象 3：简单类型

	public Integer getPlugin() {
		return plugin;
	}

	public void setPlugin(Integer plugin) {
		this.plugin = plugin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getReturnType() {
		return returnType;
	}

	public void setReturnType(Integer returnType) {
		this.returnType = returnType;
	}

}
