package com.wuxin.domanservice.vo;

import lombok.Data;

import java.util.List;

/**
 * Author:TangHong
 * data:2022/11/2
 */
@Data
public class CommentVo {
    private Long id;

    private UserVo author;

    private String body;

    private List<CommentVo> reply_list;

    private String time;

    private Integer level;

    private String reply_user_name;
}
