package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import custom_ui.RoundedButton;
import custom_ui.RoundedLabel;
import custom_ui.RoundedPanel;
import custom_ui.SimpleRoundedPanel;

public class Stats extends JPanel{
    
    private JDateChooser dateFrom;
	private JDateChooser dateTo;
	private RoundedButton filterButton;
	private RoundedButton btnToday;
    private RoundedButton btnWeek;
    private RoundedButton btnMonth;
    private RoundedButton btnYear;
    private RoundedButton btnExport;
    
	private JLabel lblRevenue;
	private JLabel lblRevenueGrowth;
	private JLabel lblProfit;
	private JLabel lblMargin;
	private CardLayout centerCard;
	private JPanel pnlCenterCard;

	public Stats(){
        init();
       
    }

	private void init() {
		// bố cục chính
		this.setLayout(new BorderLayout(10,10));
		this.setBackground(Color.decode("#F5F6FA"));
		
		// lhu vuc phia tren
		JPanel pnlNorth = new JPanel(new BorderLayout(0, 15));
		pnlNorth.setBackground(Color.decode("#f9fafb"));
		
		pnlNorth.add(createToolbar(), BorderLayout.NORTH);
		pnlNorth.add(createKpiArea(), BorderLayout.CENTER);
		
		this.add(pnlNorth, BorderLayout.NORTH);
		
		JPanel pnlCenter = createCenterArea();
		
		this.add(pnlCenter);
		// khu vuc trung tam
		
	}
	
	private JPanel createToolbar() {
		JPanel pnlToolbar = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		pnlToolbar.setBackground(Color.decode("#ffffff"));
		
		// icon 
		ImageIcon titleIcon = getIcon("/images/char.png", 25, 25);
		RoundedLabel thongKeIcon = new RoundedLabel(20, Color.decode("#eddac7"));
		thongKeIcon.setIcon(titleIcon);
		thongKeIcon.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		pnlToolbar.add(thongKeIcon);
		
		// title
		RoundedLabel lblThongKe = new RoundedLabel("Thống kê", 20, Color.decode("#ffffff"));
		lblThongKe.setFont(new Font("Arial", Font.BOLD, 30));
		lblThongKe.setHorizontalAlignment(JLabel.CENTER);
		lblThongKe.setIconTextGap(10);
		lblThongKe.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		pnlToolbar.add(lblThongKe);
		
		// chọn ngày để lọc 
		SimpleRoundedPanel pnlDateFilter = new SimpleRoundedPanel(20, Color.decode("#F3F4F6"), Color.decode("#E5E7EB"));
		pnlDateFilter.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		// các thành phần bên trong
		
		// ngày bắt đầu
		dateFrom  = new JDateChooser();
		dateFrom.setDateFormatString("dd/MM/yyyy");
		dateFrom.setPreferredSize(new Dimension(130,30));
			
		// ngày kết thúc 
		dateTo = new JDateChooser();
		dateTo.setDateFormatString("dd/MM/yyyy");
		dateTo.setPreferredSize(new Dimension(130,30));
		// icon ngay 
		JLabel calenderIcon = new JLabel();
		calenderIcon.setIcon(getIcon("/images/calendar.png", 20, 20));
		
		// dau gach
		JLabel lblSeparator = new JLabel("-");
		lblSeparator.setForeground(Color.decode("#7F7F7F"));
		
		// nút lọc
		filterButton = new RoundedButton("Lọc", 20, Color.BLACK);
		filterButton.setForeground(Color.WHITE);
		filterButton.setPreferredSize(new Dimension(80,30));
		
		pnlDateFilter.add(calenderIcon);
		pnlDateFilter.add(dateFrom);
		pnlDateFilter.add(lblSeparator);
		pnlDateFilter.add(dateTo);
		pnlDateFilter.add(filterButton);
		
		pnlToolbar.add(pnlDateFilter);
		
		// button panel
		SimpleRoundedPanel pnlButton = new SimpleRoundedPanel(20, Color.decode("#F3F4F6"), Color.decode("#E5E7EB"));
		pnlButton.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
		pnlButton.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
		btnToday = createToolbarButton("Hôm nay", false);
        btnWeek = createToolbarButton("7 Ngày qua", false);
        btnMonth = createToolbarButton("Tháng này", false);
        btnYear = createToolbarButton("Năm nay", false);
        btnExport = createToolbarButton("Xuất Excel", true);
        
        pnlButton.add(btnToday);
        pnlButton.add(btnWeek);
        pnlButton.add(btnMonth);
        pnlButton.add(btnYear);
        
        pnlToolbar.add(pnlButton);
        
        pnlToolbar.add(btnExport);
        
		return pnlToolbar;
	}
	
	private ImageIcon getIcon(String filePath, int width, int height) {
		try {
			// tim file
			ImageIcon imageIcon = new ImageIcon(getClass().getResource(filePath));
			// lafm k bi rỗ
			Image scaledImage = imageIcon.getImage().getScaledInstance(width, height,Image.SCALE_SMOOTH);
			
			return new ImageIcon(scaledImage);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Không tìm thấy ảnh");
			return null;
		}
	}
	
