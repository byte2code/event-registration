package com.example.EventRegistration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class ApplicationContextTest {

    @Test
    void loadsEventAndPrototypeStudentBeans() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            CollegeEvent event = context.getBean("event", CollegeEvent.class);
            Attendee firstStudent = context.getBean("student", Attendee.class);
            Attendee secondStudent = context.getBean("student", Attendee.class);

            assertNotNull(event);
            assertNotNull(firstStudent);
            assertNotNull(secondStudent);
            assertTrue(firstStudent != secondStudent);
        }
    }
}
