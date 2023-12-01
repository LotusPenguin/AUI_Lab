package com.example.aui_lab.device.function;

import com.example.aui_lab.device.dto.GetCategoryResponse;
import com.example.aui_lab.device.entity.Category;

import java.util.function.Function;

public class CategoryToResponseFunction implements Function<Category, GetCategoryResponse> {

    @Override
    public GetCategoryResponse apply(Category entity) {
        return GetCategoryResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}
