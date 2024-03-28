package com.icloud.springframework.exception;

public class BeanException extends RuntimeException{
    public BeanException(String msg){
        super(msg);
    }
}
