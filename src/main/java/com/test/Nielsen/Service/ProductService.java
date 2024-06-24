package com.test.Nielsen.Service;

import com.test.Nielsen.Dto.ProductMetaDataDTO;
import com.test.Nielsen.Respository.ProductRepository;
import com.test.Nielsen.Respository.ShopperProductRepository;
import com.test.Nielsen.domain.ProductMetaData;
import com.test.Nielsen.domain.ShopperProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          ShopperProductRepository shopperRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(ProductMetaDataDTO productMetaDataDTO) {

        ProductMetaData productMetaData = new ProductMetaData();
        productMetaData.setProductId(productMetaDataDTO.getProductId());
        productMetaData.setCategory(productMetaDataDTO.getCategory());
        productMetaData.setBrand(productMetaDataDTO.getBrand());

        productRepository.save(productMetaData);
    }

    public ProductMetaDataDTO getProduct(String productId) {
        ProductMetaData productMetaData = productRepository.findByProductId(productId);
        ProductMetaDataDTO productMetaDataDTO = new ProductMetaDataDTO();
        productMetaDataDTO.setProductId(productMetaData.getProductId());
        productMetaDataDTO.setCategory(productMetaData.getCategory());
        productMetaDataDTO.setBrand(productMetaData.getBrand());
        return productMetaDataDTO;
    }

}
