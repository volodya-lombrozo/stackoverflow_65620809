package com.github.volodyalombrozo.amqp_ack_65620809;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmqpAck65620809Application implements CommandLineRunner {

    @Autowired
    private final Sender sender;

    public AmqpAck65620809Application(final Sender sender) {
        this.sender = sender;
    }

    public static void main(String[] args) {
        SpringApplication.run(AmqpAck65620809Application.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        sender.sendMessage();
    }
}
