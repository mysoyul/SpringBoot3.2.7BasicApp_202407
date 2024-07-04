package com.basic.myspringboot.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    @Rollback(value = false)
    public void customer() throws Exception {
        //등록
        Customer customer = new Customer();
        customer.setCustomerId("A001");
        customer.setCustomerName("스프링");
        Customer addCustomer = customerRepository.save(customer);
        System.out.println(addCustomer.getCustomerId() + " " + addCustomer.getCustomerName());
        assertThat(addCustomer).isNotNull();
        assertThat(addCustomer.getCustomerName()).isEqualTo("스프링");
        assertEquals("A001", addCustomer.getCustomerId());

        Optional<Customer> existCustomer = customerRepository.findByCustomerId(addCustomer.getCustomerId());
        assertThat(existCustomer).isNotEmpty();

        Optional<Customer> notExistOptional = customerRepository.findByCustomerId("B001");
        assertThat(notExistOptional).isEmpty();
    }
}