package com.liyouxiu.spring.impl;

import com.liyouxiu.spring.dao.UserDao;
import com.liyouxiu.spring.service.UserService;

/**
 * @author liyouxiu
 * @date 2022/9/30 14:59
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
