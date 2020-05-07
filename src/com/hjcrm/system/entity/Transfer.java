package com.hjcrm.system.entity;

import java.sql.Timestamp;

public class Transfer {

    private int transferrecordId;//转移记录ID
    private int resourceId;//资源ID
    private String phone;//手机号
    private String tel;//座机
    private int sourceId;//数据来源人ID
    private String sourceName;//数据来源人
    private int belongId;//归属者ID
    private String belongName;//归属者
    private Timestamp create_time;//转移时间
    private int state;//资源状态  0未分配 1已分配(未处理) 2已处理
    private int deptid;//部门ID
    private int source;//渠道: 0自建  1课程注册  2在线注册  3app下载注册   4电话咨询   5金考网注册用户   6线上渠道  7在线咨询  8大库资源 9 在线购买
    private int operationId;//操作人ID
    private String operationName;//操作人姓名
    private String resourceLevelBefore;//转移前资源等级     A B C D
    private String resourceLevelAfter;//转移后资源等级     A B C D
    private String createStarttime;//转移开始时间
    private String createEndtime;//转移结束时间

    public Transfer() {
        super();
    }

    public Transfer(int transferrecordId, int resourceId, String phone, String tel, int sourceId, String sourceName, int belongId, String belongName, Timestamp create_time, int state, int deptid, int source, int operationId, String operationName, String resourceLevelBefore, String resourceLevelAfter, String createStarttime, String createEndtime) {
        this.transferrecordId = transferrecordId;
        this.resourceId = resourceId;
        this.phone = phone;
        this.tel = tel;
        this.sourceId = sourceId;
        this.sourceName = sourceName;
        this.belongId = belongId;
        this.belongName = belongName;
        this.create_time = create_time;
        this.state = state;
        this.deptid = deptid;
        this.source = source;
        this.operationId = operationId;
        this.operationName = operationName;
        this.resourceLevelBefore = resourceLevelBefore;
        this.resourceLevelAfter = resourceLevelAfter;
        this.createStarttime = createStarttime;
        this.createEndtime = createEndtime;
    }

    public int getTransferrecordId() {
        return transferrecordId;
    }

    public void setTransferrecordId(int transferrecordId) {
        this.transferrecordId = transferrecordId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public int getBelongId() {
        return belongId;
    }

    public void setBelongId(int belongId) {
        this.belongId = belongId;
    }

    public String getBelongName() {
        return belongName;
    }

    public void setBelongName(String belongName) {
        this.belongName = belongName;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getResourceLevelBefore() {
        return resourceLevelBefore;
    }

    public void setResourceLevelBefore(String resourceLevelBefore) {
        this.resourceLevelBefore = resourceLevelBefore;
    }

    public String getResourceLevelAfter() {
        return resourceLevelAfter;
    }

    public void setResourceLevelAfter(String resourceLevelAfter) {
        this.resourceLevelAfter = resourceLevelAfter;
    }

    public String getCreateStarttime() {
        return createStarttime;
    }

    public void setCreateStarttime(String createStarttime) {
        this.createStarttime = createStarttime;
    }

    public String getCreateEndtime() {
        return createEndtime;
    }

    public void setCreateEndtime(String createEndtime) {
        this.createEndtime = createEndtime;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transferrecordId=" + transferrecordId +
                ", resourceId=" + resourceId +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", sourceId=" + sourceId +
                ", sourceName='" + sourceName + '\'' +
                ", belongId=" + belongId +
                ", belongName='" + belongName + '\'' +
                ", create_time=" + create_time +
                ", state=" + state +
                ", deptid=" + deptid +
                ", source=" + source +
                ", operationId=" + operationId +
                ", operationName='" + operationName + '\'' +
                ", resourceLevelBefore='" + resourceLevelBefore + '\'' +
                ", resourceLevelAfter='" + resourceLevelAfter + '\'' +
                ", createStarttime='" + createStarttime + '\'' +
                ", createEndtime='" + createEndtime + '\'' +
                '}';
    }
}
