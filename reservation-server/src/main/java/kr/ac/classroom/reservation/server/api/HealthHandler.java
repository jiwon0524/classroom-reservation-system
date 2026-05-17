package kr.ac.classroom.reservation.server.api;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public final class HealthHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        ResponseWriter.json(exchange, 200, "{\"status\":\"UP\"}");
    }
}
