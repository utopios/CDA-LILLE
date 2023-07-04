package com.example.demorest.controller;


import com.example.demorest.dto.EmployeeDto;
import com.example.demorest.dto.EmployeeDtoToEmployee;
import com.example.demorest.dto.EmployeeToEmployeDto;
import com.example.demorest.entity.Employee;
import com.example.demorest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeeDto(){
       List <EmployeeDto> employeeDtos = new ArrayList<>();
       for (Employee employee : employeeService.findAll()){
           employeeDtos.add(employeeToEmployeDto.convert(employee));
       }
       return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmploye(@PathVariable Integer id){
        Optional<Employee> employee = employeeService.findById(id);
        if(employee.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<EmployeeDto>(employeeToEmployeDto.convert(employee.get()), HttpStatus.OK);

    }


    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Integer id){
        employeeDto.setId(id);
        Employee employee =  employeeService.save(employeeDtoToEmployee.convert(employeeDto));

        return new ResponseEntity<>(employeeToEmployeDto.convert(employee),HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployeeById(@PathVariable Integer id) {
        try {
            employeeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }
}
