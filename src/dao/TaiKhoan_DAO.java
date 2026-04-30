package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.TaiKhoan;
import utils.ConnectDB;

public class TaiKhoan_DAO {

	public ArrayList<TaiKhoan> getalltbTaiKhoan() {
		ArrayList<TaiKhoan> dstaikhoan = new ArrayList<TaiKhoan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) { 
				String maTK = rs.getString("MaTK");
				String user = rs.getString("TenDangNhap");
				String pass = rs.getString("MatKhau");
				TaiKhoan tk = new TaiKhoan(maTK,user,pass);
				dstaikhoan.add(tk);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return dstaikhoan;
	}
	
    public int checkPassWord(String userName,String pass) {
    	try {
	        ConnectDB.getInstance().connect(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 3; // 3-> Lỗi kết nối CSDL
	    }
    	
    	ArrayList<TaiKhoan> list = this.getalltbTaiKhoan();
    	for(TaiKhoan tk : list) {
    		//Đúng tên đăng nhập
    		if(tk.getTenDangNhap().equals(userName)) {
    			// Đúng mật khẩu
    			if(tk.getMatKhau().equals(pass)) {
    				System.out.println("Đăng nhập thành công!!");
    			    return 0; //0-> đăng nhập thành công
    			}
    			// Sai mật khẩu
    			else {
    				System.out.println("Sai mật khẩu. Vui lòng thử lại!!");
    				return 2; //2-> sai mật khẩu
    			}
    		}
    	}
    	
    	// Sai tên đăng nhập
    	System.out.println("Sai tên đăng nhập. Vui lòng thử lại!!");
		return 1; //1-> sai tên đăng nhập
    }
	
}

