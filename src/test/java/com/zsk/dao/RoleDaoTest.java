package com.zsk.dao;

import com.zsk.pojo.Permission;
import com.zsk.pojo.Role;
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
 * @date 2018/12/3 15:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleDaoTest {
    @Autowired
    RoleDao roleDao;
    
    @Autowired
    PermissionDao permissionDao;
    
    @Test
    public void add(){
        Role role = new Role();
        List<Permission> permissions = new LinkedList<>();
        permissions.add(permissionDao.findOne(1));
        role.setRoleName("guest");
        role.setDescription("只能添加");
        role.setPermissionList(permissions);
        roleDao.save(role);
    }
}