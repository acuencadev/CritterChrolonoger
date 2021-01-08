package com.acuencadev.critterchronologer.pet;

import com.acuencadev.critterchronologer.user.Customer;
import com.acuencadev.critterchronologer.user.CustomerRepository;
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

        if (customer != null) {
//            if (customer.getPets() == null) {
//                customer.setPets(new ArrayList<Pet>());
//            }
//
//            customer.addPet(pet);
            
            pet.setCustomer(customer);
        }

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
