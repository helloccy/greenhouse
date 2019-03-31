package com.greenhouse.handle;

import com.greenhouse.bean.ResponseBean;
import com.greenhouse.exception.CustomException;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseBean handle(Exception e){

        if( e instanceof CustomException){
            return ResponseBean.createException(e.getMessage());
        }

        if(e instanceof BindException){
            return ResponseBean.createError(((BindException) e).getFieldError().getDefaultMessage());
        }
        logger.error("异常信息：",e);

        return ResponseBean.createException("未知错误:"+ e.getMessage());
    }
}
