package com.test.Nielsen.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class ShopperProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "shopper_id")
    private String shopperId;

    @OneToMany(mappedBy = "shopperProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    public void setProducts(List<Product> products) {
        this.products = products;
        if (products != null) {
            for (Product product : products) {
                product.setShopperProduct(this); // Ensure bi-directional relationship
            }
        }
    }

}