	// ham tao nut
	private RoundedButton createToolbarButton(String btnName, boolean isExport) {
        RoundedButton btn = new RoundedButton(btnName,20,Color.WHITE);
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

	// hàm xử lí việc đổi màu khi chọn tab 
	public void setActiveTab(RoundedButton activeButton) {
	    RoundedButton[] tabButton = new RoundedButton[] {btnToday, btnWeek, btnMonth, btnYear};
	    
	    for(RoundedButton listButton : tabButton) {
	        if(listButton == activeButton) {
	            // Nút được chọn thif Tô màu nâu, chữ trắng
	            listButton.setTabColor(Color.decode("#c17f3e"), Color.WHITE);
	        } else {
	            // Nút khoong được chọn thì trả về nền trắng, chữ xám đậm

	            listButton.setTabColor(Color.WHITE, Color.DARK_GRAY);
	        }
	    }
	}
	
	// Hàm phụ trợ tạo cái thẻ Badge bo tròn xanh lá
    private JPanel createBadgeSubLabel(String badgeText, String normalText) {
        JPanel pnl = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pnl.setOpaque(false);

        RoundedLabel lblBadge = new RoundedLabel(badgeText, 10, Color.decode("#E8F5E9"));
        lblBadge.setForeground(Color.decode("#16A34A"));
        lblBadge.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblBadge.setBorder(BorderFactory.createEmptyBorder(2, 6, 2, 6)); 

        JLabel lblText = new JLabel(normalText);
        lblText.setFont(new Font("SansSerif", Font.BOLD, 11));
        lblText.setForeground(Color.decode("#9CA3AF")); 

        pnl.add(lblBadge);
        pnl.add(lblText);
        return pnl;
    }

    private JPanel createKpiArea() {

        JPanel pnlKpi = new JPanel(new GridLayout(1, 4, 15, 0));
        pnlKpi.setOpaque(false);
        pnlKpi.setBorder(new EmptyBorder(5, 15, 15, 15));

        Color bgWhite = Color.WHITE;
        Color borderGray = Color.decode("#E5E7EB");
        Color textDark = Color.decode("#2D1A10");

        //CARD TỔNG DOANH THU
        lblRevenue = createLargeLabel("#2D1A10");
        lblRevenue.setText("1.152.000 đ");
        JPanel subRev = createBadgeSubLabel("↑ 10.3%", "SO VỚI HÔM QUA");
        ImageIcon icRev = getIcon("/images/dollar.png", 40, 40); 
        pnlKpi.add(createKpiCard("TỔNG DOANH THU", lblRevenue, subRev, bgWhite, textDark, borderGray, icRev));

        //CARD SỐ ĐƠN HÀNG
        JLabel lblOrd = createLargeLabel("#2D1A10");
        lblOrd.setText("11");
        JLabel subOrd = createSmallLabel("<html><span style='color:#9CA3AF;'>Bình quân: </span><span style='color:#C17F3E; font-weight:bold;'>104.727 đ/đơn</span></html>");
        ImageIcon icOrd = getIcon("/images/bag.png", 40, 40);
        pnlKpi.add(createKpiCard("SỐ ĐƠN HÀNG", lblOrd, subOrd, bgWhite, textDark, borderGray, icOrd));

        // CARD SP ĐÃ BÁN
        JLabel lblItem = createLargeLabel("#2D1A10");
        lblItem.setText("31");
        JLabel subItem = createSmallLabel("<html><span style='color:#9CA3AF;'>Món chạy nhất: </span><span style='color:#C17F3E; font-weight:bold;'>Bánh Tiramisu</span></html>");
        ImageIcon icItem = getIcon("/images/box.png", 40, 40); 
        pnlKpi.add(createKpiCard("SP ĐÃ BÁN", lblItem, subItem, bgWhite, textDark, borderGray, icItem));

        // CARD LỢI NHUẬN GỘP
        lblProfit = createLargeLabel("#E8A842"); 
        lblProfit.setText("648.000 đ");
        String subText4 = "<html><span style='color:#D1D5DB;'>Biên lợi nhuận: </span><span style='color:white; font-weight:bold;'>56.3%</span></html>";
        lblMargin = createSmallLabel(subText4);
        ImageIcon iconProfit = getIcon("/images/trend_icon.png", 40, 40); 
        pnlKpi.add(createKpiCard("LỢI NHUẬN GỘP", lblProfit, lblMargin, Color.decode("#2D1A10"), Color.WHITE, Color.decode("#2D1A10"), iconProfit));

        return pnlKpi;
    }
	

    private JLabel createLargeLabel(String hexColor) {
        JLabel lbl = new JLabel("0"); 
        lbl.setFont(new Font("SansSerif", Font.BOLD, 28)); 
        lbl.setForeground(Color.decode(hexColor));
        return lbl;
    }

    // label nhỏ
    private JLabel createSmallLabel(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font("SansSerif", Font.PLAIN, 13));
        return lbl;
    }


