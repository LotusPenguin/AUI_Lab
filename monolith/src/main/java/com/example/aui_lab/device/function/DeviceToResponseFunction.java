package com.example.aui_lab.device.function;

import com.example.aui_lab.device.dto.GetDeviceResponse;
import com.example.aui_lab.device.entity.Device;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DeviceToResponseFunction implements Function<Device, GetDeviceResponse> {
    @Override
    public GetDeviceResponse apply(Device device) {
        return GetDeviceResponse.builder()
                .id(device.getId())
                .name(device.getName())
                .manufacturer(device.getManufacturer())
                .category(GetDeviceResponse.Category.builder()
                        .id(device.getCategory().getId())
                        .name(device.getCategory().getName())
                        .build())
                .build();
    }
}
