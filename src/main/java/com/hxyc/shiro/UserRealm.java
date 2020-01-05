package com.hxyc.shiro;

import com.hxyc.model.User;
import com.hxyc.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName UserRealm
 * @Description TODO 自定义Realm
 * @Author admin
 * @Date 2020/1/4 17:37
 **/
public class UserRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    /**
     * 执行授权逻辑
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        System.out.println("执行授权逻辑");
        User user = (User) principal.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //实际操作中是根据用户查找用户具有的资源权限
        //这里简化
        info.addStringPermission(user.getPerms());

        return info;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        //编写shiro判断条件，判断用户名和密码
        // 1、判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        User user = userService.findByUsername(token.getUsername());

        if(user ==null){
            //用户名不存在
            return null; //shiro底层会抛出UnknownAccountException
        }

        //2、判断密码
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");//shiro底层会拿到数据库的密码去比对用户输入的密码
    }
}
