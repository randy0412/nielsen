package com.test.Nielsen.domain;


import lombok.Data;

import java.util.List;

@Data
public class ProductList {

    private String shopperId;
    List<Shopper> shoppers;
}
