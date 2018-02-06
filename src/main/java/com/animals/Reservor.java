package com.animals;

import java.time.*;

public class Reservor {
    private String name;
    private LocalDateTime reservedAt;

    public String getName() {
        return name;
    }

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public Reservor(String name, LocalDateTime reservedAt) {
        this.name = name;
        this.reservedAt = reservedAt;
    }
}
