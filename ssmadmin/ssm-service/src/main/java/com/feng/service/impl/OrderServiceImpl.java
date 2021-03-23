package com.feng.service.impl;

import com.feng.dao.IProductdao;
import com.feng.dao.Orderdao;
import com.feng.domain.Order;
import com.feng.domain.Product;
import com.feng.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    Orderdao orderdao;
    @Autowired
    IProductdao iProductdao;
    public List<Order> findAll(int currentpage,int pagecount) {
        PageHelper.startPage(currentpage,pagecount);
        return orderdao.findAll();

    }

    public Order findById(String id) {
        return orderdao.findById(id);
    }
}
