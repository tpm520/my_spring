package com.icloud.springframework;

import com.icloud.springframework.factory.config.BeanDefinition;
import com.icloud.springframework.factory.config.BeanReference;
import com.icloud.springframework.factory.support.DefaultListableBeanFactory;
import com.icloud.springframework.service.UserDao;
import com.icloud.springframework.service.UserService;
import org.junit.Test;

public class BeanTest {

    @Test
    public void beanFactoryTest(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUser("测试");
    }


    @Test
    public void beanPropertyValueTest(){
        BeanDefinition beanDefinition = new BeanDefinition(UserDao.class);

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("userDao",beanDefinition);

        PropertyValues propertyValues = new PropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("account","123456"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        BeanDefinition userServiceBeanDefinition = new BeanDefinition(UserService.class,propertyValues);
        defaultListableBeanFactory.registerBeanDefinition("userService",userServiceBeanDefinition);

        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");
        userService.queryUser("1");

    }

}
