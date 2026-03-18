package com.example.EventRegistration;

public class MyCollege implements College {

    private final String name = "IIT Bombay";
    private CollegeEvent collegeEvent;

    public void init() {
        System.out.println("MyCollege bean created!!");
    }

    public void destroy() {
        System.out.println("MyCollege bean destroyed");
    }

    public void setCollegeEvent(CollegeEvent collegeEvent) {
        this.collegeEvent = collegeEvent;
    }

    public void setEvent(CollegeEvent event) {
        this.collegeEvent = event;
    }

    @Override
    public String getCollegeName() {
        return name;
    }

    @Override
    public CollegeEvent getEvent() {
        return collegeEvent;
    }
}
