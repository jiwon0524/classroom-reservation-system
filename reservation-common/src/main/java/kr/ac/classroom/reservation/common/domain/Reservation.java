package kr.ac.classroom.reservation.common.domain;

import java.time.LocalDateTime;

public record Reservation(
        String id,
        String classroomId,
        String requesterId,
        Role requesterRole,
        String purpose,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime,
        int attendeeCount,
        ReservationStatus status
) {
    public Reservation {
        if (!startDateTime.isBefore(endDateTime)) {
            throw new IllegalArgumentException("reservation start must be before end");
        }
        if (attendeeCount <= 0) {
            throw new IllegalArgumentException("attendee count must be positive");
        }
    }
}
