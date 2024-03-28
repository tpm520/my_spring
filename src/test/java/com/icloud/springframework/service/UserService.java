package com.icloud.springframework.service;

public class UserService {


    private String account;

    private UserDao userDao;

    public UserService(){

    }


    public void queryUser(String id){
        System.out.println("查询用户："+userDao.findNameById(id));
        System.out.println("查询账户："+account);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
