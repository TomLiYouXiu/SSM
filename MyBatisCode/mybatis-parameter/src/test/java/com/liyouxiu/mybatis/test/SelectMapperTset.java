package com.liyouxiu.mybatis.test;

import com.liyouxiu.mybatis.mapper.SelectMapper;
import com.liyouxiu.mybatis.pojo.User;
import com.liyouxiu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTset {
    @Test
    public void TestgetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

    }

    @Test
    public void TestgetAllUsers(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> user=mapper.getAllUsers();
        user.forEach(System.out::println);
    }

    @Test
    public void TestgetCount(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void TestgetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(1);
        System.out.println(map);
    }

    @Test
    public void TestgetAllToMap(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        /*
        [{password=123456, gender=男, id=1, age=23, email=123456@qq.com, username=root},
        {password=admin, gender=男, id=2, age=22, email=123456@qq.com, username=liyouxiu},
        {password=admin, gender=男, id=3, age=23, email=123456@qq.com, username=小明}]
         */
//        List<Map<String, Object>> list = mapper.getAllToMap();
//        System.out.println(list);

        /*
        {1={password=123456, gender=男, id=1, age=23, email=123456@qq.com, username=root},
        2={password=admin, gender=男, id=2, age=22, email=123456@qq.com, username=liyouxiu},
        3={password=admin, gender=男, id=3, age=23, email=123456@qq.com, username=小明}}
         */
        Map<String, Object> map = mapper.getAllToMap();
        System.out.println(map);
    }
}
