package com.feng.service;

import com.feng.domain.Permission;
import com.feng.domain.Role;
import com.feng.domain.UserInfo;

import java.util.List;

public interface Roleservice {
    List<Role> findAll();

    void save(Role role);

    Role findByid(String roleid);

    List<Permission> findOthersPermission(String roleid);
    void addRoleToUser(String permissionid,String roleid);
}
