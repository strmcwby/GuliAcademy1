package com.atguigu.servicebase.exceptionhandler;
import com.atguigu.commonutils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody//为了返回数据结构
    //全局异常
    public Result error(Exception e){
        e.printStackTrace();
        return Result.error().message("全局异常处理");
    }

    //特定异常，优先
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody//为了返回数据结构
    public Result error(ArithmeticException e){
        e.printStackTrace();
        return Result.error().message("ArithmeticException异常处理");
    }

    //自定义异常 前提有创建自定义异常类
    @ExceptionHandler(GuliException.class)
    @ResponseBody//为了返回数据结构
    public Result error(GuliException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return Result.error().code(e.getCode()).message(e.getMsg());
    }


}
