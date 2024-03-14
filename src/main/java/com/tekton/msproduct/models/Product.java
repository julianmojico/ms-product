package com.tekton.msproduct.models;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
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
