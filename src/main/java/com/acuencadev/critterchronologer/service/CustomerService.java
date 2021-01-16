package com.acuencadev.critterchronologer.service;

import com.acuencadev.critterchronologer.model.Customer;
import com.acuencadev.critterchronologer.repository.CustomerRepository;
import com.acuencadev.critterchronologer.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(PetRepository petRepository, CustomerRepository customerRepository) {
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getOne(Long id) {
        return customerRepository.getOne(id);
    }

    public Customer getCustomerByPetId(Long petId) {
        return petRepository.getOne(petId).getCustomer();
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
