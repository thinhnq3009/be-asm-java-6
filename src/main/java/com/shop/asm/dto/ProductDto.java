package com.shop.asm.dto;

import com.shop.asm.entity.Brand;
import com.shop.asm.entity.Category;
import com.shop.asm.entity.OrderDetail;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class ProductDto {


    private Long id;

    private String name;

    private String image;
    
    private Double price;

    private Double salePrice;

    private Integer quantity;

    private CategoryDto category;

    private BrandDto brand;

    private Date createdDate;

    private String description;

    private Integer sold;

}
