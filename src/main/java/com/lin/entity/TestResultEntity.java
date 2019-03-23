package com.lin.entity;

public class TestResultEntity extends AbstractEntity {
	private String testValues;
	private String result;
	private Long spendTime = 0L;
	private int plugin = 0;
	private int method = 0;

	public Long getSpendTime() {
		return spendTime;
	}

	public void setSpendTime(Long spendTime) {
		this.spendTime = spendTime;
	}

	public String getTestValues() {
		return testValues;
	}

	public void setTestValues(String testValues) {
		this.testValues = testValues;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getPlugin() {
		return plugin;
	}

	public void setPlugin(int plugin) {
		this.plugin = plugin;
	}

	public int getMethod() {
		return method;
	}

	public void setMethod(int method) {
		this.method = method;
	}

}
