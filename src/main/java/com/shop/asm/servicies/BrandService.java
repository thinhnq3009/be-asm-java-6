package com.shop.asm.servicies;

import com.shop.asm.dto.BrandDto;
import com.shop.asm.mapper.BrandDtoMapper;
import com.shop.asm.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    private final BrandDtoMapper brandDtoMapper;

    public List<BrandDto> getAllBrands() {
        return brandRepository.findAll().stream()
                .map(brandDtoMapper)
                .collect(java.util.stream.Collectors.toList());
    }


}
