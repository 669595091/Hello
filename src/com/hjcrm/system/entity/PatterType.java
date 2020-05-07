package com.hjcrm.system.entity;

import java.sql.Timestamp;

public class PatterType {

    private int patterTypeId;// 话术场景类别主键
    private int courseid;// 所属课程ID
    private String patterTypeName;// 话术场景类别名称
    private int create_id;// 创建人
    private Timestamp create_time;// 创建时间
    private Timestamp update_time;// 修改时间
    private int update_id;// 修改人
    private int dr;// 删除标志 0未删除 1已删除

    public PatterType() {
        super();
    }

    public PatterType(int patterTypeId, int courseid, String patterTypeName, int create_id, Timestamp create_time, Timestamp update_time, int update_id, int dr) {
        this.patterTypeId = patterTypeId;
        this.courseid = courseid;
        this.patterTypeName = patterTypeName;
        this.create_id = create_id;
        this.create_time = create_time;
        this.update_time = update_time;
        this.update_id = update_id;
        this.dr = dr;
    }

    public int getPatterTypeId() {
        return patterTypeId;
    }

    public void setPatterTypeId(int patterTypeId) {
        this.patterTypeId = patterTypeId;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getPatterTypeName() {
        return patterTypeName;
    }

    public void setPatterTypeName(String patterTypeName) {
        this.patterTypeName = patterTypeName;
    }

    public int getCreate_id() {
        return create_id;
    }

    public void setCreate_id(int create_id) {
        this.create_id = create_id;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    @Override
    public String toString() {
        return "PatterType{" +
                "patterTypeId=" + patterTypeId +
                ", courseid=" + courseid +
                ", patterTypeName='" + patterTypeName + '\'' +
                ", create_id=" + create_id +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", update_id=" + update_id +
                ", dr=" + dr +
                '}';
    }
}
