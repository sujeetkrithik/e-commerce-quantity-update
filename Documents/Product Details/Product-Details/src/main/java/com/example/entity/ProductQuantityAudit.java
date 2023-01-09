package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Entity
//@Table(name = "product_quantity_audit")
public class ProductQuantityAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_quantity_audit_Id;")
    private int productQuantityAuditId;
    private int existingQuantity;
    private int updatedQuantity;
    private int productId;
}
