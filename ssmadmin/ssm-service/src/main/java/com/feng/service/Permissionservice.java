package com.feng.service;

import com.feng.domain.Permission;
import com.feng.domain.Role;
import com.feng.domain.UserInfo;

import java.util.List;

public interface Permissionservice {
    List<Permission> findAll();

    void save(Permission permission);

    Permission findByid(String pid);

    List<Role> findOtherRoles(String pid);
}
