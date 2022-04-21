package com.rabbitmqApp.rabbitmq.consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(id = "rabbitmq.queue", queues = "rabbitmq.queue")
public class Consumer {

    private static final Logger logger = LogManager.getLogger(Consumer.class.toString());

    @RabbitHandler
    public String receiveMsg(final String msg) throws Exception {
        logger.info("Message Received from queue: " + msg);
        return "Message Received from queue: " + msg;
    }

}
