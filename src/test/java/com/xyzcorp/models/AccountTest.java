package com.xyzcorp.models;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private Account sam = null;
    private Account samCopy = null;
    private Account jane = null;
    private UUID samUUID = null;
    private UUID janeUUID = null;
    private LocalDate samRegisteredDate = LocalDate.of(2018, 1, 10);
    private LocalDate janeRegisteredDate = LocalDate.of(2018, 12, 25);

    @Before
    public void setUp() {
        samUUID = UUID.fromString("66554b91-b00d-403d-a6fe-0679e0ff0925");
        janeUUID = UUID.fromString("17d7e685-d3fb-497c-8425-1adcaf3744b5");

        sam =  new Account("Sam", "Rogers", samUUID, samRegisteredDate);
        samCopy =  new Account("Sam", "Rogers", samUUID, samRegisteredDate);
        jane =  new Account("Jane", "Loggins", janeUUID, janeRegisteredDate);
    }

    @Test
    public void testFirstName() {
        assertThat(sam.getFirstName()).isEqualTo("Sam");
    }

    @Test
    public void testFirstNameWithDifferentPerson() {
        assertThat(jane.getFirstName()).isEqualTo("Jane");
    }

    @Test
    public void testLastName() {
        assertThat(sam.getLastName()).isEqualTo("Rogers");
    }

    @Test
    public void testLastNameWithDifferentPerson() {
        assertThat(jane.getLastName()).isEqualTo("Loggins");
    }

    @Test
    public void testGetUUID() {
        assertThat(sam.getUUID()).isEqualTo(samUUID);
    }

    @Test
    public void testGetUUIDWithDifferentPerson() {
        assertThat(jane.getUUID()).isEqualTo(janeUUID);
    }

    @Test
    public void testGetRegisteredDate() {
        assertThat(sam.getRegisteredDate()).isEqualTo(samRegisteredDate);
    }

    @Test
    public void testGetRegisteredDateWithDifferentPerson() {
        assertThat(jane.getRegisteredDate()).isEqualTo(janeRegisteredDate);
    }

    @Test
    public void testEquality() {
        assertThat(sam).isEqualTo(samCopy);
    }

    @Test
    public void testNonEquality() {
        assertThat(sam).isNotEqualTo(jane);
    }

    @Test
    public void testHashCode() {
        assertThat(sam.hashCode()).isEqualTo(samCopy.hashCode());
    }

    @Test
    public void testHashCodeDifferentPerson() {
        assertThat(sam.hashCode()).isNotEqualTo(jane.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "Account[firstName='Sam', lastName='Rogers', " +
                "registeredDate=2018-01-10, " +
                "uuid=66554b91-b00d-403d-a6fe-0679e0ff0925]";
        assertThat(sam.toString()).isEqualTo(expected);
    }

}