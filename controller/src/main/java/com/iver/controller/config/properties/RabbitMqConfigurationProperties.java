package com.iver.controller.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitMqConfigurationProperties {
    private final String queueName;
}
