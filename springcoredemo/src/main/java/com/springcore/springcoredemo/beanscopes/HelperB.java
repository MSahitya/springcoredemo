package com.springcore.springcoredemo.beanscopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Scope("prototype")
@Component
public class HelperB {

    private final String creationTimestamp;

    public HelperB() {
        // Store creation time to easily identify the instance
        this.creationTimestamp = LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("--> HelperB instance created at: " + creationTimestamp + " (Hash: " + this.hashCode() + ")");
    }

    public void doWork() {
        System.out.println("   HelperB (created at " + creationTimestamp + ", Hash: " + this.hashCode() + ") is doing work.");
    }
}
