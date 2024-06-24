package com.test.Nielsen.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {
    @Id
    private String productId;
    private double relevancyScore;

    @ManyToOne
    @JoinColumn(name = "shopper_id", nullable = false)
    private ShopperProduct shopperProduct;

}
