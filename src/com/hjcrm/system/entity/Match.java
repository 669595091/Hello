package com.hjcrm.system.entity;

import java.sql.Timestamp;

public class Match {

    public static final Integer IS_MATCH_NO = 0;//未匹配
    public static final Integer IS_MATCH_YES = 1;//已匹配

    private int matchInfoId;// 到账信息主键ID
    private String matchname;// 姓名
    private String payMoney;// 收款金额
    private Timestamp receiveTime;// 收款日期
    private String payType;// 汇款方式
    private String matchnote;// 备注
    private int ismatch;// 是否已匹配 0未匹配 1已匹配
    private int dr;// 删除标志 0未删除 1已删除
    private String studentName;//确认到账对应的学员姓名

    private String receiveStartTime;//收款开始日期
    private String receiveEndTime;//收款结束日期
    private String receive_time;

    public Match() {
        super();
    }

    public Match(int matchInfoId, String matchname, String payMoney, Timestamp receiveTime, String payType, String matchnote, int ismatch, int dr, String studentName, String receiveStartTime, String receiveEndTime, String receive_time) {
        this.matchInfoId = matchInfoId;
        this.matchname = matchname;
        this.payMoney = payMoney;
        this.receiveTime = receiveTime;
        this.payType = payType;
        this.matchnote = matchnote;
        this.ismatch = ismatch;
        this.dr = dr;
        this.studentName = studentName;
        this.receiveStartTime = receiveStartTime;
        this.receiveEndTime = receiveEndTime;
        this.receive_time = receive_time;
    }

    public static Integer getIsMatchNo() {
        return IS_MATCH_NO;
    }

    public static Integer getIsMatchYes() {
        return IS_MATCH_YES;
    }

    public int getMatchInfoId() {
        return matchInfoId;
    }

    public void setMatchInfoId(int matchInfoId) {
        this.matchInfoId = matchInfoId;
    }

    public String getMatchname() {
        return matchname;
    }

    public void setMatchname(String matchname) {
        this.matchname = matchname;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    public Timestamp getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Timestamp receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getMatchnote() {
        return matchnote;
    }

    public void setMatchnote(String matchnote) {
        this.matchnote = matchnote;
    }

    public int getIsmatch() {
        return ismatch;
    }

    public void setIsmatch(int ismatch) {
        this.ismatch = ismatch;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getReceiveStartTime() {
        return receiveStartTime;
    }

    public void setReceiveStartTime(String receiveStartTime) {
        this.receiveStartTime = receiveStartTime;
    }

    public String getReceiveEndTime() {
        return receiveEndTime;
    }

    public void setReceiveEndTime(String receiveEndTime) {
        this.receiveEndTime = receiveEndTime;
    }

    public String getReceive_time() {
        return receive_time;
    }

    public void setReceive_time(String receive_time) {
        this.receive_time = receive_time;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchInfoId=" + matchInfoId +
                ", matchname='" + matchname + '\'' +
                ", payMoney='" + payMoney + '\'' +
                ", receiveTime=" + receiveTime +
                ", payType='" + payType + '\'' +
                ", matchnote='" + matchnote + '\'' +
                ", ismatch=" + ismatch +
                ", dr=" + dr +
                ", studentName='" + studentName + '\'' +
                ", receiveStartTime='" + receiveStartTime + '\'' +
                ", receiveEndTime='" + receiveEndTime + '\'' +
                ", receive_time='" + receive_time + '\'' +
                '}';
    }
}
