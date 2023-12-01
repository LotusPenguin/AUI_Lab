package com.example.aui_lab.device.controller.api;

import com.example.aui_lab.device.dto.GetDeviceResponse;
import com.example.aui_lab.device.dto.GetDevicesResponse;
import com.example.aui_lab.device.dto.PutDeviceRequest;

import java.util.UUID;

public interface DeviceController {
    GetDevicesResponse getDevices();
    GetDevicesResponse getCategoryDevices(UUID categoryId);
    GetDeviceResponse getDevice(UUID id);
    void putDevice(UUID id, PutDeviceRequest request);
    void deleteDevice(UUID id);
}
