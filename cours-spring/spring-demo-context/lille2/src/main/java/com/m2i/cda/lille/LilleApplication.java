package com.m2i.cda.lille;

import com.m2i.cda.lille.contoller.EmployeeController;
import com.m2i.cda.lille.service.EmployeeService;
import com.m2i.cda.lille.service.impl.EmployeeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class LilleApplication {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeController employeeController = context.getBean(EmployeeController.class);
        employeeController.getAllEmployee2().stream().forEach(System.out::println);


    }

}
