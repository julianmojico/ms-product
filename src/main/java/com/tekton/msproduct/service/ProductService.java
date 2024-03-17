package com.tekton.msproduct.service;

import com.tekton.msproduct.models.Product;
import com.tekton.msproduct.models.ProductDTO;
import com.tekton.msproduct.models.StatusEnum;
import com.tekton.msproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductDTO getProductById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            return toDTO(productRepository.findById(id).get());
        } else {
            return null;
        }
    }

    private ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .status(product.getStatus().getValue())
                .sku(product.getSku())
                .price(product.getPrice())
                .stock(product.getStock())
                .name(product.getName())
                .description(product.getDescription())
                .finalPrice(product.getFinalPrice())
                .discount(product.getDiscount())
                .build();
    }

    private Product toEntity(ProductDTO productDTO) {

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setStatus(StatusEnum.fromValue(productDTO.getStatus()));
        product.setSku(productDTO.getSku());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setFinalPrice(productDTO.getFinalPrice());
        product.setDiscount(productDTO.getDiscount());

        return product;

    }

    public ProductDTO saveProduct(ProductDTO productDTO) {
        try {
            Product product = toEntity(productDTO);
            Product result = productRepository.save(product);
            return toDTO(result);
        } catch (Exception ex) {
            throw (DataAccessException) ex;
        }
    }
}