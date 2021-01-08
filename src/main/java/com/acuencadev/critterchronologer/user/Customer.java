package com.acuencadev.critterchronologer.user;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class Customer extends Person {

    public Customer() {
    }

    public Customer(String name, String phoneNumber, String notes) {
        setName(name);
        this.phoneNumber = phoneNumber;
        this.notes = notes;
    }

    private String phoneNumber;

    private String notes;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
