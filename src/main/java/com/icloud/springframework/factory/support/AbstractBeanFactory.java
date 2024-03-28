package com.icloud.springframework.factory.support;

import com.icloud.springframework.exception.BeanException;
import com.icloud.springframework.factory.BeanFactory;
import com.icloud.springframework.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        Object singleBean = getSingleBean(name);
        if (singleBean != null) {
            return singleBean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition) throws BeanException;
}
