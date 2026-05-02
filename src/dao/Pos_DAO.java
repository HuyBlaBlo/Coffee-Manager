package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entity.SanPham;
import utils.ConnectDB;

public class Pos_DAO {
    
    // Lấy thông tin sản phẩm (để đẩy lên View khi click chọn món)
    public SanPham getSanPhamByTen(String tenSP) {
        SanPham sp = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM SanPham WHERE tenSP = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tenSP);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                sp = new SanPham();
                sp.setMaSP(rs.getString("maSP"));
                sp.setTenSP(rs.getString("tenSP"));
                sp.setGiaBan(rs.getDouble("giaBan"));
                // Map thêm các trường khác...
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }

    // Đẩy dữ liệu Hóa Đơn xuống CSDL khi nhấn Thanh Toán
    public boolean insertHoaDon(double tongTien, String phuongThucTT) {
        // Viết câu lệnh INSERT INTO HoaDon...
        return true; 
    }
}