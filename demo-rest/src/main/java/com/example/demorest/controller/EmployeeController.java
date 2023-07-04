package com.example.demorest.controller;


import com.example.demorest.dto.EmployeeDto;
import com.example.demorest.dto.EmployeeDtoToEmployee;
import com.example.demorest.dto.EmployeeToEmployeDto;
import com.example.demorest.entity.Employee;
import com.example.demorest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeDtoToEmployee employeeDtoToEmployee;

    @Autowired
    private EmployeeToEmployeDto employeeToEmployeDto;

    @PostMapping("/create_employee")
    public ResponseEntity<EmployeeDto>addEmployee(@RequestBody Employee employee){

        Employee employee1 = employeeService.save(employee);

        return new ResponseEntity<EmployeeDto>(employeeToEmployeDto.convert(employee1), HttpStatus.OK);

    }






}
