package com.kuzyayo.ping.service;

import com.kuzyayo.ping.service.channels.PingOutputChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Created by Iulia on 27.07.2017.
 */
@Service
public class PingProducer {

    private int iteration;

    private MessageChannel pingChannel;

    public PingProducer(PingOutputChannel outputChannel) {
        this.pingChannel = outputChannel.ping();
    }

    public void sendFeedback(){
        Message<Integer> msg = MessageBuilder.withPayload(++iteration).build();
        pingChannel.send(msg);
    }
}
