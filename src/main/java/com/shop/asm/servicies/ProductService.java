package com.shop.asm.servicies;

import com.shop.asm.dto.ProductDto;
import com.shop.asm.entity.Product;
import com.shop.asm.mapper.ProductDtoMapper;
import com.shop.asm.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductDtoMapper productDtoMapper;

    public List<ProductDto> getRandomProduct(int size) {
        List <Product> products = productRepository.findAll();
        Collections.shuffle(products);

        return products.subList(0, size)
                .stream()
                .map(productDtoMapper)
                .collect(Collectors.toList());
    }


}
