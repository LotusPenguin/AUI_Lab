package com.example.aui_lab.device.controller.api;

import com.example.aui_lab.device.dto.GetDeviceResponse;
import com.example.aui_lab.device.dto.GetDevicesResponse;
import com.example.aui_lab.device.dto.PutDeviceRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface DeviceController {
    @GetMapping("/api/devices")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetDevicesResponse getDevices();

    @GetMapping("/api/categories/{categoryId}/devices")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetDevicesResponse getCategoryDevices(@PathVariable("categoryId") UUID categoryId);

    @GetMapping("/api/devices/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetDeviceResponse getDevice(@PathVariable("id") UUID id);

    @PutMapping("/api/devices/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putDevice(@PathVariable("id") UUID id, @RequestBody PutDeviceRequest request);

    @DeleteMapping("/api/devices/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteDevice(@PathVariable("id") UUID id);
}
