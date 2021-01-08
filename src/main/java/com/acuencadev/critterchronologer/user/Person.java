package com.acuencadev.critterchronologer.user;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@MappedSuperclass
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
