package com.example.service;

//import com.example.dto.ProductDTO;
import com.example.dto.ProductQuantityDTO;
import com.example.entity.ProductQuantity;
import com.example.entity.ProductQuantityAudit;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    ProductQuantity getProductServiceByProductId(int productId);
    ProductQuantity updateProductService(ProductQuantityDTO productQuantityDTO, int productQuantityId);
}

