package com.example.aui_lab.device.controller.api;

import com.example.aui_lab.device.dto.*;

import java.util.UUID;

public interface CategoryController{
    GetCategoriesResponse getCategories();
    GetCategoryResponse get(UUID id);
}
