package com.zsk.controller;

import com.zsk.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 夜尽
 * @date 2018/12/3 16:29
 */
@Controller
@Slf4j
public class ShiroController {
    
    @RequestMapping("/login")
    public String login(){
        return "shiro/login";
    }
    
    @PostMapping("/loginUser")
    public String loginUser(String username, String password, ModelMap map, HttpSession session){
        log.info(username);
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user",user);
            session.setMaxInactiveInterval(300);
            map.addAttribute("user",user);
            log.info("当前用户是否包含guest角色?{}",subject.hasRole("guest"));
            return "shiro/success";
        }catch(Exception e){
            log.error("出现错误"+e.toString());
            return "shiro/error";
        }
    }
}
