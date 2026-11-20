package org.example.NotificationServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private NotificationService notificationService;

    public void registerUser() {
        System.out.println("User registered successfully!");
        notificationService.sendNotification();
    }
}
