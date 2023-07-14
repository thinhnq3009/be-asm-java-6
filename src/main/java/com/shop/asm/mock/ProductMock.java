package com.shop.asm.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.asm.entity.Brand;
import com.shop.asm.entity.Category;
import com.shop.asm.entity.Product;
import com.shop.asm.repositories.BrandRepository;
import com.shop.asm.repositories.CategoryRepository;
import com.shop.asm.repositories.ProductRepository;
import com.shop.asm.value.DefaultValue;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ProductMock {

    private final ProductRepository productRepository;

    private final BrandRepository brandRepository;

    private final CategoryRepository categoryRepository;
    @Bean
    public CommandLineRunner productMockData() {
        return args -> {
            List<Product> products = new ArrayList<>();

            try {
                URL url = new URL("https://63e21e7d109336b6cbffea1c.mockapi.io/api/product");

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");
                connection.connect();

                // Kiểm tra mã phản hồi của yêu cầu GET
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Đọc dữ liệu JSON từ phản hồi
                    ObjectMapper mapper = new ObjectMapper();
                    Product[] productsArray = mapper.readValue(connection.getInputStream(), Product[].class);

                    // Chuyển đổi mảng thành danh sách và thêm vào productList
                    products.addAll(Arrays.asList(productsArray));
                    System.out.println(Arrays.toString(productsArray));
                } else {
                    System.out.println("Lỗi: " + responseCode);
                }

                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();

            }

            Brand brand = brandRepository.findAll().get(0);
            Category category = categoryRepository.findAll().get(0);

            products.forEach(product -> {
                product.setSalePrice(product.getPrice() * 0.9);
                product.setBrand(brand);
                product.setCategory(category);
                product.setImage(DefaultValue.DEFAULT_IMAGE_PRODUCT);

            });


            // Lưu vào database
            productRepository.saveAll(products);

        };
    }
}
