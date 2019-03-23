package com.lin.interfacePackage;

import javax.sql.DataSource;

public abstract class AbstractSQLPlugin extends AbstractVariableParamPlugin {
	public abstract void setDataSource(DataSource dataSource);

}
