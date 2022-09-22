package com.liyouxiu.mybatis.mapper;

import com.liyouxiu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author liyouxiu
 * @date 2022/9/22 20:40
 */
public interface EmpMapper {

    /**
     * 根据ID查询员工信息
     * @param empId
     * @return Emp
     */
    Emp getEmpByEmpId(@Param("empId") Integer empId);
}
