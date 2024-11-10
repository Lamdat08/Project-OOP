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
        System.out.println("Nhap ma san pham: ");
        setMaSP(sc.nextLine());
        System.out.println("Nhap ten san pham: ");
        setTenSP(sc.nextLine());
        System.out.println("Nhap so luong: ");
        setSoLuong(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap gia tien: ");
        setGiaTien(Double.parseDouble(sc.nextLine()));
        System.out.println("Nhap tien von: ");
        setTienVon(Double.parseDouble(sc.nextLine()));
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSP='" + maSP + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", soLuong=" + soLuong +
                ", giaTien=" + giaTien +
                ", tienVon=" + tienVon +
                '}';
    }
    public void Xuat(){
        System.out.println(toString());
    }

    public void Sua(){
        System.out.println("Nhap ma san pham moi: ");
        this.setMaSP(sc.nextLine());
        System.out.println("Nhap ten san pham moi: ");
        this.setTenSP(sc.nextLine());
        System.out.println("Nhap so luong moi: ");
        this.setSoLuong(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap gia tien moi: ");
        this.setGiaTien(Double.parseDouble(sc.nextLine()));
        System.out.println("Nhap tien von moi: ");
        this.setTienVon(Double.parseDouble(sc.nextLine()));
    }

    public double LoiNhuan(){
        return getGiaTien() - getTienVon();
    }
}
