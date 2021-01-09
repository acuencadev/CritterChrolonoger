package com.acuencadev.critterchronologer.repository;

import com.acuencadev.critterchronologer.model.Employee;
import com.acuencadev.critterchronologer.model.Pet;
import com.acuencadev.critterchronologer.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByPets(Pet pet);
    List<Schedule> findByEmployees(Employee employee);
    List<Schedule> findByPetsIn(List<Pet> pets);
}
