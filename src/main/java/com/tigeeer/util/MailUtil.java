package com.tigeeer.util;


import com.tigeeer.config.MailConfig;
import com.tigeeer.pojo.MailMessage;
import com.tigeeer.pojo.Record;
import com.tigeeer.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by InteliJ IDEA.
 * User: tigeeer
 * Date: 12/12/2016
 * Time: 12:54 AM
 */
@Service
public class MailUtil {

    private static final Logger logger = LoggerFactory.getLogger(MailUtil.class);

    private MailConfig mailConfig;
    private RecordService recordService;

    public MailUtil(MailConfig mailConfig, RecordService recordService) {
        this.mailConfig = mailConfig;
        this.recordService = recordService;
    }

    public void send(MailMessage mm) {
        final Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", mailConfig.getSmtp());
        props.put("mail.user", mailConfig.getUser());
        props.put("mail.password", mailConfig.getPassword());

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };

        try {
            Session mailSession = Session.getInstance(props, authenticator);
            MimeMessage message = new MimeMessage(mailSession);
            InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
            message.setFrom(form);

            InternetAddress to = new InternetAddress(mm.getAddress());
            message.setRecipient(RecipientType.TO, to);
            message.setSubject(mm.getTitle());
            message.setContent(mm.getContent(), "text/html;charset=UTF-8");

            Transport.send(message);
            recordService.insert(new Record(mm.getAddress(), mm.getTitle(), mm.getContent(), true, ""));
            logger.info(String.format("Send Mail Success: {address: %s, title: %s}", mm.getAddress(), mm.getTitle()));
        } catch (MessagingException e) {
            recordService.insert(new Record(mm.getAddress(), mm.getTitle(), mm.getContent(), false, e.getMessage()));
            logger.info(String.format("Send Mail Fail: {address: %s, title: %s}", mm.getAddress(), mm.getTitle()));
        }
    }
}