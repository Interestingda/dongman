package com.wuxin.common.api;

import com.wuxin.common.utils.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * Author:TangHong
 * data:2022/10/25
 */
public interface VideoService {
    /**
     * 返回视频详细信息
     * @param video request
     * @return 详细信息
     */
    Result video(HttpServletRequest video);

}
