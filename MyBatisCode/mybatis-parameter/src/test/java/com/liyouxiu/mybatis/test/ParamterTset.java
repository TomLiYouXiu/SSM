package com.liyouxiu.mybatis.test;

import com.liyouxiu.mybatis.mapper.UserMapper;
import com.liyouxiu.mybatis.pojo.User;
import com.liyouxiu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

}
