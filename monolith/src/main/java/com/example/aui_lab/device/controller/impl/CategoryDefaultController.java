package com.example.aui_lab.device.controller.impl;

import com.example.aui_lab.device.controller.api.CategoryController;
import com.example.aui_lab.device.dto.GetCategoriesResponse;
import com.example.aui_lab.device.dto.GetCategoryResponse;
import com.example.aui_lab.device.dto.PutCategoryRequest;
import com.example.aui_lab.device.function.CategoriesToResponseFunction;
import com.example.aui_lab.device.function.CategoryToResponseFunction;
import com.example.aui_lab.device.function.RequestToCategoryFunction;
import com.example.aui_lab.device.service.api.CategoryService;
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
    private final CategoryToResponseFunction categoryToResponse;
    private final CategoriesToResponseFunction categoriesToResponse;

    private final RequestToCategoryFunction requestToCategory;

    @Autowired
    public CategoryDefaultController(
            CategoryService service,
            CategoryToResponseFunction categoryToResponse,
            CategoriesToResponseFunction categoriesToResponse,
            RequestToCategoryFunction requestToCategory
    ) {
        this.service = service;
        this.categoryToResponse = categoryToResponse;
        this.categoriesToResponse = categoriesToResponse;
        this.requestToCategory = requestToCategory;
    }

    @Override
    public GetCategoriesResponse getCategories() {
        return categoriesToResponse.apply(service.findAll());
    }

    @Override
    public GetCategoryResponse getCategory(UUID id) {
        return service.find(id).map(categoryToResponse).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
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
