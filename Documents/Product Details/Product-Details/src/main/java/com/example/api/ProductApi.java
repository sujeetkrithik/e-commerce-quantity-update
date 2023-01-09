package com.example.api;
//
//import com.example.dto.ProductDTO;
import com.example.dto.ProductQuantityDTO;
import com.example.entity.ProductQuantity;
import com.example.entity.ProductQuantityAudit;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value="/api")
@CrossOrigin
public interface ProductApi {
    @RequestMapping(value = "/get/product/{productId}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<ProductQuantity> getProductByProductId(@PathVariable int productId);


    @RequestMapping(value="/update/product/{productQuantityId}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.PUT)
    public ResponseEntity<ProductQuantity> updateProduct(@RequestBody ProductQuantityDTO productQuantityDTO,
                                                         @PathVariable("productQuantityId") int productQuantityId);

}
