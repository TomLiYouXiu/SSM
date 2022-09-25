package com.liyouxiu.mybatis;

import com.liyouxiu.mybatis.mapper.DyNamicSQLMapper;
import com.liyouxiu.mybatis.pojo.Emp;
import com.liyouxiu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author liyouxiu
 * @date 2022/9/25 11:50
 */
public class DynamicMapperTest {

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        DyNamicSQLMapper mapper=sqlSession.getMapper(DyNamicSQLMapper.class);
        Emp emp =new Emp(null,"",23,"");
        List<Emp> list = mapper.getEmpByCondition(emp);
        list.forEach(System.out::println);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        DyNamicSQLMapper mapper=sqlSession.getMapper(DyNamicSQLMapper.class);
        Emp emp =new Emp(null,"",23,"");
        List<Emp> list = mapper.getEmpByChoose(emp);
        list.forEach(System.out::println);
    }

    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        DyNamicSQLMapper mapper=sqlSession.getMapper(DyNamicSQLMapper.class);
        Emp emp1 =new Emp(null,"小李1",22,"男");
        Emp emp2 =new Emp(null,"小李2",22,"男");
        Emp emp3 =new Emp(null,"小李3",22,"男");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        mapper.insertMoreEmp(emps);


    }
    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        DyNamicSQLMapper mapper=sqlSession.getMapper(DyNamicSQLMapper.class);
        Integer[] empIds=new Integer[]{6,7};
        mapper.deleteMoreEmp(empIds);


    }


}
