package com.kuzyayo.pong.service.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Iulia on 27.07.2017.
 */
public interface PingInputChannel {

    String PING_CHANNEL = "ping";

    @Input(PING_CHANNEL)
    SubscribableChannel ping();

}
