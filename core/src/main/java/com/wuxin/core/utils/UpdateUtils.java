package com.wuxin.core.utils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wuxin.common.domain.Video;
import com.wuxin.common.domain.VideoDetail;
import com.wuxin.common.domain.mapper.VideoDetailMapper;
import com.wuxin.common.domain.mapper.VideoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Atothor:aa
 * data:2022/10/25
 */
@Component
@RequiredArgsConstructor
public class UpdateUtils {

    private final VideoDetailMapper videoDetailMapper;

    private final VideoMapper videoMapper;

    public void w() {
        List<Video> videos = new ArrayList<>();
        LambdaQueryWrapper<VideoDetail> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(VideoDetail::getDetailInfo);
        List<VideoDetail> videoDetails = videoDetailMapper.selectList(wrapper);
        for (VideoDetail videoDetail : videoDetails) {
            try {
                Video video = new Video();
                String l = videoDetail.getDetailInfo();

                JSONObject parse = JSONObject.parseObject(l);


                video.setVod_id(Long.valueOf(parse.getString("vod_id")));
//                video.setVod_area(parse.getString("vod_area"));
//                video.setVod_year(Integer.valueOf(parse.getString("vod_year")));
//                video.setVod_class(parse.getString("vod_class"));
                video.setVod_pic(parse.getString("vod_pic"));
                videoMapper.updateById(video);
                videos.add(video);
            } catch (Exception ignored) {
            }

        }

    }
}
