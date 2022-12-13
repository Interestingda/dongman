package com.wuxin.common.vo;

import lombok.Data;

/**
 * 登录DTO
 * Author:TangHong
 * data:2022/10/15
 */
@Data
public class LoginUser {

    /**
     * 用户名称
     */
    private String name;

    /**
     * 密码
     */
    private  String password;

}
