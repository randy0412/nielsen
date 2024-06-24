package com.test.Nielsen.Controller;

import com.test.Nielsen.Dto.ShopperProductDTO;
import com.test.Nielsen.Service.ShopperService;
import com.test.Nielsen.domain.ShopperProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external/api")
public class ExternalController {
    private final ShopperService shopperService;

    @Autowired
    public ExternalController(ShopperService shopperService) {
        this.shopperService = shopperService;
    }

    @GetMapping("/getProducts")
    public ShopperProductDTO getProducts(@RequestParam String shopperId,
                                         @RequestParam(required = false) String brand,
                                         @RequestParam(required = false) String category,
                                         @RequestParam(defaultValue = "10") Integer limit) {

        limit = Math.min(limit, 100);
        return shopperService.getShopperProducts(shopperId);
    }

}
