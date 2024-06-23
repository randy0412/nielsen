package com.test.Nielsen.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    private Long productId;
    private String brand;
    private String category;
}
