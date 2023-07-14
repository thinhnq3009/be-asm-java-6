package com.shop.asm.entity;

import com.shop.asm.auth.Role;
import com.shop.asm.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User buyer;

    @ManyToOne
    private User seller;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

    @ManyToOne
    private Address address;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> details = new ArrayList<>();



    /*
     * Method to area
     */


    public void setSeller(User seller) {
        if (seller.getRole() != Role.ADMIN)
            throw new RuntimeException("User is not seller");
        this.seller = seller;
    }


}
