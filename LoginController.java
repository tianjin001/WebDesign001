package com.ginger.controller;

import com.ginger.pojo.Result;
import com.ginger.pojo.User;
import com.ginger.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
           User user1 =  loginService.login(user);
           if (user1 != null) {
               return Result.success(user1);
           }else{
                return Result.error("wrong username or password");
           }
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        User user1 = loginService.selectByUsername(user);
        if (user1 != null) {
            System.out.println("username:"+user1.getUsername()+"is existed");
            return Result.error("username is existed");
        }else{
            loginService.register(user);
            return Result.success(user);
        }
    }
}

