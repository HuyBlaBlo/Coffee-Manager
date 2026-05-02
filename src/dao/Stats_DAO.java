package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import utils.ConnectDB;

public class Stats_DAO {

    // lấy doanh thu theo ngày 
    public Map<java.sql.Date, Double> getRevenueByRange(Date start, Date end) {
        Map<java.sql.Date, Double> revenueMap = new LinkedHashMap<>();
        try {
            Connection con = ConnectDB.getConnection();
            // tao ép kiểu cho về date nha vì trong db bây viết nó là datetime, nó lấy cả thời gian, mà cái này nó k cần nên tao bỏ qua thời gian
            String sql = "SELECT CAST(ThoiGianTao AS DATE) as Ngay, sum(TongTien) as DoanhThu " +
                         "FROM HoaDon " +
                         "WHERE CAST(ThoiGianTao AS DATE) >= ? AND CAST(ThoiGianTao AS DATE) <= ? " +
                         "GROUP BY CAST(ThoiGianTao AS DATE) " +
                         "ORDER BY Ngay ASC";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(start.getTime()));
            stmt.setDate(2, new java.sql.Date(end.getTime()));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                revenueMap.put(rs.getDate("Ngay"), rs.getDouble("DoanhThu"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return revenueMap;
    }

    // lấy dữ liệu sản phẩm bán ra theo khoảng ngày 
    public Map<String, Integer> getProductSalesByRange(Date start, Date end) {
        Map<String, Integer> productSales = new LinkedHashMap<>();
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT s.TenSP, SUM(c.SoLuong) as SoLuong " +
                         "FROM ChiTietHoaDon c " +
                         "JOIN HoaDon h ON c.MaHD = h.MaHD " +
                         "JOIN SanPham s ON c.MaSP = s.MaSP " +
                         "WHERE CAST(h.ThoiGianTao AS DATE) >= ? AND CAST(h.ThoiGianTao AS DATE) <= ? " +
                         "GROUP BY s.TenSP " +
                         "ORDER BY SoLuong DESC";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(start.getTime()));
            stmt.setDate(2, new java.sql.Date(end.getTime()));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                productSales.put(rs.getString("TenSP"), rs.getInt("SoLuong"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productSales;
    }

    // tính toán 4 card
    public double[] getKPIs(Date start, Date end) {
        double[] kpis = new double[3]; 
        try {
            Connection con = ConnectDB.getConnection();
            
            // Lấy tổng doanh thu và số đơn hàng từ bảng HoaDon
            String sql1 = "SELECT SUM(TongTien) as TongDoanhThu, COUNT(MaHD) as SoDonHang " +
                          "FROM HoaDon WHERE CAST(ThoiGianTao AS DATE) >= ? AND CAST(ThoiGianTao AS DATE) <= ?";
            PreparedStatement stmt1 = con.prepareStatement(sql1);
            stmt1.setDate(1, new java.sql.Date(start.getTime()));
            stmt1.setDate(2, new java.sql.Date(end.getTime()));
            ResultSet rs1 = stmt1.executeQuery();
            if (rs1.next()) {
                kpis[0] = rs1.getDouble("TongDoanhThu");
                kpis[1] = rs1.getDouble("SoDonHang");
            }
            
            // lấy lợi nhuận gộp từ bảng ChiTietHoaDon 
            // lấy dojanh thu trừ đi vốn doanhThu-von
            String sql2 = "SELECT SUM((c.GiaBanHienTai - c.GiaVonHienTai) * c.SoLuong) as LoiNhuanGop " +
                          "FROM ChiTietHoaDon c " +
                          "JOIN HoaDon h ON c.MaHD = h.MaHD " +
                          "WHERE CAST(h.ThoiGianTao AS DATE) >= ? AND CAST(h.ThoiGianTao AS DATE) <= ?";
            PreparedStatement stmt2 = con.prepareStatement(sql2);
            stmt2.setDate(1, new java.sql.Date(start.getTime()));
            stmt2.setDate(2, new java.sql.Date(end.getTime()));
            ResultSet rs2 = stmt2.executeQuery();
            if (rs2.next()) {
                kpis[2] = rs2.getDouble("LoiNhuanGop");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kpis;
    }
}