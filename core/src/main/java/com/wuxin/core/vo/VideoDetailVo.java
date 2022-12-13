package com.wuxin.core.vo;

import lombok.Data;

/**
 * Author:TangHong
 * data:2022/10/25
 */
@Data
public class VideoDetailVo {

    /**
     * 主键
     */
    private Long vod_id;

    /**
     *
     */
    private String vod_name;

    /**
     * 图片名称
     */
    private String vod_pic;

    private String vod_remarks;

}
