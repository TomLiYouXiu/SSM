package com.liyouxiu.spring.service.impl;

import com.liyouxiu.spring.dao.UserDao;
import com.liyouxiu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author liyouxiu
 * @date 2022/9/30 21:14
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
