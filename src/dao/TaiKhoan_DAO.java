package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.NhanVien;
import utils.ConnectDB;

public class TaiKhoan_DAO {

    public NhanVien dangNhap(String tenDN, String matKhau) throws Exception {
        String sql = "SELECT tk.TenDangNhap, tk.MatKhau, ns.MaNhanSu, ns.TenNV, ns.ChucVu " +
                     "FROM TaiKhoan tk " +
                     "JOIN NhanSu ns ON tk.MaTK = ns.MaTK " +
                     "WHERE tk.TenDangNhap = ?";
        
        // Lấy connection từ class ConnectDB
        Connection con = ConnectDB.getConnection();
        
        // Đảm bảo connection đã được mở
        if (con == null || con.isClosed()) {
            ConnectDB.getInstance().connect();
            con = ConnectDB.getConnection();
        }
        
        // Lưu ý: Không đóng Connection ở đây (không đưa vào khối try(...) chứa Connection)
        // Vì Connection này dùng chung cho toàn hệ thống
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
