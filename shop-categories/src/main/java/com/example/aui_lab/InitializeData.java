package com.example.aui_lab;


import com.example.aui_lab.category.entity.Category;
import com.example.aui_lab.category.service.api.CategoryService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class InitializeData implements InitializingBean {
    private final CategoryService categoryService;

    @Autowired
    public InitializeData(
            CategoryService categoryService
    ) {
        this.categoryService = categoryService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Category mice = Category.builder()
                .id(UUID.randomUUID())
                .name("Mice")
                .packagingPrice(2.99)
                .build();
        Category keyboards = Category.builder()
                .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                .name("Keyboards")
                .packagingPrice(5.99)
                .build();
        Category gamepads = Category.builder()
                .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                .name("Gamepads")
                .packagingPrice(3.99)
                .build();

        categoryService.create(mice);
        categoryService.create(keyboards);
        categoryService.create(gamepads);
    }


}
