package com.zsk.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/** 角色实体
 * @author 夜尽
 * @date 2018/12/3 14:53
 */
@Entity
@Getter
@Setter
public class Role implements Serializable {
    private static final long serialVersionUID = 8538336013943118486L;
    
    @Id
    @GeneratedValue
    private Integer roleId;
    
    private String roleName;
    
    /**
     * 角色的解释说明
     */
    private String description;
    
    /**
     * 角色和权限多对多的关系
     */
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinTable(name = "rolePermission",joinColumns = @JoinColumn(name = "roleId"),
    inverseJoinColumns = @JoinColumn(name = "permissionId"))
    private List<Permission> permissionList;
    
    /**
     * 用户和角色的多对多关系
     */
    @ManyToMany
    @JoinTable(name = "userRole",joinColumns = @JoinColumn(name = "roleId"),
    inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<User> userList;
    
    public Role() {
    }
}
