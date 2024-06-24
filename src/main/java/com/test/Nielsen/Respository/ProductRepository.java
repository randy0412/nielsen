package com.test.Nielsen.Respository;

import com.test.Nielsen.domain.Product;
import com.test.Nielsen.domain.ProductMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductMetaData, Long> {
    ProductMetaData findByProductId(String productId);
}