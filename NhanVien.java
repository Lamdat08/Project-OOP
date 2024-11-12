package Project_OOP;

public abstract class NhanVien implements IThaoTac{
    private String maNhanVien;
    private String tenNhanVien;
    private String soDienThoai;
    private String gioiTinh;
    private double luongCoBan;



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
        return "NhanVien{" +
                "maNhanVien='" + maNhanVien + '\'' +
                ", tenNhanVien='" + tenNhanVien + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", luongCoBan=" + luongCoBan +
                '}';
    }
}
