package com.icloud.springframework.factory.support;

import com.icloud.springframework.exception.BeanException;
import com.icloud.springframework.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException {
        Object bean = null;
        try {
            bean = beanDefinition.getBean().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeanException("Instantiation of bean failed");
        }
        registerSingleBean(beanName,bean);
        return bean;
    }
}
