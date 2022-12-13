package com.wuxin.common.api;

import com.wuxin.common.utils.Result;
import com.wuxin.common.vo.LoginUser;

/**
 * Atothor:aa
 * data:2022/10/13
 */

public interface UserLogin {
    Result login(LoginUser loginUser);
    Result register(LoginUser loginUser);
    Result userDetail();
    Result loginOut();
}
