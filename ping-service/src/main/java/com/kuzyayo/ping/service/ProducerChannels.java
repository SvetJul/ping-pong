package com.kuzyayo.ping.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by Iulia on 27.07.2017.
 */
public interface ProducerChannels {

    @Output
    MessageChannel testQueue();

}
