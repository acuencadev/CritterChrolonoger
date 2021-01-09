package com.acuencadev.critterchronologer.service;

import com.acuencadev.critterchronologer.model.Customer;
import com.acuencadev.critterchronologer.model.Pet;
import com.acuencadev.critterchronologer.repository.PetRepository;
import com.acuencadev.critterchronologer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public PetService(CustomerRepository customerRepository, PetRepository petRepository) {
        this.customerRepository = customerRepository;
        this.petRepository = petRepository;
    }

    public Pet save(Pet pet, Long customerId) {
        Customer customer = customerRepository.getOne(customerId);

        pet.setCustomer(customer);

        return petRepository.save(pet);
    }

    public Pet getOne(Long id) {
        return petRepository.getOne(id);
    }

    public List<Pet> getAll() {
        return petRepository.findAll();
    }

    public List<Pet> getByCustomerId(Long customerId) {
        return petRepository.findPetsByCustomerId(customerId);
    }
}
