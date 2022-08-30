package com.alam.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(
        scanBasePackages = {
                "com.alam.notification",
                "com.alam.amqp"
        }
)
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }


}
