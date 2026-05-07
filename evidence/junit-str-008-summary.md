# JUnit5 Evidence: STR-008

Date: 2026-05-08

## Scope

- Requirement: `STR-008`
- Rule: a classroom reservation must not exceed 50% of classroom capacity.
- Code under test: `ReservationCapacityPolicy`
- Test class: `ReservationCapacityPolicyTest`

## Environment

- Installed Java on this machine: Java 17.0.18
- Course target: Java 21 or later
- JUnit runner: `junit-platform-console-standalone-1.13.1.jar`

## Result

- Tests found: 3
- Tests started: 3
- Tests successful: 3
- Tests failed: 0

## Command

```powershell
java -jar lib\junit-platform-console-standalone-1.13.1.jar --class-path out\test-classes --scan-class-path
```

## Note

This is real local JUnit5 evidence for the first extracted rule only. The team should repeat the same pattern in the final Java 21 project repository.
