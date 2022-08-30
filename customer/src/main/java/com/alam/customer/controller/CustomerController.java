package com.alam.customer.controller;

import com.alam.customer.entity.Customer;
import com.alam.customer.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alam.customer.dto.CustomerRegistrationRequest;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("new customer registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }

    @GetMapping("/list")
    public ResponseEntity<?> customerList() {
        List<Customer> customer =  customerService.customerList();
        log.info("get all customer data");
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
