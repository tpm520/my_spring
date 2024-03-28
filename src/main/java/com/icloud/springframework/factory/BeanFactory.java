package com.icloud.springframework.factory;



public interface BeanFactory {

    Object getBean(String name);

    Object getBean(String name, Object... args);

}
