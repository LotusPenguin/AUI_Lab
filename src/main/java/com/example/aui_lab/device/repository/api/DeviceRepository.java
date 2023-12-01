package com.example.aui_lab.device.repository.api;

import com.example.aui_lab.device.entity.Category;
import com.example.aui_lab.device.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<Device, UUID> {
    List<Device> findAllByCategory(Category category);
}
