package com.lin.tianyancha;

import com.lin.interfacePackage.AbstractVariableParamPlugin;
import com.lin.interfacePackage.Annotation.PluginAnnotation;
import com.lin.interfacePackage.request.VariableParamReq;
import com.lin.interfacePackage.request.VariableParamResp;

@PluginAnnotation(name = "微信功能", introduce = "", belongType = 1)
public class MainClass extends AbstractVariableParamPlugin {

    @Override
    public void getParams(VariableParamReq variableParamReq, VariableParamResp variableParamResp) {
        
    }
}

