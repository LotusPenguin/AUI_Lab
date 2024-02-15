package com.example.aui_lab.category.controller.impl;

import com.example.aui_lab.category.controller.api.CategoryController;
import com.example.aui_lab.category.dto.PutCategoryRequest;
import com.example.aui_lab.category.function.RequestToCategoryFunction;
import com.example.aui_lab.category.service.api.CategoryService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class CategoryDefaultController implements CategoryController {

    private final CategoryService service;
    private final RequestToCategoryFunction requestToCategory;

    @Autowired
    public CategoryDefaultController(
            CategoryService service,
            RequestToCategoryFunction requestToCategory
    ) {
        this.service = service;
        this.requestToCategory = requestToCategory;
    }

    @Override
    public void putCategory(UUID id, PutCategoryRequest request) {
        service.create(requestToCategory.apply(id, request));
    }

    @Override
    public void deleteCategory(UUID id) {
        service.find(id).ifPresentOrElse(
                user -> service.delete(id), () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                });
    }
}
