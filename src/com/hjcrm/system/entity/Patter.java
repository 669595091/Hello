package com.hjcrm.system.entity;

import java.sql.Timestamp;

public class Patter {

    private int patterid;// 话术主键
    private int userid;// 用户id,话术创建人
    private int roleid;// 用户角色ID
    private int courseid;// 课程id
    private int patterTypeId;// 话术场景类别
    private int contentTypeId;// 话术内容类别
    private String shortTitle;// 话术内容短标题
    private String content;// 话术内容
    private Timestamp create_time;// 创建时间
    private Timestamp update_time;// 修改时间
    private int update_id;// 修改人
    private int isshare;// 是否共享 0不共享 1共享
    private String note;// 备注
    private int dr;// 删除标志 0未删除 1已删除

    public Patter() {
        super();
    }

    public Patter(int patterid, int userid, int roleid, int courseid, int patterTypeId, int contentTypeId, String shortTitle, String content, Timestamp create_time, Timestamp update_time, int update_id, int isshare, String note, int dr) {
        this.patterid = patterid;
        this.userid = userid;
        this.roleid = roleid;
        this.courseid = courseid;
        this.patterTypeId = patterTypeId;
        this.contentTypeId = contentTypeId;
        this.shortTitle = shortTitle;
        this.content = content;
        this.create_time = create_time;
        this.update_time = update_time;
        this.update_id = update_id;
        this.isshare = isshare;
        this.note = note;
        this.dr = dr;
    }

    public int getPatterid() {
        return patterid;
    }

    public void setPatterid(int patterid) {
        this.patterid = patterid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getPatterTypeId() {
        return patterTypeId;
    }

    public void setPatterTypeId(int patterTypeId) {
        this.patterTypeId = patterTypeId;
    }

    public int getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(int contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public int getIsshare() {
        return isshare;
    }

    public void setIsshare(int isshare) {
        this.isshare = isshare;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    @Override
    public String toString() {
        return "Patter{" +
                "patterid=" + patterid +
                ", userid=" + userid +
                ", roleid=" + roleid +
                ", courseid=" + courseid +
                ", patterTypeId=" + patterTypeId +
                ", contentTypeId=" + contentTypeId +
                ", shortTitle='" + shortTitle + '\'' +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", update_id=" + update_id +
                ", isshare=" + isshare +
                ", note='" + note + '\'' +
                ", dr=" + dr +
                '}';
    }
}
