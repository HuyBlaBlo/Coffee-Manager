package entity;

public class SanPham {
    private String maSP;
    private String tenSP;
    private double giaVon;
    private double giaBan;
    private DanhMuc danhMuc;

    public SanPham() {}

    

    public SanPham(String maSP, String tenSP, double giaVon, double giaBan, DanhMuc danhMuc) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaVon = giaVon;
		this.giaBan = giaBan;
		this.danhMuc = danhMuc;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public double getGiaVon() {
		return giaVon;
	}

	public void setGiaVon(double giaVon) {
		this.giaVon = giaVon;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public DanhMuc getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}

	public double tinhLoiNhuanGop() {
        return this.giaBan - this.giaVon;
    }

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", giaVon=" + giaVon + ", giaBan=" + giaBan + ", danhMuc="
				+ danhMuc + "]";
	}
	

}
