package com.example.aui_lab.device.function;

import com.example.aui_lab.device.dto.PutCategoryRequest;
import com.example.aui_lab.device.entity.Category;
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
                .name(request.getName())
                .packagingPrice(request.getPackagingPrice())
                .devices(new ArrayList<>())
                .build();
    }
}
