package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductQuantityAuditDTO {
    private int productQuantityAuditId;
    private int existingQuantity;
//    private int quantities;
    private int updatedQuantity;
//    private String type;
    private int productId;
}
