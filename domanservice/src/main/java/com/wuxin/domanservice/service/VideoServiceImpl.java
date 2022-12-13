package com.wuxin.domanservice.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuxin.common.api.VideoService;
import com.wuxin.common.domain.Video;

import com.wuxin.common.domain.mapper.VideoDetailMapper;
import com.wuxin.common.domain.mapper.VideoMapper;
import com.wuxin.common.utils.Result;
import com.wuxin.common.vo.VideoVo;
import com.wuxin.domanservice.vo.VideoPVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

import java.util.List;

/**
 * Author:TangHong
 * data:2022/10/25
 */
@Service
@RequiredArgsConstructor
@Transactional
public class VideoServiceImpl implements VideoService {
    private final VideoMapper videoMapper;

    /**
     *
     * @param video 传入的请求参数
     * @return   返回给前端数据
     */
    @Override
    public Result video(HttpServletRequest video) {
//        page=1&movtype=1&keyword=&vod_area=&vod_class=&vod_year=
        VideoVo videoVo = new VideoVo();
        videoVo.setPage(Integer.valueOf(video.getParameter("page")));
        if (!StringUtils.isEmpty(video.getParameter("movtype"))) {
            videoVo.setMovtype(Integer.parseInt(video.getParameter("movtype")));
        }
        if (!StringUtils.isEmpty(video.getParameter("vod_area"))) {
            videoVo.setVod_area(video.getParameter("vod_area"));
        }
        if (!StringUtils.isEmpty(video.getParameter("vod_class"))) {
            videoVo.setVod_class(video.getParameter("vod_class"));
        }
        if (!StringUtils.isEmpty(video.getParameter("keyword"))) {
            videoVo.setKeyword(video.getParameter("keyword"));
        }
        if (!StringUtils.isEmpty(video.getParameter("vod_year"))) {
            videoVo.setVod_year(Integer.valueOf(video.getParameter("vod_year")));
        }





        Page<Video> page = new Page<>(videoVo.getPage(),videoVo.getLimit());

        LambdaQueryWrapper<Video> wrapper = new LambdaQueryWrapper<>();
          wrapper.select(Video::getVod_id,Video::getVod_name,Video::getVod_pic,Video::getVod_remarks);
        wrapper.eq(!StringUtils.isEmpty(videoVo.getMovtype())&&videoVo.getMovtype()>0,Video::getType_id,videoVo.getMovtype());
        wrapper.eq(!StringUtils.isEmpty(videoVo.getVod_class()),Video::getVod_class,videoVo.getVod_class());
        wrapper.like(!StringUtils.isEmpty(videoVo.getVod_area()),Video::getVod_area,videoVo.getVod_area());
        wrapper.eq(!StringUtils.isEmpty(videoVo.getVod_year()),Video::getVod_year,videoVo.getVod_year());
        wrapper.like(!StringUtils.isEmpty(videoVo.getKeyword()),Video::getVod_name,videoVo.getKeyword());
        wrapper.orderByDesc(Video::getVod_time);
        Page<Video> page1 = videoMapper.selectPage(page, wrapper);

        List<Video> list=page1.getRecords();
        return Result.success(copylist(list));
    }

    public List<VideoPVo> copylist(List<Video> L) {
        List<VideoPVo> result = new ArrayList<>();
        try{
        for (Video v : L) {
            VideoPVo videoPVo = new VideoPVo();

            videoPVo.setVod_id(v.getVod_id());
            videoPVo.setVod_name(v.getVod_name());
            videoPVo.setVod_pic(v.getVod_pic());
            videoPVo.setVod_remarks(v.getVod_remarks());
            result.add(videoPVo);
        }}catch (Exception ignored){}
        return  result;

  }
}
