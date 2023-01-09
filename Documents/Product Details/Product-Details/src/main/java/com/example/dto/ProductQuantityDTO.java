package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductQuantityDTO {
    private int productQuantityId;
    private int quantity;
    private int productId;
    private String type;
}
