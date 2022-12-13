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
   private Integer page;
   private Integer limit=12;
    private int movtype;
    private String keyword;
    private String vod_area;
    private String vod_class;
    private Integer vod_year;
}
