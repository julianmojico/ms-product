package com.tekton.msproduct.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private StatusEnum status;
    private int stock;
    private String description;
    private float price;
    private float discount;
    private float finalPrice;
    private String sku;
}
