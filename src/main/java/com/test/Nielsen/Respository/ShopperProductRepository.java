package com.test.Nielsen.Respository;

import com.test.Nielsen.domain.ShopperProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopperProductRepository extends JpaRepository<ShopperProduct, Long> {

    ShopperProduct findByShopperId(String shopperId);
}
