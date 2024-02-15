package com.example.aui_lab.category.event.repository.api;

import com.example.aui_lab.category.entity.Category;

import java.util.UUID;

public interface CategoryEventRepository {

    void create(Category category);

    void delete(UUID id);
}
