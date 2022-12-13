package com.wuxin.core.vo;

import lombok.Data;

/**
 * data:2022/10/26
 */
@Data
public class VideoVo {

    /**
     * 视频id
     */
    private Long vod_id;

    /**
     * 视频名称
     */
    private String vod_name;

    /**
     * 视频图片
     */
    private String vod_pic;

    private String vod_remarks;
}
