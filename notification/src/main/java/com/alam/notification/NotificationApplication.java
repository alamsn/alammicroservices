package com.alam.notification;

import com.alam.amqp.RabbitMQMessageProducer;
import com.alam.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.alam.notification",
                "com.alam.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            RabbitMQMessageProducer producer,
            NotificationConfig notificationConfig
            ) {
        return args -> {
            producer.publish(
                    notificationConfig.getInternalExchange(),
                    notificationConfig.getInternalNotificationRoutingKey(),
                    new Person("Ali", 18));
        };
    }
    record Person(String name, int age){}

}
