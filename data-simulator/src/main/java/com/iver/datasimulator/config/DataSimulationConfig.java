package com.iver.datasimulator.config;

import com.iver.datasimulator.config.properties.DataSimulationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
@RequiredArgsConstructor
public class DataSimulationConfig {

    private final DataSimulationProperties dataSimulationProperties;

    @Bean
    public ScheduledExecutorService threadPoolExecutor() {
        return Executors.newScheduledThreadPool(dataSimulationProperties.getDeviceNumber());
    }
}
