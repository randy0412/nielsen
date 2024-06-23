package com.test.Nielsen.Service;

import com.test.Nielsen.Respository.ProductRepository;
import com.test.Nielsen.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProduct(Long productId) {
        return productRepository.findByProductId(productId);
    }

}
