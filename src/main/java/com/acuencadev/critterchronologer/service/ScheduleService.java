package com.acuencadev.critterchronologer.service;

import com.acuencadev.critterchronologer.model.Schedule;
import com.acuencadev.critterchronologer.repository.CustomerRepository;
import com.acuencadev.critterchronologer.repository.EmployeeRepository;
import com.acuencadev.critterchronologer.repository.PetRepository;
import com.acuencadev.critterchronologer.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final PetRepository petRepository;
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(CustomerRepository customerRepository, EmployeeRepository employeeRepository,
                           PetRepository petRepository, ScheduleRepository scheduleRepository) {
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.petRepository = petRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }
}
