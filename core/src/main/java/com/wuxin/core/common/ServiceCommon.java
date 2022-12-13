package com.wuxin.core.common;


import com.wuxin.common.domain.Video;
import com.wuxin.core.vo.VideoVo;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务通用类
 */
public class ServiceCommon {

    /**
     * 转换实体
     * @param list list
     * @return vo
     */
    public static List<VideoVo> copyList(List<Video> list) {
        List<VideoVo> result = new ArrayList<>();
        try {
            for (Video v : list) {
                VideoVo videoPVo = new VideoVo();

                videoPVo.setVod_id(v.getVod_id());
                videoPVo.setVod_name(v.getVod_name());
                videoPVo.setVod_pic(v.getVod_pic());
                videoPVo.setVod_remarks(v.getVod_remarks());
                result.add(videoPVo);
            }
        } catch (Exception ignored) {}
        return result;

    }
}
