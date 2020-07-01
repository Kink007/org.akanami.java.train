package org.akanami.data.mybatis.mapper;

import org.akanami.data.mybatis.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void getUserById() {
        User user = this.userMapper.getUserById(1);
        Assert.assertNotNull(user);
    }

    @Test
    public void getUserByName() {
        User user = this.userMapper.getUserByName("admin");
        Assert.assertNotNull(user);
    }

    @Test
    public void getAll() {
        ArrayList<User> users = this.userMapper.getAll();
        Assert.assertNotNull(users);
        Assert.assertTrue(users.size() > 0);
    }

    @Test
    public void add() {
        User user = new User();
        user.setName("admin2");
        user.setBirth(new Date());

        this.userMapper.add(user);

        ArrayList<User> users = this.userMapper.getAll();
        Assert.assertNotNull(users);
        Assert.assertTrue(users.size() > 0);
    }
}