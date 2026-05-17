package kr.ac.classroom.reservation.client.controller;

import kr.ac.classroom.reservation.client.api.ServerApiClient;

public final class DashboardController {
    private final ServerApiClient apiClient;

    public DashboardController(ServerApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public String loadServerStatus() {
        try {
            return apiClient.health();
        } catch (Exception exception) {
            return "{\"status\":\"DOWN\",\"reason\":\"" + exception.getMessage() + "\"}";
        }
    }
}
