package com.lin.interfacePackage.Annotation;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PluginMethodParamAnnotationClass {
	String displayName;
	ParamType isNecessary;
	Pattern pattern;
	String[] optional;
	Size size;
	String fieldName;

	public PluginMethodParamAnnotationClass(String displayName, ParamType isNecessary, Pattern pattern,
			String[] optional, Size size, String fieldName) {
		this.displayName = displayName;
		this.isNecessary = isNecessary;
		this.pattern = pattern;
		this.optional = optional;
		this.size = size;
		this.fieldName = fieldName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public ParamType getIsNecessary() {
		return isNecessary;
	}

	public void setIsNecessary(ParamType isNecessary) {
		this.isNecessary = isNecessary;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public String[] getOptional() {
		return optional;
	}

	public void setOptional(String[] optional) {
		this.optional = optional;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

}
