package com.shop.asm.responses;

import com.shop.asm.dto.BrandDto;
import com.shop.asm.dto.CategoryDto;
import com.shop.asm.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SidebarLayoutResponse {
    private List<BrandDto> brands;

    private List<CategoryDto> categories;

    private List<String> keywords;

}
