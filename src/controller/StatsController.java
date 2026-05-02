package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import dao.Stats_DAO;
import ui.Stats;

// IMPLEMENTS TRỰC TIẾP ACTIONLISTENER VÀO CLASS
public class StatsController implements ActionListener {
    private Stats view;
    private Stats_DAO dao;
    
    public StatsController(Stats view, Stats_DAO dao) {
        this.view = view;
        this.dao = dao;
        
        initEvents();
        
        // Mặc định giả lập một cú click vào nút "Hôm nay" khi vừa mở form
        actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "TODAY"));
    }

    private void initEvents() {
        // Truyền chính class này (this) làm người lắng nghe sự kiện
        view.addTabListener(this);
    }

    // ====================================================================
    // TẤT CẢ SỰ KIỆN NÚT BẤM ĐỀU CHẢY VỀ HÀM NÀY
    // ====================================================================
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // Lấy thẻ tên của nút vừa bị bấm
        
        Date start = null;
        Date end = null;
        boolean isToday = false;

        // 1. NẾU NÚT BỊ BẤM LÀ NÚT LỌC
        if ("FILTER".equals(command)) {
            start = view.getStartDate();
            end = view.getEndDate();
            view.setTabActiveByCommand(null); // Tắt màu các tab
            
            if (start != null && end != null) {
                isToday = isSameDay(start, end);
            } else {
                return; // Chưa chọn đủ ngày thì kết thúc, không làm gì cả
            }
        } 
        // 2. NẾU NÚT BỊ BẤM LÀ CÁC TAB 7 NGÀY, THÁNG, NĂM...
        else {
            Calendar cal = Calendar.getInstance();
            end = cal.getTime();
            
            int daysAgo = 0;
            switch (command) {
                case "TODAY": daysAgo = 0; isToday = true; break;
                case "WEEK": daysAgo = 6; break;
                case "MONTH": daysAgo = 29; break;
                case "YEAR": daysAgo = 364; break;
                default: return; // Nếu command lạ thì thoát
            }
            
            cal.add(Calendar.DAY_OF_MONTH, -daysAgo);
            start = cal.getTime();

            // Cập nhật lại UI
            view.setDateRange(start, end);
            view.setTabActiveByCommand(command);
        }

        // 3. ĐI CHỢ LẤY DATA VÀ BẢO VIEW VẼ BIỂU ĐỒ
        executeDataUpdate(start, end, isToday);
    }

    private void executeDataUpdate(Date start, Date end, boolean isToday) {
        // Gọi DAO
        double[] kpis = dao.getKPIs(start, end);
        Map<String, Integer> productSales = dao.getProductSalesByRange(start, end);
        Map<java.sql.Date, Double> revenueData = dao.getRevenueByRange(start, end);

        // Bơm data cho View
        view.updateCharts(kpis, productSales, revenueData, isToday);
    }

    // Hàm tiện ích check cùng ngày
    private boolean isSameDay(Date d1, Date d2) {
        Calendar cal1 = Calendar.getInstance(); cal1.setTime(d1);
        Calendar cal2 = Calendar.getInstance(); cal2.setTime(d2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
               cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }
}