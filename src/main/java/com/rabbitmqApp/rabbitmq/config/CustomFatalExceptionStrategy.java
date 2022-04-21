/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rabbitmqApp.rabbitmq.config;

import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomFatalExceptionStrategy extends ConditionalRejectingErrorHandler.DefaultExceptionStrategy {

    private final Logger logger = LogManager.getLogger(getClass());

    @Override
    public boolean isFatal(Throwable t) {
        if (t instanceof ListenerExecutionFailedException) {
            ListenerExecutionFailedException lefe = (ListenerExecutionFailedException) t;
            logger.error("Failed to process inbound message from queue "
                    + lefe.getFailedMessage().getMessageProperties().getConsumerQueue()
                    + "; failed message: " + lefe.getFailedMessage(), t);
        }
        return super.isFatal(t);
    }
}
