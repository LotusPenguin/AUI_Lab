package com.example.aui_lab.device.controller;

import java.util.UUID;

public interface DeviceController {
    GetDevicesResponse getDevices();
    GetDevicesResponse getCategoryDevices(UUID categoryId);
    GetDeviceResponse getDevice(UUID id);
    void putDevice(UUID id, PutDeviceRequest request);
    void deleteDevice(UUID id);
}
