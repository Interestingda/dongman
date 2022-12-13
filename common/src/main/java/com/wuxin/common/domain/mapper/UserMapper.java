package com.wuxin.common.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuxin.common.domain.User;

import org.apache.ibatis.annotations.Mapper;

/**
 * Author:TangHong
 * data:2022/10/15
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
