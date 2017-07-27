package com.kuzyayo.ping.service;

import com.kuzyayo.ping.service.channels.PongInputChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * Created by Iulia on 27.07.2017.
 */
@EnableBinding(PongInputChannel.class)
public class PongConsumer {

    @Autowired
    private PingProducer pingProducer;

    @StreamListener(PongInputChannel.PONG_CHANNEL)
    public void consume(Integer payload) throws InterruptedException {
        System.out.println(PongInputChannel.PONG_CHANNEL + " " + payload);
        Thread.sleep(1000);
        pingProducer.sendFeedback();
    }
}
