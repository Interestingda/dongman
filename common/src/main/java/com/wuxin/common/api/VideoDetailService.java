package com.wuxin.common.api;

import com.wuxin.common.utils.Result;

/**
 * Author:TangHong
 * data:2022/10/31
 */
public interface VideoDetailService {

    /**
     * 根据id返回视频详细信息
     * @param id 视频id
     * @return data
     */
    Result detail(Long id);

}
