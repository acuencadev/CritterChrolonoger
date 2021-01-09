package com.acuencadev.critterchronologer.service;

import com.acuencadev.critterchronologer.model.Employee;
import com.acuencadev.critterchronologer.model.EmployeeSkill;
import com.acuencadev.critterchronologer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getOne(Long id) {
        return employeeRepository.getOne(id);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> getAllByService(LocalDate date, Set<EmployeeSkill> skills) {
        return employeeRepository.findAllByDaysAvailableAndSkillsIn(date.getDayOfWeek(), skills);
    }

    public void setAvailability(Set<DayOfWeek> days, Long id) {
        Employee employee = employeeRepository.getOne(id);

        employee.setDaysAvailable(days);
        employeeRepository.save(employee);
    }
}
