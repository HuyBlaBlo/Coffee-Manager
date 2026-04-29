package entity;

public class TaiKhoan {
	private String maTK;
	private String tenDangNhap;
	private String matKhau;
	
	public TaiKhoan() {
		
	}

	public TaiKhoan(String maTK) {
		super();
		this.maTK = maTK;
	}
	

	public TaiKhoan(String maTK, String tenDangNhap, String matKhau) {
		this.maTK = maTK;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}

	public String getMaTK() {
		return maTK;
	}

	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	

}
