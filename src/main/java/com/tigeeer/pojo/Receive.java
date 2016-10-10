package com.tigeeer.pojo;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by tigeeer on 2016/10/9.
 */
public class Receive {

    private String toMail;
    private String title;
    private String content;

    @NotEmpty
    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }

    @NotEmpty
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

    @Override
    public String toString() {
        return "Receive{" +
                "toMail='" + toMail + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
