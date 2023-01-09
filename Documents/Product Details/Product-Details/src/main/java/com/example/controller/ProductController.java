package com.example.controller;

import com.example.api.ProductApi;
//import com.example.dto.ProductDTO;
import com.example.dto.ProductQuantityDTO;
import com.example.entity.ProductQuantity;
import com.example.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductApi {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @Override
    public ResponseEntity<ProductQuantity> getProductByProductId(int productId) {
       return new ResponseEntity<>(productService.getProductServiceByProductId(productId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductQuantity> updateProduct(ProductQuantityDTO productQuantityDTO, int productQuantityId) {
        return new ResponseEntity<> (productService.updateProductService(productQuantityDTO, productQuantityId), HttpStatus.OK);
    }
}
