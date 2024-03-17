package com.tekton.msproduct.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDTO {

    private Long id;

    @Size(min = 4, max = 50, message = "name should not be less than 4 characters length")
    @NotNull(message = "name must not be null")
    private String name;

    private StatusEnum status;

    @NotNull(message = "stock must not be null")
    private int stock;

    @Size(min = 50, max = 200, message = "description should not be less than 50 characters length")
    @NotNull(message = "description must not be null")
    private String description;

    @Min( value = 0, message = "price must be greater than 0")
    private float price;
    private float discount;
    private float finalPrice;

    private String sku;
}
