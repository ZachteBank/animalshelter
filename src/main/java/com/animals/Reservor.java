package com.animals;

import java.time.*;

public class Reservor {
    private String name;
    private LocalDate reservedAt;

    public String getName() {
        return name;
    }

    public LocalDate getReservedAt() {
        return reservedAt;
    }

    public Reservor(String name, LocalDate reservedAt) {
        this.name = name;
        this.reservedAt = reservedAt;
    }
}
