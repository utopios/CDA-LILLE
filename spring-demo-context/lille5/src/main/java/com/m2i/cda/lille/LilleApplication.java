package com.m2i.cda.lille;

import com.m2i.cda.lille.controller.EmployeeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class LilleApplication {

    public static void main(String[] args) {

        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeController employeeController = context.getBean(EmployeeController.class);
        employeeController.getAllEmployee2().stream().forEach(System.out::println);


    }

}
