package com.lhy.ordersystem.service.impl;

import com.lhy.ordersystem.domain.LoginUser;
import com.lhy.ordersystem.entity.User;
import com.lhy.ordersystem.service.UserService;
import com.lhy.ordersystem.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Jesse(lhy)
 * @mail : 859028027@qq.com
 * @created : 2022-08-21
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Map<String, String> login(User user) {
        UsernamePasswordAuthenticationToken passwordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authentication = authenticationManager.authenticate(passwordAuthenticationToken);
        if (authentication == null) {
            throw new RuntimeException("login fail");
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String jwt = JwtUtil.createJWT(loginUser.getUser().getId().toString());
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);
        return map;
    }

    @Override
    public Map<String, String> logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        return null;
    }
}
