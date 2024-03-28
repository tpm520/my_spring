package com.icloud.springframework.factory.support;

import com.icloud.springframework.exception.BeanException;
import com.icloud.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) {
        Class beanClass = beanDefinition.getBean();
        try {
            if (constructor != null) {
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }else {
                return beanClass.getDeclaredConstructor().newInstance();
            }
        }catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeanException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
