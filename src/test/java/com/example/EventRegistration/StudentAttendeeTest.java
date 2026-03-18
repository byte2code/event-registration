package com.example.EventRegistration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StudentAttendeeTest {

    @Test
    void storesAttendeeDetailsAndPrintsConfirmation() {
        StudentAttendee attendee = new StudentAttendee();
        attendee.setAttendeeDetails("Bipin", "Computer Science", 2024);

        String output = ConsoleTestSupport.captureOutput(attendee::printRegistrationConfirmation);

        assertEquals("Bipin", attendee.getAttendeeName());
        assertTrue(output.contains("Hi Bipin, your registration for the Graduation Ceremony is successful"));
    }
}
