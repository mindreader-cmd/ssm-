package com.feng.dao;

import com.feng.domain.Permission;
import com.feng.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissiondao {

    @Select("select * from Permission where id in (select permissionid from  role_permission where roleid=#{id})")
    List<Permission> findPermissionByRoleId(String id);


    @Select("select * from Permission")
    List<Permission> findAll();

    @Insert("insert into Permission (permissionname,url) values(#{permissionName},#{url})")
    void save(Permission permission);

    @Select("select * from permission where id=#{pid}")
    Permission findByid(String pid);


    @Select("select * from role where id not in (select roleid from role_permission where permissionid=#{pid})")
    List<Role> findOthersRoles(String pid);
}
