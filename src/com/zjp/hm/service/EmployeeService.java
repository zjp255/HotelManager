package com.zjp.hm.service;

import com.zjp.hm.dao.EmployeeDao;
import com.zjp.hm.domain.Employee;

/**
 * @author ZhuJinPeng
 * @version 1.0
 */
public class EmployeeService {
    private EmployeeDao dao;

    public EmployeeService() {
        this.dao = new EmployeeDao();
    }


    //查询员工
    public Employee getEmployee(String empId,String pwd)
    {
        return dao.querySingle("select * from employee where empid = ? and pwd = md5(?)", Employee.class,empId,pwd);
    }

}
