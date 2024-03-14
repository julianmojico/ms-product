package com.tekton.msproduct.controller;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.tekton.msproduct.models.Product;
import com.tekton.msproduct.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    void testGetProductById() {
        // Arrange
        Long id = 1L;
        Product mockProduct = new Product();
        when(productService.getProductById(id)).thenReturn(mockProduct);

        // Act
        ResponseEntity<?> response = productController.getProductById(id);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockProduct, response.getBody());
    }

    @Test
    void testCreateProduct() {
        // Arrange
        Product productToCreate = new Product();
        when(productService.saveProduct(productToCreate)).thenReturn(productToCreate);

        // Act
        ResponseEntity<?> response = productController.saveProduct(productToCreate);

        // Assert
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(productToCreate, response.getBody());
    }
}