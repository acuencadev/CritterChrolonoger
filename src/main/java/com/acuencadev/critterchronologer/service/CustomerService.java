package com.acuencadev.critterchronologer.service;

import com.acuencadev.critterchronologer.model.Customer;
import com.acuencadev.critterchronologer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getOne(Long id) {
        return customerRepository.getOne(id);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
