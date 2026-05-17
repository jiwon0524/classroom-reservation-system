package kr.ac.classroom.reservation.server.repository.file;

import kr.ac.classroom.reservation.common.domain.Classroom;
import kr.ac.classroom.reservation.common.domain.ClassroomType;
import kr.ac.classroom.reservation.server.repository.ClassroomRepository;
import kr.ac.classroom.reservation.server.storage.FileStorage;

import java.util.List;

public final class FileClassroomRepository implements ClassroomRepository {
    private final FileStorage storage;

    public FileClassroomRepository(FileStorage storage) {
        this.storage = storage;
    }

    @Override
    public List<Classroom> findAll() {
        storage.ensureDataDirectory();
        return List.of(
                new Classroom("ROOM-0908", "정보관", 9, "908", ClassroomType.CLASSROOM, 50, true),
                new Classroom("ROOM-0911", "정보관", 9, "911", ClassroomType.LAB, 40, true),
                new Classroom("ROOM-0912", "정보관", 9, "912", ClassroomType.CLASSROOM, 45, true),
                new Classroom("ROOM-0913", "정보관", 9, "913", ClassroomType.SEMINAR_ROOM, 30, true)
        );
    }
}
