package com.m2i.cda.lille.service.impl;

import com.m2i.cda.lille.entity.Employee;
import com.m2i.cda.lille.service.EmployeeService;

import java.util.Arrays;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> getAllEmployee() {
        Employee  employee = new Employee(1L, "Michel", 21457d, true);
        Employee  employee1 = new Employee(2L, "Jean-Pierre", 20457d, false);
        Employee  employee2 = new Employee(3L, "Louis", 25874d, true);
        List<Employee> liste = Arrays.asList(employee,employee1,employee2);

        return liste;
    }
}
