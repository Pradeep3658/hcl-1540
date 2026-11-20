package org.example.NotificationServices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(Appconfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.registerUser();
    }
}
