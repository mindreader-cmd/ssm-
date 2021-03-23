package com.feng.service;

import com.feng.domain.Product;
import com.feng.domain.Role;
import com.feng.domain.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.userdetails.User;

import java.util.List;


public interface UserService {
    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findByid(String id);


    List<Role> findOtherRoles(String userid);

    void addRoleToUser(String roleid,String userid);
}
