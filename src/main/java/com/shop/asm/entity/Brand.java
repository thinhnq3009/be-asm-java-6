package com.shop.asm.entity;

import com.shop.asm.value.DefaultValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "brands")
@AllArgsConstructor
public class Brand {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private String name;

    private String description;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private String image = DefaultValue.DEFAULT_IMAGE_BRAND;

    @OneToMany(mappedBy = "brand")
    private List<Product> products = new ArrayList<>();
}
