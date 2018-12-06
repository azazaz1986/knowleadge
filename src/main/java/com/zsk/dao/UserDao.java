package com.zsk.dao;

import com.zsk.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 夜尽
 * @date 2018/12/3 15:29
 */

public interface UserDao extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
