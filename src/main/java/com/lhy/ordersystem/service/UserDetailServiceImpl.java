package com.lhy.ordersystem.service;

import com.lhy.ordersystem.domain.LoginUser;
import com.lhy.ordersystem.entity.User;
import com.lhy.ordersystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author : Jesse(lhy)
 * @mail : 859028027@qq.com
 * @created : 2022-08-18
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByUserName(username);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名或密码错误");
        }
        return new LoginUser(user);
    }
}
