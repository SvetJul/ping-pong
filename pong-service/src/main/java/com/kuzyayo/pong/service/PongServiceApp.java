package com.kuzyayo.pong.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

/**
 * Created by Iulia on 27.07.2017.
 */

@EnableBinding(ConsumerChannels.class)
@SpringBootApplication
public class PongServiceApp {

    @Bean
    IntegrationFlow integrationFlow(ConsumerChannels input) {
        return IntegrationFlows.from(input.testQueue()).handle(String.class, (payload, headers) -> {
            System.out.println("Message received: " + payload + "!!!");
            return null;
        }).get();

    }

    public static void main(String[] args) {
        SpringApplication.run(PongServiceApp.class, args);
    }
}
