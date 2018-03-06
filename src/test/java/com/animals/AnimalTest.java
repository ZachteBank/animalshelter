package com.animals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class AnimalTest {
    private Animal animal;

    @Before
    public void TestInitialize(){
        this.animal = new Animal("Ugly Duckling", Gender.Male);
    }

    @Test
    public void TestConstructor(){
        Assert.assertEquals("Ugly Duckling", this.animal.getName());
        Assert.assertEquals(Gender.Male, this.animal.getGender());
        Assert.assertNull(this.animal.getReservedBy());
    }

    @Test
    public void TestReservation(){
        Assert.assertNull(this.animal.getReservedBy());
        Assert.assertTrue(this.animal.reserve("John Doe"));
        Assert.assertNotNull(this.animal.getReservedBy());
        Assert.assertEquals("John Doe", this.animal.getReservedBy().getName());
        Assert.assertFalse(this.animal.reserve("Jane Doe"));
    }

    @Test
    @Ignore ("Implement this when interfaces have been explained")
    public void TestReservationTime(){
        Assert.fail();
    }
}
