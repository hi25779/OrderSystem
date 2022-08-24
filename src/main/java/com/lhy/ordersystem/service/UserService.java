package com.lhy.ordersystem.service;

import com.lhy.ordersystem.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author : Jesse(lhy)
 * @mail : 859028027@qq.com
 * @created : 2022-08-21
 **/
@Service
public interface UserService {

    Map<String, String> login(User user);

    Map<String, String> logout();

}
