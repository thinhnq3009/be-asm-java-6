package com.shop.asm.repositories;

import com.shop.asm.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    List<Product> findRandomProduct();
}