package com.zsk.shiroconfig;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.Configuration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;


/** freemarker支持shiro标签的配置
 * @author 夜尽
 * @date 2018/12/3 16:47
 */
@org.springframework.context.annotation.Configuration
public class ShiroTagFreeMarkerConfigurer implements InitializingBean {
    @Autowired
    Configuration configuration;
    @Autowired
    FreeMarkerViewResolver freeMarkerViewResolver;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        // 加上这句后，可以在页面上使用shiro标签
        configuration.setSharedVariable("shiro", new ShiroTags());
        // 加上这句后，可以在页面上用${context.contextPath}获取contextPath
        freeMarkerViewResolver.setRequestContextAttribute("context");
        
    }
}
