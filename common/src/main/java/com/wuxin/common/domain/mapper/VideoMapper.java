package com.wuxin.common.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuxin.common.domain.Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Atothor:aa
 * data:2022/10/22
 */
@Mapper
public interface VideoMapper extends BaseMapper<Video> {
    boolean saveVideo(List<Video> list);
}
