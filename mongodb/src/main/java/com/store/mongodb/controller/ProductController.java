package com.store.mongodb.controller;

import com.store.mongodb.model.ProductRequest;
import com.store.mongodb.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.store.mongodb.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request){
        return ResponseEntity.ok(service.create(request));
    }
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

}
