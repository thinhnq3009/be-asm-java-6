package com.shop.asm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "products")
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private String name;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private String image;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double salePrice;


    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Brand brand;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(columnDefinition = "nvarchar(max)")
    private String description;

    @Transient
    private Integer sold;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails = new ArrayList<>();


    /*
     * Method area
     */

    public Integer getSold() {
        return orderDetails
                .stream()
                .mapToInt(OrderDetail::getQuantity)
                .sum();
    }
}
