package com.wuxin.common.api;

import com.wuxin.common.domain.Video;
import com.wuxin.common.utils.Result;
import com.wuxin.common.vo.VideoVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Atothor:aa
 * data:2022/10/25
 */
public interface VideoService {
    Result video(HttpServletRequest video);
}
