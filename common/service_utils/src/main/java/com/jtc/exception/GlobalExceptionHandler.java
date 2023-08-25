package com.jtc.exception;

import com.jtc.ykt.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: 小天
 * @Date: 2023/8/23 - 08 - 23 - 19:46
 * @Decsription: com.jtc.exception
 * @version: 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    //全局异常处理
    @ExceptionHandler(Exception.class)
    public Result error(Exception e){
        System.out.println("全局......");
        e.printStackTrace();
        return Result.fail(null).message("执行全局异常");
    }

    //特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    public Result error(ArithmeticException e){
        e.printStackTrace();;
        return Result.fail(null).message("执行了特定异常处理");
    }

    //处理自定义异常
    @ExceptionHandler(YktException.class)
    public Result error(YktException e){
        e.printStackTrace();
        return Result.fail(null).message(e.getMsg()).code(e.getCode());
    }
}
