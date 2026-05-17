package kr.ac.classroom.reservation.common.policy;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckInPolicyTest {
    private final CheckInPolicy policy = CheckInPolicy.schoolDefault();
    private final LocalDateTime start = LocalDateTime.of(2026, 5, 12, 10, 0);

    @Test
    void allowsCheckInFromThirtyMinutesBeforeStartToTenMinutesAfterStart() {
        assertFalse(policy.canCheckIn(start, start.minusMinutes(31)));
        assertTrue(policy.canCheckIn(start, start.minusMinutes(30)));
        assertTrue(policy.canCheckIn(start, start.plusMinutes(10)));
        assertFalse(policy.canCheckIn(start, start.plusMinutes(11)));
    }
}
