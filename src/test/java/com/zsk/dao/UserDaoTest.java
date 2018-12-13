package com.zsk.dao;

import com.zsk.pojo.Role;
import com.zsk.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 夜尽
 * @date 2018/12/3 15:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;
    
    @Autowired
    RoleDao roleDao;
    
    @Test
    public void add(){
        List<Role> roleList = new LinkedList<>();
        roleList.add(roleDao.findOne(1));
        User user = new User();
        user.setNickName("老王");
        user.setUserName("root");
        user.setPassword("123456");
        user.setRoleList(roleList);
        userDao.save(user);
    }
    
    @Test
    public void findOne(){
        System.out.println(userDao.findOne(1));
    }

    @Test
    public void findByUsername(){
        System.out.println(userDao.findByUserName("324"));
    }
}