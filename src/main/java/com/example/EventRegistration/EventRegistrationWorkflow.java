package com.example.EventRegistration;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;

public class EventRegistrationWorkflow {

    private final ApplicationContext context;
    private final Scanner scanner;

    public EventRegistrationWorkflow(ApplicationContext context, Scanner scanner) {
        this.context = context;
        this.scanner = scanner;
    }

    public void run() {
        College college = context.getBean("myCollege", College.class);
        System.out.println("Welcome to the Graduation Ceremony Registration Application for " + college.getCollegeName());

        CollegeEvent event = college.getEvent();
        event.printEventDetails();

        while (true) {
            Integer choice = promptForMenuChoice(
                    "Do you want to register for the ceremony?",
                    "1. Yes",
                    "2. No"
            );

            if (choice == 2) {
                break;
            }

            StudentAttendee studentAttendee = context.getBean("student", StudentAttendee.class);
            studentAttendee.setAttendeeDetails(
                    promptForNonBlank("Please enter your name:"),
                    promptForNonBlank("Please enter your department:"),
                    promptForPositiveInteger("In which year did you pass out?")
            );

            event.registerStudent(studentAttendee);
            studentAttendee.printRegistrationConfirmation();
        }

        printSummary(event);
    }

    private void printSummary(CollegeEvent event) {
        System.out.println("No. of attendees registered are: " + event.getAttendeeCount());
        System.out.println("The list of attendees are:");

        for (Attendee attendee : event.getAllAttendees()) {
            System.out.println(attendee.getAttendeeName() + "    Reference id: @" + Integer.toHexString(attendee.hashCode()));
        }
    }

    private Integer promptForMenuChoice(String prompt, String... options) {
        while (true) {
            System.out.println(prompt);
            for (String option : options) {
                System.out.println(option);
            }

            Integer value = parseInteger(readLine());
            if (value != null && value >= 1 && value <= options.length) {
                return value;
            }

            System.out.println("Invalid choice.");
        }
    }

    private String promptForNonBlank(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = readLine();
            if (value != null && !value.isBlank()) {
                return value;
            }

            System.out.println("Value cannot be blank. Please try again.");
        }
    }

    private Integer promptForPositiveInteger(String prompt) {
        while (true) {
            System.out.println(prompt);
            Integer value = parseInteger(readLine());
            if (value != null && value > 0) {
                return value;
            }

            System.out.println("Please enter a valid positive number.");
        }
    }

    private String readLine() {
        if (!scanner.hasNextLine()) {
            return null;
        }

        return scanner.nextLine().trim();
    }

    private Integer parseInteger(String input) {
        if (input == null || input.isBlank()) {
            return null;
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            return null;
        }
    }
}
