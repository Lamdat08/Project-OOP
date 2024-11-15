package Project_OOP;

import java.util.Scanner;

public class SanPham implements IThaoTac {

    static Scanner sc = new Scanner(System.in);

    private String maSP;
    private String tenSP;
    private int soLuong;
    private double giaTien;
    private double tienVon;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, int soLuong, double giaTien, double tienVon) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.tienVon = tienVon;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public double getTienVon() {
        return tienVon;
    }

    public void setTienVon(double tienVon) {
        this.tienVon = tienVon;
    }

    public void Nhap(){
        System.out.println("Nhập mã sản phẩm: ");
        setMaSP(sc.nextLine());
        System.out.println("Nhập tên sản phẩm: ");
        setTenSP(sc.nextLine());
        System.out.println("Nhập số lượng: ");
        setSoLuong(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhập giá tiền: ");
        setGiaTien(Double.parseDouble(sc.nextLine()));
        System.out.println("Nhập tiền vốn: ");
        setTienVon(Double.parseDouble(sc.nextLine()));
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "Mã Sản Phầm: '" + maSP + '\'' +
                ", Tên Sản Phầm='" + tenSP + '\'' +
                ", Số lương=" + soLuong +
                ", Giá tiền=" + giaTien +
                ", Tiền vốn=" + tienVon +
                '}';
    }
    public void Xuat(){
        System.out.println(toString());
    }

    public void Sua(){
        System.out.println("Nhập mã sản phẩm mới: ");
        this.setMaSP(sc.nextLine());
        System.out.println("Nhập tên sản phẩm mới: ");
        this.setTenSP(sc.nextLine());
        System.out.println("Nhập số lượng mới: ");
        this.setSoLuong(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhập giá tiền mới: ");
        this.setGiaTien(Double.parseDouble(sc.nextLine()));
        System.out.println("Nhập tiền vốn mới: ");
        this.setTienVon(Double.parseDouble(sc.nextLine()));
    }

    public double LoiNhuan(){
        return getGiaTien() - getTienVon();
    }
}
