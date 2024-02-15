package com.example.aui_lab.category.dto;

import lombok.*;
import org.springframework.data.repository.NoRepositoryBean;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class PutCategoryRequest {
    private String name;
    private double packagingPrice;
}
