package com.kuzyayo.ping.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Created by Iulia on 27.07.2017.
 */
@EnableBinding(ProducerChannels.class)
@SpringBootApplication
public class PingServiceApp {

    private final MessageChannel channel;


    public PingServiceApp(ProducerChannels channel) {
        this.channel = channel.testQueue();
    }

    public static void main(String[] args) {
        SpringApplication.run(PingServiceApp.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            Message<String> msg = MessageBuilder.withPayload("Hi there!").build();
            channel.send(msg);
            System.out.println("Message sent!!!");
        };
    }

}
