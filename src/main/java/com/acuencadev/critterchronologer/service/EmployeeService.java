package com.acuencadev.critterchronologer.service;

import com.acuencadev.critterchronologer.model.Employee;
import com.acuencadev.critterchronologer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
