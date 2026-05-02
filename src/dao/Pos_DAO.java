package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entity.ChiTietHoaDon;
import entity.HoaDon;
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
    public boolean insertThanhToan(HoaDon hd, List<ChiTietHoaDon> listCTHD) {
        Connection con = null;
        PreparedStatement stmtHD = null;
        PreparedStatement stmtCTHD = null;
        try {
            con = ConnectDB.getConnection();
            con.setAutoCommit(false); // Bật Transaction

            // 1. INSERT bảng HoaDon
            String sqlHD = "INSERT INTO HoaDon (MaHD, ThoiGianTao, Ban, MaNhanSu, PhuongThucTT, TrangThai, TongTien) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmtHD = con.prepareStatement(sqlHD);
            stmtHD.setString(1, hd.getMaHD());
            stmtHD.setTimestamp(2, new java.sql.Timestamp(hd.getThoiGianTao().getTime()));
            stmtHD.setString(3, hd.getBan());
            stmtHD.setString(4, hd.getMaNV() != null ? hd.getMaNV().getMaNV() : null);
            stmtHD.setString(5, hd.getPhuongThucTT());
            stmtHD.setString(6, hd.getTrangThai());
            stmtHD.setDouble(7, hd.getTongTien());
            stmtHD.executeUpdate();

            // 2. INSERT bảng ChiTietHoaDon
            String sqlCTHD = "INSERT INTO ChiTietHoaDon (MaHD, MaSP, SoLuong, GiaBanHienTai, GiaVonHienTai) VALUES (?, ?, ?, ?, ?)";
            stmtCTHD = con.prepareStatement(sqlCTHD);
            for (ChiTietHoaDon ct : listCTHD) {
                stmtCTHD.setString(1, hd.getMaHD());
                stmtCTHD.setString(2, ct.getSanPham().getMaSP());
                stmtCTHD.setInt(3, ct.getSoLuong());
                stmtCTHD.setDouble(4, ct.getGiaBanHienTai());
                stmtCTHD.setDouble(5, ct.getGiaVonHienTai());
                stmtCTHD.executeUpdate();
            }

            con.commit(); // Thành công thì lưu toàn bộ
            return true;
        } catch (SQLException e) {
            try {
                if (con != null) con.rollback(); // Lỗi thì hoàn tác toàn bộ
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (stmtHD != null) stmtHD.close();
                if (stmtCTHD != null) stmtCTHD.close();
                if (con != null) con.setAutoCommit(true); // Trả lại trạng thái ban đầu
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}