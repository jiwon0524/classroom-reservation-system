package kr.ac.classroom.reservation.common.policy;

import kr.ac.classroom.reservation.common.domain.Role;

import java.time.Duration;
import java.time.LocalDateTime;

public final class ReservationPolicy {
    public boolean isDurationAllowed(Role role, LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        return switch (role) {
            case PROFESSOR -> !duration.isNegative() && !duration.isZero() && duration.compareTo(Duration.ofHours(3)) <= 0;
            case STUDENT -> !duration.isNegative() && !duration.isZero() && duration.compareTo(Duration.ofHours(2)) <= 0;
            case ADMIN -> false;
        };
    }

    public boolean isStudentCapacityAllowed(int attendeeCount, int classroomCapacity) {
        return attendeeCount <= classroomCapacity / 2;
    }
}
