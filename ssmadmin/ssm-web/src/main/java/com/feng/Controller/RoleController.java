package com.feng.Controller;

import com.feng.domain.Permission;
import com.feng.domain.Role;
import com.feng.domain.UserInfo;
import com.feng.service.Roleservice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/role")
@RolesAllowed("ADMIN")
public class RoleController {
    @Autowired
    Roleservice  roleservice;


    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "3")Integer currentpage,@RequestParam(defaultValue = "3")Integer pagesize){
        ModelAndView modelAndView=new ModelAndView();
        PageHelper.startPage(currentpage,pagesize);
        List<Role> roles = roleservice.findAll();
        PageInfo pageInfo=new PageInfo<Role>(roles);
        modelAndView.addObject("page", pageInfo);
        modelAndView.addObject("roleList", pageInfo.getList());
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public ModelAndView findUserByIdAndAllRole(Role role){
        roleservice.save(role);
        return new ModelAndView("redirect:findAll.do");
    }


    //查询角色以及角色可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String roleid) throws Exception {
        ModelAndView mv = new ModelAndView();
        //1.根据用户id查询用户
        Role role = roleservice.findByid(roleid);
        //2.根据用户id查询可以添加的角色
        List<Permission> othersPermissions = roleservice.findOthersPermission(roleid);
        mv.addObject("role", role);
        mv.addObject("permissionList",othersPermissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    //添加权限
    @RequestMapping("/addPermissionToRole.do")
    public ModelAndView addPermissionToRole(@RequestParam(name = "roleId", required = true) String roleid, @RequestParam(name = "ids", required = true) String[] ids){
        ModelAndView modelAndView=new ModelAndView();
        for(int i=0;i<ids.length;i++){
           roleservice.addRoleToUser(ids[i],roleid);
        }
        modelAndView.addObject("id",roleid);
        modelAndView.setViewName("redirect:findAll.do");
        return modelAndView;
    }
}
