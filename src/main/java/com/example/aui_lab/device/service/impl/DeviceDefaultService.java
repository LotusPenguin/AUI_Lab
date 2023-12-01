package com.example.aui_lab.device.service.impl;

import com.example.aui_lab.device.entity.Device;
import com.example.aui_lab.device.repository.api.CategoryRepository;
import com.example.aui_lab.device.repository.api.DeviceRepository;
import com.example.aui_lab.device.service.api.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeviceDefaultService implements DeviceService {

    private final DeviceRepository repository;
    private final CategoryRepository categoryRepository;

    @Autowired DeviceDefaultService(
            DeviceRepository repository,
            CategoryRepository categoryRepository
    ) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Device> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Device> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<List<Device>> findAllByCategory(UUID categoryId) {
        return categoryRepository.findById(categoryId).map(repository::findAllByCategory);
    }

    @Override
    public void create(Device device) {
        repository.save(device);
    }

    @Override
    public void update(Device device) {
        repository.save(device);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
