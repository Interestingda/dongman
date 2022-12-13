package com.wuxin.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuxin.common.api.CollectService;
import com.wuxin.common.domain.Collect;
import com.wuxin.common.domain.Video;
import com.wuxin.common.domain.mapper.CollectMapper;
import com.wuxin.common.domain.mapper.VideoMapper;
import com.wuxin.common.utils.Result;
import com.wuxin.core.common.ServiceCommon;
import com.wuxin.core.vo.VideoPVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Atothor:aa
 * data:2022/11/1
 */
@Service
@RequiredArgsConstructor
public class CollectServiceImpl implements CollectService {

    private final CollectMapper collectMapper;

    private final VideoMapper videoMapper;

    //添加收藏
    @Override
    public Result add(Long id, Long userId) {
        Collect collect = new Collect();
        collect.setUserId(userId);
        collect.setVodId(id);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        collect.setCreateTime(dateFormat.format(new Date()));
        collectMapper.insert(collect);
        return Result.success(200, "收藏成功");
    }

    /**
     * @param id     视频id
     * @param userId 用户id
     * @return 删除收藏成功
     */
    @Override
    public Result remove(Long id, Long userId) {
        LambdaQueryWrapper<Collect> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Collect::getVodId, id);
        queryWrapper.eq(Collect::getUserId, userId);
        collectMapper.delete(queryWrapper);
        return Result.success(200, "取消收藏成功");
    }

    /**
     * @param page   页数
     * @param userId 用户id
     * @return 返回收藏
     */
    @Override
    public Result show(Integer page, Long userId) {
        Page<Collect> page1 = new Page<>(page, 8);
        LambdaQueryWrapper<Collect> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Collect::getVodId);
        queryWrapper.eq(Collect::getUserId, userId);
        Page<Collect> collectPage = collectMapper.selectPage(page1, queryWrapper);

        List<Collect> records = collectPage.getRecords();
        List<Long> id = new ArrayList<>();
        if (!CollectionUtils.isEmpty(records)) {
            for (Collect collect : records) {
                id.add(collect.getVodId());
            }
            List<Video> videos = videoMapper.selectBatchIds(id);
            return Result.success(ServiceCommon.copyList(videos));
        }
        return Result.fail(200, "不存在收藏或者系统错误");
    }

}
