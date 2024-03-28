package com.icloud.springframework.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.icloud.springframework.PropertyValue;
import com.icloud.springframework.PropertyValues;
import com.icloud.springframework.exception.BeanException;
import com.icloud.springframework.factory.config.BeanDefinition;
import com.icloud.springframework.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.util.List;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new SimpleInstiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeanException {
        Object bean = null;
        try {
            bean = crateBeanInstance(beanName,beanDefinition,args);
            applyBeanPropertyValues(beanName,bean,beanDefinition);
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
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructor,args);
    }


    public void applyBeanPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition){
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getBeanName());
            }
            BeanUtil.setFieldValue(bean,name,value);
        }
    }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
