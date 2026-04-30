package entity;

public class ChiTietHoaDon {
    private String maHD;
    private int maSP;
    private int soLuong;
    private double giaBanHienTai;
    private double giaVonHienTai;

    public ChiTietHoaDon() {}

    public ChiTietHoaDon(String maHD, int maSP, int soLuong, double giaBanHienTai, double giaVonHienTai) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.giaBanHienTai = giaBanHienTai;
        this.giaVonHienTai = giaVonHienTai;
    }

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBanHienTai() {
		return giaBanHienTai;
	}

	public void setGiaBanHienTai(double giaBanHienTai) {
		this.giaBanHienTai = giaBanHienTai;
	}

	public double getGiaVonHienTai() {
		return giaVonHienTai;
	}

	public void setGiaVonHienTai(double giaVonHienTai) {
		this.giaVonHienTai = giaVonHienTai;
	}

    
}