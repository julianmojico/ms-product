package com.tekton.msproduct.service;

import com.tekton.msproduct.models.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

@Service
public class DiscountsAPIService {

    private static final String apiUrl = "https://65f8e830df1514524610276a.mockapi.io/tekton/products";
    @Autowired
    private RestOperations restOperations;

    public Discount fetchDataFromExternalService(Long id) {
        return restOperations.getForObject(apiUrl + "/" + id, Discount.class);
    }
}
