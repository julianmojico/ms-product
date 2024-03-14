package com.tekton.msproduct.service;

import com.tekton.msproduct.models.Product;
import com.tekton.msproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product getProductById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Product saveProduct(Product product) {
        //TODO: validations
        return productRepository.save(product);
    }
}