package com.m2i.cda.lille;

import com.m2i.cda.lille.contoller.EmployeeController;
import com.m2i.cda.lille.service.EmployeeService;
import com.m2i.cda.lille.service.impl.EmployeeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class LilleApplication {

	public static void main(String[] args) {


		// Par constructor
		System.out.println("Par constructeur");
		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
		EmployeeController employeeController = new EmployeeController(employeeServiceImpl);
		employeeController.getAllEmployee2().stream().forEach(System.out::println);

		System.out.println(" ");
		System.out.println("********");
		System.out.println(" ");

		// Par setter
		System.out.println("Par setter");
		EmployeeServiceImpl employeeServiceImpl1 = new EmployeeServiceImpl();
		EmployeeController employeeController1 = new EmployeeController();
		employeeController1.setEmployeeService(employeeServiceImpl1);
		employeeController1.getAllEmployee2().stream().forEach(System.out::println);

		System.out.println(" ");
		System.out.println("********");
		System.out.println(" ");

		// Par interface
	/*	System.out.println("Par interface");
		EmployeeService employeeService = new EmployeeServiceImpl();
		EmployeeController employeeController2 = new EmployeeController(employeeService);
		employeeController2.setEmployeeService(employeeServiceImpl1);
		employeeController2.getAllEmployee().stream().forEach(System.out::println);*/



	}

}
