package com.shop.asm.mock;

import com.shop.asm.entity.Brand;
import com.shop.asm.repositories.BrandRepository;
import com.shop.asm.value.DefaultValue;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
@RequiredArgsConstructor
public class BrandMock  {

    private final BrandRepository brandRepository;

    @Bean
    public CommandLineRunner brandMockData() {
        return  args -> {
            List<Brand> brands = new ArrayList<>();
            String[] brandNames = {
                    "Cocoon",
                    "Thái Dương",
                    "Lagumi",
                    "Thorakao",
                    "Decumar",
                    "Emmié",
                    "Laco",
                    "Lemonade",
                    "Hanayuki",
                    "M.O.I",
                    "Vedette",
                    "Skinna"
            };

            for (String brandName : brandNames) {
                Brand brand = Brand.builder()
                        .name(brandName)
                        .image(DefaultValue.DEFAULT_IMAGE_BRAND)
                        .build();
                brands.add(brand);
            }

            brandRepository.saveAll(brands);


        };
    }

}
