package com.example.aui_lab.device.function;

import com.example.aui_lab.device.dto.GetCategoriesResponse;
import com.example.aui_lab.device.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
@Component
public class CategoriesToResponseFunction implements Function<List<Category>, GetCategoriesResponse> {

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
