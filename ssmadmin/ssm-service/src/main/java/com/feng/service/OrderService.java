package com.feng.service;

import com.feng.domain.Order;
import com.feng.domain.Product;

import java.util.List;

public interface OrderService {
    List<Order> findAll(int currentpage,int pagecount);

    Order findById(String id);
}
