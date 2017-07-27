package com.kuzyayo.pong.service;

import com.kuzyayo.pong.service.channels.PongOutputChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Created by Iulia on 27.07.2017.
 */

@EnableBinding(PongOutputChannel.class)
@SpringBootApplication
public class MsgServiceTwoApp {

    public static void main(String[] args) {
        SpringApplication.run(MsgServiceTwoApp.class, args);
    }
}
