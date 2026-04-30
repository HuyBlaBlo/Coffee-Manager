-- Tao co so du lieu QLQuanCF
create database QLQuanCF
on primary
(
	name = "QLQuanCF_data",
	filename = "D:\HCSDL\QLQuanCF\QLQuanCF_data.mdf",
	size = 40,
	maxsize = 80,
	filegrowth = 1
)

log on
(
	name = "QLQuanCF_log",
	filename = "D:\HCSDL\QLQuanCF\QLQuanCF_data.ldf",
	size = 9,
	maxsize = 12,
	filegrowth = 1
)

--Tao bang va moi quan he giua cac bang
use QLQuanCF
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

