# Changelog

All notable changes to this project are documented in this file.

## [v3.0.0] - 2026-03-18

### Summary
Third version of the Event Registration project that keeps the college-owned ceremony model from `v2` and adds custom Spring lifecycle callbacks for the managed beans.

### Highlights
- Added `init()` lifecycle methods for `StudentAttendee`, `GraduationCeremonyEvent`, and `MyCollege`.
- Added `destroy()` lifecycle methods for `GraduationCeremonyEvent` and `MyCollege`.
- Updated Spring XML to use `init-method` and `destroy-method` attributes.
- Updated the configured college name to `IIT Bombay` to reflect the new template version.
- Expanded tests and documentation to cover lifecycle behavior and the updated welcome flow.

### Notes
This version focuses on Spring bean lifecycle management while preserving the registration behavior introduced in `v2`.

## [v2.0.0] - 2026-03-18

### Summary
Second version of the Event Registration project that adds a college abstraction around the graduation ceremony event while keeping the registration workflow intact.

### Highlights
- Added `College` and `MyCollege` to model the ceremony as part of a college.
- Updated Spring XML to wire `myCollege`, `graduationCeremonyEvent`, and the prototype attendee bean together.
- Updated the console flow to welcome the user with the configured college name.
- Added tests for the new college layer and updated documentation for the revised flow.

### Notes
This version extends the event model by introducing a college-owned ceremony while preserving the same attendee registration behavior from `v1`.

## [v1.0.0] - 2026-03-18

### Summary
Initial version of the Event Registration project built as a Java 17 console application with Spring XML bean configuration.

### Highlights
- Added attendee and event abstractions for a graduation ceremony registration flow.
- Added Spring XML wiring for the event bean and prototype attendee bean.
- Added a console workflow for alumni registration and summary printing.
- Added tests for bean loading, attendee behavior, and workflow output.
- Added GitHub-ready documentation and changelog files.

### Notes
This version establishes the project as a compact event-registration demo suitable for GitHub and portfolio presentation.
