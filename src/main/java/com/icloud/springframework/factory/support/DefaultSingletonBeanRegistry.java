package com.icloud.springframework.factory.support;

import com.icloud.springframework.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String,Object> singletonBeanMap = new ConcurrentHashMap<>();

    @Override
    public Object getSingleBean(String beanName) {
        return singletonBeanMap.get(beanName);
    }

    protected void registerSingleBean(String beanName,Object singleBean) {
        singletonBeanMap.put(beanName,singleBean);
    }
}
