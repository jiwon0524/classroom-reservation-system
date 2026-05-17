package kr.ac.classroom.reservation.server.repository;

import kr.ac.classroom.reservation.common.domain.Classroom;

import java.util.List;

public interface ClassroomRepository {
    List<Classroom> findAll();
}
