package com.animals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dog extends Animal {
    private LocalDate LastWalk;

    public LocalDate getLastWalk() {
        return LastWalk;
    }

    public boolean NeedsWalk(){
        return LocalDate.now().compareTo(LastWalk) != 0;
    }

    public Dog(String name, Gender gender) {
        super(name, gender);
        LastWalk = LocalDate.now();
    }

    @Override
    public String toString() {
        return super.toString() + ", last walk: " + LastWalk.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
    }
}
