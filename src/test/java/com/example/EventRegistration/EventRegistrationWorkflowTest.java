package com.example.EventRegistration;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class EventRegistrationWorkflowTest {

    @Test
    void registersSingleStudentAndPrintsSummary() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            EventRegistrationWorkflow workflow = new EventRegistrationWorkflow(
                    context,
                    scannerFor("1", "Bipin", "Computer Science", "2024", "2")
            );

            String output = ConsoleTestSupport.captureOutput(workflow::run);

            assertTrue(output.contains("Welcome to the Graduation Ceremony Registration Application for IIT Bombay"));
            assertTrue(output.contains("Hi Bipin, your registration for the Graduation Ceremony is successful"));
            assertTrue(output.contains("No. of attendees registered are: 1"));
            assertTrue(output.contains("Bipin    Reference id: @"));
            assertTrue(output.contains("StudentAttendee bean created!!"));
        }
    }

    @Test
    void retriesInvalidBatchBeforeRegistering() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            EventRegistrationWorkflow workflow = new EventRegistrationWorkflow(
                    context,
                    scannerFor("1", "Anaya", "Electronics", "-1", "2023", "2")
            );

            String output = ConsoleTestSupport.captureOutput(workflow::run);

            assertTrue(output.contains("Please enter a valid positive number."));
            assertTrue(output.contains("Hi Anaya, your registration for the Graduation Ceremony is successful"));
        }
    }

    @Test
    void retriesInvalidMenuChoiceBeforeExiting() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            EventRegistrationWorkflow workflow = new EventRegistrationWorkflow(
                    context,
                    scannerFor("7", "2")
            );

            String output = ConsoleTestSupport.captureOutput(workflow::run);

            assertTrue(output.contains("Invalid choice."));
            assertTrue(output.contains("No. of attendees registered are: 0"));
        }
    }

    private Scanner scannerFor(String... lines) {
        String input = String.join(System.lineSeparator(), lines) + System.lineSeparator();
        return new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }
}
