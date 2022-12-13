package com.wuxin.common.api;

import com.wuxin.common.utils.Result;

/**
 * Author:TangHong
 * data:2022/11/1
 */
public interface CollectService {

    /**
     * 添加收藏
     * @param id 视频id
     * @param userId 用户id
     * @return id
     */
    Result add(Long id,Long userId);

    /**
     * 删除收藏
     * @param id 视频id
     * @param userId 用户id
     * @return false/true
     */
    Result remove(Long id,Long userId);

    /**
     * 返回收藏详情
     * @param page 页码
     * @param userId 用户id
     * @return Collect List
     */
    Result show(Integer page,Long userId);
}
