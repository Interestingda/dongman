package com.wuxin.common.api;

import com.wuxin.common.utils.Result;

/**
 * Author:TangHong
 * data:2022/11/1
 */
public interface CollectService {
    //添加收藏
    Result add(Long id,Long userId);

    //移除收藏
    Result remove(Long id,Long userId);

    //展示收藏
    Result show(Integer page,Long userId);
}
