package com.shop.asm.mapper;


import com.shop.asm.dto.ProductDto;
import com.shop.asm.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ProductDtoMapper implements Function<Product, ProductDto> {

    private final CategoryDtoMapper categoryMapper;

    private final BrandDtoMapper brandMapper;

    @Override
    public ProductDto apply(Product product) {
        return ProductDto
                .builder()
                .id(product.getId())
                .name(product.getName())
                .image(product.getImage())
                .price(product.getPrice())
                .salePrice(product.getSalePrice())
                .quantity(product.getQuantity())
                .category(categoryMapper.apply(product.getCategory()))
                .brand(brandMapper.apply(product.getBrand()))
                .createdDate(product.getCreatedDate())
                .description(product.getDescription())
                .sold(product.getSold())
                .build();
    }
}
