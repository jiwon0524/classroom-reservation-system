package kr.ac.deu.classroom.reservation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReservationCapacityPolicyTest {
    @Test
    @DisplayName("STR-008: 50% 이하 예약 인원은 허용한다")
    void acceptsReservationWithinHalfCapacity() {
        assertTrue(ReservationCapacityPolicy.canAcceptReservation(40, 10, 10));
    }

    @Test
    @DisplayName("STR-008: 50% 초과 예약 인원은 거부한다")
    void rejectsReservationOverHalfCapacity() {
        assertFalse(ReservationCapacityPolicy.canAcceptReservation(40, 20, 1));
    }

    @Test
    @DisplayName("STR-008: 잘못된 강의실 정원은 예외로 처리한다")
    void rejectsInvalidClassroomCapacity() {
        assertThrows(IllegalArgumentException.class,
                () -> ReservationCapacityPolicy.canAcceptReservation(0, 0, 1));
    }
}
