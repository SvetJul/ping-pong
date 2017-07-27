package com.kuzyayo.pong.service.channels;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Iulia on 27.07.2017.
 */
public interface PongOutputChannel {

    String PONG_CHANNEL = "pong";

    @Output(PONG_CHANNEL)
    SubscribableChannel pong();

}
