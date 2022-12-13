package com.wuxin.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wuxin.common.api.VideoDetailService;
import com.wuxin.common.domain.VideoDetail;
import com.wuxin.common.domain.mapper.VideoDetailMapper;
import com.wuxin.common.utils.Result;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

/**
 * Atothor:aa
 * data:2022/10/31
 */
@Service
@RequiredArgsConstructor
@Transactional
public class VideoDetailServiceImpl implements VideoDetailService {
    private final VideoDetailMapper videoDetailMapper;

    @Override
    public Result detail(Long id) {
        if (Objects.isNull(id)) {
            System.out.println(id);
            return Result.fail(400, "id为空");
        }
        VideoDetail videoDetail = videoDetailMapper.selectById(id);
        if (!Objects.isNull(videoDetail)) {
            String detail = videoDetail.getDetailInfo();
            System.out.println(detail);
            JSONObject parse = JSONObject.parseObject(detail);
            String playurl = parse.getString("vod_play_url");

            String[] sp = playurl.split("#");
            Map<String, String> map = new LinkedHashMap<>();
            for (String s : sp) {
                String[] spl = s.split("\\$");
                map.put(spl[0], spl[1]);
            }
            parse.put("vod_play_url", map);
            return Result.success(parse);
        }
        return Result.fail(400, "数据不存在");
    }
}
