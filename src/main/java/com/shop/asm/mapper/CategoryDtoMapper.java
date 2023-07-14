package com.shop.asm.mapper;

import com.shop.asm.dto.CategoryDto;
import com.shop.asm.entity.Category;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CategoryDtoMapper implements Function< Category, CategoryDto> {

    @Override
    public CategoryDto apply(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .image(category.getImage())
                .countProduct(category.getProducts().size())
                .isNew(category.getProducts().size() > 0)
                .topSold(0)
                .build();
    }


}
