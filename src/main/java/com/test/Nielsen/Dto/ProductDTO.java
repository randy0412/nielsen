package com.test.Nielsen.Dto;

import lombok.Data;

@Data
public class ProductDTO {

    private String productId;
    private double relevancyScore;

    private ShopperProductDTO shopperProductDTO;
}
