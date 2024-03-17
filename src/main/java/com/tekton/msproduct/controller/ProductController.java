package com.tekton.msproduct.controller;

import com.tekton.msproduct.models.ProductDTO;
import com.tekton.msproduct.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
        ProductDTO product = productService.getProductById(id);
        if (product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping("/products")
    public ResponseEntity<?> saveProduct(@RequestBody @Valid ProductDTO product) {
               ProductDTO newProduct = productService.saveProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }
}
