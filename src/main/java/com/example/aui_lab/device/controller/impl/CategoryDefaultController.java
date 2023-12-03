package com.example.aui_lab.device.controller.impl;

import com.example.aui_lab.device.controller.api.CategoryController;
import com.example.aui_lab.device.dto.*;
import com.example.aui_lab.device.function.CategoriesToResponseFunction;
import com.example.aui_lab.device.function.CategoryToResponseFunction;
import com.example.aui_lab.device.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.NoSuchElementException;
import java.util.UUID;

@Controller
public class CategoryDefaultController implements CategoryController {

    private final CategoryService service;
    private final CategoryToResponseFunction categoryToResponse;
    private final CategoriesToResponseFunction categoriesToResponse;

    @Autowired
    public CategoryDefaultController(
            CategoryService service,
            CategoryToResponseFunction categoryToResponse,
            CategoriesToResponseFunction categoriesToResponse
    ) {
        this.service = service;
        this.categoryToResponse = categoryToResponse;
        this.categoriesToResponse = categoriesToResponse;
    }

    @Override
    public GetCategoriesResponse getCategories() {
        return categoriesToResponse.apply(service.findAll());
    }

    @Override
    public GetCategoryResponse get(UUID id) {
        return service.find(id).map(categoryToResponse).orElseThrow(NoSuchElementException::new);
    }
}
