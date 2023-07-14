package com.shop.asm.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Product product;

    private Integer quantity;

    private Double price;

    @ManyToOne
    private Order order;


    public void setQuantity(Integer quantity) {
        if (product == null) {
            throw new RuntimeException("Set product before set quantity");
        } else if (quantity > product.getQuantity()) {
            throw new RuntimeException("Quantity is not enough");
        } else if (quantity < 0) {
            throw new RuntimeException("Quantity must be positive");
        } else {
            this.quantity = quantity;
        }
    }
}
