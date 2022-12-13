package com.wuxin.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 评论实体
 * Author:TangHong
 * data:2022/11/2
 */
@Data
@TableName("t_comment")
public class Comment {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 评论内容
     */
    @TableField(value = "content")
    private String body;

    /**
     * 创建时间
     */
    @TableField(value = "create_date")
    private String createDate;

    /**
     * 视频主键
     */
    @TableField(value = "vod_id")
    private Long vodId;
    /**
     * 用户主键
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 上级主键
     */
    @TableField(value = "parent_id")
    private Long parentId;

    @TableField(value = "to_uid")
    private Long toUid;

    private Integer level;
}
