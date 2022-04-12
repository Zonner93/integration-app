package com.integration.integrationapp.models.mapper;

import com.integration.integrationapp.models.dto.CategoryDto;
import com.integration.integrationapp.models.entity.Category;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CategoryMapper {

    public Category dtoToEntity(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }
        Category.CategoryBuilder builder = Category.builder();

        if (Objects.nonNull(categoryDto.getName())) {
            builder.name(categoryDto.getName());
        }
        if (Objects.nonNull(categoryDto.getImgUrl())) {
            builder.imageURL(categoryDto.getImgUrl());
        }
        return builder.build();
    }

    public CategoryDto entityToDto(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDto.CategoryDtoBuilder builder = CategoryDto.builder();

        if (Objects.nonNull(category.getName())) {
            builder.name(category.getName());
        }
        if (Objects.nonNull(category.getImageURL())) {
            builder.imgUrl(category.getImageURL());
        }
        return builder.build();
    }
}
