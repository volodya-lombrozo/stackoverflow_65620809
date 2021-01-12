package com.github.volodyalombrozo.amqp_ack_65620809;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Listener {
    @RabbitListener(queues = RabbitConfig.QUEUE, containerFactory = "prefetchOneRabbitListenerContainerFactory")
    public static void listen(final String input, final Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) final long tag) throws IOException {
        System.out.println(input);
        System.exit(0);
        System.out.println("Another method");
        channel.basicAck(tag, false);
    }
}