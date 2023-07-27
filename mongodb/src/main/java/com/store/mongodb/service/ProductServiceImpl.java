package com.store.mongodb.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.store.mongodb.model.ProductRequest;
import com.store.mongodb.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.store.mongodb.persistence.entity.Product;
import com.store.mongodb.persistence.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository repository;
    @Override
    public ProductResponse create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        repository.save(product);

        return createResponse(product);
    }

    @Override
    public List<ProductResponse> getAll() {
        List<ProductResponse> responses = new ArrayList<>();

        List<Product> products = repository.findAll();

        if (!products.isEmpty()){
            products.forEach(product -> responses.add(createResponse(product)));
        }

        return responses;
    }
    private ProductResponse createResponse(Product product) {

        ProductResponse response = new ProductResponse();

        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        return response;
    }
}
