package com.zsk.service.impl;

import com.zsk.dao.UserDao;
import com.zsk.pojo.User;
import com.zsk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author 夜尽
 * @date 2018/12/3 16:11
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    
    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }
}
