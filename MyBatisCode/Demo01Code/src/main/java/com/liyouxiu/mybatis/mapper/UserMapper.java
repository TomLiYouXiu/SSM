package com.liyouxiu.mybatis.mapper;

import com.liyouxiu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /*
    * 添加用户信息
    * */
    int insertUser();

    /*
    * 修改用户信息
    * */
    void testUpdate();

    /*
    * 删除用户信息
    * */
    void deleteUser();

    /*
    * 根据ID查询用户信息
    * */
    User getUserById();

    /*
    * 查询所有的用户信息
    * */
    List<User> getAllUsers();
}
