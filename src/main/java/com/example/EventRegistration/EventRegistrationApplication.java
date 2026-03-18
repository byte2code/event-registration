package com.example.EventRegistration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class EventRegistrationApplication {

    public static void main(String[] args) {
        try (
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                Scanner scanner = new Scanner(System.in)
        ) {
            new EventRegistrationWorkflow(context, scanner).run();
        }
    }

}
