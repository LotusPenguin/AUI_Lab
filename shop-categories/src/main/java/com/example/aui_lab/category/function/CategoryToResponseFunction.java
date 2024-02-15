package com.example.aui_lab.category.function;

import com.example.aui_lab.category.dto.GetCategoryResponse;
import com.example.aui_lab.category.entity.Category;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CategoryToResponseFunction implements Function<Category, GetCategoryResponse> {

    @Override
    public GetCategoryResponse apply(Category entity) {
        return GetCategoryResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .packagingPrice(entity.getPackagingPrice())
                .build();
    }

}
