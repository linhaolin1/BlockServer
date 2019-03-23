package com.lin.entity;

import java.util.List;

public class DataTableEntity extends AbstractEntity{
	String name;
	
	List<String> columns;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	
}
