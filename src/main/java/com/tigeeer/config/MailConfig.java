package com.tigeeer.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/5/12
 * Time: 11:15
 */
@Configuration
@EnableAutoConfiguration
@PropertySource({"classpath:config.properties"})
@ConfigurationProperties(prefix = "mail")
public class MailConfig {

    private String smtp;
    private String user;
    private String password;

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
