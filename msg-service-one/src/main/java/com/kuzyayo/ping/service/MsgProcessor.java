package com.kuzyayo.ping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

/**
 * Created by Iulia on 27.07.2017.
 */
@EnableBinding(Processor.class)
public class MsgProcessor {

    @Autowired
    private IterationKeeper iteration;

    @Value("${spring.cloud.stream.bindings.input.destination}")
    private String inputChannel;


    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Object transform(Object message) throws InterruptedException {
        System.out.println(" " + message);
        Thread.sleep(2000);
        return iteration.getIncremented();
    }

}
