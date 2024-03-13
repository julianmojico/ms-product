package com.tekton.msproduct.repository;

import com.tekton.msproduct.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}