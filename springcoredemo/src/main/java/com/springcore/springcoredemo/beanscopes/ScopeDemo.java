package com.springcore.springcoredemo.beanscopes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// --- Configuration and Main Class ---
@Configuration
@ComponentScan(basePackages = "com.springcore.springcoredemo.beanscopes") // Adjust package if needed
class AppConfig {}

// Assuming the classes above are in com.example.scopes package
public class ScopeDemo {
    public static void main(String[] args) {
        System.out.println("Starting Spring Container...");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Spring Container Started.\n");

        System.out.println("Requesting ServiceA bean (Singleton)...");
        ServiceA serviceA1 = context.getBean(ServiceA.class);

        // Call the method that uses the injected HelperB multiple times
        serviceA1.useHelperMultipleTimes();

        System.out.println("\nRequesting ServiceA bean again...");
        ServiceA serviceA2 = context.getBean(ServiceA.class);

        System.out.println("Is serviceA1 the same instance as serviceA2? " + (serviceA1 == serviceA2));

        System.out.println("\nChecking the HelperB instance injected into serviceA1:");
        HelperB helperInA1 = serviceA1.getInjectedHelper();
        helperInA1.doWork();

        System.out.println("\nChecking the HelperB instance injected into serviceA2 (should be the same HelperB as in serviceA1):");
        HelperB helperInA2 = serviceA2.getInjectedHelper();
        helperInA2.doWork();

        System.out.println("Is the HelperB in serviceA1 the same instance as the HelperB in serviceA2? " + (helperInA1 == helperInA2));


        System.out.println("\nRequesting HelperB directly from context (should be a NEW instance):");
        HelperB directHelper1 = context.getBean(HelperB.class);
        directHelper1.doWork();

        System.out.println("\nRequesting HelperB directly from context again (should be another NEW instance):");
        HelperB directHelper2 = context.getBean(HelperB.class);
        directHelper2.doWork();

        System.out.println("Is directHelper1 the same instance as directHelper2? " + (directHelper1 == directHelper2));
        System.out.println("Is the HelperB in serviceA1 the same instance as directHelper1? " + (helperInA1 == directHelper1));


        System.out.println("\nClosing Spring Container...");
        context.close();
        System.out.println("Spring Container Closed.");
    }
}