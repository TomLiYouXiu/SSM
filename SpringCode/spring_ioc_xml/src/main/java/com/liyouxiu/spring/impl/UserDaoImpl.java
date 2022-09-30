package com.liyouxiu.spring.impl;

import com.liyouxiu.spring.dao.UserDao;

/**
 * @author liyouxiu
 * @date 2022/9/30 15:07
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
