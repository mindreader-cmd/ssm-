package com.feng.Controller;

import com.feng.domain.Permission;
import com.feng.domain.Role;
import com.feng.domain.UserInfo;
import com.feng.service.Permissionservice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    Permissionservice permissionservice;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") Integer currentpage,@RequestParam(defaultValue = "3") Integer pagesize){
        ModelAndView modelAndView=new ModelAndView();
        PageHelper.startPage(currentpage,pagesize);
        List<Permission> permissions = permissionservice.findAll();
        PageInfo pageInfo=new PageInfo<Permission>(permissions);
        modelAndView.addObject("permissionList", pageInfo.getList());
        modelAndView.addObject("page", pageInfo);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }
    @RequestMapping("/save.do")
    public ModelAndView findUserByIdAndAllRole(Permission permission){
        permissionservice.save(permission);
        return new ModelAndView("redirect:findAll.do");
    }


    //查询权限以及权限可以添加的角色
    @RequestMapping("/findPermissionByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String pid) throws Exception {
        ModelAndView mv = new ModelAndView();
        //1.根据权限id查询权限
       Permission permission = permissionservice.findByid(pid);
        //2.根据权限id查询可以添加的角色
        List<Role> otherRoles = permissionservice.findOtherRoles(pid);
        mv.addObject("p", permission);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("role-permission-add");
        return mv;
    }

}
