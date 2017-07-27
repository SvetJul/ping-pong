package com.kuzyayo.ping.service.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Iulia on 27.07.2017.
 */
public interface PongInputChannel {

    String PONG_CHANNEL = "pong";

    @Input(PONG_CHANNEL)
    SubscribableChannel pong();

}
