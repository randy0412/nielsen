package com.test.Nielsen.Service;

import com.test.Nielsen.Respository.ProductRepository;
import com.test.Nielsen.Respository.ShopperRepository;
import com.test.Nielsen.domain.Product;
import com.test.Nielsen.domain.ProductList;
import com.test.Nielsen.domain.Shopper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ShopperRepository shopperRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          ShopperRepository shopperRepository) {
        this.productRepository = productRepository;
        this.shopperRepository = shopperRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProduct(Long productId) {
        return productRepository.findByProductId(productId);
    }

    public ProductList getProducts(String ShopperId) {
        return shopperRepository.findByShopperId(ShopperId);
    }

    public void addShopper(Shopper Shopper) {
        shopperRepository.save(Shopper);
    }

}
