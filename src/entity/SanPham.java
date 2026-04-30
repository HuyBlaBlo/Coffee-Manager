package entity;

public class SanPham {
    private int maSP;
    private String tenSP;
    private double giaVon;
    private double giaBan;
    private int maDM;

    public SanPham() {}

    public SanPham(int maSP, String tenSP, double giaVon, double giaBan, int maDM) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaVon = giaVon;
        this.giaBan = giaBan;
        this.maDM = maDM;
    }

    public double tinhLoiNhuanGop() {
        return this.giaBan - this.giaVon;
    }

    public int getMaSP() { return maSP; }
    public void setMaSP(int maSP) { this.maSP = maSP; }
    public String getTenSP() { return tenSP; }
    public void setTenSP(String tenSP) { this.tenSP = tenSP; }
    public double getGiaVon() { return giaVon; }
    public void setGiaVon(double giaVon) { this.giaVon = giaVon; }
    public double getGiaBan() { return giaBan; }
    public void setGiaBan(double giaBan) { this.giaBan = giaBan; }
    public int getMaDM() { return maDM; }
    public void setMaDM(int maDM) { this.maDM = maDM; }
    
    @Override
    public String toString() {
        return this.tenSP;
    }
}