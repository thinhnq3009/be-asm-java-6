package com.shop.asm.dto;

import com.shop.asm.value.DefaultValue;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {
    private Long id;

    private String name;

    private String description;

    private String image ;

    private Integer countProduct;

    private Boolean isNew;

    private Integer topSold;
}
