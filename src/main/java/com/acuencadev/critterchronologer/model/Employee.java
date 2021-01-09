package com.acuencadev.critterchronologer.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.time.DayOfWeek;
import java.util.Set;

@Entity
public class Employee extends Person {

    @ElementCollection
    private Set<EmployeeSkill> skills;

    @ElementCollection
    private Set<DayOfWeek> daysAvailable;

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public Set<DayOfWeek> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }
}
