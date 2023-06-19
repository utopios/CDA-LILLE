package com.m2i.cda.lille.contoller;

import com.m2i.cda.lille.entity.Employee;
import com.m2i.cda.lille.service.EmployeeService;
import com.m2i.cda.lille.service.impl.EmployeeServiceImpl;

import java.util.List;

public class EmployeeController {


    private EmployeeServiceImpl _employeeServiceImpl;

    // Injection par setter
    public void setEmployeeService(EmployeeServiceImpl employeeServiceImpl){
        this._employeeServiceImpl = employeeServiceImpl;
    }

    public EmployeeController() {
    }

    public List<Employee> getAllEmployee2(){

        return _employeeServiceImpl.getAllEmployee();
    }






}
