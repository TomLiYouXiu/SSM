package com.liyouxiu.mybatis.mapper;

import com.liyouxiu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author liyouxiu
 * @date 2022/9/23 15:53
 */
public interface DeptMapper {

    /**
     * 查询员工和所对应的部门信息第二步
     * 查询部门信息
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("deptId")Integer deptId);

    /**
     * 查询部门以及部门中的员工信息
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    /**
     * 通过分步查询部门以及部门中的员工信息的第一步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
