package com.test.Nielsen.Controller;

import com.test.Nielsen.Dto.ProductMetaDataDTO;
import com.test.Nielsen.Dto.ShopperProductDTO;
import com.test.Nielsen.Service.ProductService;
import com.test.Nielsen.Service.ShopperService;
import com.test.Nielsen.domain.ProductMetaData;
import com.test.Nielsen.domain.ShopperProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal/api")
public class InternalController {
    private final ProductService productService;
    private final ShopperService shopperService;

    @Autowired
    public InternalController(ProductService productService, ShopperService shopperService) {
        this.productService = productService;
        this.shopperService = shopperService;
    }

    @GetMapping("/getProduct")
    public ResponseEntity<ProductMetaDataDTO> getProductMetadata(@RequestParam String productId) {
        return new ResponseEntity<ProductMetaDataDTO>(productService.getProduct(productId), HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProductMetadata(@RequestBody ProductMetaDataDTO productMetaDataDTO) {

        productService.addProduct(productMetaDataDTO);
        return ResponseEntity.ok("Product Save Successfully");
    }

    @PostMapping("/addShopperProduct")
    public ResponseEntity<String> addProduct(@RequestBody ShopperProductDTO shopperProductDTO) {

        shopperService.addShopperProduct(shopperProductDTO);
        return ResponseEntity.ok("Shopper Save Successfully");
    }
}
