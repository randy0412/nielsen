package com.test.Nielsen.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ProductMetaData {

    @Id
    private String productId;
    private String brand;
    private String category;
}
