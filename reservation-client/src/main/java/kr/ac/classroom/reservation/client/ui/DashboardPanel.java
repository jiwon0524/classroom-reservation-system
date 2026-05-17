package kr.ac.classroom.reservation.client.ui;

import kr.ac.classroom.reservation.client.controller.DashboardController;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

public final class DashboardPanel extends JPanel {
    private final JTextArea statusArea = new JTextArea();

    public DashboardPanel(DashboardController controller) {
        setLayout(new BorderLayout(8, 8));
        statusArea.setEditable(false);
        JButton refreshButton = new JButton("서버 상태 확인");
        refreshButton.addActionListener(event -> statusArea.setText(controller.loadServerStatus()));
        add(refreshButton, BorderLayout.NORTH);
        add(new JScrollPane(statusArea), BorderLayout.CENTER);
    }
}
