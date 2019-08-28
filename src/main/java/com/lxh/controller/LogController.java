package com.lxh.controller;


import com.lxh.annotation.Operation;
import com.lxh.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/log")
public class LogController {

    @Resource
    LogService logService;

    @RequestMapping("/addLog")
    @ResponseBody
    @Operation(value = "保存日志")
    public String login(ModelAndView model){
        System.out.println("保存日志");
        return "zhangsan";
    }
}
