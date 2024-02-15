package com.example.aui_lab.device.function;

import com.example.aui_lab.device.dto.PatchDeviceRequest;
import com.example.aui_lab.device.entity.Device;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateDeviceWithRequestFunction implements BiFunction<Device, PatchDeviceRequest, Device> {
    @Override
    public Device apply(Device device, PatchDeviceRequest request){
        return Device.builder()
                .id(device.getId())
                .name(request.getName())
                .manufacturer(request.getManufacturer())
                .category(device.getCategory())
                .build();
    }
}
