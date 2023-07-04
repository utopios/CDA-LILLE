package com.example.demorest.dto;

import com.example.demorest.entity.Employee;
import com.example.demorest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Component
public class EmployeeDtoToEmployee {

    @Autowired
    EmployeeService employeeService;

    public Employee convert(EmployeeDto employeeDto) {

        Employee employee = employeeDto.getId() != null ? employeeService.findById(employeeDto.getId()).get() : new Employee();

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employee.getLastName());
        employee.setEmail(employeeDto.getEmail());

        return employee;
    }



}
