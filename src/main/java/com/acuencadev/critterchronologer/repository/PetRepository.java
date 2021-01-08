package com.acuencadev.critterchronologer.repository;

import com.acuencadev.critterchronologer.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findPetsByCustomerId(Long customerId);
}
