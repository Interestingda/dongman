package com.wuxin.common.api;

import com.wuxin.common.utils.Result;
import com.wuxin.common.vo.LoginUser;

/**
 * Author:TangHong
 * data:2022/10/13
 */

public interface UserLogin {
    //用户登录
    Result login(LoginUser loginUser);

    // 用户注册
    Result register(LoginUser loginUser);

    //用户信息获取
    Result userDetail();
    Result loginOut();
}
