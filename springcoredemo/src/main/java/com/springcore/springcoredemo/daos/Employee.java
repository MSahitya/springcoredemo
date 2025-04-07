package com.springcore.springcoredemo.daos;

import com.springcore.springcoredemo.SpringcoredemoApplication;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Employee {

   // @Autowired
   // private ApplicationContext context;
    private String name;
    private int id;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private Employee(){
        super();
    }
    public static Employee createInstance(){
        return new Employee();
    }
}
