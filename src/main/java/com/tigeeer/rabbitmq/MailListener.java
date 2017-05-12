package com.tigeeer.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/5/12
 * Time: 14:23
 */
@Configuration
public class MailListener {
    public final static String QUEUE_NAME = "mail-queue";
    public final static String EXCHANGE_NAME = "mail-exchange";
    public final static String ROUTING_KEY = "send-mail";

    @Bean
    Queue mailQueue() {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    DirectExchange mailExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding mailBinding(Queue mailQueue, @SuppressWarnings("SpringJavaAutowiringInspection") DirectExchange mailExchange) {
        return BindingBuilder.bind(mailQueue).to(mailExchange).with(ROUTING_KEY);
    }

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Bean
    SimpleMessageListenerContainer mailContainer(ConnectionFactory connectionFactory,
                                                 MessageListenerAdapter mailListenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(mailListenerAdapter);
        return container;
    }

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Bean
    MessageListenerAdapter mailListenerAdapter(MessageReceiver receiver) {
        return new MessageListenerAdapter(receiver, "sendMail");
    }
}
