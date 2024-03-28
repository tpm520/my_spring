package com.icloud.springframework.factory.support;

import com.icloud.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor,Object[] args);

}
