package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import dao.Pos_DAO;
import entity.SanPham;
import ui.POS;

public class POSController implements ActionListener{
	
	private POS posView;
	private Pos_DAO posDao;
	public POSController(POS posView) {
		// TODO Auto-generated constructor stub
		this.posView = posView;
		this.posDao = new Pos_DAO();
		this.posView.addPOSListener(this);
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
	    
	    // 1. Xử lý khi nhấn "Tại chỗ"
	    if (command.equals("TaiCho")) {
	        posView.setKichHoatBan(true); // Mở khóa nút bàn
	        posView.setTrangThaiDonHang(" Chưa chọn bàn! ");
	    } 
	    // 2. Xử lý khi nhấn "Mang đi"
	    else if (command.equals("MangDi")) {
	        posView.setKichHoatBan(false); // Khóa nút bàn
	        posView.setTrangThaiDonHang(" Khách mang đi ");
	    }
	    // 3. Xử lý khi click vào các nút Bàn
	    else if (command.startsWith("Bàn ")) {
	        // Lấy đúng tên bàn từ command (VD: "Bàn 1") đẩy lên label trạng thái
	        posView.setTrangThaiDonHang(" " + command + " ");
	    }else if (command.startsWith("Món: ")) {
            // Cắt chuỗi để lấy tên món
			String tenMon = command.replace("Món: ", "").trim();
            themMonVaoDonHang(tenMon);
		} 
        else if (command.equals("ThanhToan")) {
			xuLyThanhToan();
		}
	}
	
	// Logic xử lý khi click vào 1 món
    private void themMonVaoDonHang(String tenMon) {
        // 1. Gọi DAO lấy giá trị sản phẩm từ Database
        SanPham sp = posDao.getSanPhamByTen(tenMon);
        
        if (sp != null) {
            // 2. Đẩy dữ liệu lên Table (View)
            DefaultTableModel model = posView.getOrderTableModel();
            int soLuong = 1;
            double thanhTien = sp.getGiaBan() * soLuong;
            
            // Xử lý cộng dồn số lượng nếu món đã có trong bảng (tự implement thêm vòng lặp check rows)
            
            model.addRow(new Object[]{sp.getTenSP(), sp.getGiaBan(), soLuong, thanhTien});
        }
    }

    private void xuLyThanhToan() {
        // Lấy dữ liệu từ bảng, gọi posDao.insertHoaDon()...
        System.out.println("Đang lưu hóa đơn xuống Database...");
    }

	
}
