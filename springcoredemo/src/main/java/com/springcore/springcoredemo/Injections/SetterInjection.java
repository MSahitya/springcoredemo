package com.springcore.springcoredemo.Injections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class SetterInjection {
}
// Interface and Implementation (EmailService) remain the same as above...

// The dependent class using Setter Injection
@Component // Mark this as a Spring bean
  class NotificationService1 {

    // Dependency field - cannot be final
    private MessageService messageService;

    // A public no-argument constructor is required (often implicit)
      NotificationService1() {
        System.out.println("NotificationService Default Constructor");
    }

    // Public setter method where Spring injects the dependency
    @Autowired
    public void setMessageService(MessageService messageService) {
        System.out.println("NotificationService Setter: Injecting MessageService");
        this.messageService = messageService; // Assign the injected dependency
    }

    public void sendNotification(String notification) {
        // Use the injected dependency
        // Need to be careful - messageService could potentially be null if injection failed
        // or if it was optional and not provided.
        if (messageService != null) {
            messageService.sendMessage("Notification: " + notification);
        } else {
            System.out.println("Warning: MessageService not available.");
        }
    }
}

// --- Spring Configuration (Conceptual) ---
// Spring scans for @Component, finds EmailService and NotificationService.
// When creating NotificationService, it calls the default constructor first.
// Then, it sees the @Autowired setter method, finds the EmailService bean,
// and calls setMessageService() with the EmailService instance.