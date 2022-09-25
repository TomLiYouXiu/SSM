package com.liyouxiu.mybatis.mapper;

import com.liyouxiu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author liyouxiu
 * @date 2022/9/25 21:11
 */
public interface CacheMapper {

    /**
     * 根据员工ID查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpById(@Param("empId") Integer empId);
}
