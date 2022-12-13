package com.wuxin.common.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuxin.common.domain.VideoDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Atothor:aa
 * data:2022/10/24
 */
@Mapper
public interface VideoDetailMapper extends BaseMapper<VideoDetail> {
    boolean videoInsert(List<VideoDetail> entityList);
}
