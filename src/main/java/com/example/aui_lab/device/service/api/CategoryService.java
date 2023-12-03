package com.example.aui_lab.device.service.api;

import com.example.aui_lab.device.entity.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    Optional<Category> find(UUID id);
    void create(Category category);

    List<Category> findAll();
}
