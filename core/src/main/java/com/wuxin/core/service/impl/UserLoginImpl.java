package com.wuxin.core.service.impl;

import com.wuxin.common.api.UserLogin;

import com.wuxin.common.domain.User;
import com.wuxin.common.domain.mapper.UserMapper;
import com.wuxin.common.utils.Result;
import com.wuxin.common.vo.LoginUser;
import com.wuxin.core.utils.SaltUtils;
import com.wuxin.core.vo.UserVo;
import lombok.RequiredArgsConstructor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * Author:TangHong
 * data:2022/10/13
 */
@Service
@RequiredArgsConstructor
public class UserLoginImpl implements UserLogin {

    private final UserServiceImpl userService;
    private final UserMapper userMapper;
    private final SaltUtils saltUtils;

    /**
     * @param loginUser 进行登录的认证
     */
    @Override
    public Result login(LoginUser loginUser) {
        String username = loginUser.getName();
        String password = loginUser.getPassword();
        // 创建Subject实例
        Subject currentUser = SecurityUtils.getSubject();

        // 将用户名及密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        try {
            currentUser.login(token);
            // 判断当前用户是否登录
            if (currentUser.isAuthenticated()) {

                return Result.success(200, "登录成功");
            }
        } catch (IncorrectCredentialsException ice) {
            return Result.fail(400, "登录失败,密码不正确");
        } catch (UnknownAccountException uae) {
            return Result.fail(400, "登录失败,账号不存在");
        } catch (AuthenticationException ae) {
            return Result.fail(400, "登录失败,账号状态异常");
        }

        return Result.fail(400, "登录失败，系统错误");
    }

    /**
     * 进行账号密码的注册
     */
    @Override
    public Result register(LoginUser loginUser) {
        String username = loginUser.getName();
        String pw = loginUser.getPassword();


        Map<String, Object> map = userService.queryInfoByUsername(username);
        //检查是否已存在这个用户名
        if (CollectionUtils.isEmpty(map)) {
            String salt = saltUtils.getSalt(username.length());
            String password = new SimpleHash("MD5", pw, salt, 1024).toHex();
            User zh = new User();
            zh.setUserName(username);
            zh.setPassword(password);
            zh.setSalt(salt);
            userMapper.insert(zh);
            return Result.success(Result.success(200, username));
        }

        return Result.fail(400, "账户注册失败,账户已存在");
    }

    /**
     * @return 返回用户对象的相关信息
     */
    @Override
    public Result userDetail() {
        Subject subject = SecurityUtils.getSubject();
        Map<String, Object> userInfo = (Map<String, Object>) subject.getPrincipal();


        if (userInfo != null) {
            UserVo userVo = new UserVo();
            Object id = userInfo.get("id");
            Object name = userInfo.get("userName");
            userVo.setId(Long.valueOf(id.toString()));
            userVo.setName(name.toString());
            return Result.success(200, userVo, "用户信息返回成功");
        }
        return null;
    }

    @Override
    public Result loginOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Result.success(200, "退出登录成功");
    }

}
