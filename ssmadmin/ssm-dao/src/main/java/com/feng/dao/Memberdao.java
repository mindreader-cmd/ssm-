package com.feng.dao;

import com.feng.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface Memberdao {
    @Select("select * from member where id=#{id}")
    Member findByid(String id);
}
