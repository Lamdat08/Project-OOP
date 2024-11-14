package Project_OOP;

import java.util.Scanner;

public class KhachHang implements IThaoTac{
    static Scanner sc = new Scanner(System.in);

    private String maKH;
    private String tenKH;
    private String SDT;
    private String diaChi;
    private String gioiTinh;

    public KhachHang() {

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
        System.out.println("Nhap ma khach hang: ");
        setMaKH(sc.nextLine());
        System.out.println("Nhap ten khach hang: ");
        setTenKH(sc.nextLine());
        System.out.println("Nhap so dien thoai khach hang: ");
        setSDT(sc.nextLine());
        System.out.println("Nhap dia chi khach hang: ");
        setDiaChi(sc.nextLine());
        System.out.println("Nhap gioi tinh khach hang: ");
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
        System.out.println("Nhap ma khach hang moi: ");
        this.setMaKH(sc.nextLine());
        System.out.println("Nhap ten khach hang moi: ");
        this.setTenKH(sc.nextLine());
        System.out.println("Nhap so dien thoai moi: ");
        this.setSDT(sc.nextLine());
        System.out.println("Nhap dia chi moi: ");
        this.setDiaChi(sc.nextLine());
        System.out.println("Nhap gioi tinh moi: ");
        this.setGioiTinh(sc.nextLine());
    }
}
