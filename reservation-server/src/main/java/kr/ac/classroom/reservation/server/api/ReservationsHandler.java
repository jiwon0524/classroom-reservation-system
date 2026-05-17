package kr.ac.classroom.reservation.server.api;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import kr.ac.classroom.reservation.server.application.ReservationService;

import java.io.IOException;

public final class ReservationsHandler implements HttpHandler {
    private final ReservationService reservationService;

    public ReservationsHandler(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            ResponseWriter.json(exchange, 200, reservationService.findReservationSummary());
            return;
        }
        ResponseWriter.json(exchange, 405, "{\"error\":\"method_not_allowed\"}");
    }
}
