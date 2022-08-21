package com.lhy.ordersystem;

import com.lhy.ordersystem.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : Jesse(lhy)
 * @mail : 859028027@qq.com
 * @created : 2022-08-14
 **/
@SpringBootTest
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void userMapperTest() {
        System.out.println(passwordEncoder.encode("123456"));
    }
}
