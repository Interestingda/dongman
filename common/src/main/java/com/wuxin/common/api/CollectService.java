package com.wuxin.common.api;

import com.wuxin.common.utils.Result;

/**
 * Atothor:aa
 * data:2022/11/1
 */
public interface CollectService {
    Result add(Long id,Long userId);
    Result remove(Long id,Long userId);
    Result show(Integer page,Long userId);
}
