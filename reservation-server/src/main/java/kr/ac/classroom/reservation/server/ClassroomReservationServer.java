package kr.ac.classroom.reservation.server;

import com.sun.net.httpserver.HttpServer;
import kr.ac.classroom.reservation.common.protocol.ApiPaths;
import kr.ac.classroom.reservation.server.api.ClassroomsHandler;
import kr.ac.classroom.reservation.server.api.HealthHandler;
import kr.ac.classroom.reservation.server.api.ReservationsHandler;
import kr.ac.classroom.reservation.server.application.ClassroomService;
import kr.ac.classroom.reservation.server.application.ReservationService;
import kr.ac.classroom.reservation.server.config.ServerConfig;
import kr.ac.classroom.reservation.server.repository.file.FileClassroomRepository;
import kr.ac.classroom.reservation.server.storage.FileStorage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.util.concurrent.Executors;

public final class ClassroomReservationServer {
    private ClassroomReservationServer() {
    }

    public static void main(String[] args) throws IOException {
        ServerConfig config = ServerConfig.fromArgs(args);
        FileStorage storage = new FileStorage(Path.of(config.dataDirectory()));
        ClassroomService classroomService = new ClassroomService(new FileClassroomRepository(storage));
        ReservationService reservationService = new ReservationService();

        HttpServer server = HttpServer.create(new InetSocketAddress(config.port()), 0);
        server.createContext(ApiPaths.HEALTH, new HealthHandler());
        server.createContext(ApiPaths.CLASSROOMS, new ClassroomsHandler(classroomService));
        server.createContext(ApiPaths.RESERVATIONS, new ReservationsHandler(reservationService));
        server.setExecutor(Executors.newFixedThreadPool(config.workerThreads()));
        server.start();

        System.out.printf("Classroom reservation server started at http://localhost:%d%n", config.port());
    }
}
