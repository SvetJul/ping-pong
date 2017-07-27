package com.kuzyayo.pong.service;

import com.kuzyayo.pong.service.channels.PongOutputChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Created by Iulia on 27.07.2017.
 */
@Service
public class PongProducer {

    private int iteration;

    private MessageChannel pongChannel;

    public PongProducer(PongOutputChannel pongChannel) {
        this.pongChannel = pongChannel.pong();
    }

    public void sendFeedback(){
        Message<Integer> msg = MessageBuilder.withPayload(++iteration).build();
        pongChannel.send(msg);
    }
}
