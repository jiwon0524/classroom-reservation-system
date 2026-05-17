package kr.ac.classroom.reservation.server.application;

import kr.ac.classroom.reservation.common.domain.Classroom;
import kr.ac.classroom.reservation.server.repository.ClassroomRepository;

import java.util.List;

public final class ClassroomService {
    private final ClassroomRepository classroomRepository;

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<Classroom> findActiveClassrooms() {
        return classroomRepository.findAll().stream()
                .filter(Classroom::active)
                .toList();
    }
}
