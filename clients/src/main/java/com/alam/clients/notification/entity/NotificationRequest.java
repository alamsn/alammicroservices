package com.alam.clients.notification.entity;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerEmail,
        String message
) {
}