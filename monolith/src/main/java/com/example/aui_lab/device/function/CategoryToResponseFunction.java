package com.example.aui_lab.device.function;

import com.example.aui_lab.device.dto.GetCategoryResponse;
import com.example.aui_lab.device.entity.Category;
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
