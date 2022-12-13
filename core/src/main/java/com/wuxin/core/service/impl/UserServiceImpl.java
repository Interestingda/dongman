package com.wuxin.core.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wuxin.common.api.UserService;
import com.wuxin.common.domain.User;
import com.wuxin.common.domain.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;


/**
 * Atothor:aa
 * data:2022/10/15
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;

    @Override
    public Map<String, Object> queryInfoByUsername(String username) {

        LambdaQueryWrapper<User> aa = new LambdaQueryWrapper<>();

        aa.select(User::getId,User::getUserName,User::getPassword,User::getSalt);
        aa.eq(User::getUserName, username);

        List<Map<String, Object>> collect = userMapper.selectMaps(aa);

        if(CollectionUtils.isEmpty(collect)){
                return null;
            }
        return collect.get(0);
    }



}
