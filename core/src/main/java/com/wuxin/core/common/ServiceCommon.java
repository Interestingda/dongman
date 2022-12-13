package com.wuxin.core.common;


import com.wuxin.common.domain.Video;
import com.wuxin.core.vo.VideoPVo;

import java.util.ArrayList;
import java.util.List;

public class ServiceCommon {

    public static List<VideoPVo> copyList(List<Video> L) {
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
