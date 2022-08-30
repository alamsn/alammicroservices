package com.alam.customer.repository;

import com.alam.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
