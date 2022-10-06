package com.liyouxiu.spring.dao.impl;

import com.liyouxiu.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author liyouxiu
 * @date 2022/9/30 21:18
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
