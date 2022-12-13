package com.wuxin.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:TangHong
 * data:2022/10/25
 */
@Data
@NoArgsConstructor
public class VideoVo {
    /**
     * 页数
     */
    private Integer page;

    /**
     * 条数
     */
    private Integer limit = 12;

    /**
     * 视频类型
     */
    private int movtype;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 地区
     */
    private String vod_area;

    private String vod_class;

    /**
     * 年限
     */
    private Integer vod_year;
}
