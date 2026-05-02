package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import dao.Pos_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
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
		}else if (command.equals("ThanhToan")) {
			xuLyThanhToan();
		}else if(command.equals("Xoa")) {
			xuLyXoaMon();
		}
	}
	
	// --- THÊM HÀM XỬ LÝ XÓA MÓN ---
    private void xuLyXoaMon() {
        int selectedRow = posView.getTblOrder().getSelectedRow();
        if (selectedRow != -1) {
            posView.getOrderTableModel().removeRow(selectedRow);
            capNhatTongTien(); // Cập nhật lại tổng tiền sau khi xóa
        } else {
            JOptionPane.showMessageDialog(posView, "Vui lòng chọn một món trong đơn hàng để xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }
	
	// Logic xử lý khi click vào 1 món
	private void themMonVaoDonHang(String tenMon) {
	    SanPham sp = posDao.getSanPhamByTen(tenMon);
	    
	    if (sp != null) {
	        DefaultTableModel model = posView.getOrderTableModel();
	        int rowCount = model.getRowCount();
	        boolean daTonTai = false;
	        
	        // 1. Kiểm tra xem món đã có trong bảng chưa
	        for (int i = 0; i < rowCount; i++) {
	            String tenMonTrongBang = (String) model.getValueAt(i, 0);
	            if (tenMonTrongBang.equals(sp.getTenSP())) {
	                // Nếu có, tăng số lượng và cập nhật thành tiền
	                int soLuongCu = (int) model.getValueAt(i, 2);
	                int soLuongMoi = soLuongCu + 1;
	                double thanhTienMoi = sp.getGiaBan() * soLuongMoi;
	                
	                model.setValueAt(soLuongMoi, i, 2);
	                model.setValueAt(thanhTienMoi, i, 3);
	                daTonTai = true;
	                break;
	            }
	        }
	        
	        // 2. Nếu món chưa có, thêm một dòng mới
	        if (!daTonTai) {
	            model.addRow(new Object[]{sp.getTenSP(), sp.getGiaBan(), 1, sp.getGiaBan()});
	        }
	        
	        // 3. Cập nhật lại tổng tiền trên giao diện
	        capNhatTongTien();
	    }else {
	        // Thêm dòng này để nếu click không lên thì nhìn xuống Console sẽ biết ngay lỗi do tên món sai
	        System.out.println("Lỗi: Không tìm thấy món '" + tenMon + "' trong Database. Hãy kiểm tra lại bảng SanPham!");
	    }
	}
	
	// Hàm tính tổng tiền từ các dòng trong JTable
	private void capNhatTongTien() {
	    DefaultTableModel model = posView.getOrderTableModel();
	    double tongTien = 0;
	    for (int i = 0; i < model.getRowCount(); i++) {
	        tongTien += (double) model.getValueAt(i, 3);
	    }
	    posView.setTongTien(tongTien);
	}

	private void xuLyThanhToan() {
	    DefaultTableModel model = posView.getOrderTableModel();
	    
	    // 1. Validate: Kiểm tra giỏ hàng rỗng
	    if (model.getRowCount() == 0) {
	        JOptionPane.showMessageDialog(posView, "Chưa có món nào để thanh toán!", "Lỗi", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    String trangThaiBan = posView.getLblStatusOrder().getText().trim();
	    if (trangThaiBan.equals("Chưa chọn bàn!")) {
	        JOptionPane.showMessageDialog(posView, "Vui lòng chọn bàn hoặc 'Mang đi' trước khi thanh toán!", "Lỗi", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    // 2. Tính tổng tiền và chuẩn bị dữ liệu
	    double tongTien = 0;
	    for (int i = 0; i < model.getRowCount(); i++) {
	    	tongTien += Double.parseDouble(model.getValueAt(i, 3).toString());
	    }

	    /* 
	     * 3. GỌI DAO ĐỂ LƯU XUỐNG DATABASE Ở ĐÂY
	     * 
	     * HoaDon hd = new HoaDon("HD" + System.currentTimeMillis(), new Date(), trangThaiBan, null, "Tiền mặt", "Đã thanh toán", tongTien);
	     * List<ChiTietHoaDon> dsCTHD = new ArrayList<>();
	     * // Lặp qua model để tạo dsCTHD...
	     * boolean isSuccess = posDao.insertThanhToan(hd, dsCTHD);
	     * if (!isSuccess) return; // Nếu lỗi DB thì ngừng lại
	     */
	    
	 // 3. Khởi tạo đối tượng HoaDon
	    // Cắt chuỗi tạo mã hóa đơn ngẫu nhiên (VD: HD1683021) đảm bảo vừa với VARCHAR(20)
	    String maHD = "HD" + (System.currentTimeMillis() % 1000000000); 
	    Date thoiGianTao = new Date();
	    String phuongThucTT = "Tiền mặt"; // Có thể nâng cấp bắt sự kiện nút thanh toán sau
	    String trangThai = "Đã thanh toán";
	    
	    // Tạo HoaDon (Mã NV tạm thời để null, sẽ nối với Session Login sau)
	    HoaDon hd = new HoaDon(maHD, thoiGianTao, trangThaiBan, null, phuongThucTT, trangThai, tongTien);

	    // 4. Khởi tạo danh sách ChiTietHoaDon
	    List<ChiTietHoaDon> dsCTHD = new ArrayList<>();
	    for (int i = 0; i < model.getRowCount(); i++) {
	        String tenMon = model.getValueAt(i, 0).toString();
	        int soLuong = Integer.parseInt(model.getValueAt(i, 2).toString());
	        double giaBan = Double.parseDouble(model.getValueAt(i, 1).toString());

	        // Lấy SanPham từ CSDL để có được MaSP và GiaVon
	        SanPham sp = posDao.getSanPhamByTen(tenMon);

	        if (sp != null) {
	            ChiTietHoaDon cthd = new ChiTietHoaDon(hd, sp, soLuong, giaBan, sp.getGiaVon());
	            dsCTHD.add(cthd);
	        }
	    }

	 // 5. Đẩy xuống Database thông qua DAO
	    boolean isSuccess = posDao.insertThanhToan(hd, dsCTHD);

	    if (isSuccess) {
	        JOptionPane.showMessageDialog(posView, "Thanh toán thành công!\nMã HD: " + maHD, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        
	        // Gọi màn hình in Bill ở đây (nếu có)
	        // BillDialog bill = new BillDialog(...);

	        // 6. Reset màn hình POS
	        model.setRowCount(0);
	        posView.setTongTien(0);
	        posView.setTrangThaiDonHang(" Chưa chọn bàn! ");
	    } else {
	        JOptionPane.showMessageDialog(posView, "Lỗi khi lưu Database. Vui lòng kiểm tra lại kết nối!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}

	
}
