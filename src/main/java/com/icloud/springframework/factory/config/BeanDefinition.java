package com.icloud.springframework.factory.config;

import com.icloud.springframework.PropertyValue;
import com.icloud.springframework.PropertyValues;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;


    public BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass,PropertyValues propertyValues){
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public Class getBean(){
        return this.beanClass;
    }
}
