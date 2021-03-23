package com.feng.service;

import com.feng.domain.Product;

import java.util.List;

public interface ProduceService {
    List<Product> findAll();

    void addProduct(Product product);

    void deleteByid(String id);
}
