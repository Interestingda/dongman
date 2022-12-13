package com.wuxin.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Author:TangHong
 * data:2022/10/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="t_user")
public class User {

    @TableId(value = "UserId",type = IdType.AUTO)
    private Long id;
    @TableField(value = "userName")
    private  String userName;
    @TableField(value = "userPassword")
    private  String password;
    @TableField(value ="salt")
    private String salt;
    
}