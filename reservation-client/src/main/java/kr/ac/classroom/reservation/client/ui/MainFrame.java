package kr.ac.classroom.reservation.client.ui;

import kr.ac.classroom.reservation.client.api.ServerApiClient;
import kr.ac.classroom.reservation.client.controller.DashboardController;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

public final class MainFrame extends JFrame {
    public MainFrame(ServerApiClient apiClient) {
        super("정보관 강의실 예약 시스템");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 720);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("대시보드", new DashboardPanel(new DashboardController(apiClient)));
        tabs.addTab("강의실 조회", new RoomSearchPanel(apiClient));
        tabs.addTab("예약 신청", new ReservationPanel(apiClient));
        tabs.addTab("관리자", new AdminPanel());

        add(tabs, BorderLayout.CENTER);
    }
}
