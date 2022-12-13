package com.wuxin.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Atothor:aa
 * data:2022/11/2
 */
@Data
@TableName("t_comment")
public class Comment {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "content")
    private String body;

    @TableField(value = "create_date")
    private String createDate;

    @TableField(value = "vod_id")
    private Long vodId;
    @TableField(value = "user_id")
    private Long userId;
    @TableField(value = "parent_id")
    private Long parentId;
    @TableField(value = "to_uid")
    private Long toUid;

    private Integer level;
}
