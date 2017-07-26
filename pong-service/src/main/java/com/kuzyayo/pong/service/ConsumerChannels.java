package com.kuzyayo.pong.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Iulia on 27.07.2017.
 */
public interface ConsumerChannels {
    @Input
    SubscribableChannel testQueue();
}
