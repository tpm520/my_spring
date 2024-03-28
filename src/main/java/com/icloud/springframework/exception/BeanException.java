package com.icloud.springframework.exception;

public class BeanException extends RuntimeException{

    public BeanException(String msg){
        super(msg);
    }
    public BeanException(String msg,Throwable throwable){
        super(msg,throwable);
    }
}
