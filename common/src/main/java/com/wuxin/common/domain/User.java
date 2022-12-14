package com.wuxin.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 用户实体
 * Author:TangHong
 * data:2022/10/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="t_user")
public class User {

    /**
     * id
     */
    @TableId(value = "UserId",type = IdType.AUTO)
    private Long id;

    /**
     * 用户名称
     */
    @TableField(value = "userName")
    private  String userName;

    /**
     * 密码
     */
    @TableField(value = "userPassword")
    private  String password;

    /**
     * 加密盐
     */
    @TableField(value ="salt")
    private String salt;
    
}