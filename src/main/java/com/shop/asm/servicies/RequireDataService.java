package com.shop.asm.servicies;


import com.shop.asm.dto.BrandDto;
import com.shop.asm.dto.CategoryDto;
import com.shop.asm.dto.ProductDto;
import com.shop.asm.entity.Product;
import com.shop.asm.responses.HomePageResponse;
import com.shop.asm.responses.SidebarLayoutResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequireDataService {

    private final CategoryService categoryService;

    private final BrandService brandService;

    private final ProductService productService;

    // important data for sidebar layout
    public SidebarLayoutResponse getSidebarLayoutData() {

        List<CategoryDto> categoryDtos = categoryService.getAllCategories();

        List<BrandDto> brandDtos = brandService.getAllBrands();

        // Update sau khi dùng search engine
        List<String> keywords = List.of(
                "3ce",
                "nước tẩy trang",
                "nước hoa",
                "son",
                "kem chống nắng",
                "kem dưỡng",
                "kem nền",
                "kem lót",
                "túi xách"
        );


        return SidebarLayoutResponse
                .builder()
                .categories(categoryDtos)
                .brands(brandDtos)
                .keywords(keywords)
                .build();

    }


    // important data for home page
    public HomePageResponse     getHomePageData(int productSize) {

            List<ProductDto> products = productService.getRandomProduct(productSize);

            List<BrandDto> brands = brandService.getAllBrands();

            return HomePageResponse
                    .builder()
                    .products(products)
                    .brands(brands)
                    .build();
    }

}
