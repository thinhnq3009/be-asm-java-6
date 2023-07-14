package com.shop.asm.mapper;

import com.shop.asm.dto.BrandDto;
import com.shop.asm.entity.Brand;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class BrandDtoMapper implements Function<Brand, BrandDto> {
    @Override
    public BrandDto apply(Brand brand) {
        return BrandDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .description(brand.getDescription())
                .image(brand.getImage())
                .countProduct(brand.getProducts().size())
                .isNew(brand.getProducts().size() > 0)
                .topSold(0)
                .build();
    }
}
