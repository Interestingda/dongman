package com.wuxin.core.controller;

import com.wuxin.common.utils.Result;
import com.wuxin.core.service.CommentService;
import com.wuxin.core.vo.CommentParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Atothor:aa
 * data:2022/11/2
 */
@RestController
@RequestMapping("apis")
@RequiredArgsConstructor
public class CommenController {
    private final CommentService commentService;

    /**
     * @param id           传入视频id
     * @param commentParam 评论的信息和评论的用户
     * @return 返回评论成功
     */
    @RequestMapping("publish/comment/{vod_id}")
    public Result publish(@PathVariable("vod_id") Long id, @RequestBody CommentParam commentParam) {
        return commentService.publish(id, commentParam);
    }

    /**
     * @param id 视频id
     * @return 返回评论
     */
    @RequestMapping("show/comment/{vod_id}")
    public Result show(@PathVariable("vod_id") Long id) {
        return commentService.show(id);
    }

    /**
     * @param id           评论的id
     * @param commentParam 回复的内容
     * @return 返回回复成功
     */
    @RequestMapping("reply/comment/{comment_id}")
    public Result reply(@PathVariable("comment_id") Long id, @RequestBody CommentParam commentParam) {
        return commentService.reply(id,commentParam);
    }
}
