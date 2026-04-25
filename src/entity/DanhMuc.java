package entity;

public class DanhMuc {
    private int maDM;
    private String tenDM;

    public DanhMuc() {}

    public DanhMuc(int maDM, String tenDM) {
        this.maDM = maDM;
        this.tenDM = tenDM;
    }

    public int getMaDM() { return maDM; }
    public void setMaDM(int maDM) { this.maDM = maDM; }
    public String getTenDM() { return tenDM; }
    public void setTenDM(String tenDM) { this.tenDM = tenDM; }

    @Override
    public String toString() {
        return this.tenDM;
    }
}
