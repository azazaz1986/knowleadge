package com.zsk.service;

import com.zsk.pojo.User;

/**
 * @author 夜尽
 * @date 2018/12/3 16:10
 */

public interface UserService {
    /**
     * 根据UserName进行查询
     * @param username
     * @return
     */
    User findByUserName(String username);
}
