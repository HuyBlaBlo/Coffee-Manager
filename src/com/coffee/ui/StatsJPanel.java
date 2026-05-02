package com.coffee.ui;

import com.toedter.calendar.JDateChooser;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class StatsJPanel extends JPanel {

    // Buttons
    private JButton btnToday;
    private JButton btnWeek;
    private JButton btnMonth;
    private JButton btnYear;
    private JButton btnExport;
    private JButton btnResetFilter;

    // Date Choosers
    private JDateChooser dateFrom;
    private JDateChooser dateTo;

    // KPIs Labels
    private JLabel lblRevenue;
    private JLabel lblRevenueGrowth;
    
    private JLabel lblOrders;
    private JLabel lblAvgOrder;
    
    private JLabel lblItems;
    private JLabel lblBestSeller;
    
    private JLabel lblProfit;
    private JLabel lblMargin;

    // Chart Containers
    private JPanel pnlBarChartContainer;
    private JPanel pnlPieChartContainer;
    
    // AI Insight
    private JTextArea txtAiInsight;

    public StatsJPanel() {
        initUI();
    }

    private void initUI() {
        // 1. Bố cục tổng thể (Main Layout)
        this.setLayout(new BorderLayout(15, 15));
        this.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.setBackground(Color.decode("#F5F6FA"));

        // 2. Khu vực Phía trên (NORTH)
        JPanel pnlNorth = new JPanel(new BorderLayout(0, 15));
        pnlNorth.setOpaque(false);
        pnlNorth.add(createToolbar(), BorderLayout.NORTH);
        pnlNorth.add(createKpiArea(), BorderLayout.CENTER);
        
        this.add(pnlNorth, BorderLayout.NORTH);

        // 3. Khu vực Trung tâm (CENTER)
        this.add(createCenterArea(), BorderLayout.CENTER);
    }

    private JPanel createToolbar() {
        JPanel pnlToolbar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        pnlToolbar.setOpaque(false);

        dateFrom = new JDateChooser();
        dateFrom.setPreferredSize(new Dimension(130, 30));
        dateTo = new JDateChooser();
        dateTo.setPreferredSize(new Dimension(130, 30));

        btnToday = createToolbarButton("Hôm nay", false);
        btnWeek = createToolbarButton("7 Ngày qua", false);
        btnMonth = createToolbarButton("Tháng này", false);
        btnYear = createToolbarButton("Năm nay", false);
        btnExport = createToolbarButton("Xuất Excel", true);

        pnlToolbar.add(new JLabel("Từ ngày:"));
        pnlToolbar.add(dateFrom);
        pnlToolbar.add(new JLabel("Đến ngày:"));
        pnlToolbar.add(dateTo);
        pnlToolbar.add(btnToday);
        pnlToolbar.add(btnWeek);
        pnlToolbar.add(btnMonth);
        pnlToolbar.add(btnYear);


        return pnlToolbar;
    }

    private JButton createToolbarButton(String text, boolean isExport) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(110, 35));
        
        if (isExport) {
            btn.setBackground(Color.decode("#16A34A"));
            btn.setForeground(Color.WHITE);
            btn.setBorder(BorderFactory.createEmptyBorder());
        } else {
            btn.setBackground(Color.WHITE);
            btn.setForeground(Color.DARK_GRAY);
            btn.setBorder(new LineBorder(Color.decode("#E5E7EB"), 1, true));
        }
        return btn;
    }

    private JPanel createKpiArea() {
        JPanel pnlKpi = new JPanel(new GridLayout(1, 4, 15, 0));
        pnlKpi.setOpaque(false);

        // Card 1: Doanh thu
        lblRevenue = createLargeLabel("#2D1A10");
        lblRevenueGrowth = createSmallLabel(Color.decode("#16A34A"));
        pnlKpi.add(createKpiCard("TỔNG DOANH THU", lblRevenue, lblRevenueGrowth, Color.WHITE, Color.decode("#2D1A10")));

        // Card 2: Số đơn hàng
        lblOrders = createLargeLabel("#2D1A10");
        lblAvgOrder = createSmallLabel(Color.GRAY);
        pnlKpi.add(createKpiCard("SỐ ĐƠN HÀNG", lblOrders, lblAvgOrder, Color.WHITE, Color.decode("#2D1A10")));

        // Card 3: SP đã bán
        lblItems = createLargeLabel("#2D1A10");
        lblBestSeller = createSmallLabel(Color.decode("#C17F3E"));
        pnlKpi.add(createKpiCard("SP ĐÃ BÁN", lblItems, lblBestSeller, Color.WHITE, Color.decode("#2D1A10")));

        // Card 4: Lợi nhuận gộp
        lblProfit = createLargeLabel("#E8A842");
        lblMargin = createSmallLabel(Color.decode("#D1D5DB")); // Sáng màu
        pnlKpi.add(createKpiCard("LỢI NHUẬN GỘP", lblProfit, lblMargin, Color.decode("#2D1A10"), Color.WHITE));

        return pnlKpi;
    }

    private JLabel createLargeLabel(String hexColor) {
        JLabel lbl = new JLabel("0", SwingConstants.LEFT);
        lbl.setFont(new Font("SansSerif", Font.BOLD, 24));
        lbl.setForeground(Color.decode(hexColor));
        return lbl;
    }

    private JLabel createSmallLabel(Color color) {
        JLabel lbl = new JLabel("--", SwingConstants.LEFT);
        lbl.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lbl.setForeground(color);
        return lbl;
    }

    private JPanel createKpiCard(String title, JLabel valueLabel, JLabel subLabel, Color bgColor, Color titleColor) {
        JPanel card = new JPanel(new BorderLayout(5, 5));
        card.setBackground(bgColor);
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.decode("#E5E7EB"), 1, true),
                new EmptyBorder(15, 15, 15, 15)
        ));

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblTitle.setForeground(titleColor);

        JPanel pnlCenter = new JPanel(new GridLayout(2, 1, 0, 5));
        pnlCenter.setOpaque(false);
        pnlCenter.add(valueLabel);
        pnlCenter.add(subLabel);

        card.add(lblTitle, BorderLayout.NORTH);
        card.add(pnlCenter, BorderLayout.CENTER);

        return card;
    }

    private JPanel createCenterArea() {
        JPanel pnlCenter = new JPanel(new BorderLayout(15, 0));
        pnlCenter.setOpaque(false);

        // Nửa trái
        pnlBarChartContainer = new JPanel(new BorderLayout());
        pnlBarChartContainer.setBackground(Color.WHITE);
        pnlBarChartContainer.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.decode("#E5E7EB"), 1, true),
                BorderFactory.createTitledBorder(
                        new EmptyBorder(10, 10, 10, 10), 
                        "Doanh Thu Theo Thời Gian", 
                        TitledBorder.DEFAULT_JUSTIFICATION, 
                        TitledBorder.DEFAULT_POSITION, 
                        new Font("SansSerif", Font.BOLD, 14), 
                        Color.decode("#2D1A10")
                )
        ));
        
        btnResetFilter = new JButton("Bỏ lọc");
        btnResetFilter.setFocusPainted(false);
        btnResetFilter.setVisible(false);
        
        JPanel pnlBarTop = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlBarTop.setOpaque(false);
        pnlBarTop.add(btnResetFilter);
        pnlBarChartContainer.add(pnlBarTop, BorderLayout.NORTH);

        // Nửa phải
        pnlPieChartContainer = new JPanel(new BorderLayout());
        pnlPieChartContainer.setPreferredSize(new Dimension(400, 0));
        pnlPieChartContainer.setBackground(Color.WHITE);
        pnlPieChartContainer.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.decode("#E5E7EB"), 1, true),
                BorderFactory.createTitledBorder(
                        new EmptyBorder(10, 10, 10, 10), 
                        "Tỷ Trọng Sản Phẩm", 
                        TitledBorder.DEFAULT_JUSTIFICATION, 
                        TitledBorder.DEFAULT_POSITION, 
                        new Font("SansSerif", Font.BOLD, 14), 
                        Color.decode("#2D1A10")
                )
        ));

        txtAiInsight = new JTextArea(4, 20);
        txtAiInsight.setLineWrap(true);
        txtAiInsight.setWrapStyleWord(true);
        txtAiInsight.setEditable(false);
        txtAiInsight.setOpaque(false);
        txtAiInsight.setFont(new Font("SansSerif", Font.ITALIC, 13));
        txtAiInsight.setForeground(Color.DARK_GRAY);
        txtAiInsight.setBorder(BorderFactory.createCompoundBorder(
                new TitledBorder(null, "AI Insight", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("SansSerif", Font.BOLD, 12), Color.decode("#16A34A")),
                new EmptyBorder(5, 5, 5, 5)
        ));
        txtAiInsight.setText("Đang phân tích dữ liệu...");
        
        pnlPieChartContainer.add(txtAiInsight, BorderLayout.SOUTH);

        pnlCenter.add(pnlBarChartContainer, BorderLayout.CENTER);
        pnlCenter.add(pnlPieChartContainer, BorderLayout.EAST);

        return pnlCenter;
    }

    // 4. Getters
    public JButton getBtnToday() { return btnToday; }
    public JButton getBtnWeek() { return btnWeek; }
    public JButton getBtnMonth() { return btnMonth; }
    public JButton getBtnYear() { return btnYear; }
    public JButton getBtnExport() { return btnExport; }
    public JButton getBtnResetFilter() { return btnResetFilter; }

    public JDateChooser getDateFrom() { return dateFrom; }
    public JDateChooser getDateTo() { return dateTo; }

    public JLabel getLblRevenue() { return lblRevenue; }
    public JLabel getLblRevenueGrowth() { return lblRevenueGrowth; }

    public JLabel getLblOrders() { return lblOrders; }
    public JLabel getLblAvgOrder() { return lblAvgOrder; }

    public JLabel getLblItems() { return lblItems; }
    public JLabel getLblBestSeller() { return lblBestSeller; }

    public JLabel getLblProfit() { return lblProfit; }
    public JLabel getLblMargin() { return lblMargin; }

    public JPanel getPnlBarChartContainer() { return pnlBarChartContainer; }
    public JPanel getPnlPieChartContainer() { return pnlPieChartContainer; }
    public JTextArea getTxtAiInsight() { return txtAiInsight; }
    
    public static void main(String[] args) {
        // 1. Mentor Tip: Set Look and Feel theo hệ điều hành (Windows) 
        // để giao diện nút bấm, lịch không bị cổ lỗ sĩ như Java đời tống.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. Chạy Swing UI trong luồng an toàn (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> {
            // Tạo một cái khung giả để chứa cái Panel thống kê
            JFrame frame = new JFrame("Test Giao Diện Thống Kê");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Set size rộng một chút để có chỗ cho 2 cái Chart hiện lên (1200x800 là chuẩn)
            frame.setSize(1200, 800); 
            frame.setLocationRelativeTo(null); // Hiển thị ra giữa màn hình

            // Khởi tạo cái Panel của ông và nhét vào giữa khung
            StatsJPanel statsPanel = new StatsJPanel();
            frame.add(statsPanel);

            // Bật hiển thị
            frame.setVisible(true);
        });
    }
}
