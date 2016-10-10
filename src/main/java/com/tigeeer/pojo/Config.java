package com.tigeeer.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by tigeeer on 2016/10/9.
 */
@ConfigurationProperties(prefix = "email",locations = "classpath:config.properties")
public class Config {

    public static String smtp;
    public static String user;
    public static String password;

    public static String getSmtp() {
        return smtp;
    }

    public static void setSmtp(String smtp) {
        Config.smtp = smtp;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Config.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Config.password = password;
    }
}
