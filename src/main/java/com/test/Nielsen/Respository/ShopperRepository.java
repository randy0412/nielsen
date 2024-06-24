package com.test.Nielsen.Respository;

import com.test.Nielsen.domain.ProductList;
import com.test.Nielsen.domain.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShopperRepository extends JpaRepository<Shopper, Long> {

    @Query
    ProductList findByShopperId(String shopperId);
}
