-- Tao co so du lieu QLQuanCF
create database QLQuanCF

on primary
(
	name = QLQuanCF_data,
	filename = 'D:\HCSDL\QLQuanCF\QLQuanCF_data.mdf',
	size = 40,
	maxsize = 80,
	filegrowth = 1
)

log on
(
	name = QLQuanCF_log,
	filename = 'D:\HCSDL\QLQuanCF\QLQuanCF_log.ldf',
	size = 9,
	maxsize = 12,
	filegrowth = 1
)

--Tao bang va moi quan he giua cac bang
GO
use QLQuanCF
GO
create table TaiKhoan
(
	MaTK char(10) not null primary key,
	TenDangNhap nvarchar(40),
	MatKhau nvarchar(20)
)
go

create table NhanSu
(
	MaNhanSu char(10) not null primary key,
	TenNV nvarchar(20) not null,
	ChuVu nvarchar(10),
	CaLamViec nvarchar(50),
	SoDienThoai nvarchar(10),
	MaTK char(10) not null references TaiKhoan(MaTK)
)
go

-- Bảng DanhMuc
CREATE TABLE DanhMuc (
    MaDM VARCHAR(20) NOT NULL PRIMARY KEY,
    TenDM NVARCHAR(50)
)
GO



-- Bảng SanPham
CREATE TABLE SanPham (
    MaSP VARCHAR(20) NOT NULL PRIMARY KEY,
    TenSP NVARCHAR(100),
    GiaVon DECIMAL(18,2),
    GiaBan DECIMAL(18,2),
    MaDM VARCHAR(20) REFERENCES DanhMuc(MaDM)
)
GO

-- Bảng HoaDon
CREATE TABLE HoaDon (
    MaHD VARCHAR(20) NOT NULL PRIMARY KEY,
    ThoiGianTao DATETIME,
    Ban NVARCHAR(50),
    MaNhanSu CHAR(10) REFERENCES NhanSu(MaNhanSu), 
    PhuongThucTT NVARCHAR(50),
    TrangThai NVARCHAR(50),
    TongTien DECIMAL(18,2)
)
GO

-- Bảng ChiTietHoaDon
CREATE TABLE ChiTietHoaDon (
    MaHD VARCHAR(20) NOT NULL REFERENCES HoaDon(MaHD),
    MaSP VARCHAR(20) NOT NULL REFERENCES SanPham(MaSP),
    SoLuong INT,
    GiaBanHienTai DECIMAL(18,2),
    GiaVonHienTai DECIMAL(18,2),
    PRIMARY KEY (MaHD, MaSP) 
)
GO
--====================================================================
--========THÊM DỮ LIỆU==========

-- Them du lieu vao bang
insert into TaiKhoan values('tk1','admin','123456789')
insert into TaiKhoan values('tk2','thungan','234567891')
insert into TaiKhoan values('tk3','phache','345678912')
go

-- chua insert du lieu bangNhanSu
INSERT INTO NhanSu VALUES('NV01', N'Anh Ba Đen', N'Quản lý', N'Hành chính', '0123456789', 'tk1')
INSERT INTO NhanSu VALUES('NV02', N'Bành Thị Bé Bưởi', N'Thu ngân', N'Ca 1', '0987654321', 'tk2')
INSERT INTO NhanSu VALUES('NV03', N'Nguyễn Văn Tí Em', N'Pha chế', N'Ca 1', '0911222333', 'tk3')
go


-- thêm danh mục
INSERT INTO DanhMuc (MaDM, TenDM) VALUES 
('DM01', N'Cà phê'),
('DM02', N'Trà & Matcha'),
('DM03', N'Bánh ngọt');
GO

