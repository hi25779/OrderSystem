package com.lhy.ordersystem;

import com.lhy.ordersystem.entity.User;
import com.lhy.ordersystem.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author : Jesse(lhy)
 * @mail : 859028027@qq.com
 * @created : 2022-08-14
 **/
@SpringBootTest
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void userMapperTest() {
        List<User> list = userMapper.selectList(null);
        //System.out.println(userMapper.getUserById(2).toString());
        User user = userMapper.getUserByUserName("lhy");
        System.out.println(user.getUserName());
    }
}
