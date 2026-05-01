package entity;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private String chucVu;
    private String caLamViec;
    private String soDienThoai;
    private TaiKhoan maTK;

    public NhanVien() {}

	public NhanVien(String maNV, String tenNV, String chucVu, String caLamViec, String soDienThoai, TaiKhoan maTK) {
		
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.chucVu = chucVu;
		this.caLamViec = caLamViec;
		this.soDienThoai = soDienThoai;
		this.maTK = maTK;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getCaLamViec() {
		return caLamViec;
	}

	public void setCaLamViec(String caLamViec) {
		this.caLamViec = caLamViec;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public TaiKhoan getMaTK() {
		return maTK;
	}

	public void setMaTK(TaiKhoan maTK) {
		this.maTK = maTK;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", chucVu=" + chucVu + ", caLamViec=" + caLamViec
				+ ", soDienThoai=" + soDienThoai + ", maTK=" + maTK + "]";
	}


	

    
}
