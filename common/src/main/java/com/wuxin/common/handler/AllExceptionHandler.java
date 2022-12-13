package com.wuxin.common.handler;

import com.wuxin.common.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * Author:TangHong
 * data:2022/10/15
 */
@ControllerAdvice
public class AllExceptionHandler {

    /**
     * Excetion 统一拦截处理
     * @param e Exception
     * @return Result
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception e){
        e.printStackTrace();
        return Result.fail(-99999,"系统错误"+e.getMessage());
    }

}
