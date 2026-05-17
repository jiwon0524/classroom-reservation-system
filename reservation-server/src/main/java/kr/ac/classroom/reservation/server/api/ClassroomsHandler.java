package kr.ac.classroom.reservation.server.api;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import kr.ac.classroom.reservation.common.domain.Classroom;
import kr.ac.classroom.reservation.server.application.ClassroomService;

import java.io.IOException;
import java.util.stream.Collectors;

public final class ClassroomsHandler implements HttpHandler {
    private final ClassroomService classroomService;

    public ClassroomsHandler(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (!"GET".equals(exchange.getRequestMethod())) {
            ResponseWriter.json(exchange, 405, "{\"error\":\"method_not_allowed\"}");
            return;
        }
        String rooms = classroomService.findActiveClassrooms().stream()
                .map(this::toJson)
                .collect(Collectors.joining(",", "[", "]"));
        ResponseWriter.json(exchange, 200, rooms);
    }

    private String toJson(Classroom classroom) {
        return """
                {"id":"%s","building":"%s","floor":%d,"roomNo":"%s","type":"%s","capacity":%d}
                """.formatted(
                classroom.id(),
                classroom.building(),
                classroom.floor(),
                classroom.roomNo(),
                classroom.type(),
                classroom.capacity()
        ).trim();
    }
}
