package com.kuzyayo.ping.service.channels;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Iulia on 27.07.2017.
 */
public interface PingOutputChannel {

    String PING_CHANNEL = "ping";

    @Output(PING_CHANNEL)
    SubscribableChannel ping();

}
