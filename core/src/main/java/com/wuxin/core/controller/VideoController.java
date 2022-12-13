package com.wuxin.core.controller;

import com.wuxin.common.api.VideoDetailService;
import com.wuxin.common.api.VideoService;
import com.wuxin.common.utils.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Atothor:aa
 * data:2022/10/25
 */
@RestController
@RequestMapping("apis")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;
    private final VideoDetailService videoDetailService;

    /**
     *
     * @param request 获取传入的参数
     * @return 返回视频信息
     */
    @RequestMapping(value = "vod_list",method = RequestMethod.GET)
    public Result video(HttpServletRequest request){

        return  videoService.video(request);
    }

    /**
     *
     * @param id 传入视频id
     * @return 返回视频详细信息
     */
    @RequestMapping ("vod_detail")
    public Result detail(@RequestParam(value ="vod_id") Long id){

        return  videoDetailService.detail(id);
    }

}
