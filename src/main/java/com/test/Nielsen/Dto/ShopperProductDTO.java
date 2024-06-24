package com.test.Nielsen.Dto;

import com.test.Nielsen.domain.Product;
import lombok.Data;

import java.util.List;

@Data
public class ShopperProductDTO {

    private String shopperId;
    private List<ProductDTO> products;

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
        if (products != null) {
            for (ProductDTO product : products) {
                product.setShopperProductDTO(this); // Ensure bi-directional relationship
            }
        }
    }

}
