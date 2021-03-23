package com.feng.dao;

import com.feng.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Travellerdao {
    @Select("select * from traveller where id in (select travellerid from order_traveller where orderid=#{id})")
    List<Traveller> findByid(String id);

}
