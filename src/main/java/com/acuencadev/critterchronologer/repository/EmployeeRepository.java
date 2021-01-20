package com.acuencadev.critterchronologer.repository;

import com.acuencadev.critterchronologer.model.Employee;
import com.acuencadev.critterchronologer.model.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByDaysAvailable(DayOfWeek dayOfWeek);
}
