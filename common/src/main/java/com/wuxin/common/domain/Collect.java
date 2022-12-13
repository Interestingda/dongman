package com.wuxin.common.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Atothor:aa
 * data:2022/11/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_collect")
public class Collect {
    private Long id;
    @TableField("vod_id")
    private Long vodId;

    @TableField("user_id")
    private Long userId;
    @TableField("create_time")
    private String createTime;
}
