package com.tekton.msproduct.controller;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.tekton.msproduct.models.ProductDTO;
import com.tekton.msproduct.models.StatusEnum;
import com.tekton.msproduct.service.ProductService;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("When fetching a valid product, then return HTTP status code 200 and json in the body")
    void getProductByIdSuccessTest() {

        ProductDTO mockProduct = validProduct();
        when(productService.getProductById(mockProduct.getId())).thenReturn(mockProduct);

        ResponseEntity<?> response = productController.getProductById(mockProduct.getId());

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockProduct, response.getBody());
    }

    @Test
    @DisplayName("When fetching a valid product, then return HTTP status code 200 and json in the body")
    void getProductByIdFailedTest() {

        ProductDTO mockProduct = validProduct();
        when(productService.getProductById(validProduct().getId())).thenReturn(mockProduct);

        ResponseEntity<?> response = productController.getProductById(validProduct().getId());

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockProduct, response.getBody());
    }

    @Test
    @DisplayName("When product is successfully created, then return HTTP status code 201 and json in the body")
    void createProductSuccessTest() {

        ProductDTO mockProduct = validProduct();
        when(productService.insertProduct(mockProduct)).thenReturn(mockProduct);

        ResponseEntity<?> response = productController.saveProduct(mockProduct);

        assertEquals(201, response.getStatusCode().value());
        assertEquals(mockProduct, response.getBody());
    }

    ProductDTO validProduct(){
       return ProductDTO.builder()
                .id(1L)
                .name("productName")
                .price(100.0f)
                .description("description")
                .stock(10)
                .status(StatusEnum.Active.getValue())
                .sku("SKU1234")
                .build();
    }

}