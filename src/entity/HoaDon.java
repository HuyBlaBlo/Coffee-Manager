package entity;

import java.util.Date;

public class HoaDon {
    private String maHD;
    private Date thoiGianTao;
    private String ban;
    private String maNV;
    private String phuongThucTT;
    private String trangThai;
    private double tongTien;

    public HoaDon() {}

    public HoaDon(String maHD, Date thoiGianTao, String ban, String maNV, String phuongThucTT, String trangThai, double tongTien) {
        this.maHD = maHD;
        this.thoiGianTao = thoiGianTao;
        this.ban = ban;
        this.maNV = maNV;
        this.phuongThucTT = phuongThucTT;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
    }

    public String getMaHD() { return maHD; }
    public void setMaHD(String maHD) { this.maHD = maHD; }
    public Date getThoiGianTao() { return thoiGianTao; }
    public void setThoiGianTao(Date thoiGianTao) { this.thoiGianTao = thoiGianTao; }
    public String getBan() { return ban; }
    public void setBan(String ban) { this.ban = ban; }
    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }
    public String getPhuongThucTT() { return phuongThucTT; }
    public void setPhuongThucTT(String phuongThucTT) { this.phuongThucTT = phuongThucTT; }
    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }
}