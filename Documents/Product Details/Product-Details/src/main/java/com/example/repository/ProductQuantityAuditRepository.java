package com.example.repository;

import com.example.entity.ProductQuantityAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductQuantityAuditRepository extends JpaRepository<ProductQuantityAudit, Integer> {

}
