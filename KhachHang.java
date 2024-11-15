package Project_OOP;

import java.util.Scanner;

public class KhachHang implements IThaoTac {

    static Scanner sc = new Scanner(System.in);

    private String maKH;
    private String tenKH;
    private String SDT;
    private String diaChi;
    private String gioiTinh;

    public KhachHang() {

    }

    public KhachHang(String maKH, String tenKH, String SDT, String diaChi, String gioiTinh) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void Nhap() {
        System.out.println("Nhập mã khách hàng: ");
        setMaKH(sc.nextLine());
        System.out.println("Nhập tên khách hàng: ");
        setTenKH(sc.nextLine());
        System.out.println("Nhập số điện thoại khách hàng: ");
        setSDT(sc.nextLine());
        System.out.println("Nhập đia chỉ khách hàng: ");
        setDiaChi(sc.nextLine());
        System.out.println("Nhập giới tính khách hàng: ");
        setGioiTinh(sc.nextLine());
    }

    @Override
    public String toString() {
        return "ThanhVien{" +
                "maKH='" + maKH + '\'' +
                ", tenKH='" + tenKH + '\'' +
                ", SDT='" + SDT + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                '}';
    }

    public void Xuat() {
        System.out.println(toString());
    }

    public void Sua() {
        System.out.println("Nhập mã khách hàng mới: ");
        this.setMaKH(sc.nextLine());
        System.out.println("Nhập tên khách hàng mới: ");
        this.setTenKH(sc.nextLine());
        System.out.println("Nhập số điện thoại mới: ");
        this.setSDT(sc.nextLine());
        System.out.println("Nhập địa chỉ mới: ");
        this.setDiaChi(sc.nextLine());
        System.out.println("Nhập giới tính: ");
        this.setGioiTinh(sc.nextLine());
    }
}
