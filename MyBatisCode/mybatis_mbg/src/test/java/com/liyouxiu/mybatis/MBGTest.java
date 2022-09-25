package com.liyouxiu.mybatis;

import com.liyouxiu.mybatis.mapper.EmpMapper;
import com.liyouxiu.mybatis.pojo.Emp;
import com.liyouxiu.mybatis.pojo.EmpExample;
import com.liyouxiu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author liyouxiu
 * @date 2022/9/25 23:25
 */
public class MBGTest {
    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        根据ID查询数据
//        Emp emp = mapper.selectByPrimaryKey(1);
//        System.out.println(emp);
//        查询所有数据
//        List<Emp> emps = mapper.selectByExample(null);
//        emps.forEach(System.out::println);
        EmpExample empExample =new EmpExample();
        empExample.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThan(20);
        List<Emp> emps = mapper.selectByExample(empExample);
        emps.forEach(System.out::println);

    }
}
