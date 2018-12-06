package com.zsk.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/** 用户实体表
 * @author 夜尽
 * @date 2018/12/3 14:43
 */
@Entity
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = -628832785106969605L;
    @Id
    @GeneratedValue
    private Integer userId;
    
    /**
     * 用户登录账号
     */
    @Column(unique = true)
    private String userName;
    
    /**
     * 昵称
     */
    private String nickName;
    
    private String password;
    
    /**
     * 用户和角色多对多关系
     */
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinTable(name = "userRole",joinColumns = @JoinColumn(name = "userId"),
    inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roleList;
    
    public User() {
    }
}
