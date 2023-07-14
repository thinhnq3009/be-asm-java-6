package com.shop.asm.servicies;

import com.shop.asm.dto.CategoryDto;
import com.shop.asm.mapper.CategoryDtoMapper;
import com.shop.asm.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryDtoMapper categoryDtoMapper;

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryDtoMapper)
                .collect(Collectors.toList());
    }




}
