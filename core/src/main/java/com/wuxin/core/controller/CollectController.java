package com.wuxin.core.controller;

import com.wuxin.common.api.CollectService;
import com.wuxin.common.utils.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Atothor:aa
 * data:2022/11/3
 */
@RestController
@RequestMapping("apis/collection")
@RequiredArgsConstructor
public class CollectController {
    private final CollectService collect;
    /**
     *
     * @param vod 传入视频id，和用户id
     * @return 返回增加收藏成功
     */
    @RequestMapping("add")
    public Result add(@RequestParam(value ="vod_id") Long vod,@RequestParam(value = "user_id") Long user){
        return collect.add(vod,user);
    }

    /**
     *
     * @param vod 传入收藏的视频id
     * @param user 传入收藏的用户
     * @return
     */
    @RequestMapping("remove")
    public Result remove(@RequestParam(value ="vod_id") Long vod,@RequestParam(value = "user_id") Long user){
        return collect.remove(vod,user);
    }
    @RequestMapping("show")
    public Result show(@RequestParam(value ="page") Integer page,@RequestParam(value = "user_id") Long user){
        return collect.show(page,user);
    }}
