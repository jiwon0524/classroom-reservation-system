package kr.ac.classroom.reservation.common.domain;

public record UserAccount(
        String id,
        String name,
        Role role,
        String department
) {
}
