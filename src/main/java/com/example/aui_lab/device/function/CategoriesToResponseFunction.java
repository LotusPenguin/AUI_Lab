package com.example.aui_lab.device.function;

import com.example.aui_lab.device.dto.GetCategoriesResponse;
import com.example.aui_lab.device.entity.Category;

import java.util.List;
import java.util.function.Function;

public class ProfessionsToResponseFunction implements Function<List<Category>, GetCategoriesResponse> {

    @Override
    public GetCategoriesResponse apply(List<Category> entities) {
        return GetCategoriesResponse.builder()
                .categories(entities.stream()
                        .map(category -> GetCategoriesResponse.Category.builder()
                                .id(category.getId())
                                .name(category.getName())
                                .build())
                        .toList())
                .build();
    }

}
