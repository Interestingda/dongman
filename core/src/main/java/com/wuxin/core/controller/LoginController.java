package com.wuxin.core.controller;


import com.wuxin.common.utils.Result;
import com.wuxin.common.vo.LoginUser;
import com.wuxin.core.service.impl.UserLoginImpl;


import com.wuxin.core.utils.UpdateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Atothor:aa
 * data:2022/10/15
 */

@RestController
@RequestMapping("apis/auth")
@RequiredArgsConstructor
public class LoginController {
   private final UpdateUtils tutils;
    private final UserLoginImpl userLogin;

    /**
     *
     * @param loginUser  用户登录
     * @return 返回成功
     */
    @PostMapping(value = "login")
    public Result login(@RequestBody LoginUser loginUser) {


        return userLogin.login(loginUser);
    }

    /**
     *
     * @param loginUser 用户注册
     * @return 返回成功
     */
    @PostMapping("register")
    public Result register(@RequestBody LoginUser loginUser) {
        return userLogin.register(loginUser);
    }

    /**
     *
     *
     * @return 获取用户登录的信息
 y   */
    @GetMapping("user")
    public Result user() {
        return userLogin.userDetail();
    }
    /**
     *
     */
    @RequestMapping("loginOut")
    public Result logout(){
        return userLogin.loginOut();
    }
}
