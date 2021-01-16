package com.acuencadev.critterchronologer.service;

import com.acuencadev.critterchronologer.model.Customer;
import com.acuencadev.critterchronologer.model.Employee;
import com.acuencadev.critterchronologer.model.Pet;
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

    public List<Schedule> getPetSchedule(Long petId) {
        Pet pet = petRepository.getOne(petId);
        List<Schedule> schedules = scheduleRepository.findByPets(pet);

        return schedules;
    }

    public List<Schedule> getEmployeeSchedule(Long employeeId) {
        Employee employee = employeeRepository.getOne(employeeId);
        List<Schedule> schedules = scheduleRepository.findByEmployee(employee);

        return schedules;
    }

    public List<Schedule> getCustomerSchedule(Long customerId) {
        Customer customer = customerRepository.getOne(customerId);
        List<Schedule> schedules = scheduleRepository.findByPetsIn(customer.getPets());

        return schedules;
    }

    public Schedule save(Schedule schedule, List<Long> employeeIds, List<Long> petIds) {
        List<Pet> pets = petRepository.findAllById(petIds);
        List<Employee> employees = employeeRepository.findAllById(employeeIds);

        schedule.setPets(pets);
        schedule.setEmployees(employees);

        return scheduleRepository.save(schedule);
    }
}
