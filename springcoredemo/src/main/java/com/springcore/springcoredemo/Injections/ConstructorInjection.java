package com.springcore.springcoredemo.Injections;

import org.springframework.stereotype.Component;

public class ConstructorInjection {
}


// Interface for the dependency
  interface MessageService {
    void sendMessage(String message);
}

// Concrete implementation of the dependency
@Component // Mark this as a Spring bean
class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Email: " + message);
    }
}

// The dependent class using Constructor Injection
@Component // Mark this as a Spring bean
class NotificationService {

    // Dependency field - can be made 'final' for immutability
    private final MessageService messageService;

    // Constructor where Spring injects the dependency
    // @Autowired // Optional in Spring if only one constructor
    public NotificationService(MessageService messageService) {
        System.out.println("NotificationService Constructor: Injecting MessageService");
        // Check for null is good practice, though Spring usually guarantees injection
        if (messageService == null) {
            throw new IllegalArgumentException("MessageService cannot be null");
        }
        this.messageService = messageService; // Assign the injected dependency
    }

    public void sendNotification(String notification) {
        // Use the injected dependency
        messageService.sendMessage("Notification: " + notification);
    }
}

// --- Spring Configuration (Conceptual) ---
// Spring scans for @Component, finds EmailService and NotificationService.
// When creating NotificationService, it sees the constructor needs a MessageService.
// It finds the EmailService bean (which implements MessageService) and passes it to the constructor.