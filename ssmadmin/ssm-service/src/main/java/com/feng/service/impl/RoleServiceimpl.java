package com.feng.service.impl;

import com.feng.dao.IRoleDao;
import com.feng.domain.Permission;
import com.feng.domain.Role;
import com.feng.domain.UserInfo;
import com.feng.service.Roleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceimpl implements Roleservice {
    @Autowired
    IRoleDao roleDao;
    public List<Role> findAll() {
       return roleDao.findAll();
    }

    public void save(Role role) {
        roleDao.save(role);
    }

    public Role findByid(String roleid) {

        return roleDao.findByid(roleid);
    }

    public List<Permission> findOthersPermission(String roleid) {

        return roleDao.findOthersPermission(roleid);
    }

    public void addRoleToUser(String permissionid, String roleid) {
        roleDao.addRoleToUser(permissionid,roleid);
    }
}
