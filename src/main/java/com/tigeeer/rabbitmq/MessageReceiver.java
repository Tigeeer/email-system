package com.tigeeer.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tigeeer.pojo.MailMessage;
import com.tigeeer.util.MailUtil;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/4/19
 * Time: 16:23
 */
@Component
public class MessageReceiver {

    private MailUtil mailUtil;
    private ExecutorService executor;

    public MessageReceiver(MailUtil mailUtil) {
        this.mailUtil = mailUtil;
        executor = Executors.newFixedThreadPool(20);
    }

    public void sendMail(String message) {
        executor.submit(() -> {
            try {
                mailUtil.send(new ObjectMapper().readValue(message, MailMessage.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
