-- Tao co so du lieu QLQuanCF
create database QLQuanCF

on primary
(
	name = "QLQuanCF_data",
	filename = 'D:\HCSDL\QLQuanCF\QLQuanCF_data.mdf',
	size = 40,
	maxsize = 80,
	filegrowth = 1
)

log on
(
	name = "QLQuanCF_log",
	filename = 'D:\HCSDL\QLQuanCF\QLQuanCF_data.ldf',
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

create table NhanSu
(
	MaNhanSu char(10) not null primary key,
	TenNV nvarchar(20) not null,
	ChuVu nvarchar(10),
	CaLamViec nvarchar(50),
	SoDienThoai nvarchar(10),
	MaTK char(10) not null references TaiKhoan(MaTK)
)


-- Them du lieu vao bang
select * from TaiKhoan
insert into TaiKhoan values('tk1','admin','123456789')
insert into TaiKhoan values('tk2','thungan','234567891')
insert into TaiKhoan values('tk3','phache','345678912')

-- chua insert du lieu bangNhanSu
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