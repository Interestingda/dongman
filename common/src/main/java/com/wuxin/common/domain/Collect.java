package com.wuxin.common.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 收藏实体
 * Author:TangHong
 * data:2022/11/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_collect")
public class Collect {

    /**
     * 主键
     */
    private Long id;

    /**
     * 视频主键
     */
    @TableField("vod_id")
    private Long vodId;

    /**
     * 用户主键
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private String createTime;
}
