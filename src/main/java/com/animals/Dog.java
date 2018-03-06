package com.animals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dog extends Animal {
    private LocalDateTime LastWalk;

    public boolean NeedsWalk(){
        return LocalDateTime.now().compareTo(LastWalk) != 0;
    }

    public Dog(String name, Gender gender) {
        super(name, gender);
        LastWalk = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return super.toString() + ", last walk: " + LastWalk.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
    }
}
