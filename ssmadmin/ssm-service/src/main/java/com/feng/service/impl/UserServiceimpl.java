package com.feng.service.impl;

import com.feng.dao.Userdao;
import com.feng.domain.Role;
import com.feng.domain.UserInfo;
import com.feng.service.UserService;
import com.feng.utils.BCryptPasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

//用户Service
@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private Userdao userdao;
    public List<UserInfo> findAll() {
        return userdao.findAll();
    }

    public void save(UserInfo userInfo) {
        userInfo.setPassword(BCryptPasswordEncoderUtils.encodePassword(userInfo.getPassword()));
        userdao.save(userInfo);
    }

    public UserInfo findByid(String id) {
        return userdao.findByid(id);
    }


    public List<Role> findOtherRoles(String userid) {
        return  userdao.findOtherRoles(userid);

    }

    public void addRoleToUser(String roleid,String userid) {
        userdao.addRoleToUser(roleid,userid);
    }


}
