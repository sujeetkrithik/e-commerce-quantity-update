package com.example.service;

//import com.example.dto.ProductDTO;
import com.example.dto.ProductQuantityDTO;
import com.example.entity.ProductQuantity;
import com.example.entity.ProductQuantityAudit;
import com.example.repository.ProductQuantityAuditRepository;
import com.example.repository.ProductQuantityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
//@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductQuantityRepository productRepos;

    private final ProductQuantityAuditRepository productQuantityAuditRepository;

    public ProductServiceImpl(ProductQuantityRepository productRepos, ProductQuantityAuditRepository productQuantityAuditRepository) {
        this.productRepos = productRepos;
        this.productQuantityAuditRepository = productQuantityAuditRepository;
    }


    @Override
    public ProductQuantity getProductServiceByProductId(int productId) {
        Optional<ProductQuantity> byId = productRepos.findById(productId);
        if (byId.isEmpty()) {
            throw new RuntimeException("product is not found");
        }
        ProductQuantity product = byId.get();
        return product;
    }


    public ProductQuantity updateProductService(ProductQuantityDTO productQuantityDTO, int productQuantityId) {
        Optional<ProductQuantity> byId = productRepos.findById(productQuantityId);
        if (!byId.isPresent())
            throw new RuntimeException("not found");

        ProductQuantity product1 = byId.get();
        int existingQuantity2 = product1.getQuantity();

        if(productQuantityDTO.getType().equals("append")){
           product1.setQuantity(product1.getQuantity() + productQuantityDTO.getQuantity());
        }
        else if(productQuantityDTO.getType().equals("consume")){
            product1.setQuantity(product1.getQuantity() - productQuantityDTO.getQuantity());
        }

        else if(productQuantityDTO.getType().equals("refrush")){
            product1.setQuantity(product1.getQuantity());
        }

        productRepos.save(product1);

        updateProductAudit(product1, existingQuantity2);

        return product1;

    }

    public void updateProductAudit(ProductQuantity product1, int existingQuantity)
    {
        ProductQuantityAudit productQuantityAudit = new ProductQuantityAudit();

        productQuantityAudit.setExistingQuantity(existingQuantity);

        productQuantityAudit.setUpdatedQuantity(product1.getQuantity());

        productQuantityAuditRepository.save(productQuantityAudit);
    }
}
