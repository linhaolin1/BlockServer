package com.lin.plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lin.constants.BlockConstant;
import com.lin.entity.ProcessArgumentEntity;
import com.lin.interfacePackage.AbstractVariableParamPlugin;
import com.lin.interfacePackage.Annotation.ParamType;
import com.lin.interfacePackage.Annotation.PluginAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotationClass;
import com.lin.interfacePackage.request.VariableParamReq;
import com.lin.interfacePackage.request.VariableParamResp;
import com.lin.plugin.request.ExecureProcessReq;
import com.lin.plugin.request.ExecuteProcessResp;
import com.lin.request.req.GetProcessReq;
import com.lin.request.req.ProcessReq;
import com.lin.request.resp.GetProcessResp;
import com.lin.request.resp.ProcessResp;
import com.lin.service.ProcessService;

@PluginAnnotation(name = "流程插件", introduce = "跨流程调用", belongType = 1)
@Component
public class ProcessPlugin extends AbstractVariableParamPlugin {
	@Autowired
	ProcessService processService;

	@PluginMethodAnnotation(name = "调用流程")
	public void executeProcess(ExecureProcessReq req, ExecuteProcessResp resp) {
		ProcessReq executeReq = new ProcessReq();
		executeReq.setProcessId(Integer.parseInt(req.getProcessId()));
		executeReq.setObject(req.getMap());
		ProcessResp executeResp = new ProcessResp();
		processService.executeProcess(executeReq, executeResp, null);
		HashMap map = new HashMap();
		if (executeResp.getResponse() != null)
			map.putAll(executeResp.getResponse());
		resp.setOutMap(map);
	}

	@Override
	public void getParams(VariableParamReq req, VariableParamResp resp) {
		// TODO Auto-generated method stub
		GetProcessReq infoReq = new GetProcessReq();
		infoReq.setId(Integer.parseInt(req.getMap().get("流程ID")));
		GetProcessResp infoResp = new GetProcessResp();
		processService.getProcess(infoReq, infoResp);

		List<PluginMethodParamAnnotationClass> list = new ArrayList<PluginMethodParamAnnotationClass>();
		List<PluginMethodParamAnnotationClass> list2 = new ArrayList<PluginMethodParamAnnotationClass>();

		for (ProcessArgumentEntity pa : infoResp.getArgs()) {
			if (pa.getType() == BlockConstant.args_type_input) {
				PluginMethodParamAnnotationClass clz = new PluginMethodParamAnnotationClass(pa.getName(),
						ParamType.Optional, null, null, null, "map");
				list.add(clz);
			} else if (pa.getType() == BlockConstant.args_type_output) {
				PluginMethodParamAnnotationClass clz2 = new PluginMethodParamAnnotationClass(pa.getName(),
						ParamType.Optional, null, null, null, "outMap");
				list2.add(clz2);
			}
		}
		resp.setInArgs(list);
		resp.setOutArgs(list2);
	}
}
