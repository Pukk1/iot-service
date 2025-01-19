package com.iver.ruleengine.service.impl;

import com.iver.ruleengine.service.Logger;
import org.springframework.stereotype.Component;

@Component
public class ConsoleLogger implements Logger {

    @Override
    public void log(String message) {
        // System.out.println(message);
    }
}
