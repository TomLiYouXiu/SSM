package com.liyouxiu.mapper;

import com.liyouxiu.pojo.Employee;

import java.util.List;

/**
 * @author liyouxiu
 * @date 2022/10/12 17:57
 */
public interface EmployeeMapper {
    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployees();
}
