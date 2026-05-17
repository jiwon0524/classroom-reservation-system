package kr.ac.classroom.reservation.common.domain;

public record Classroom(
        String id,
        String building,
        int floor,
        String roomNo,
        ClassroomType type,
        int capacity,
        boolean active
) {
    public Classroom {
        if (floor < 1 || floor > 9) {
            throw new IllegalArgumentException("floor must be between 1 and 9");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
    }
}
