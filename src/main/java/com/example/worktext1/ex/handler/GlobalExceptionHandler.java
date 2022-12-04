package com.example.worktext1.ex.handler;

import com.example.worktext1.ex.ServiceException;
import com.example.worktext1.web.JsonResult;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    public GlobalExceptionHandler(){
        log.debug("创建统一处理异常的类:GlobalExceptionHandler");
    }

    @ExceptionHandler
    public JsonResult<Void> handleServiceException(ServiceException e){
        log.debug("处理ServiceException：{}",e.getMessage());
        return JsonResult.fail(e);
    }
}
