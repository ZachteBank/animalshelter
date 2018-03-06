package com.animals;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class ReservorTest {
    @Test
    public void TestConstructor(){
        LocalDate reservedAt = LocalDate.now();
        Reservor reservor = new Reservor("John Doe", reservedAt);
        Assert.assertEquals("John Doe", reservor.getName());
        Assert.assertEquals(reservedAt, reservor.getReservedAt());
    }
}
