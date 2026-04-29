package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
		
		// 2. Gọi hàm dangNhap từ TaiKhoan_DAO
		try {
			NhanVien nv = taiKhoanDAO.dangNhap(userName, pass);
			
			// 3. Nếu thành công:
			Auth.user = nv;
			JOptionPane.showMessageDialog(loginDialog, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			MainFrame mainFrame = new MainFrame();
			mainFrame.setVisible(true);
			loginDialog.dispose();
			
			
		} catch (Exception ex) {
			String errorMsg = ex.getMessage();
			JOptionPane.showMessageDialog(loginDialog, errorMsg, "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
			
			if (errorMsg.equals("Tên đăng nhập không tồn tại! Vui lòng thử lại!")) {
				loginDialog.focusUsername();
			} else if (errorMsg.equals("Sai mật khẩu! Vui lòng thử lại!")) {
				loginDialog.focusPassword();
			}
		}
	}
	

}
