package com.hjcrm.system.entity;

import java.sql.Timestamp;

public class Dealrecord {

    private int dealrecordId;// 成交记录主键ID
    private int resourceId;// 资源ID
    private int studentId;// 学员ID
    private int courseid;// 课程ID
    private int subjectid;// 科目ID
    private int userid;// 创建人
    private Timestamp create_time;// 创建日期
    private int update_id;// 修改人
    private Timestamp update_time;// 修改日期
    private String note;// 备注
    private int dr;// 删除标志 0未删除 1已删除
    private Timestamp scoretime;// 考试时间
    private String score;// 考试成绩
    private int ispass;// 是否通过 0未通过 1通过 2缺考

    public Dealrecord() {
        super();
    }

    public Dealrecord(int dealrecordId, int resourceId, int studentId, int courseid, int subjectid, int userid, Timestamp create_time, int update_id, Timestamp update_time, String note, int dr, Timestamp scoretime, String score, int ispass) {
        this.dealrecordId = dealrecordId;
        this.resourceId = resourceId;
        this.studentId = studentId;
        this.courseid = courseid;
        this.subjectid = subjectid;
        this.userid = userid;
        this.create_time = create_time;
        this.update_id = update_id;
        this.update_time = update_time;
        this.note = note;
        this.dr = dr;
        this.scoretime = scoretime;
        this.score = score;
        this.ispass = ispass;
    }

    public int getDealrecordId() {
        return dealrecordId;
    }

    public void setDealrecordId(int dealrecordId) {
        this.dealrecordId = dealrecordId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
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

    public Timestamp getScoretime() {
        return scoretime;
    }

    public void setScoretime(Timestamp scoretime) {
        this.scoretime = scoretime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getIspass() {
        return ispass;
    }

    public void setIspass(int ispass) {
        this.ispass = ispass;
    }

    @Override
    public String toString() {
        return "Dealrecord{" +
                "dealrecordId=" + dealrecordId +
                ", resourceId=" + resourceId +
                ", studentId=" + studentId +
                ", courseid=" + courseid +
                ", subjectid=" + subjectid +
                ", userid=" + userid +
                ", create_time=" + create_time +
                ", update_id=" + update_id +
                ", update_time=" + update_time +
                ", note='" + note + '\'' +
                ", dr=" + dr +
                ", scoretime=" + scoretime +
                ", score='" + score + '\'' +
                ", ispass=" + ispass +
                '}';
    }
}
