package com.test.Nielsen.Service;


import com.test.Nielsen.Dto.ProductDTO;
import com.test.Nielsen.Dto.ShopperProductDTO;
import com.test.Nielsen.Respository.ShopperProductRepository;
import com.test.Nielsen.domain.Product;
import com.test.Nielsen.domain.ShopperProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopperService {

    private final ShopperProductRepository shopperProductRepository;

    public ShopperService(ShopperProductRepository shopperProductRepository) {
        this.shopperProductRepository = shopperProductRepository;
    }

    public void addShopperProduct(ShopperProductDTO shopperProductDTO) {

        ShopperProduct shopperProduct = new ShopperProduct();
        shopperProduct.setShopperId(shopperProductDTO.getShopperId());

        List<Product> products = shopperProductDTO.getProducts().stream().map(dto -> {
            Product product = new Product();
            product.setProductId(dto.getProductId());
            product.setRelevancyScore(dto.getRelevancyScore());
            product.setShopperProduct(shopperProduct); // Set bi-directional relationship
            return product;
        }).toList();

        shopperProduct.setProducts(products);
        shopperProductRepository.save(shopperProduct);
    }

    public ShopperProductDTO getShopperProducts(String shopperId) {

        ShopperProductDTO shopperProductDTO = new ShopperProductDTO();
        ShopperProduct shopperProduct = shopperProductRepository.findByShopperId(shopperId);
        shopperProductDTO.setShopperId(shopperProduct.getShopperId());
        List<ProductDTO> products = shopperProduct.getProducts().stream().map(dto -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(dto.getProductId());
            productDTO.setRelevancyScore(dto.getRelevancyScore());
            productDTO.setShopperProductDTO(shopperProductDTO); // Set bi-directional relationship
            return productDTO;
        }).toList();
        shopperProductDTO.setProducts(products);
        return shopperProductDTO;
    }
}
