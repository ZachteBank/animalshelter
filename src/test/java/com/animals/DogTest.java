package com.animals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class DogTest {
    private Dog dog;

    @Before
    public void TestInitialize(){
        this.dog = new Dog("Sgt. Woof", Gender.Male);
    }

    @Test
    public void TestConstructor(){
        Assert.assertEquals("Sgt. Woof", this.dog.getName());
        Assert.assertEquals(Gender.Male, this.dog.getGender());
        Assert.assertNull(this.dog.getReservedBy());
        Assert.assertEquals(LocalDate.now(), this.dog.getLastWalk());
        Assert.assertFalse(this.dog.NeedsWalk());
    }

    @Test
    public void TestReservation(){
        Assert.assertNull(this.dog.getReservedBy());
        Assert.assertTrue(this.dog.reserve("John Doe"));
        Assert.assertNotNull(this.dog.getReservedBy());
        Assert.assertEquals("John Doe", this.dog.getReservedBy().getName());
        Assert.assertFalse(this.dog.reserve("Jane Doe"));
    }
}
