package com.iver.controller.service.impl;

import com.iver.controller.dto.input.DevicePackageInput;
import com.iver.controller.model.DevicePackage;
import com.iver.controller.repository.DevicePackageRepository;
import com.iver.controller.service.IotService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IotServiceImpl implements IotService {

    private final RabbitTemplate rabbitTemplate;

    private final DevicePackageRepository devicePackageRepository;

    @Override
    public void processRequest(DevicePackageInput devicePackageInput) {
        rabbitTemplate.convertAndSend("test message");
        devicePackageRepository.save(new DevicePackage());
    }
}
