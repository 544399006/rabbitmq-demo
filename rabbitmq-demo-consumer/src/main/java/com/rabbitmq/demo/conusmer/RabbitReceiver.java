package com.rabbitmq.demo.conusmer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver {
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "queue-1",durable = "true"),
    exchange = @Exchange(value = "exchange-1",durable = "true",
    type = "topic",ignoreDeclarationExceptions = "true"),key = "springboot.*"))
    @RabbitHandler
    public void onMessage(Message message, Channel channel){

    }
}
