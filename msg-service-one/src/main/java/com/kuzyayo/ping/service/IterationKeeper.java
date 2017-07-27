package com.kuzyayo.ping.service;

import org.springframework.stereotype.Service;

/**
 * Created by Iulia on 27.07.2017.
 */
@Service
public class IterationKeeper {

    private int iteration;

    public int getIncremented() {
        return ++iteration;
    }

}
