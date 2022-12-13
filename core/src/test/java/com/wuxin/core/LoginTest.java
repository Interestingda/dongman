package com.wuxin.core;

import com.wuxin.common.api.UserLogin;
import com.wuxin.common.vo.LoginUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {

    @Resource
    private UserLogin userLogin;

    @Test
    public void login(){
        LoginUser loginUser = new LoginUser();
        loginUser.setName("zs");
        loginUser.setPassword("123455");
        userLogin.login(loginUser);
        System.out.println(userLogin.login(loginUser));
    }

    @Test
    public void logout(){
        System.out.println(userLogin.loginOut());
    }

    @Test
    public void register(){
        LoginUser loginUser = new LoginUser();
        loginUser.setName("zs");
        loginUser.setPassword("123455");
        System.out.println(userLogin.register(loginUser));
    }

    @Test
    public void queryUserDetail(){
        System.out.println(userLogin.userDetail());
    }
}
