package com.lxh.controller;

import com.lxh.entity.User;
import com.lxh.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView model){
        System.out.println("zhangsan");
        List<User> listusers=userService.selectAllUsers();
        for (User user : listusers) {
            System.out.println(user.toString());
        }
        System.out.println(listusers);
        model.setViewName("login");
        model.addObject("users",listusers);
        return model;
    }



}
