package com.tekton.msproduct.service;

import com.tekton.msproduct.controller.ProductController;
import com.tekton.msproduct.models.ProductDTO;
import com.tekton.msproduct.models.StatusEnum;
import com.tekton.msproduct.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    @DisplayName("When fetching an existing product, then return ProductDTO object")
    void getProductByIdSuccessTest() {

        ProductDTO mockProduct = validProduct();
//TODO: mock repository

    }

    @Test
    @DisplayName("When fetching an inexisten product, return null")
    void getProductByIdFailedTest() {

        ProductDTO mockProduct = validProduct();

    }

    @Test
    @DisplayName("When product is successfully created, then the input ProductDTO object is returned")
    void createProductSuccessTest() {

        ProductDTO mockProduct = validProduct();

    }

    @Test
    @DisplayName("When product creation fails, then return exception")
    void createProductExceptionTest() {

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