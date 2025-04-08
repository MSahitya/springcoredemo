package com.springcore.springcoredemo.beanscopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceA {

    @Autowired
    public HelperB helperB;
    public ServiceA() {
        System.out.println("ServiceA Singleton instance created.");
    }

    public void useHelperMultipleTimes() {
        System.out.println("\nCalling useHelperMultipleTimes() on ServiceA instance: " + this.hashCode());
        System.out.println("First call to helperB:");
        helperB.doWork();

        System.out.println("\nSecond call to helperB:");
        helperB.doWork();

        System.out.println("\nThird call to helperB:");
        helperB.doWork();
        System.out.println("--- Finished useHelperMultipleTimes() ---");
    }

    public HelperB getInjectedHelper() {
        return helperB;
    }
}
