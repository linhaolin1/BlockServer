package com.lin.interfacePackage;

import com.lin.interfacePackage.request.VariableParamReq;
import com.lin.interfacePackage.request.VariableParamResp;

public abstract class AbstractVariableParamPlugin extends AbstractPlugin {
	public abstract void getParams(VariableParamReq req,VariableParamResp resp);

}
