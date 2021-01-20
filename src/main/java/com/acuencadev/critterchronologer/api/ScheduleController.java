package com.acuencadev.critterchronologer.api;

import com.acuencadev.critterchronologer.dto.ScheduleDTO;
import com.acuencadev.critterchronologer.model.Employee;
import com.acuencadev.critterchronologer.model.Pet;
import com.acuencadev.critterchronologer.model.Schedule;
import com.acuencadev.critterchronologer.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        Schedule schedule = dtoToEntity(scheduleDTO);
        ScheduleDTO newScheduleDTO = entityToDto(scheduleService.save(schedule,
                scheduleDTO.getEmployeeIds(), scheduleDTO.getPetIds()));

        return newScheduleDTO;
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
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();

        List<Schedule> schedules = scheduleService.getPetSchedule(petId);
        for (Schedule schedule : schedules) {
            scheduleDTOList.add(entityToDto(schedule));
        }

        return scheduleDTOList;
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();

        List<Schedule> schedules = scheduleService.getEmployeeSchedule(employeeId);
        for (Schedule schedule : schedules) {
            scheduleDTOList.add(entityToDto(schedule));
        }

        return scheduleDTOList;
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();

        List<Schedule> schedules = scheduleService.getCustomerSchedule(customerId);
        for (Schedule schedule : schedules) {
            scheduleDTOList.add(entityToDto(schedule));
        }

        return scheduleDTOList;
    }

    private Schedule dtoToEntity(ScheduleDTO scheduleDTO) {
        Schedule schedule = modelMapper.map(scheduleDTO, Schedule.class);

        schedule.setSkills(scheduleDTO.getActivities());

        return schedule;
    }

    private ScheduleDTO entityToDto(Schedule schedule) {
        ScheduleDTO scheduleDTO = modelMapper.map(schedule, ScheduleDTO.class);

        List<Long> petIds = new ArrayList<>();
        for (Pet pet: schedule.getPets()) {
            petIds.add(pet.getId());
        }

        List<Long> employeeIds = new ArrayList<>();
        for (Employee employee: schedule.getEmployees()) {
            employeeIds.add(employee.getId());
        }

        scheduleDTO.setPetIds(petIds);
        scheduleDTO.setEmployeeIds(employeeIds);
        scheduleDTO.setActivities(schedule.getSkills());

        return scheduleDTO;
    }
}
