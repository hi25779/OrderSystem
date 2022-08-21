package com.lhy.ordersystem.service.impl;

import com.lhy.ordersystem.domain.LoginUser;
import com.lhy.ordersystem.entity.User;
import com.lhy.ordersystem.service.UserService;
import com.lhy.ordersystem.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Map;

/**
 * @author : Jesse(lhy)
 * @mail : 859028027@qq.com
 * @created : 2022-08-21
 **/
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    public Map<String, String> login(User user) {
        UsernamePasswordAuthenticationToken passwordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authentication = authenticationManager.authenticate(passwordAuthenticationToken);
        if (authentication == null) {
            throw new RuntimeException("login fail");
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

    }
}