-- Thêm sản phẩm
INSERT INTO SanPham (MaSP, TenSP, GiaVon, GiaBan, MaDM) VALUES 
('SP01', N'Cà phê đen đá', 10000, 25000, 'DM01'),
('SP02', N'Cà phê sữa đá', 12000, 29000, 'DM01'),
('SP03', N'Bạc xỉu', 15000, 30000, 'DM01'),
('SP04', N'Trà đào', 15000, 35000, 'DM02'),
('SP05', N'Trà vải', 15000, 35000, 'DM02'),
('SP06', N'Matcha Latte', 20000, 45000, 'DM02'),
('SP07', N'Tiramisu', 25000, 40000, 'DM03'),
('SP08', N'Bánh sừng trâu', 15000, 30000, 'DM03'),
('SP09', N'Bánh Donut', 10000, 20000, 'DM03');
GO

-- thêm hó đơn tào lao
INSERT INTO HoaDon (MaHD, ThoiGianTao, Ban, MaNhanSu, PhuongThucTT, TrangThai, TongTien) VALUES
('HD001', '2026-05-03 08:30:00', N'Bàn 01', 'NV02', N'Tiền mặt', N'Đã thanh toán', 55000),
('HD002', '2026-05-03 09:15:00', N'Bàn 02', 'NV02', N'Chuyển khoản', N'Đã thanh toán', 64000),
('HD003', '2026-05-03 14:20:00', N'Bàn 03', 'NV02', N'Tiền mặt', N'Đã thanh toán', 45000),
('HD004', '2026-05-02 10:00:00', N'Bàn 01', 'NV02', N'Tiền mặt', N'Đã thanh toán', 110000),
('HD005', '2026-05-01 19:30:00', N'Bàn 05', 'NV02', N'Chuyển khoản', N'Đã thanh toán', 90000),
('HD006', '2026-04-28 07:45:00', N'Mang đi', 'NV01', N'Tiền mặt', N'Đã thanh toán', 29000),
('HD007', '2026-04-25 15:00:00', N'Bàn 04', 'NV01', N'Chuyển khoản', N'Đã thanh toán', 85000);
GO

-- thêm ch tiết hó đơn
--======ANH EM NÀO THÊM CHI TIẾT HÓA ĐƠN THÌ NHỚ PHẢI ĐÚNG GIÁ VỚI CSAI GIÁ VỐN VÀ GIÁ BÁN CỦA SẢN PHẨM NHA
-- hóa đơn 1
INSERT INTO ChiTietHoaDon (MaHD, MaSP, SoLuong, GiaBanHienTai, GiaVonHienTai) VALUES
('HD001', 'SP01', 1, 25000, 10000),
('HD001', 'SP03', 1, 30000, 15000);

-- Hóa đơn 2
INSERT INTO ChiTietHoaDon (MaHD, MaSP, SoLuong, GiaBanHienTai, GiaVonHienTai) VALUES
('HD002', 'SP02', 1, 29000, 12000),
('HD002', 'SP05', 1, 35000, 15000);

-- Hóa đơn 3
INSERT INTO ChiTietHoaDon (MaHD, MaSP, SoLuong, GiaBanHienTai, GiaVonHienTai) VALUES
('HD003', 'SP06', 1, 45000, 20000);

-- Hóa đơn 4
INSERT INTO ChiTietHoaDon (MaHD, MaSP, SoLuong, GiaBanHienTai, GiaVonHienTai) VALUES
('HD004', 'SP07', 2, 40000, 25000),
('HD004', 'SP03', 1, 30000, 15000);

-- Hóa đơn 5
INSERT INTO ChiTietHoaDon (MaHD, MaSP, SoLuong, GiaBanHienTai, GiaVonHienTai) VALUES
('HD005', 'SP06', 2, 45000, 20000);

-- Hóa đơn 6
INSERT INTO ChiTietHoaDon (MaHD, MaSP, SoLuong, GiaBanHienTai, GiaVonHienTai) VALUES
('HD006', 'SP02', 1, 29000, 12000);

-- Hóa đơn 7
INSERT INTO ChiTietHoaDon (MaHD, MaSP, SoLuong, GiaBanHienTai, GiaVonHienTai) VALUES
('HD007', 'SP05', 1, 35000, 15000),
('HD007', 'SP08', 1, 30000, 15000),
('HD007', 'SP09', 1, 20000, 10000);
GO