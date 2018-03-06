package com.animals;

import java.time.LocalDateTime;

public class Animal {
    private String name;
    private Gender gender;
    private Reservor reservedBy;

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Reservor getReservedBy() {
        return reservedBy;
    }

    public Animal(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public boolean reserve(String reservedBy){
        if (this.reservedBy == null)
        {
            this.reservedBy = new Reservor(reservedBy, LocalDateTime.now());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String reserved = "not reserved";

        if(this.reservedBy != null){
            reserved = "reserved by " + this.reservedBy.getName();
        }
        return String.format("%s, $s, $s", this.name, this.gender, reserved);
    }
}
