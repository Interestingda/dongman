package com.wuxin.common.api;

import com.wuxin.common.utils.Result;

import java.util.Map;

/**
 * Author:TangHong
 * data:2022/10/15
 */
public interface UserService {
    Map<String, Object> queryInfoByUsername(String username);

}
