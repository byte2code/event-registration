# Event Registration

Event Registration is a Java 17 console application that uses Spring XML bean configuration to register alumni for a graduation ceremony.

## GitHub Metadata

- Suggested repository description: `Java 17 Spring console app for graduation ceremony registration using XML-based dependency injection.`
- Suggested topics: `java`, `java-17`, `spring-framework`, `spring`, `maven`, `xml-configuration`, `dependency-injection`, `junit5`, `oop`, `console-application`, `event-registration`, `learning-project`, `portfolio-project`

## Tech Stack

- Java 17
- Maven
- Spring Framework XML configuration
- JUnit 5

## Project Overview

The application models a simple graduation-ceremony registration flow:

- `StudentAttendee` implements the `Attendee` interface.
- `GraduationCeremonyEvent` implements the `CollegeEvent` interface.
- `EventRegistrationWorkflow` manages console interaction and validation.
- `applicationContext.xml` wires the event bean and prototype attendee bean.

## Current Flow

1. The application starts in `EventRegistrationApplication`.
2. Spring loads `applicationContext.xml`.
3. The app prints the graduation-ceremony event details.
4. The user decides whether to register.
5. If yes, the app collects attendee name, department, and pass-out year.
6. The attendee is registered with the event.
7. The app prints a confirmation message and, at the end, a summary list of attendees.

## Flow Diagram

```mermaid
flowchart TD
    A["Start: EventRegistrationApplication.main()"] --> B["Load Spring XML context<br/>applicationContext.xml"]
    B --> C["Print graduation event details"]
    C --> D["Show registration menu"]
    D --> E{"Register?"}
    E -->|"Yes"| F["Collect attendee name, department, batch"]
    E -->|"No"| H["Print registration summary"]
    E -->|"Invalid"| I["Show invalid choice and retry"]
    I --> D
    F --> G["Register attendee and print confirmation"]
    G --> D
    H --> J["Print attendee list and end"]
```

## How To Run

```bash
mvn test
mvn package
java -jar target/event-registration-0.0.1-SNAPSHOT.jar
```

If you prefer the Maven Wrapper, use `mvnw.cmd` on Windows or `./mvnw` on Unix-like systems.

## Sample Output

```text
Welcome to the Graduation Ceremony Registration Application
The Graduation Ceremony details are as follows:
Venue: Auditorium
Time: 10AM
Date: 12 Nov 2023
Do you want to register for the ceremony?
1. Yes
2. No
Please enter your name:
Please enter your department:
In which year did you pass out?
Hi Bipin, your registration for the Graduation Ceremony is successful
No. of attendees registered are: 1
```

## Known Limitations

- The application is console-based and does not expose a REST API.
- Registered attendees are stored only for the current runtime.
- There is no duplicate-checking, persistence, or event capacity management.

## Why This Repo Exists

This repository is intended as a learning and portfolio project that shows:

- interface-based design
- Spring XML bean wiring
- prototype bean usage
- console workflow handling
- automated tests for wiring and registration flow