    private SimpleRoundedPanel createKpiCard(String title, JLabel valueLabel, JComponent subComponent, Color bgColor, Color titleColor, Color borderColor, ImageIcon icon) {

        SimpleRoundedPanel card = new SimpleRoundedPanel(15, bgColor, borderColor);
        card.setLayout(new BorderLayout(10, 10)); 
        card.setBorder(new EmptyBorder(15, 15, 15, 15));

        // nửa bên trái chứa title, giá trị, các sublabel
        JPanel pnlLeft = new JPanel(new GridLayout(3, 1, 0, 5));
        pnlLeft.setOpaque(false); 

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 13));
        lblTitle.setForeground(titleColor);

        pnlLeft.add(lblTitle);
        pnlLeft.add(valueLabel);
        pnlLeft.add(subComponent);

        JLabel lblIcon = new JLabel(icon);
        lblIcon.setVerticalAlignment(SwingConstants.TOP);

        card.add(pnlLeft, BorderLayout.CENTER);
        card.add(lblIcon, BorderLayout.EAST);

        return card;
    }
    
    // phan trung tam, centerArea
    
    public JPanel createCenterArea () {
    	centerCard = new CardLayout();
    	pnlCenterCard = new JPanel(centerCard);
    	pnlCenterCard.setOpaque(false);
    	pnlCenterCard.setBorder(new EmptyBorder(15, 0, 0, 0));
    	
    	// khung ngày hôm nay 
    	SimpleRoundedPanel pnlTodayView = new SimpleRoundedPanel(20, Color.WHITE, Color.decode("#E5E7EB"));
        pnlTodayView.setLayout(new BorderLayout(0, 20));
        pnlTodayView.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JPanel pnlHeaderToday = new JPanel(new BorderLayout());
        pnlHeaderToday.setOpaque(false);
        JLabel lblTitleToday = new JLabel("TỶ TRỌNG SẢN PHẨM");
        lblTitleToday.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitleToday.setForeground(Color.decode("#2D1A10"));
    	
        RoundedLabel lblDateStats = new RoundedLabel("Hôm nay (22/04/2026)", 10, Color.decode("#F3F4F6"));
        lblDateStats.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblDateStats.setForeground(Color.decode("#6B7280"));
        lblDateStats.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12));
        
        pnlHeaderToday.add(lblTitleToday, BorderLayout.WEST);
        pnlHeaderToday.add(lblDateStats, BorderLayout.EAST);
        
        // bieểu đồ tròn dành cho các sản phẩm bán trong ngày
        pnlTodayView.add(pnlHeaderToday, BorderLayout.NORTH);
        pnlTodayView.add(new JLabel("CHỖ NÀY VẼ BIỂU ĐỒ DONUT BỰ", SwingConstants.CENTER), BorderLayout.CENTER);
        
        //========================================================================================================
    	//khung 7 ngày vừa qua, tháng này, năm nay;
        JPanel pnlRangeView = new JPanel(new BorderLayout(15, 0)); 
        pnlRangeView.setOpaque(false);

        // Khung trái: BIỂU ĐỒ CỘT
        SimpleRoundedPanel pnlBarBox = new SimpleRoundedPanel(20, Color.WHITE, Color.decode("#E5E7EB"));
        pnlBarBox.setLayout(new BorderLayout());
        pnlBarBox.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JLabel lblTitleBar = new JLabel("DOANH THU");
        lblTitleBar.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitleBar.setForeground(Color.decode("#2D1A10"));
        pnlBarBox.add(lblTitleBar, BorderLayout.NORTH);
        
        pnlBarBox.add(new JLabel("CHỖ NÀY VẼ BIỂU ĐỒ CỘT", SwingConstants.CENTER), BorderLayout.CENTER);

        //khung phải: TỶ TRỌNG SẢN PHẨM
        SimpleRoundedPanel pnlDonutBox = new SimpleRoundedPanel(20, Color.WHITE, Color.decode("#E5E7EB"));
        pnlDonutBox.setLayout(new BorderLayout());
        pnlDonutBox.setBorder(new EmptyBorder(20, 20, 20, 20));
        pnlDonutBox.setPreferredSize(new Dimension(380, 0));

        JLabel lblTitleDonut = new JLabel("TỶ TRỌNG SẢN PHẨM");
        lblTitleDonut.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblTitleDonut.setForeground(Color.decode("#2D1A10"));
        pnlDonutBox.add(lblTitleDonut, BorderLayout.NORTH);
        pnlDonutBox.add(new JLabel("BIỂU ĐỒ DONUT NHỎ", SwingConstants.CENTER), BorderLayout.CENTER);

        pnlRangeView.add(pnlBarBox, BorderLayout.CENTER);
        pnlRangeView.add(pnlDonutBox, BorderLayout.EAST); 
        
        pnlCenterCard.add(pnlTodayView, "CARD_TODAY");
        pnlCenterCard.add(pnlRangeView, "CARD_RANGE");
        
        // mặc định vô là hiện thoogns kê ngày trước 
        centerCard.show(pnlCenterCard, "CARD_TODAY");
    	return pnlCenterCard;
    }
}








