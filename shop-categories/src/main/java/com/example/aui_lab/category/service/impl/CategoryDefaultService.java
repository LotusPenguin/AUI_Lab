package com.example.aui_lab.category.service.impl;

import com.example.aui_lab.category.entity.Category;
import com.example.aui_lab.category.event.repository.api.CategoryEventRepository;
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

    private final CategoryEventRepository categoryEventRepository;

    @Autowired
    public CategoryDefaultService(CategoryRepository repository, CategoryEventRepository categoryEventRepository) {
        this.repository = repository;
        this.categoryEventRepository = categoryEventRepository;
    }

    @Override
    public Optional<Category> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(Category category) {
        repository.save(category);
        categoryEventRepository.create(category);
    }

    @Override
    public void edit(Category category) {
        repository.save(category);
    }

    @Override
    public void delete(UUID uuid) {
        repository.findById(uuid).ifPresent(repository::delete);
        categoryEventRepository.delete(uuid);
    }

}
