package com.tekton.msproduct.controller;

import com.tekton.msproduct.models.Product;
import com.tekton.msproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books-rest")
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
        try {
        Product product = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
