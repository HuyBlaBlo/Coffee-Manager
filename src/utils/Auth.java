package utils;

import entity.NhanVien;

public class Auth {
	public static NhanVien user = null;
	
//	xoa user
	public static void clear() {
		Auth.user = null;		
	}
	
//	kiem tra de dang nhap
	public static boolean isLogin() {
		return Auth.user != null;
	}
	
	//kiem tra co phai la quan ly khong de cap quyen
	public static boolean isManager() {
		return isLogin() && "Quản lý".equalsIgnoreCase(user.getVaiTro());
	}
	
}
