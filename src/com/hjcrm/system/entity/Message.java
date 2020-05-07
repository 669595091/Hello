package com.hjcrm.system.entity;

import java.sql.Timestamp;

public class Message {
    private int systemmessageId;// 系统消息主键
    private String messagetitle;// 消息标题
    private String messageContent;// 消息内容
    private int issend;// 是否发布 0未发布 1已发布
    private Timestamp send_time;// 消息发布时间
    private Timestamp create_time;// 创建时间
    private int create_id;// 创建人

    public Message() {
        super();
    }

    public Message(int systemmessageId, String messagetitle, String messageContent, int issend, Timestamp send_time, Timestamp create_time, int create_id) {
        this.systemmessageId = systemmessageId;
        this.messagetitle = messagetitle;
        this.messageContent = messageContent;
        this.issend = issend;
        this.send_time = send_time;
        this.create_time = create_time;
        this.create_id = create_id;
    }

    public int getIssend() {
        return issend;
    }

    public void setIssend(int issend) {
        this.issend = issend;
    }

    public int getSystemmessageId() {
        return systemmessageId;
    }

    public void setSystemmessageId(int systemmessageId) {
        this.systemmessageId = systemmessageId;
    }

    public String getMessagetitle() {
        return messagetitle;
    }

    public void setMessagetitle(String messagetitle) {
        this.messagetitle = messagetitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Timestamp getSend_time() {
        return send_time;
    }

    public void setSend_time(Timestamp send_time) {
        this.send_time = send_time;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getCreate_id() {
        return create_id;
    }

    public void setCreate_id(int create_id) {
        this.create_id = create_id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "systemmessageId=" + systemmessageId +
                ", messagetitle='" + messagetitle + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", issend=" + issend +
                ", send_time=" + send_time +
                ", create_time=" + create_time +
                ", create_id=" + create_id +
                '}';
    }
}
