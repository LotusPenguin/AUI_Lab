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
    /**
     * Seeks for single device
     *
     * @param id   device's id
     * @param category device's category
     * @return container (can be empty) with device
     */
    Optional<Character> findByIdAndCategory(UUID id, Category category);

    /**
     * Seeks for all devices in a given category
     *
     * @param category devices' category
     * @return list (can be empty) of devices in a given category
     */
    List<Device> findAllByCategory(Category category);
    /**
     * Seeks for single device
     *
     * @param id device's id
     * @return container (can be empty) with device
     */
    Optional<Device> findDeviceById(UUID id);

}
