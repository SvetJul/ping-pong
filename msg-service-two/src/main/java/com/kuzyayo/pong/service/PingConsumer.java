package com.kuzyayo.pong.service;

import com.kuzyayo.pong.service.channels.PingInputChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * Created by Iulia on 27.07.2017.
 */
@EnableBinding(PingInputChannel.class)
public class PingConsumer {

    @Autowired
    private PongProducer pongProducer;

    @StreamListener(PingInputChannel.PING_CHANNEL)
    public void consume(Integer payload) throws InterruptedException {
        System.out.println(PingInputChannel.PING_CHANNEL + " " + payload);
        Thread.sleep(1000);
        pongProducer.sendFeedback();
    }

}
