package com.animals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dog extends Animal {
    private LocalDateTime lastWalk;

    public boolean NeedsWalk(){
        return LocalDateTime.now().compareTo(lastWalk) != 0;
    }

    public Dog(String name, Gender gender) {
        super(name, gender);
        lastWalk = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return super.toString() + ", last walk: " + lastWalk.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
    }
}
