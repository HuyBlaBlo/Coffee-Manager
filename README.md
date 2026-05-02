# ☕ JavaCoffee POS - Hệ Thống Quản Lý Quán Cà Phê Chuyên Nghiệp

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![SQL Server](https://img.shields.io/badge/SQL_Server-CC2927?style=for-the-badge&logo=microsoft-sql-server&logoColor=white)
![JFreeChart](https://img.shields.io/badge/Library-JFreeChart-blue?style=for-the-badge)

> Dự án phần mềm Quản lý điểm bán hàng (Point of Sale) dành cho mô hình Quán Cà Phê, được xây dựng trên nền tảng Java Swing với kiến trúc MVC chuẩn mực. Tập trung vào trải nghiệm người dùng (UX) hiện đại và khả năng phân tích dữ liệu chuyên sâu.

<div align="center">
  <img src="https://via.placeholder.com/1000x400.png?text=Bỏ+ảnh+Banner+hoặc+Màn+hình+POS+vào+đây" alt="Banner Project" width="100%">
</div>

---

## ✨ Tính Năng Nổi Bật (Key Features)

### 🛒 1. Màn hình Bán hàng (POS) mượt mà
- Giao diện chia khu vực (Bàn/Take-away, Menu, Giỏ hàng) trực quan.
- Thêm/bớt món, tính tiền, áp dụng thuế/giảm giá realtime.
- Tự động cảnh báo khi nhập sai thông tin.

### 📊 2. Dashboard Thống Kê Phân Tích (Drill-down Analytics)
- **Visual Charts:** Tích hợp `JFreeChart` vẽ biểu đồ Cột (Doanh thu) và Tròn (Tỷ trọng sản phẩm).
- **Drill-down:** Tương tác trực tiếp bằng cách Click vào cột biểu đồ để lọc chi tiết hóa đơn và sản phẩm của ngày/tháng đó.
- Tự động tính toán % tăng trưởng so với kỳ trước.

### ⚙️ 3. Tự động Khởi tạo Database (Auto-Migration & Seeding)
- Không cần setup SQL phức tạp! Phần mềm tự động kiểm tra, tạo Database, tạo Bảng và đổ dữ liệu mồi (Seed Data) ngay lần chạy đầu tiên.

### 📄 4. Xuất Báo Cáo Kế Toán (Excel Export)
- Tích hợp `Apache POI` cho phép trích xuất dữ liệu doanh thu và hóa đơn ra file `.xlsx` chuẩn form kế toán chỉ với 1 click.

---

## 📸 Hình Ảnh Giao Diện (Screenshots)

| Màn Hình Đăng Nhập | Màn Hình POS Bán Hàng |
| :---: | :---: |
| <img src="https://via.placeholder.com/400x250.png?text=Ảnh+Màn+Hình+Login" width="100%"> | <img src="https://via.placeholder.com/400x250.png?text=Ảnh+Màn+Hình+POS" width="100%"> |

| Màn Hình Thống Kê (Dashboard) | Quản Lý Thực Đơn / Nhân Sự |
| :---: | :---: |
| <img src="https://via.placeholder.com/400x250.png?text=Ảnh+Màn+Hình+Dashboard" width="100%"> | <img src="https://via.placeholder.com/400x250.png?text=Ảnh+Quản+Lý+CRUD" width="100%"> |

---

## 🛠️ Công Nghệ Sử Dụng (Tech Stack)

* **Ngôn ngữ:** Java (JDK 17+)
* **Giao diện:** Java Swing
* **Cơ sở dữ liệu:** Microsoft SQL Server
* **Kiến trúc:** MVC (Model - View - Controller)
* **Thư viện bên thứ 3:**
  * `jfreechart.jar`: Vẽ biểu đồ thống kê chuyên nghiệp.
  * `jcalendar.jar` (`JDateChooser`): Chọn ngày tháng giao diện UI.
  * `poi.jar` (Apache POI): Xử lý xuất file Excel.
  * `mssql-jdbc.jar`: Driver kết nối SQL Server.

---

## 📂 Cấu Trúc Thư Mục (Project Structure)

Dự án được tổ chức theo kiến trúc MVC phân tách rõ ràng nhiệm vụ:

```text
src/
 ├── com.coffee.dao/          # Truy xuất Database (CRUD, Query)
 ├── com.coffee.entity/       # Các lớp đối tượng (HoaDon, SanPham, NhanVien...)
 ├── com.coffee.ui/           # Chỉ chứa giao diện Swing (View)
 ├── com.coffee.controller/   # Xử lý sự kiện (Listener), điều phối View & DAO
 ├── com.coffee.utils/        # Các hàm dùng chung (JdbcHelper, ExcelHelper, Auth...)
 └── MainApp.java             # Entry point khởi chạy phần mềm
