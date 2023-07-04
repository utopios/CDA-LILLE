package com.example.demorest.service.impl;

import com.example.demorest.entity.Employee;
import com.example.demorest.repository.EmployeeRepository;
import com.example.demorest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {

        return employeeRepository.save(employee);

    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);

    }
}
