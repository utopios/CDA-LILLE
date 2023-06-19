package com.m2i.cda.lille.contoller;

import com.m2i.cda.lille.entity.Employee;
import com.m2i.cda.lille.service.EmployeeService;
import com.m2i.cda.lille.service.impl.EmployeeServiceImpl;

import java.util.List;

public class EmployeeController {

    private EmployeeService _employeeService;
    private EmployeeServiceImpl _employeeServiceImpl;

    // Injection par setter
    public void setEmployeeService(EmployeeServiceImpl employeeServiceImpl){
        this._employeeServiceImpl = employeeServiceImpl;
    }

    // Injection par constructeur
    public EmployeeController(EmployeeServiceImpl employeeServiceImpl){
        this._employeeServiceImpl = employeeServiceImpl;
    }

    // Injection par Interface (constructeur)
    public EmployeeController(EmployeeService employeeService){
        this._employeeService = employeeService;
    }

    public EmployeeController() {
    }

   /* public List<Employee> getAllEmployee(){
        return _employeeService.getAllEmployee();
    }*/

    public List<Employee> getAllEmployee2(){

        return _employeeServiceImpl.getAllEmployee();
    }






}
