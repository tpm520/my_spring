package com.icloud.springframework;

import com.icloud.springframework.factory.config.BeanDefinition;
import com.icloud.springframework.factory.support.DefaultListableBeanFactory;
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

}
