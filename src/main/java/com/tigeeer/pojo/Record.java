package com.tigeeer.pojo;

import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/5/12
 * Time: 15:54
 */
public class Record {

    private String address;
    private String title;
    private String content;
    private boolean completed;
    private String reason;
    private Timestamp sendTime;

    public Record(String address, String title, String content, boolean completed, String reason) {
        this.address = address;
        this.title = title;
        this.content = content;
        this.completed = completed;
        this.reason = reason;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }
}
