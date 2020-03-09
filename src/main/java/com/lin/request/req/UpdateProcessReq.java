package com.lin.request.req;

import com.lin.entity.ProcessArgumentEntity;
import com.lin.nettyserver.http.bean.Propertyable;

import java.util.List;

public class UpdateProcessReq extends Propertyable {
    private String name;
    private String intro;
    private String url;
    private Integer processId;
    private List<ProcessArgumentEntity> inArgs;
    private List<ProcessArgumentEntity> outArgs;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ProcessArgumentEntity> getInArgs() {
        return inArgs;
    }

    public void setInArgs(List<ProcessArgumentEntity> inArgs) {
        this.inArgs = inArgs;
    }

    public List<ProcessArgumentEntity> getOutArgs() {
        return outArgs;
    }

    public void setOutArgs(List<ProcessArgumentEntity> outArgs) {
        this.outArgs = outArgs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

}
