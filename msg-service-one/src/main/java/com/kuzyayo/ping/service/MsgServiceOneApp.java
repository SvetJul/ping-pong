package com.kuzyayo.ping.service;

import com.kuzyayo.ping.service.channels.PingOutputChannel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

/**
 * Created by Iulia on 27.07.2017.
 */
@EnableBinding(PingOutputChannel.class)
@SpringBootApplication
public class MsgServiceOneApp {

    public static void main(String[] args) {
        SpringApplication.run(MsgServiceOneApp.class, args);
    }

    @Bean
    public CommandLineRunner run(PingProducer pingProducer) {
        return args -> {
            pingProducer.sendFeedback();
        };
    }

}
