package com.zsk.dao;

import com.zsk.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 夜尽
 * @date 2018/12/3 15:29
 */

public interface UserDao extends JpaRepository<User,Integer> {
    /**
     * 根据UserName进行查询
     * @param username
     * @return
     */
    User findByUserName(String username);
}
