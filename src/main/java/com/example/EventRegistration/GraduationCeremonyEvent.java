/*
package com.example.EventRegistration;


import java.util.ArrayList;
import java.util.List;

public class GraduationCeremonyEvent implements CollegeEvent{

    */
/*
    1. Create the following attributes:
        a. name (initialize it as "Graduation Ceremony".
        b. address (String)
        c. time (String)
        d. date (String)
        e. count (int) (initially 0)
        f. eventAttendees (List of Attendee)
        NOTE: Initialize the address, time and date attributes with some values.
    2. Inject Attendee with attribute name "attendee" with setter injection.
    3. Make this class an implementation of CollegeEvent interface and override the interface methods.
    *//*


    String name = "Graduation Ceremony";
    String address = "Auditorium";
    String time = "10 AM";
    String date = "12 Nov 2023";
    int count = 0;
    List<Attendee> eventAttendees = new ArrayList<>();


    @Override
    public void registerStudent(Attendee user) {
        eventAttendees.add(user);
        count++;
    }

    @Override
    public List<Attendee> getAllAttendees() {
        return eventAttendees;
    }

    @Override
    public void printEventDetails() {
        System.out.println("The "+this.name+" details are as follows:");
        System.out.println("Venue: "+this.address);
        System.out.println("Time: "+this.time);
        System.out.println("Date: "+this.date);
    }

    @Override
    public int getAttendeeCount() {
        return eventAttendees.size();
    }

    @Override
    public void setAttendee(Attendee attendee) {
        eventAttendees.add(attendee);
//        count++;
    }
}
*/

package com.example.EventRegistration;

import java.util.ArrayList;
import java.util.List;

public class GraduationCeremonyEvent implements CollegeEvent {

    private final String name = "Graduation Ceremony";
    private final String address = "Auditorium";
    private final String time = "10AM";
    private final String date = "12 Nov 2023";
    private final List<Attendee> eventAttendees = new ArrayList<>();

    private Attendee attendee;

    public void init() {
        System.out.println("Graduation Ceremony bean created!!");
    }

    public void destroy() {
        System.out.println("Graduation Ceremony bean destroyed");
    }

    @Override
    public void registerStudent(Attendee user) {
        eventAttendees.add(user);
    }

    @Override
    public List<Attendee> getAllAttendees() {
        return eventAttendees;
    }

    @Override
    public void printEventDetails() {
        System.out.println("The Graduation Ceremony details are as follows:");
        System.out.println("Venue: " + address);
        System.out.println("Time: " + time);
        System.out.println("Date: " + date);
    }

    @Override
    public int getAttendeeCount() {
        return eventAttendees.size();
    }

    @Override
    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
    }
}
