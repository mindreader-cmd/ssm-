package com.feng.service.impl;

import com.feng.dao.IPermissiondao;
import com.feng.domain.Permission;
import com.feng.domain.Role;
import com.feng.domain.UserInfo;
import com.feng.service.Permissionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService implements Permissionservice {
    @Autowired
    IPermissiondao permissiondao;
    public List<Permission> findAll() {
        return permissiondao.findAll();
    }

    public void save(Permission permission) {
        permissiondao.save(permission);
    }

    public Permission findByid(String pid) {
        return permissiondao.findByid(pid);
    }

    public List<Role> findOtherRoles(String pid) {

        return permissiondao.findOthersRoles(pid);
    }
}
