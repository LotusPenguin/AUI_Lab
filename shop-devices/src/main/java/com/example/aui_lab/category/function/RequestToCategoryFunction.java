package com.example.aui_lab.category.function;

import com.example.aui_lab.category.dto.PutCategoryRequest;
import com.example.aui_lab.category.entity.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToCategoryFunction implements BiFunction<UUID, PutCategoryRequest, Category> {

    @Override
    public Category apply(UUID id, PutCategoryRequest request) {
        return Category.builder()
                .id(id)
                .build();
    }
}
