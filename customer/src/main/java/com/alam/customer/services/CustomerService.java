package com.alam.customer.services;

import com.alam.amqp.RabbitMQMessageProducer;
import com.alam.clients.fraud.FraudClient;
import com.alam.clients.fraud.entity.FraudCheckResponse;
import com.alam.clients.notification.NotificationClient;
import com.alam.clients.notification.entity.NotificationRequest;
import com.alam.customer.dto.CustomerRegistrationRequest;
import com.alam.customer.entity.Customer;
import com.alam.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalArgumentException();
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome...",
                        customer.getFirstName())
        );

        rabbitMQMessageProducer.publish(
                "internal.exchange",
                "internal.notification.routing-key",
                notificationRequest
        );

    }
    public List<Customer> customerList() {
        return customerRepository.findAll();
    }
}
