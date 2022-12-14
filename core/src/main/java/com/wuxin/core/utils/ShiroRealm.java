package com.wuxin.core.utils;

import com.wuxin.common.api.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Map;

/**
 * Author:TangHong
 * data:2022/10/15
 */
public class ShiroRealm extends AuthenticatingRealm {

    @Autowired
    private UserService userService;

    private SimpleAuthenticationInfo info = null;

    /**
     * 1.doGetAuthenticationInfo，获取认证消息，如果数据库中没有数，返回null，如果得到了正确的用户名和密码，
     * 返回指定类型的对象
     * <p>
     * 2.AuthenticationInfo 可以使用SimpleAuthenticationInfo实现类，封装正确的用户名和密码。
     * <p>
     * 3.token参数 就是我们需要认证的token
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 将token装换成UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        // 获取用户名即可
        String username = upToken.getUsername();
        // 查询数据库，是否查询到用户名和密码的用户
        Map<String, Object> userInfo = userService.queryInfoByUsername(username);

        if (userInfo != null) {
            // 如果查询到了，封装查询结果，返回给我们的调用
            Object principal = userInfo.get("userName");
            Object credentials = userInfo.get("password");
            // 获取盐值，即用户名 将盐值封装到byteSource
            ByteSource salt = ByteSource.Util.bytes(userInfo.get("salt"));
            String realmName = this.getName();
            // 将用户对象，密码，盐值，realmName实例化到SimpleAuthenticationInfo中交给Shiro来管理
            info = new SimpleAuthenticationInfo(userInfo, credentials, salt, realmName);
        } else {
            // 如果没有查询到，抛出一个异常
            System.out.println("账号不存在");
            throw new UnknownAccountException("账号不存在");
        }

        return info;
    }
}
