package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.NhanVien;
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
	
    public NhanVien dangNhap(String tenDN, String matKhau) throws Exception {
        String sql = "SELECT tk.TenDangNhap, tk.MatKhau, ns.MaNhanSu, ns.TenNV, ns.ChucVu " +
                     "FROM TaiKhoan tk " +
                     "JOIN NhanSu ns ON tk.MaTK = ns.MaTK " +
                     "WHERE tk.TenDangNhap = ?";
        
        // Lấy connection từ class ConnectDB
        Connection con = ConnectDB.getConnection();
        
        // nếu không kết nối được thử kết lối lại
        if (con == null || con.isClosed()) {
            ConnectDB.getInstance().connect();
            con = ConnectDB.getConnection();
        }
        
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setString(1, tenDN);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String pass = rs.getString("MatKhau");
                    
                    if (!pass.equals(matKhau)) {
                        throw new Exception("Sai mật khẩu!");
                    }
                    
                    // Khởi tạo đối tượng NhanVien nếu đăng nhập thành công
                    NhanVien nv = new NhanVien();
                    nv.setMaNV(rs.getString("MaNhanSu"));
                    nv.setTenNV(rs.getString("TenNV"));
                    nv.setChucVu(rs.getString("ChucVu"));
                    
                    return nv;
                } else {
                    throw new Exception("Tên đăng nhập không tồn tại!");
                }
            }
        }
    }
}
