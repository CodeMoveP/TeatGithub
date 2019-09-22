package com.paic.controller;

import com.paic.model.MyResult;
import com.paic.model.UserModel;
import com.paic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * url转发
 * controller层传递对象参数时记得前面加@RequestBody注解
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param userModel
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login")
    public MyResult login(@RequestBody UserModel userModel){
        return userService.login(userModel);
    }

    /**
     * 新增用户
     * @param userModel
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUser")
    public MyResult addUser(@RequestBody UserModel userModel){
         return userService.insert(userModel);
    }

    /**
     * 测试
     * @return
     */
    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        System.out.println("123456");
        return "123";
    }

}
