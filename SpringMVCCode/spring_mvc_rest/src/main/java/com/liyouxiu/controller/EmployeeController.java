package com.liyouxiu.controller;

import com.liyouxiu.dao.EmployeeDao;
import com.liyouxiu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author liyouxiu
 * @date 2022/10/11 12:33
 *
 * 查询所有的员工信息---》employee----》get
 * 跳转到添加页面---》to/add----》get
 * 新增员工信息---》employee----》post
 * 跳转到修改页面---》employee/id----》get
 * 修改员工信息---》employee----》put
 * 删除员工信息---》employee/id----》delete
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    //查询所有员工信息
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployees(Model model){
        //获取所有的员工信息
        Collection<Employee> allEmployee = employeeDao.getAll();
        //将所有的员工信息在请求域中共享
        model.addAttribute("allEmployee",allEmployee);
        //跳转页面列表
        return "employee_list";
    }

    //添加员工信息
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        //保存员工信息
        employeeDao.save(employee);
        //访问列表功能,采用重定向
        // /employee
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        //根据ID查询员工信息
        Employee employee = employeeDao.get(id);
        //将员工信息共享到请求域
        model.addAttribute("employee",employee);
        //跳转employee_update.html
        return "employee_update";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String upDateEmployee(Employee employee){
        //保存员工信息
        employeeDao.save(employee);
        //访问列表功能,采用重定向
        // /employee
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }
}
