package com.tekton.msproduct.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Discount implements Serializable {

    private Long id;
    @Min(value = 0, message = "Discount value must be at least 0")
    @Max(value = 100, message = "Discount value must be at most 100")
    private int discount;
}
