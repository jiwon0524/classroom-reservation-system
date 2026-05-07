package kr.ac.deu.classroom.reservation;

/**
 * Validates the classroom reservation capacity rule from STR-008.
 */
public final class ReservationCapacityPolicy {
    private ReservationCapacityPolicy() {
    }

    public static boolean canAcceptReservation(int classroomCapacity, int alreadyReservedPeople, int requestedPeople) {
        if (classroomCapacity <= 0) {
            throw new IllegalArgumentException("classroomCapacity must be positive");
        }
        if (alreadyReservedPeople < 0 || requestedPeople <= 0) {
            throw new IllegalArgumentException("reservation people counts are invalid");
        }

        int allowedPeople = classroomCapacity / 2;
        return alreadyReservedPeople + requestedPeople <= allowedPeople;
    }
}
