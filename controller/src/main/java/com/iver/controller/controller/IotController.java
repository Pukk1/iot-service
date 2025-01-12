package com.iver.controller.controller;

import com.iver.controller.dto.input.DevicePackageInput;
import com.iver.controller.service.IotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/iot")
public class IotController {
    private final IotService iotService;

    @PostMapping
    public ResponseEntity<?> executeIotPackage(@RequestBody DevicePackageInput input) {
        iotService.processRequest(input);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
