package com.feng.dao;

import com.feng.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IProductdao {
    @Select("select * from PRODUCT")
    List<Product> findAll();

    @Select("select * from product where id=#{id}")
    Product findByid(String id);

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void addProduct(Product product);

    @Update("delete from product where id=#{id}")
    void deleteByid(String id);
}
