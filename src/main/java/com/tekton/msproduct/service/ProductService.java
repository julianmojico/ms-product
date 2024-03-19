package com.tekton.msproduct.service;

import com.tekton.msproduct.models.Discount;
import com.tekton.msproduct.models.Product;
import com.tekton.msproduct.models.ProductDTO;
import com.tekton.msproduct.models.StatusEnum;
import com.tekton.msproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Map;

@Service
@CacheConfig(cacheNames = "productStatus")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductService {

    @Autowired
    ProductService self;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DiscountsAPIService discountsAPIService;
    public ProductDTO getProductById(Long id) {
            if (productRepository.findById(id).isPresent()) {
                Product output = productRepository.findById(id).get();
                updatePrices(id, output);
                self.saveProductsStatusCache(output);
                return toDTO(output);
            } else {
                return null;
            }
    }

    @Cacheable("productsStatus")
    public Map<Long, Integer> saveProductsStatusCache(Product product) {
        return Map.of(product.getId(), product.getStatus().getValue());
    }
    private void updatePrices(Long id, Product output) {
        Discount discount = discountsAPIService.fetchDataFromExternalService(id);
        output.setDiscount(discount.getDiscount());
        float finalPrice = (output.getPrice() * (100 - output.getDiscount())) / 100;
        output.setFinalPrice(finalPrice);
    }

    public ProductDTO insertProduct(ProductDTO productDTO) {
        try {
            Product product = toEntity(productDTO);
            Product result = productRepository.save(product);
            updatePrices(result.getId(), result);
            return toDTO(result);
        } catch (Exception ex) {
            throw (DataAccessException) ex;
        }
    }

    public ProductDTO updateProduct(ProductDTO productDTO, Long id) throws NoResourceFoundException {
            if (productRepository.findById(id).isPresent()) {
                Product product = toEntity(productDTO);
                product.setId(id);
                Product result = productRepository.save(product);
                return toDTO(result);
            } else {
                throw new NoResourceFoundException(HttpMethod.PUT,"No product found with id: " + id);
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
}