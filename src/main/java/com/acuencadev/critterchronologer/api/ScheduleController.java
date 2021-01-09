package com.acuencadev.critterchronologer.api;

import com.acuencadev.critterchronologer.dto.CustomerDTO;
import com.acuencadev.critterchronologer.dto.ScheduleDTO;
import com.acuencadev.critterchronologer.model.Customer;
import com.acuencadev.critterchronologer.model.Pet;
import com.acuencadev.critterchronologer.model.Schedule;
import com.acuencadev.critterchronologer.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ModelMapper modelMapper;
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ModelMapper modelMapper, ScheduleService scheduleService) {
        this.modelMapper = modelMapper;
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        throw new UnsupportedOperationException();
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();

        List<Schedule> schedules = scheduleService.getAll();
        for (Schedule schedule : schedules) {
            scheduleDTOList.add(entityToDto(schedule));
        }

        return scheduleDTOList;
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        throw new UnsupportedOperationException();
    }

    private Schedule dtoToEntity(ScheduleDTO scheduleDTO) {
        Schedule schedule = modelMapper.map(scheduleDTO, Schedule.class);

        return schedule;
    }

    private ScheduleDTO entityToDto(Schedule schedule) {
        ScheduleDTO scheduleDTO = modelMapper.map(schedule, ScheduleDTO.class);

        return scheduleDTO;
    }
}
