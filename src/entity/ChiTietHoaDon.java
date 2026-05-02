package entity;

public class ChiTietHoaDon {
	private HoaDon hoaDon; 
	private SanPham sanPham;
	private int soLuong;
    private double giaBanHienTai;
    private double giaVonHienTai;

    public ChiTietHoaDon() {}

    

	public ChiTietHoaDon(HoaDon hoaDon, SanPham sanPham, int soLuong, double giaBanHienTai, double giaVonHienTai) {
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.giaBanHienTai = giaBanHienTai;
		this.giaVonHienTai = giaVonHienTai;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
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



	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", sanPham=" + sanPham + ", soLuong=" + soLuong + ", giaBanHienTai="
				+ giaBanHienTai + ", giaVonHienTai=" + giaVonHienTai + "]";
	}

	
	
    
}