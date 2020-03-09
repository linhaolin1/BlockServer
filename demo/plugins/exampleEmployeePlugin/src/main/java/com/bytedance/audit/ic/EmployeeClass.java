package com.bytedance.audit.ic;


import com.bytedance.audit.ic.req.PeopleListReq;
import com.bytedance.audit.ic.resp.PeopleListResp;
import com.bytedance.audit.ic.viewmodel.PeopleAPIResponse;
import com.lin.interfacePackage.AbstractPlugin;
import com.lin.interfacePackage.Annotation.PluginAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodAnnotation;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@PluginAnnotation(name = "示例Employee插件", introduce = "", belongType = 1)
public class EmployeeClass extends AbstractPlugin {

    @PluginMethodAnnotation(name = "获取peopleList")
    public void peopleList(PeopleListReq req, PeopleListResp resp) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(req.getAppid(), req.getSecret()));
        PeopleAPIResponse response = restTemplate.getForObject(req.getUrl(), PeopleAPIResponse.class);

        if (response.isSuccess()) {
            List list = response.getEmployees();
            resp.setResult(list);
        }
    }

}
