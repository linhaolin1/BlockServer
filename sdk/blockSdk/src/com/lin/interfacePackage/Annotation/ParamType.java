package com.lin.interfacePackage.Annotation;

public enum ParamType {
	Necessary(Integer.valueOf(1)), Optional(Integer.valueOf(2));

	private Integer value;

	private ParamType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return this.value;
	}
}
