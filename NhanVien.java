package Project_OOP;

public abstract class NhanVien implements IThaoTac{
    private String maNhanVien;
    private String tenNhanVien;
    private String soDienThoai;
    private String gioiTinh;
    private double luongCoBan;
    private boolean trangThai;



    public double getLuongCoBan(){
        return luongCoBan;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public NhanVien() {
        this.trangThai = true;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVien(String maNhanVien, String tenNhanVien, String soDienThoai, String gioiTinh, double luongCoBan) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.luongCoBan = luongCoBan;
        this.trangThai = true;
    }

    //    public abstract void nhap();
//
//    public abstract void xuat();
//
//    public abstract void sua();
//
//    public abstract double tinhLuong();
//


    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%.2f",maNhanVien,tenNhanVien,soDienThoai,gioiTinh,luongCoBan);
    }
}
