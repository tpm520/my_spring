package com.icloud.springframework.factory.config;

public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
    }

    public Class getBean(){
        return this.beanClass;
    }
}
