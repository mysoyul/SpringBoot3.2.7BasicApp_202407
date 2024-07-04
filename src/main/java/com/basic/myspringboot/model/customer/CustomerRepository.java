package com.basic.myspringboot.model.customer;

import com.basic.myspringboot.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByCustomerId(String customerid);
    List<Customer> findByCustomerName(String customername);
}
