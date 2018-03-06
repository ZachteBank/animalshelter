package com.animals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CatTest {
    private Cat cat;

    @Before
    public void TestInitialize(){
        this.cat = new Cat("Ms. Meow", Gender.Female, "Scratches couch");
    }

    @Test
    public void TestConstructor(){
        Assert.assertEquals("Ms. Meow", this.cat.getName());
        Assert.assertEquals(Gender.Female, this.cat.getGender());
        Assert.assertNull(this.cat.getReservedBy());
        Assert.assertEquals("Scratches couch", this.cat.getBadHabits());
    }

    @Test
    public void TestReservation(){
        Assert.assertNull(this.cat.getReservedBy());
        Assert.assertTrue(this.cat.reserve("John Doe"));
        Assert.assertNotNull(this.cat.getReservedBy());
        Assert.assertEquals("John Doe", this.cat.getReservedBy().getName());
        Assert.assertFalse(this.cat.reserve("Jane Doe"));
    }

    @Test
    @Ignore("Implement this when interfaces have been explained")
    public void TestReservationTime(){
        Assert.fail();
    }
}
