package com.example.aui_lab.category.event.repository.rest;

import com.example.aui_lab.category.entity.Category;
import com.example.aui_lab.category.event.repository.api.CategoryEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class CategoryEventRestRepository implements CategoryEventRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public CategoryEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/categories/{uuid}", id);
    }

    @Override
    public void create(Category category) {
        restTemplate.put("/api/categories/{uuid}", category, category.getId());
    }
}
