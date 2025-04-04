package com.springcore.springcoredemo.controller;

import com.springcore.springcoredemo.daos.Employee;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {
    Employee employee;
    EmployeeController(Employee employee){
        this.employee=employee;
        this.employee.setName("Sahitya");
    }


}
