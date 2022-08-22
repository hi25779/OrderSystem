package com.lhy.ordersystem.controller;

import com.lhy.ordersystem.domain.Message;
import com.lhy.ordersystem.entity.User;
import com.lhy.ordersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Message login(@RequestBody User user) {
        return new Message(200, "login succesfuly", userService.login(user));
    }

}
