package com.rabbitmqApp.rabbitmq.Producer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    private static Logger logger = LogManager.getLogger(Producer.class.toString());

    public void sendMsg(final String msg) throws Exception {
        rabbitTemplate.convertAndSend(queue.getName(), msg);
        Thread.sleep(1000L);
    }

}
