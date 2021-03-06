package com.bramkempen;

import com.animals.Animal;
import com.animals.Cat;
import com.animals.Dog;
import com.animals.Gender;
import com.sun.javafx.UnmodifiableArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Reservation {

    private ArrayList<Animal> animals = new ArrayList<>();

    public List<Animal> getAnimals(){
        return Collections.unmodifiableList(animals);
    }

    public void newCat(String name, Gender gender, String badHabits){
        this.animals.add(new Cat(name, gender, badHabits));
    }

    public void newDog(String name, Gender gender){
        this.animals.add(new Dog(name,gender));
    }
}
