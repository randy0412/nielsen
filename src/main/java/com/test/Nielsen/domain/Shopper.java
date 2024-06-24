package com.test.Nielsen.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Shopper {

    @Id
    private Long productId;
    private String shopperId;
    private String relScore;
}
