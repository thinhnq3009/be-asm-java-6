package com.shop.asm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@AllArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private String name;

    @Column( columnDefinition = "nvarchar(max)")
    private String description;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private String image = DefaultValue.DEFAULT_IMAGE_CATEGORY;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

}
