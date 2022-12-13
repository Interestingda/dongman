package com.wuxin.common.api;

import java.util.Map;

/**
 * Author:TangHong
 * data:2022/10/15
 */
public interface UserService {

    /**
     * 查询用户信息根据用户名
     * @param username 用户名
     * @return 用户信息
     */
    Map<String, Object> queryInfoByUsername(String username);

}
