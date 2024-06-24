package com.test.Nielsen.Controller;

import com.test.Nielsen.Service.ProductService;
import com.test.Nielsen.domain.ProductList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external/api")
public class ExternalController {
    private final ProductService productService;

    @Autowired
    public ExternalController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/getProducts")
    public ProductList getProducts(@RequestParam String shopperId){
        return productService.  getProducts(shopperId);
    }

}
