package com.wuxin.common.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.baomidou.mybatisplus.annotation.IdType.INPUT;


/**
 * 视频信息实体
 * Author:TangHong
 * data:2022/10/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_video")
public class Video {

    /**
     * 主键
     */
    @TableField(value = "type_id")
    private Long type_id;

    /**
     * 类型名称
     */
    @TableField(value = "type_name")
    private String type_name;

    @TableField(value = "vod_en")
    private String vod_en;

    /**
     * 视频主键
     */
    @TableField(value = "vod_id")
    @TableId(type = INPUT)
    private Long vod_id;

    /**
     * 视频名称
     */
    private String vod_name;

    /**
     * 视频来源
     */
    private String vod_play_from;

    private String vod_remarks;

    /**
     * 时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date vod_time;

    /**
     * 视频地区
     */
    @TableField(value = "vod_area")
    private String vod_area;

    /**
     * 视频年限
     */
    @TableField(value = "vod_year")
    private Integer vod_year;

    @TableField(value = "vod_class")
    private String vod_class;

    @TableField(value = "vod_pic")
    private String vod_pic;
}
