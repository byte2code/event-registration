package com.example.EventRegistration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class MyCollegeTest {

    @Test
    void returnsConfiguredCollegeNameAndEvent() {
        MyCollege college = new MyCollege();
        GraduationCeremonyEvent event = new GraduationCeremonyEvent();

        college.setCollegeEvent(event);

        assertEquals("IIT Bombay", college.getCollegeName());
        assertSame(event, college.getEvent());
    }
}
