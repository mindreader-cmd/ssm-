package com.feng.Controller;

import com.feng.domain.Role;
import com.feng.domain.UserInfo;
import com.feng.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
@RolesAllowed("ADMIN")
public class UserController {
    @Autowired
    UserService userService;
    //查询所有
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") Integer currentpage,@RequestParam(defaultValue = "3") Integer pagesize){
        ModelAndView modelAndView=new ModelAndView();
        PageHelper.startPage(currentpage,pagesize);
        List<UserInfo> users = userService.findAll();
        PageInfo pageInfo=new PageInfo<UserInfo>(users);
        modelAndView.addObject("userList", pageInfo.getList());
        modelAndView.addObject("page", pageInfo);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    //新增用户
    @RequestMapping("/save.do")
    public ModelAndView save(UserInfo userInfo){
        userService.save(userInfo);
        return new ModelAndView("redirect:findAll");
    }

    //查询一个
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView modelAndView=new ModelAndView();
        UserInfo userInfo=userService.findByid(id);
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }


//查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String userid) throws Exception {
        ModelAndView mv = new ModelAndView();
        //1.根据用户id查询用户
        UserInfo userInfo = userService.findByid(userid);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(userid);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    //添加角色
    @RequestMapping("/addRoleToUser.do")
    public ModelAndView addRoleToUser(@RequestParam(name = "userId", required = true) String userid, @RequestParam(name = "ids", required = true) String[] ids){
        ModelAndView modelAndView=new ModelAndView();
        for(int i=0;i<ids.length;i++){
            userService.addRoleToUser(ids[i],userid);
        }
        modelAndView.addObject("id",userid);
        modelAndView.setViewName("redirect:findById.do");
        return modelAndView;
    }


}
