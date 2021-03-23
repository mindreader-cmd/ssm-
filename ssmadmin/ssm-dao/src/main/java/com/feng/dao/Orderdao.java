package com.feng.dao;

import com.feng.domain.Member;
import com.feng.domain.Order;
import com.feng.domain.Product;
import com.feng.domain.Traveller;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Orderdao {
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "member",column = "memberid",javaType = Member.class,one = @One(select = "com.feng.dao.Memberdao.findByid")),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.feng.dao.IProductdao.findByid"))})
            List<Order> findAll();

    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "member",column = "memberid",javaType = Member.class,one = @One(select = "com.feng.dao.Memberdao.findByid")),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.feng.dao.IProductdao.findByid")),
            @Result(property = "travellers",column = "id",javaType = List.class,many = @Many(select = "com.feng.dao.Travellerdao.findByid"))})
            Order findById(String id);
}
