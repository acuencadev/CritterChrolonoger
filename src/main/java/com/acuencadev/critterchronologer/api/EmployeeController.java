package com.acuencadev.critterchronologer.api;

import com.acuencadev.critterchronologer.dto.EmployeeDTO;
import com.acuencadev.critterchronologer.dto.EmployeeRequestDTO;
import com.acuencadev.critterchronologer.model.Employee;
import com.acuencadev.critterchronologer.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user/employee")
public class EmployeeController
{

    private final ModelMapper modelMapper;
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(ModelMapper modelMapper, EmployeeService employeeService) {
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = dtoToEntity(employeeDTO);

        return entityToDto(employeeService.save(employee));
    }

    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        Employee employee = employeeService.getOne(employeeId);

        return entityToDto(employee);
    }

    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        throw new UnsupportedOperationException();
    }

    private Employee dtoToEntity(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }

    private EmployeeDTO entityToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }
}
