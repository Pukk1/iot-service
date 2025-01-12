package com.iver.datasimulator.config.properties;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "data.simulation")
public class DataSimulationProperties {
    volatile private Integer deviceNumber;
    volatile private Integer messagePerSecond;
}
