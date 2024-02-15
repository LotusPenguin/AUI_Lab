package com.example.aui_lab.device.service.api;


import com.example.aui_lab.device.entity.Device;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeviceService {
    Optional<Device> find(UUID id);

    List<Device> findAll();

    void create(Device device);

    void update(Device device);

    void delete(UUID id);

    Optional<List<Device>> findAllByCategory(UUID categoryId);

}
