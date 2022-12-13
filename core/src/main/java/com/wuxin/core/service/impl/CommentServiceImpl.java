package com.wuxin.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wuxin.common.domain.Comment;
import com.wuxin.common.domain.User;
import com.wuxin.common.domain.mapper.CommentMapper;
import com.wuxin.common.domain.mapper.UserMapper;
import com.wuxin.common.utils.Result;
import com.wuxin.core.service.CommentService;
import com.wuxin.core.vo.CommentParam;
import com.wuxin.core.vo.CommentVo;
import com.wuxin.core.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Atothor:aa
 * data:2022/11/2
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;
    private final UserMapper userMapper;

    /**
     * 实现评论发布的service
     */
    @Override
    public Result publish(Long id, CommentParam commentParam) {
        Comment comment = new Comment();
        processVO(comment, commentParam);
        comment.setParentId(0L);
        comment.setLevel(1);
        comment.setVodId(Long.valueOf(id));
        comment.setToUid(0L);
        commentMapper.insert(comment);
        return Result.success(200, "评论成功");
    }

    /**
     * 实现评论的展示功能
     */
    @Override
    public Result show(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getVodId, id);
        queryWrapper.eq(Comment::getLevel, 1);
        List<Comment> list = commentMapper.selectList(queryWrapper);
        return Result.success(copyList(list));

    }


    @Override
    public Result reply(Long id, CommentParam commentParam) {
//        processVO(comment, commentParam);
        Comment comment = commentMapper.selectById(id);

        if (comment.getParentId() == 0) {
            comment.setParentId(comment.getId());
        }
        if (comment.getParentId() != 0) {
            comment.setParentId(comment.getParentId());
        }
        comment.setLevel(2);
        comment.setVodId(0L);
        comment.setToUid(comment.getUserId());
        commentMapper.insert(comment);
        return Result.success(200, "回复成功");
    }

    /**
     * @param list 传入评论list数据并遍历
     */
    public List<CommentVo> copyList(List<Comment> list) {
        List<CommentVo> commentVos = new ArrayList<>();
        for (Comment comment : list) {
            commentVos.add(copy(comment));
        }

        return commentVos;
    }

    /**
     * @param comment 传入查询后的评论数据
     * @return 返回Vo类数据
     */
    public CommentVo copy(Comment comment) {
        CommentVo commentVo = new CommentVo();
        commentVo.setId(comment.getId());
        commentVo.setTime(comment.getCreateDate());
        commentVo.setBody(comment.getBody());
        commentVo.setAuthor(copyUser(comment.getUserId()));
        //如果是第一层就将第一层评论的id作为参数进行查询第二层相关信息
        if (1 == comment.getLevel()) {
            List<CommentVo> commentVoList = findByParentId(comment.getId());
            if (CollectionUtils.isEmpty(commentVoList)) {
                commentVo.setReply_list(null);
            }
            commentVo.setReply_list(commentVoList);

        }
        if (comment.getLevel() > 1) {
            commentVo.setReply_user_name(copyUser(comment.getToUid()).getName());

        }


        return commentVo;
    }

    /**
     * @param id 根据第一层的评论id 查询楼层下的评论
     * @return 返回评论list
     */
    public List<CommentVo> findByParentId(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getParentId, id);
        queryWrapper.eq(Comment::getLevel, 2);
        List<Comment> list = commentMapper.selectList(queryWrapper);
        return copyList(list);
    }

    /**
     * 进行原始用户数据查询和vo类的转化
     */
    public UserVo copyUser(Long userId) {
        User user = userMapper.selectById(userId);
        if (user != null) {
            UserVo userVo = new UserVo();
            userVo.setId(user.getId());
            userVo.setName(user.getUserName());
            return userVo;
        }
        return null;
    }

    /**
     * 处理实体基本信息
     * @param comment entity
     * @param param 映射参数
     */
    private void processVO(Comment comment, CommentParam param) {
        Subject subject = SecurityUtils.getSubject();
        Map<String, Object> principal = (Map<String, Object>) subject.getPrincipal();
        comment.setUserId(Long.valueOf(principal.get("id").toString()));
        comment.setBody(param.getBody());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        comment.setCreateDate(dateFormat.format(new Date()));
    }
}
