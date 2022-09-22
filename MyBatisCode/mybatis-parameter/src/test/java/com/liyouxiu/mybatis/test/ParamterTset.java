package com.liyouxiu.mybatis.test;

import com.liyouxiu.mybatis.mapper.UserMapper;
import com.liyouxiu.mybatis.pojo.User;
import com.liyouxiu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParamterTset {
    @Test
    public void TestGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.GetUserByUsername("root");
        System.out.println(user);
    }
    @Test
    public void TestcheckLogin(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("root","123456");
        System.out.println(user);
    }

    @Test
    public void TestcheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","root");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void TestinsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=new User(null,"liyouxiu","admin",22,"男","123456@qq.com");
        mapper.insertUser(user);

    }

    @Test
    public void TestcheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("liyouxiu", "admin");
        System.out.println(user);

    }

    @Test
    public void TestinsertUserdemo(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("请输入用户信息");
        User user=new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户姓名:");
        user.setUsername(sc.nextLine());
        System.out.println("请输入密码:");
        user.setPassword(sc.nextLine());
        System.out.println("请输入用户年龄:");
        user.setAge(Integer.valueOf(sc.nextLine()));
        System.out.println("请输入用户性别:");
        user.setGender(sc.nextLine());
        System.out.println("请输入用户邮箱:");
        user.setEmail(sc.nextLine());
        mapper.insertUserdemo(user);

    }

    @Test
    public void TestgetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入ID");
        User user = mapper.getUserById(sc.nextInt());
        System.out.println(user);
    }

}
