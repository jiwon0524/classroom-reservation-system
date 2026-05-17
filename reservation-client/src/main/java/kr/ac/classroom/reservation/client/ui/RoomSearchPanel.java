package kr.ac.classroom.reservation.client.ui;

import kr.ac.classroom.reservation.client.api.ServerApiClient;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

public final class RoomSearchPanel extends JPanel {
    private final JTextArea resultArea = new JTextArea();

    public RoomSearchPanel(ServerApiClient apiClient) {
        setLayout(new BorderLayout(8, 8));
        resultArea.setEditable(false);
        JButton loadButton = new JButton("강의실 불러오기");
        loadButton.addActionListener(event -> {
            try {
                resultArea.setText(apiClient.classrooms());
            } catch (Exception exception) {
                resultArea.setText("강의실 조회 실패: " + exception.getMessage());
            }
        });
        add(loadButton, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }
}
