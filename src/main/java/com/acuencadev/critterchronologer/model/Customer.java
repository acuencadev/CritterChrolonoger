package com.acuencadev.critterchronologer.model;

import com.acuencadev.critterchronologer.pet.Pet;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table
@Entity
public class Customer extends Person {

    private String phoneNumber;

    private String notes;

    @OneToMany(targetEntity = Pet.class)
    private List<Pet> pets;

    public Customer() {
    }

    public Customer(String name, String phoneNumber, String notes) {
        setName(name);
        this.phoneNumber = phoneNumber;
        this.notes = notes;
    }

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

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }
}
