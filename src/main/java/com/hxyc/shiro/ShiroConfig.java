package com.hxyc.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Description TODO  Shiro的配置类
 * @Author admin
 * @Date 2020/1/4 17:41
 **/
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *    常用的拦截器：
         *       anon: 无需认证(登录)可以访问
         *       authc: 必须认证才可以访问
         *       user: 如果使用rememeberMe的功能可以直接访问
         *       perms: 该资源必须得到资源权限才可以访问
         *       roles: 该资源必须得到角色权限才可以访问
         *
         */

        Map<String,String> filterMap = new LinkedHashMap<>();
        //key：要拦截的资源路径  value:用哪种拦截器拦截该资源
        /*
        filterMap.put("/add","authc");
        filterMap.put("/update","authc");
        */
        filterMap.put("/testThymeleaf","anon");
        //放行login.html页面
        filterMap.put("/login","anon");

        //授权过滤器
        //注意：当授权拦截后，shiro会自动跳转到未授权页面
        filterMap.put("/add","perms[user:add]");
        filterMap.put("/update","perms[user:update]");

        //如果一个目录下的所有资源都需要过滤
        // 特别注意：我们这里TestController类没有访问路径，才/*这样配置，有的话需要加上 /路径/*
        filterMap.put("/*","authc");// /目录请求路径/* eg:/user/*

        //修改跳转的登录页面 (认证不通过默认跳转到login.jsp页面)
        shiroFilterFactoryBean.setLoginUrl("/toLogin");

        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }
    /**
     * 创建DefaultWebSecurityManager
     * @Qualifier("userRealm")的作用：表示这个参数的值是从下面方法中（getRealm()）获取的
     * @param userRealm
     * @return
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    /**
     * 创建Realm
     * @return
     * @Bean的作用：让这个方法返回的值放入spring环境中，其它地方可以用
     */
    @Bean(name="userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

    /**
     * 配置ShiroDialect，用于thymeleaf和shiro标签整合使用
     * @return
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
