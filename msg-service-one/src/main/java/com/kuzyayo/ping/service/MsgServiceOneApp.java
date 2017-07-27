package com.kuzyayo.ping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Created by Iulia on 27.07.2017.
 */
@EnableBinding(Processor.class)
@SpringBootApplication
public class MsgServiceOneApp {

    @Autowired
    private IterationKeeper iteration;

    public static void main(String[] args) {
        SpringApplication.run(MsgServiceOneApp.class, args);
    }

    @Bean
    public CommandLineRunner run(Processor processor, IterationKeeper iteration) {
        return args -> {
            processor.output().send(MessageBuilder.withPayload(iteration.getIncremented()).build());
        };
    }

}
