package com.tigeeer.pojo;

/**
 * Created by InteliJ IDEA.
 * User: tigeeer
 * Date: 12/12/2016
 * Time: 12:54 AM
 */
public class MailMessage {

    private String address;
    private String title;
    private String content;

    public MailMessage() {}

    public MailMessage(String address, String title, String content) {
        this.address = address;
        this.title = title;
        this.content = content;
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
}
