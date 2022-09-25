package com.liyouxiu.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyouxiu.mybatis.mapper.EmpMapper;
import com.liyouxiu.mybatis.pojo.Emp;
import com.liyouxiu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author liyouxiu
 * @date 2022/9/25 23:48
 */
public class PageTest {
    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        查询功能之前开启分页功能
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Emp> emps = mapper.selectByExample(null);
//          查询功能之后可以获取分页相关的所有数据
        PageInfo<Emp> pageInfo=new PageInfo<>(emps,5);
        emps.forEach(System.out::println);
        System.out.println(pageInfo);
    }
}
