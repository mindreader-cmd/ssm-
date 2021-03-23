package com.feng.dao;

import com.feng.domain.Permission;
import com.feng.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface IRoleDao {

    //根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.feng.dao.IPermissiondao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("select * from role")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.feng.dao.IPermissiondao.findPermissionByRoleId"))
    })
    List<Role> findAll();


    @Insert("insert into role(rolename,roledesc) values(#{roleName},#{roleDesc})")
    void save(Role role);


    @Select("select * from role where id =#{roleid}")
    Role findByid(String roleid);


    @Select("select * from permission where id not in (select permissionid from role_permission where roleid=#{roleid})")
    List<Permission> findOthersPermission(String roleid);


    @Insert("insert into role_permission(roleid,permissionid) values(#{roleid},#{permissionid})")
    void addRoleToUser(@Param("permissionid") String permissionid,@Param("roleid") String roleid);
}
