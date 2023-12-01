package com.example.aui_lab.device.function;

import com.example.aui_lab.device.dto.GetDevicesResponse;
import com.example.aui_lab.device.entity.Device;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class DevicesToResponseFunction implements Function<List<Device>, GetDevicesResponse> {
    @Override
    public GetDevicesResponse apply(List<Device> devices) {
        return GetDevicesResponse.builder()
                .devices(devices.stream()
                        .map(device -> GetDevicesResponse.Device.builder()
                                .id(device.getId())
                                .name(device.getName())
                                .build())
                        .toList())
                .build();
    }
}
