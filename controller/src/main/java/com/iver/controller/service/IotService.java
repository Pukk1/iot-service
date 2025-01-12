package com.iver.controller.service;

import com.iver.controller.dto.input.DevicePackageInput;

public interface IotService {
    void processRequest(DevicePackageInput devicePackageInput);
}
