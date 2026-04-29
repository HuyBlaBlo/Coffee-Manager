package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ui.custom_ui.RoundedButton;
import ui.custom_ui.RoundedPanel;
import ui.custom_ui.RoundedPasswordField;
import ui.custom_ui.RoundedTextField;


public class LoginDialog extends JFrame{
// giao dien dang nhap nha may em yeu
	
	private RoundedPanel mainPanel;
	private Box header;
	private JLabel subheading;
	private Box login;
	private JLabel lblDangNhap;
	private RoundedTextField txtDangNhap;
	private JLabel lblMatKhau;
	private RoundedPasswordField txtMatKhau;
	private RoundedButton btnDangNhap;

	public LoginDialog() {
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setTitle("Login");
		setSize(450,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		mainPanel = new RoundedPanel(30); 
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        
        getContentPane().setBackground(new Color(240, 240, 240));

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
  
        header = Box.createVerticalBox();
     // Dấu / ở đầu đại diện cho thư mục src
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/bon_anh_em_logo_2_trimmed.png"));
		Image img = icon.getImage().getScaledInstance(140, 120, Image.SCALE_SMOOTH);
		JLabel logo = new JLabel(new ImageIcon(img));
		logo.setAlignmentX(Component.CENTER_ALIGNMENT);

		subheading = new JLabel("Hệ thống quản lý quán ~ v2.0");
		subheading.setFont(new Font(subheading.getFont().getName(),subheading.getFont().ITALIC,subheading.getFont().getSize() + 2));
		subheading.setForeground(Color.decode("#cccccc"));
		subheading.setAlignmentX(Component.CENTER_ALIGNMENT);
		header.add(logo);
		header.add(Box.createVerticalStrut(10));
		header.add(subheading);
		mainPanel.add(header,BorderLayout.NORTH);
		
		login = Box.createVerticalBox();
		lblDangNhap = new JLabel("Tên đăng nhập: ");
		lblDangNhap.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblDangNhap.setFont(new Font(lblDangNhap.getFont().getName(),lblDangNhap.getFont().BOLD,lblDangNhap.getFont().getSize() + 3));
		lblDangNhap.setForeground(Color.white);
		txtDangNhap = new RoundedTextField(20);
		ImageIcon userIcon = new ImageIcon(getClass().getResource("/images/group.png"));
		txtDangNhap.setIcon(userIcon);
		txtDangNhap.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtDangNhap.setFont(new Font("Arial", Font.PLAIN, 18));
		txtDangNhap.setMaximumSize(new Dimension(Integer.MAX_VALUE,45));
		lblMatKhau = new JLabel("Mật khẩu: ");
		lblMatKhau.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblMatKhau.setFont(new Font(lblMatKhau.getFont().getName(),lblMatKhau.getFont().BOLD,lblMatKhau.getFont().getSize() + 3));
		lblMatKhau.setForeground(Color.white);
		txtMatKhau = new RoundedPasswordField(20);
		ImageIcon passIcon = new ImageIcon(getClass().getResource("/images/key.png"));
		txtMatKhau.setIcon(passIcon);
		txtMatKhau.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtMatKhau.setFont(new Font("Arial", Font.PLAIN, 18));
		txtMatKhau.setMaximumSize(new Dimension(Integer.MAX_VALUE,45));
		login.add(Box.createVerticalStrut(30));
		login.add(lblDangNhap);
		login.add(Box.createVerticalStrut(10));
		login.add(txtDangNhap);
		login.add(Box.createVerticalStrut(20));
		login.add(lblMatKhau);
		login.add(Box.createVerticalStrut(10));
		login.add(txtMatKhau);
		login.add(Box.createVerticalStrut(10));
		
		mainPanel.add(login,BorderLayout.CENTER);
		
		ImageIcon loginIcon = new ImageIcon(getClass().getResource("/images/login.png"));
		Image loginImg = loginIcon.getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(loginImg);
		btnDangNhap = new RoundedButton("ĐĂNG NHẬP",20,Color.decode("#f9bd14"));
		btnDangNhap.setForeground(Color.white);
		btnDangNhap.setPreferredSize(new Dimension(0,45));
		btnDangNhap.setFont(new Font("Arial", Font.BOLD, 13));
		btnDangNhap.setIcon(scaledIcon);
		btnDangNhap.setIconTextGap(2);
		mainPanel.add(btnDangNhap,BorderLayout.SOUTH);
		
	}
	
	// hàm gắn sự kiện 
	public void addLoginAction(ActionListener listener) {
        btnDangNhap.addActionListener(listener);
    }
	
	// hàm để lấy các thông tin ra
	public String getUsername() {
        return txtDangNhap.getText().trim();
    }

    public String getPassword() {
        return new String(txtMatKhau.getPassword());
    }

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
	
	public void focusUsername() {
		txtDangNhap.selectAll();
		txtDangNhap.requestFocus();
	}
	
	public void focusPassword() {
		txtMatKhau.selectAll();
		txtMatKhau.requestFocus();
	}
}
