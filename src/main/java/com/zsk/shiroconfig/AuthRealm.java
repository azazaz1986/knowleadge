package com.zsk.shiroconfig;

import com.zsk.dao.UserDao;
import com.zsk.pojo.Permission;
import com.zsk.pojo.Role;
import com.zsk.pojo.User;
import com.zsk.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/** realm shiro认证和授权
 * @author 夜尽
 * @date 2018/12/3 16:05
 */

public class AuthRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user = userService.findByUserName(username);
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<Role> roles = user.getRoleList();
        Set<String> roleNames = new HashSet<>();
        List<String> permissions = new LinkedList<>();
        if(roles.size()>0){
            for (Role role : roles){
                roleNames.add(role.getRoleName());
                List<Permission> permissionList = role.getPermissionList();
                if(permissionList.size()>0){
                    for (Permission permission : permissionList){
                        permissions.add(permission.getPermissionName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermissions(permissions);
        authorizationInfo.setRoles(roleNames);
        return authorizationInfo;
    }
}
