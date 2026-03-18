package com.example.EventRegistration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class ApplicationContextTest {

    @Test
    void loadsEventAndPrototypeStudentBeans() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            College college = context.getBean("myCollege", College.class);
            CollegeEvent event = context.getBean("graduationCeremonyEvent", CollegeEvent.class);
            Attendee firstStudent = context.getBean("student", Attendee.class);
            Attendee secondStudent = context.getBean("student", Attendee.class);

            assertEquals("IIT Bombay", college.getCollegeName());
            assertNotNull(college.getEvent());
            assertNotNull(event);
            assertNotNull(firstStudent);
            assertNotNull(secondStudent);
            assertTrue(firstStudent != secondStudent);
        }
    }

    @Test
    void printsLifecycleMessagesWhenContextStartsAndStops() {
        String output = ConsoleTestSupport.captureOutput(() -> {
            try (ClassPathXmlApplicationContext ignored = new ClassPathXmlApplicationContext("applicationContext.xml")) {
                // lifecycle messages are printed by init and destroy methods
            }
        });

        assertTrue(output.contains("Graduation Ceremony bean created!!"));
        assertTrue(output.contains("MyCollege bean created!!"));
        assertTrue(output.contains("MyCollege bean destroyed"));
        assertTrue(output.contains("Graduation Ceremony bean destroyed"));
    }
}
