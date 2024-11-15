package Project_OOP;

import java.util.Scanner;

public class ThanhVien extends KhachHang {

    private int diemTichLuy;

    public ThanhVien() {

    }

    public ThanhVien(String maKH, String tenKH, String SDT, String diaChi, String gioiTinh, int DiemTichLuy) {
        super(maKH, tenKH, SDT, diaChi, gioiTinh);
        this.diemTichLuy = DiemTichLuy;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    @Override
    public void Nhap() {
        super.Nhap();
        System.out.println("Nhập điểm tích lũy: ");
        setDiemTichLuy(Integer.parseInt(sc.nextLine()));
    }

    @Override
    public String toString() {
        return super.toString() + "ThanhVien{" +
                "diemTichLuy=" + diemTichLuy +
                '}';
    }

    @Override
    public void Xuat() {
        System.out.println(toString());
    }

    @Override
    public void Sua() {
        super.Sua();
        System.out.println("Nhap diem tich luy moi: ");
        this.setDiemTichLuy(Integer.parseInt(sc.nextLine()));
    }

    public String rank() {
        if (getDiemTichLuy() >= 20)
            return "Gold";
        else if (getDiemTichLuy() >= 10)
            return "Silver";
        else
            return "Bronze";
    }
}
