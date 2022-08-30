package com.alam.notification.controller;

import com.alam.clients.notification.entity.NotificationRequest;
import com.alam.notification.services.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("new notification {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
