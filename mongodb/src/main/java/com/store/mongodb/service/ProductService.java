package com.store.mongodb.service;

import com.store.mongodb.model.ProductRequest;
import com.store.mongodb.model.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse create(ProductRequest request);

    List<ProductResponse> getAll();
}
