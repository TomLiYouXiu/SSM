package com.liyouxiu.mybatis.test;

import com.liyouxiu.mybatis.mapper.UserMapper;
import com.liyouxiu.mybatis.pojo.User;
import com.liyouxiu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyBatisTest {
//    @Test
//    public void testInsert() throws IOException {
//        //获取核心配置文件的输入流
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//        //获取SqlSessionFactoryBuilder对象
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder =new SqlSessionFactoryBuilder();
//        //获取SqlSessionFactory对象
//        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(is);
//        //获取sql的会话对象SqlSession，不会自动提交事务,是Mybatis提供的操作数据库对象
//        //SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        //获取sql的会话对象SqlSession，自动提交事务，是Mybatis提供的操作数据库对象
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        //获取UserMapper的代理实现对象
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        //提供sql以及唯一标识找到sql并执行，唯一标识是  namespace.sqlid
//        int insert = sqlSession.insert("com.liyouxiu.mybatis.mapper.UserMapper.insertUser");
//        //调用mapper接口中的方法，实现添加用户信息的功能
//        int i = mapper.insertUser();
//        System.out.println("结果"+i);
//        //提交事务
//        //sqlSession.commit();
//
//        //关闭 sqlSession
//        sqlSession.close();
//    }


    @Test
    public void testUpdate(){
        SqlSession sqlSession= SqlSessionUtil.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.testUpdate();
        sqlSession.close();
    }
    @Test
    public void testDelete(){
        SqlSession sqlSession= SqlSessionUtil.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }
    @Test
    public void testGetUserById(){
        SqlSession sqlSession= SqlSessionUtil.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=mapper.getUserById();
        System.out.println(user);
    }
    @Test
    public void testGetAllUserById(){
        SqlSession sqlSession= SqlSessionUtil.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user=mapper.getAllUsers();
        user.forEach(System.out::println);
    }
}
