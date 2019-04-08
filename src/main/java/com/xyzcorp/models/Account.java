package com.xyzcorp.models;

import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

public class Account {
    private final String firstName;
    private final String lastName;
    private final LocalDate registeredDate;
    private final UUID uuid;

    public Account(String firstName, String lastName, UUID uuid, LocalDate registeredDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registeredDate = registeredDate;
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UUID getUUID() {
        return uuid;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(uuid, account.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("registeredDate=" + registeredDate)
                .add("uuid=" + uuid)
                .toString();
    }
}
