package com.zsk.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author 夜尽
 * @date 2018/12/3 15:02
 */
@Entity
@Getter
@Setter
public class Permission implements Serializable {
    private static final long serialVersionUID = -8358792626195942374L;
    
    @Id
    @GeneratedValue
    private Integer permissionId;
    
    private String permissionName;
    
    /**
     * 权限与角色多对多的关系
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "rolePermission",joinColumns = @JoinColumn(name = "permissionId"),
    inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roleList;
    
    public Permission() {
    }
}
