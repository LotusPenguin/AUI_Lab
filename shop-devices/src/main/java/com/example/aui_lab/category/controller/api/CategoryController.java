package com.example.aui_lab.category.controller.api;

import com.example.aui_lab.category.dto.GetCategoriesResponse;
import com.example.aui_lab.category.dto.GetCategoryResponse;
import com.example.aui_lab.category.dto.PutCategoryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface CategoryController{

    @PutMapping("/api/categories/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putCategory(@PathVariable("id") UUID id,@RequestBody PutCategoryRequest request);

    @DeleteMapping("/api/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteCategory(@PathVariable("id") UUID id);
}
