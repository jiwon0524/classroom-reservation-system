package kr.ac.classroom.reservation.client.ui;

import kr.ac.classroom.reservation.client.api.ServerApiClient;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

public final class ReservationPanel extends JPanel {
    private final JTextArea resultArea = new JTextArea();

    public ReservationPanel(ServerApiClient apiClient) {
        setLayout(new BorderLayout(8, 8));
        resultArea.setEditable(false);
        JButton loadButton = new JButton("예약 현황 불러오기");
        loadButton.addActionListener(event -> {
            try {
                resultArea.setText(apiClient.reservations());
            } catch (Exception exception) {
                resultArea.setText("예약 현황 조회 실패: " + exception.getMessage());
            }
        });
        add(loadButton, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }
}
