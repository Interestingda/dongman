package com.wuxin.core.service;

import com.wuxin.common.utils.Result;
import com.wuxin.core.vo.CommentParam;

/**
 * Atothor:aa
 * data:2022/11/2
 */
public interface CommentService {

    Result publish(Long id, CommentParam commentParam);

    Result show(Long id);

    Result reply(Long id, CommentParam commentParam);

}
