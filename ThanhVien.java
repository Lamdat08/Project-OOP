package Project_OOP;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ThanhVien extends KhachHang {

    private int diemTichLuy;

    public ThanhVien() {
        super();
    }

    public ThanhVien(String maKH, String tenKH, String SDT, String diaChi, String gioiTinh, int DiemTichLuy) {
        super(maKH, tenKH, SDT, diaChi, gioiTinh);
        this.diemTichLuy = DiemTichLuy;
    }

    public void menuSua() {
        System.out.println("Chọn thông tin cần sửa: ");
        System.out.println("0. Sửa điểm tích lũy");
        super.Sua();
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        String inputDiemTichLuy = Integer.toString(diemTichLuy);
        if (inputDiemTichLuy == null || inputDiemTichLuy.trim().isEmpty()) {
            this.diemTichLuy = 0;
            return;
        }
        String regex = "^[0-9]$";
        while (!Pattern.matches(regex, inputDiemTichLuy)) {
            System.out.println("Điểm tích lũy không hợp lệ, vui lòng nhập lại !");
            diemTichLuy = Integer.parseInt(sc.nextLine());
            inputDiemTichLuy = Integer.toString(diemTichLuy);
        }
        this.diemTichLuy = diemTichLuy;
    }

    public String rank() {
        if (getDiemTichLuy() >= 20)
            return "Gold";
        else if (getDiemTichLuy() >= 10)
            return "Silver";
        else
            return "Bronze";
    }

    @Override
    public void Nhap() {
        super.Nhap();
        System.out.println("Nhập điểm tích lũy: ");
        setDiemTichLuy(Integer.parseInt(sc.nextLine()));
    }

    @Override
    public String toString() {
        return super.toString() + String.format(";%d%s", diemTichLuy, rank());
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println("Điểm tích lũy: " + getDiemTichLuy());
    }

    @Override
    public void Sua() {
        super.Sua();
        System.out.println("Nhập điểm tích lũy mới: ");
        this.setDiemTichLuy(Integer.parseInt(sc.nextLine()));
    }

}
