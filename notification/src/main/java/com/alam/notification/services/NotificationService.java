package com.alam.notification.services;

import com.alam.clients.notification.entity.NotificationRequest;
import com.alam.notification.entity.Notification;
import com.alam.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    public void send(NotificationRequest notificationRequest) {

        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .sender("Alam")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
