package com.wuxin.common.api;

import com.wuxin.common.utils.Result;
import com.wuxin.common.vo.LoginUser;

/**
 * Author:TangHong
 * data:2022/10/13
 */

public interface UserLogin {

    /**
     * 用户登录
     * @param loginUser 登录信息
     * @return data
     */
    Result login(LoginUser loginUser);

    /**
     * 用户注册
     * @param loginUser 用户信息
     * @return id
     */
    Result register(LoginUser loginUser);

    /**
     * 获取用户详情
     * @return UserVO
     */
    Result userDetail();

    /**
     * 退出登录, 清除session
     * @return false/true
     */
    Result loginOut();
}
