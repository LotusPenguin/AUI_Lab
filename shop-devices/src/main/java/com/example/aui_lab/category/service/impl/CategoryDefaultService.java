package com.example.aui_lab.category.service.impl;

import com.example.aui_lab.category.entity.Category;
import com.example.aui_lab.category.repository.api.CategoryRepository;
import com.example.aui_lab.category.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryDefaultService implements CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryDefaultService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Category> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void create(Category category) {
        repository.save(category);
    }

    @Override
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }

}
