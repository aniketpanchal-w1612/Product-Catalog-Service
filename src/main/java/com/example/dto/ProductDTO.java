package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductDTO {

    @NotBlank(message = "Product name must not be blank")
    private String name;

    @Positive(message = "Price must be positive")
    private double price;
}
