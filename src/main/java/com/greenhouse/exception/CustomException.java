package com.greenhouse.exception;

/**
 *异常处理
 */
public class CustomException extends RuntimeException {
    //异常信息
    private String message;

    public CustomException(String message){
        super(message);
        this.message=message;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }
}