package com.liyouxiu.controller;

import com.liyouxiu.pojo.Employee;
import com.liyouxiu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author liyouxiu
 * @date 2022/10/12 17:16
 *
 * 查询所有的员工信息---->/employee--->get
 * 根据id查询某个员工信息---->/employee--->get
 * 跳转到添加页面---->/to/add--->get
 * 添加员工信息---->/employee--->post
 * 修改员工信息---->/employee--->put
 * 删除员工信息---->/employee/1--->delete
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查询所有的员工信息
        List<Employee> list=employeeService.getAllEmployees();
        //将员工信息在请求域中共享
        model.addAttribute("list",list);
        //跳转到employee_List.html
        return "employee_List";
    }
}
