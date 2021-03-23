package com.feng.service.impl;


import com.feng.dao.IProductdao;
import com.feng.domain.Product;
import com.feng.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl  implements ProduceService {
    @Autowired
    IProductdao iProductdao;
    public List<Product> findAll() {
        return iProductdao.findAll();
    }

    public void addProduct(Product product) {
        iProductdao.addProduct(product);

    }

    public void deleteByid(String id) {
        iProductdao.deleteByid(id);
    }



}
