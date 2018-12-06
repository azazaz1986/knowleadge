package com.zsk.dao;

import com.zsk.pojo.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author 夜尽
 * @date 2018/12/3 15:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionDaoTest {
    @Autowired
    PermissionDao permissionDao;
    
    @Test
    public void add(){
        Permission permission = new Permission();
        permission.setPermissionName("add");
        permissionDao.save(permission);
    }
}