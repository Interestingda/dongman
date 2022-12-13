package com.wuxin.core.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.wuxin.common.domain.Video;
import com.wuxin.common.domain.mapper.VideoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;

import java.util.List;

/**
 * Atothor:aa
 * data:2022/10/20
 */
@Component
@RequiredArgsConstructor
public class PaChongUtils {
// pChoUtils.ss(1,300);
//        pChoUtils.ss(301,500);
//        pChoUtils.ss(501,700);
//        pChoUtils.ss(701,1000);
//        pChoUtils.ss(1001,1300);
//        pChoUtils.ss(1301,1550);
//        pChoUtils.ss(1551,1800);
//        pChoUtils.ss(1801,2100);
//        pChoUtils.ss(2101,2500);
//        pChoUtils.ss(2501,2800);
//        pChoUtils.ss(2801,3100);
//        pChoUtils.ss(3101,3562);

    private final HttpsUtils httpsUtils;

    private final VideoMapper videoMapper;
    @Async("task")
     public void ss(int p,int number){
        int pg=p;
        String tName=Thread.currentThread().getName();

    while(pg<=number){
        String data= null;
        try {
            data = httpsUtils.getResponse(pg);
            if (null !=data && !data.isEmpty()){
                pg++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
      JSONObject jsonObject = JSONObject.parseObject(data);		//将数据转换为JSON对象
        if (!CollectionUtils.isEmpty(jsonObject)) {
            String list = jsonObject.getString("list");
            System.out.println(pg+ "调用的线程名字："+tName);
//            TLSv1.1,TLSv1.2
            List<Video> list1=JSONArray.parseArray(list,Video.class);


              try {
                  videoMapper.saveVideo(list1);
              }catch (Exception ignored){}







        }



//        JSONObject res = JSONObject.parseObject(jsonObject.getString("list"));
//        System.out.println(res);

    }
}}




