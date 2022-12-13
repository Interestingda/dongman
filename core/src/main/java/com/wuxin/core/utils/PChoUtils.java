package com.wuxin.core.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wuxin.common.domain.VideoDetail;

import com.wuxin.common.domain.mapper.VideoDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;


/**
 * Atothor:aa
 * data:2022/10/24
 */
@Component
@RequiredArgsConstructor
public class PChoUtils {


    /**
     * Atothor:aa
     * data:2022/10/20
     */


    private final OkHttpUtils okHttpUtils;
    private final VideoDetailMapper videoDetailMapper;

    //        private final VideoDetailMapper videoDetailMapper;
    @Async("task")
    public void ss(int p, int number) {
        int pg = p;
        String tName = Thread.currentThread().getName();

        while (pg <= number) {
            String data = null;
            try {
                data = okHttpUtils.request(pg);
                if (null != data && !data.isEmpty()) {
                    pg++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject = JSONObject.parseObject(data);        //将数据转换为JSON对象
            if (!CollectionUtils.isEmpty(jsonObject)) {
                String list = jsonObject.getString("list");
                System.out.println(pg + "调用的线程名字：" + tName);
                JSONArray array = JSONArray.parseArray(list);
//                System.out.println(list1.get(0));
//                List<VideoDetail> list2 = JSONArray.parseArray(list, VideoDetail.class);
                List<VideoDetail> entityList = new ArrayList<>();
                for (int i = 0; i < array.size(); i++) {
                    JSONObject obj = (JSONObject) array.get(i);
                    VideoDetail entity = new VideoDetail();
                    entity.setVod_id(Long.valueOf(obj.getInteger("vod_id")));
                    entity.setVod_pic(obj.getString("vod_pic"));
                    entity.setDetailInfo(obj.toJSONString());
                    entityList.add(entity);
                }
                videoDetailMapper.videoInsert(entityList);
            }


//        JSONObject res = JSONObject.parseObject(jsonObject.getString("list"));
//        System.out.println(res);

        }
    }
}






