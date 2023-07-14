package com.shop.asm.responses;

import com.shop.asm.dto.BrandDto;
import com.shop.asm.dto.ProductDto;
import com.shop.asm.entity.Brand;
import com.shop.asm.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HomePageResponse {

    List<ProductDto> products;

    List<BrandDto> brands;

}
