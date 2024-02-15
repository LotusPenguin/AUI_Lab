package com.example.aui_lab.category.service.api;

import com.example.aui_lab.category.entity.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    Optional<Category> find(UUID id);

    List<Category> findAll();

    void create(Category category);

    void edit(Category category);

    void delete(UUID uuid);
}
