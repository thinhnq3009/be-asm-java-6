package com.shop.asm.mock;

import com.shop.asm.entity.Category;
import com.shop.asm.repositories.CategoryRepository;
import com.shop.asm.value.DefaultValue;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CategoryMock {

    private final CategoryRepository categoryRepository;

    @Bean
    public CommandLineRunner categoryMockData() {
        return args -> {
            List<Category> categories = new ArrayList<>();
            String[] names = new String[]{
                    "Son môi",
                    "Kem dưỡng da",
                    "Kem chống nắng",
                    "Phấn phủ",
                    "Mascara",
                    "Kẻ mắt",
                    "Tẩy trang",
                    "Sữa rửa mặt",
                    "Tinh chất dưỡng da",
                    "Serum dưỡng da",
                    "Dầu gội đầu",
                    "Dầu xả tóc",
                    "Sữa tắm",
                    "Sữa dưỡng thể",
                    "Nước hoa"
            };

            for (String name : names) {
                Category category = Category.builder()
                        .name(name)
                        .image(DefaultValue.DEFAULT_IMAGE_CATEGORY)
                        .build();
                categories.add(category);
            }

            categoryRepository.saveAll(categories);
        };
    }

}
