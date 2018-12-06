package com.zsk.dao;

import com.zsk.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 夜尽
 * @date 2018/12/3 15:30
 */

public interface RoleDao extends JpaRepository<Role,Integer> {

}
