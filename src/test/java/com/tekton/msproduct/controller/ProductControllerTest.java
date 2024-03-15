package com.tekton.msproduct.controller;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.tekton.msproduct.models.Product;
import com.tekton.msproduct.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    @DisplayName("When fetching a valid product, then return HTTP status code 200 and json in the body")
    void getProductByIdSuccessTest() {

        Long id = 1L;
        Product mockProduct = new Product();
        when(productService.getProductById(id)).thenReturn(mockProduct);

        BindingResult bindingResult = mock(BindingResult.class);

        ResponseEntity<?> response = productController.getProductById(id);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockProduct, response.getBody());
    }

    @Test
    @DisplayName("When product is successfully created, then return HTTP status code 201 and json in the body")
    void createProductSuccessTest() {

        Product productToCreate = new Product();
        when(productService.saveProduct(productToCreate)).thenReturn(productToCreate);

        ResponseEntity<?> response = productController.saveProduct(productToCreate);

        assertEquals(201, response.getStatusCode().value());
        assertEquals(productToCreate, response.getBody());
    }

    @Test
    @DisplayName("When product creation fails due to data type validations, then return HTTP status code 400 and json in the body")
    void createProductDataTypeValidationFailedTest() {

        Product productToCreate = new Product();
        when(productService.saveProduct(productToCreate)).thenReturn(productToCreate);

        ResponseEntity<?> response = productController.saveProduct(productToCreate);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(productToCreate, response.getBody());
    }
}