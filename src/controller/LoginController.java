package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


import dao.TaiKhoan_DAO;
import entity.NhanVien;
import ui.LoginDialog;
import ui.MainFrame;
import utils.Auth;


public class LoginController implements ActionListener {
	private LoginDialog loginDialog;
	private TaiKhoan_DAO taiKhoanDAO;
	
	public LoginController(LoginDialog loginDialog) {
		this.loginDialog = loginDialog;
//		gọi DAO để dùng
		this.taiKhoanDAO = new TaiKhoan_DAO();
		
		// Gắn sự kiện click cho nút Đăng Nhập
		this.loginDialog.addLoginAction(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String userName = loginDialog.getUsername();
		String pass = loginDialog.getPassword();
		
		// Lấy tên người đăng nhập vào hệ thống
		NhanVien nvLogin = taiKhoanDAO.checkLogin(userName, pass);
		Auth.user = nvLogin;
		
		// Kieemr tra lỗi rỗng
		if (userName.isEmpty()) {
			JOptionPane.showMessageDialog(loginDialog, "Tên đăng nhập không được rỗng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			loginDialog.focusUsername();
			return;
		}
		if (pass.isEmpty()) {
			JOptionPane.showMessageDialog(loginDialog, "Mật khẩu không được rỗng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			loginDialog.focusPassword();
			return;
		}
		
		int result = taiKhoanDAO.checkPassWord(userName, pass);
		if(result==0) {
			loginDialog.showMessage("Đăng nhập thành công!!"); 
			loginDialog.dispose();
			MainFrame mainFrame = new MainFrame();
	        new MainController(mainFrame); 
	        mainFrame.setVisible(true);
			return;
		}
		else if(result==1) {
			loginDialog.showMessage("Sai tên đăng nhập. Vui lòng thử lại!!");
			loginDialog.focusUsername();
			return;
		}
		else if(result==2){
			loginDialog.showMessage("Sai mật khẩu. Vui lòng thử lại!!");
			loginDialog.focusPassword();
			return;
		}
		else {
			loginDialog.showMessage("Lỗi kết nối CSDL");
			return;
		}
		
	}
	

}