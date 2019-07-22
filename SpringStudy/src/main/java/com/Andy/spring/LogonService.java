package com.Andy.spring;


import org.springframework.beans.factory.BeanNameAware;

public class LogonService implements BeanNameAware{

    public LogonService(){}

    public LogonService(LogDao logDao, UserDao userDao) {
        this.logDao = logDao;
        this.userDao = userDao;
    }

    private LogDao logDao;

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

    public LogDao getLogDao() {
        return logDao;
    }
    public UserDao getUserDao() {
        return userDao;
    }

    public void setBeanName(String beanName) {
        System.out.println("beanName:"+beanName);
    }

    public void initMethod1(){
        System.out.println("initMethod1");
    }
    public void initMethod2(){
        System.out.println("initMethod2");
    }

}
