package com.lin.entity;

import java.io.Serializable;

public class HtmlParamEntity extends AbstractEntity implements Serializable {
	Double width;
	Double height;
	Double top;
	Double left;
	Double column;
	Double row;
	Integer type; // 1 grid 2:tree 3. pic 4 text 5 Carousel
	String template;

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getTop() {
		return top;
	}

	public void setTop(Double top) {
		this.top = top;
	}

	public Double getLeft() {
		return left;
	}

	public void setLeft(Double left) {
		this.left = left;
	}

	public Double getColumn() {
		return column;
	}

	public void setColumn(Double column) {
		this.column = column;
	}

	public Double getRow() {
		return row;
	}

	public void setRow(Double row) {
		this.row = row;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
