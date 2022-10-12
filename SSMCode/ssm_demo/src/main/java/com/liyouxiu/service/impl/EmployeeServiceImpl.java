package com.liyouxiu.service.impl;

import com.liyouxiu.mapper.EmployeeMapper;
import com.liyouxiu.pojo.Employee;
import com.liyouxiu.service.EmployeeService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liyouxiu
 * @date 2022/10/12 17:31
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeMapper.getAllEmployees();
    }
}
