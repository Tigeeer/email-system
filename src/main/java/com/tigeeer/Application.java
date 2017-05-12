package com.tigeeer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tigeeer.pojo.MailMessage;
import com.tigeeer.rabbitmq.MailListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by InteliJ IDEA.
 * User: tigeeer
 * Date: 12/12/2016
 * Time: 12:54 AM
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MailMessage mailMessage = new MailMessage("1606088706@qq.com", "测试标题", "测试内容");
        rabbitTemplate.convertAndSend(MailListener.EXCHANGE_NAME, MailListener.ROUTING_KEY, new ObjectMapper().writeValueAsString(mailMessage));
    }
}
