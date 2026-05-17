package kr.ac.classroom.reservation.client.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public final class AdminPanel extends JPanel {
    public AdminPanel() {
        setLayout(new BorderLayout());
        add(new JLabel("관리자 기능: 예약 승인/거부, 강의실 관리, 시설 신고 처리, 백업/복구"), BorderLayout.NORTH);
    }
}
