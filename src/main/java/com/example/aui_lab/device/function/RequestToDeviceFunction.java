package com.example.aui_lab.device.function;

import com.example.aui_lab.device.dto.PutDeviceRequest;
import com.example.aui_lab.device.entity.Category;
import com.example.aui_lab.device.entity.Device;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;
@Component
public class RequestToDeviceFunction implements BiFunction<UUID, PutDeviceRequest, Device> {

    @Override
    public Device apply(UUID id, PutDeviceRequest request) {
        return Device.builder()
                .id(id)
                .name(request.getName())
                .manufacturer(request.getManufacturer())
                .category(Category.builder()
                        .id(request.getCategory())
                        .build())
                .build();
    }

}
