package com.liyouxiu.mybatis.test;

import com.liyouxiu.mybatis.mapper.SelectSQLMapper;
import com.liyouxiu.mybatis.pojo.User;
import com.liyouxiu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @author liyouxiu
 * @date 2022/9/21 21:47
 */
public class SelectSQLMapperTest {
    @Test
    public void TestgetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        SelectSQLMapper mapper = sqlSession.getMapper(SelectSQLMapper.class);
        List<User> list = mapper.getUserByLike("o");
        list.forEach(System.out::println);
    }
    public void testJDBC(){
        try {
            Class.forName("");//注册驱动
            Connection connection = DriverManager.getConnection("","","");
            String sql = "select * from t_user where like '%?%'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,"o");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestDeleteMoreUsere(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        SelectSQLMapper mapper = sqlSession.getMapper(SelectSQLMapper.class);
        mapper.DeleteMoreUsere("5,7");
    }

    @Test
    public void TestgetAllUsers(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        SelectSQLMapper mapper = sqlSession.getMapper(SelectSQLMapper.class);
        List<User> user = mapper.getAllUsers("t_user");
        user.forEach(System.out::println);
    }

    @Test
    public void TestinsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        SelectSQLMapper mapper = sqlSession.getMapper(SelectSQLMapper.class);
        User user=new User(null,"小李","121323",34,"男","12323@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }

}
