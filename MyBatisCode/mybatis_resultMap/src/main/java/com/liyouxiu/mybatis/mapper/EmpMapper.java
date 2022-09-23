package com.liyouxiu.mybatis.mapper;

import com.liyouxiu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 获取员工信息和部门
     * @param empId
     * @return Emp
     */
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    /**
     * 查询员工和所对应的部门信息第一步
     * 查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

    /**
     * 通过分步查询部门以及部门中的员工信息的第二步
     * @param deptId
     * @return
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);
}
