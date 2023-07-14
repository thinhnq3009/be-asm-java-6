package com.shop.asm.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

import java.util.*;


@Data
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private String receiverName;

    @Column(nullable = false, columnDefinition = "varchar(10)")
    private String receiverPhone;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private Integer provinceId;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private Integer districtId;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private Integer wardId;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private String provinceName;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private String districtName;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private String wardName;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private String detail;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private String note;

    private Boolean isDefault = false;

    private Boolean isDeleted = false;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "address")
    private List<Order> orders = new ArrayList<>();



}
