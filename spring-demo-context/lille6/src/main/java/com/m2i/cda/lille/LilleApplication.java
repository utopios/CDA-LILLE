package com.m2i.cda.lille;

import com.m2i.cda.lille.controller.EmployeeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
/*@Configuration
@ComponentScan(basePackages = {"com.m2i.cda.lille.controller","com.m2i.cda.lille.service","com.m2i.cda.lille.entity"})*/
public class LilleApplication {

    public static void main(String[] args) {

        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ApplicationContext context = new AnnotationConfigApplicationContext(LilleApplication.class);
        ApplicationContext context = SpringApplication.run(LilleApplication.class, args);
        EmployeeController employeeController = context.getBean(EmployeeController.class);
        employeeController.getAllEmployee2().stream().forEach(System.out::println);


    }

}
