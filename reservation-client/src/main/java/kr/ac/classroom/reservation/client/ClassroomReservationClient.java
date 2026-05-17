package kr.ac.classroom.reservation.client;

import kr.ac.classroom.reservation.client.api.ServerApiClient;
import kr.ac.classroom.reservation.client.ui.MainFrame;

import javax.swing.SwingUtilities;
import java.net.URI;

public final class ClassroomReservationClient {
    private ClassroomReservationClient() {
    }

    public static void main(String[] args) {
        URI serverUri = URI.create(args.length > 0 ? args[0] : "http://localhost:8080");
        ServerApiClient apiClient = new ServerApiClient(serverUri);
        SwingUtilities.invokeLater(() -> new MainFrame(apiClient).setVisible(true));
    }
}
