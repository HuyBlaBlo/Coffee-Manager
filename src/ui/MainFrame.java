package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import utils.Auth;

public class MainFrame extends JFrame{
	private JPanel pnlSideBar;
	private CardLayout cardLayout;
	private JPanel pnlMain;
	private JButton btnPOS;
	private JButton btnInvoice;
	private JButton btnMenu;
	private JButton btnStaff;
	private JButton btnStats;
	private JButton btnLogout;

	
	public MainFrame() {
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setTitle("Hệ thống quản lý quán Cà Phê");
		setSize(1920,1080);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// ============SIDE BẢR ==========//
		// thanh hieenr thi ben trai (co dinh ben trai)
		pnlSideBar = new JPanel();
		pnlSideBar.setPreferredSize(new Dimension(250, 1080));
		pnlSideBar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		pnlSideBar.setBackground(Color.decode("#1a0f0a")); // màu nâu cứt chó
		pnlSideBar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.decode("#c17f3e")));  // cũng cứt chó nhưng nhạt hơn
		
		// chữ tên quán
		JLabel lblLogo = new JLabel("BỐN ANH EM");
		lblLogo.setFont(new Font("Arial", Font.BOLD, 28));
		lblLogo.setForeground(Color.decode("#e8a842")); // vang gold
		lblLogo.setPreferredSize(new Dimension(250,60));
		pnlSideBar.add(lblLogo);
		
		//nguoi dunng
		// lay ten nguoi dung ra
		String userName = (Auth.user != null) ? Auth.user.getTenNV() : "Quản lý";
		JLabel lblUser = new JLabel("Xin chào" + userName,JLabel.CENTER);
		lblUser.setForeground(Color.decode("#f5e6d3")); //mau trang
        lblUser.setFont(new Font("Arial", Font.ITALIC, 18));
        lblUser.setPreferredSize(new Dimension(250, 30));
        pnlSideBar.add(lblUser);
		
        //==========MAIN PANEL (dung cardlayout)///
        cardLayout = new CardLayout();
        pnlMain = new JPanel(cardLayout);
        pnlMain.setBackground(Color.decode("#2d1a10"));// mau nau
        
        // noi se nhet cac panel cua tung chuc nang ne
        btnPOS = createMenuButton("POS");
        btnInvoice = createMenuButton("Invoice");
        btnMenu = createMenuButton("Menu");
        btnStaff = createMenuButton("Staff");
        btnStats = createMenuButton("Stats");
        
        // them nut vao sidebar
        pnlSideBar.add(btnPOS);
        pnlSideBar.add(btnInvoice);
        pnlSideBar.add(btnMenu);
        pnlSideBar.add(btnStaff);
        pnlSideBar.add(btnStats);
        
        // nut dang xuat
        
        btnLogout = createMenuButton("Logout");
        pnlSideBar.add(Box.createVerticalStrut(100));
        pnlSideBar.add(btnLogout);
        
        
        // them vao frame
        add(pnlSideBar,BorderLayout.WEST);
        add(pnlMain, BorderLayout.CENTER);
	}
	
	// ham nay tao nut
	private JButton createMenuButton(String text) {
		JButton btn = new JButton(text);
		btn.setPreferredSize(new Dimension(220,45));
		btn.setForeground(Color.decode("#f5e6d3"));
		btn.setBackground(Color.decode("#2d1a10"));
		btn.setFont(new Font("Arial", Font.BOLD, 18));
		btn.setBorder(BorderFactory.createLineBorder(Color.decode("#c17f3e"), 2)); // giong mau cua vien 

		return btn;
	}

	
	//========== CÁC HÀM NÀY SẼ TƯƠNG TÁC VỚI CONTROLER==========//
	// 1. Cho phép Controller nhét csac cái panel vào pnlMain
    public void addSubPanel(JPanel panel, String name) {
        pnlMain.add(panel, name);
    }

    // 2. Cho phép Controller ra lệnh chuyển màn hình
    public void showCard(String cardName) {
        cardLayout.show(pnlMain, cardName);
    }
    
    // 3. Hàm này gắn sự kiện cho csac nút nè nhá các em
    public void addMenuAction(ActionListener actionListener) {
    	btnPOS.addActionListener(actionListener);
        btnInvoice.addActionListener(actionListener);
        btnMenu.addActionListener(actionListener);
        btnStaff.addActionListener(actionListener);
        btnStats.addActionListener(actionListener);
        btnLogout.addActionListener(actionListener);
    }
	
	
	
}
