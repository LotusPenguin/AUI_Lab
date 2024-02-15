package com.example.aui_lab.device.controller.impl;

import com.example.aui_lab.device.controller.api.DeviceController;
import com.example.aui_lab.device.dto.GetDeviceResponse;
import com.example.aui_lab.device.dto.GetDevicesResponse;
import com.example.aui_lab.device.dto.PutDeviceRequest;
import com.example.aui_lab.device.function.DeviceToResponseFunction;
import com.example.aui_lab.device.function.DevicesToResponseFunction;
import com.example.aui_lab.device.function.RequestToDeviceFunction;
import com.example.aui_lab.device.service.api.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Controller
public class DeviceDefaultController implements DeviceController {

    private final DeviceService service;
    private final DeviceToResponseFunction deviceToResponse;
    private final DevicesToResponseFunction devicesToResponse;
    private final RequestToDeviceFunction requestToDevice;

    @Autowired
    public DeviceDefaultController(
            DeviceService service,
            DeviceToResponseFunction deviceToResponse,
            DevicesToResponseFunction devicesToResponse,
            RequestToDeviceFunction requestToDevice
    ) {
        this.service = service;
        this.deviceToResponse = deviceToResponse;
        this.devicesToResponse = devicesToResponse;
        this.requestToDevice = requestToDevice;
    }

    @Override
    public GetDevicesResponse getDevices() {
        return devicesToResponse.apply(service.findAll());
    }

    @Override
    public GetDevicesResponse getCategoryDevices(UUID categoryId) {
        return service.findAllByCategory(categoryId)
                .map(devicesToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetDeviceResponse getDevice(UUID id) {
        return service.find(id).map(deviceToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putDevice(UUID id, PutDeviceRequest request) {
        service.create(requestToDevice.apply(id, request));
    }

    @Override
    public void deleteDevice(UUID id) {
        service.find(id).ifPresentOrElse(
                user -> service.delete(id),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                });
    }
}
