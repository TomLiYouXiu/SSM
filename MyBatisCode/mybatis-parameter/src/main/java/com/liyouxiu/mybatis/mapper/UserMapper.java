package com.liyouxiu.mybatis.mapper;

import com.liyouxiu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/*
*Mybatis获取参数值的两种方式#{}和${}
* #{}的本质是占位符赋值   ${}的本质是字符串拼接
* 1.若mapper接口方法的参数为单个的字面量类型
* 此时可以通过#{}和${}任意内容获取参数，一定要注意${}的单引号问题
*
* */
public interface UserMapper {
    /*
    * 根据用户名查询用户信息
    * */
    User GetUserByUsername(String username);

    /*
     * 验证登录
     * */
    User checkLogin(String username, String password);

    /*
     * 以map集合验证登录
     * */
    User checkLoginByMap(Map<String,Object> map);

    /*
    添加用户信息
    */
    void insertUser(User user);

    /*
    验证登录使用@Param注解可以给
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

}
