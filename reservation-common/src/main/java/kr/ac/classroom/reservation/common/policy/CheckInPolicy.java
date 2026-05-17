package kr.ac.classroom.reservation.common.policy;

import java.time.Duration;
import java.time.LocalDateTime;

public final class CheckInPolicy {
    private final Duration openBeforeStart;
    private final Duration graceAfterStart;

    public CheckInPolicy(Duration openBeforeStart, Duration graceAfterStart) {
        this.openBeforeStart = openBeforeStart;
        this.graceAfterStart = graceAfterStart;
    }

    public static CheckInPolicy schoolDefault() {
        return new CheckInPolicy(Duration.ofMinutes(30), Duration.ofMinutes(10));
    }

    public boolean canCheckIn(LocalDateTime reservationStart, LocalDateTime now) {
        LocalDateTime opensAt = reservationStart.minus(openBeforeStart);
        LocalDateTime closesAt = reservationStart.plus(graceAfterStart);
        return !now.isBefore(opensAt) && !now.isAfter(closesAt);
    }
}
