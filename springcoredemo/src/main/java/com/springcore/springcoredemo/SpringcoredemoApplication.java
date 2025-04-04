package com.springcore.springcoredemo;

import com.springcore.springcoredemo.controller.EmployeeController;
import com.springcore.springcoredemo.daos.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication//@ComponentScan+@Configuration
public class SpringcoredemoApplication {

	EmployeeController employeeController;

	@Autowired
	SpringcoredemoApplication(EmployeeController employeeController){
		employeeController=employeeController;
	}

	public static void main(String[] args) {
		//To access Application context:If you have access to the Spring application's run method:
		ApplicationContext context = SpringApplication.run(SpringcoredemoApplication.class, args);
		Employee employee = context.getBean(Employee.class);
		System.out.println("EmployeeNmae is="+employee.getName());

		//What are the different ways what we can access Application Context?
		//Two primary ways
		//1. From SpringApplication.run():
		//2. Using @Autowired within a Spring-managed component:



	}

}
