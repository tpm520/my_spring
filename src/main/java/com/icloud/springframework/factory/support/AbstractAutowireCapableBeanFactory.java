package com.icloud.springframework.factory.support;

import com.icloud.springframework.exception.BeanException;
import com.icloud.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeanException {
        Object bean = null;
        try {
            bean = crateBeanInstance(beanName,beanDefinition,args);
        } catch (Exception e) {
            throw new BeanException("Instantiation of bean failed",e);
        }
        registerSingleBean(beanName,bean);
        return bean;
    }

    public Object crateBeanInstance(String beanName, BeanDefinition beanDefinition,Object[] args){
        Class beanClass = beanDefinition.getBean();
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        Constructor constructor = null;
        for (Constructor declaredConstructor : declaredConstructors) {
            if (args != null && declaredConstructor.getParameterTypes().length == args.length) {
                constructor = declaredConstructor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition,beanName,constructor,args);
    }
}
