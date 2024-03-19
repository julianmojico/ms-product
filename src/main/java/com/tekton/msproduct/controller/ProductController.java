package com.tekton.msproduct.controller;

import com.tekton.msproduct.models.ProductDTO;
import com.tekton.msproduct.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestController
@Validated
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;
    @Operation(summary = "Get a book by its id")
    @GetMapping(value = "/products/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponse(responseCode = "200", description = "Product get by id successfully")
    @ApiResponse(responseCode = "400", description = "Product get by id failed")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
        ProductDTO product = productService.getProductById(id);
        if (product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @ApiResponse(responseCode = "201", description = "Product created successfully")
    @ApiResponse(responseCode = "500", description = "Product creation failed")
    @Operation(summary = "Get a book by its id")
    @PostMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveProduct(@RequestBody @Valid ProductDTO product) {
               ProductDTO newProduct = productService.insertProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @PutMapping( value = "/products/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProduct(@PathVariable("id") Long id, @RequestBody @Valid ProductDTO product) throws NoResourceFoundException {
        ProductDTO updatedProduct = productService.updateProduct(product, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }
}
