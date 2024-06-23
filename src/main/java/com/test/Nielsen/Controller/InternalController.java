package com.test.Nielsen.Controller;


import com.test.Nielsen.Service.ProductService;
import com.test.Nielsen.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal/api")
public class InternalController {
    private final ProductService productService;

    @Autowired
    public InternalController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getProduct")
    public ResponseEntity<Product> addProduct(@RequestParam Long productId) {
        return new ResponseEntity<Product>(productService.getProduct(productId), HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {

        productService.addProduct(product);
        return ResponseEntity.ok("Product Save Successfully");
    }
}
