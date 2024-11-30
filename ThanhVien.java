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

    public void menuSuaThanhVien() {
        System.out.println("Chọn thông tin cần sửa: ");
        System.out.println("1 - Sửa điểm tích lũy.");
        System.out.println("2 - Sửa thông tin khác của khách hàng.");
        System.out.println("3 - Thoát sửa điểm tích lũy.");
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        while (diemTichLuy < 0) {
            System.out.println("Điểm tích lũy không hợp lệ (phải >= 0). Vui lòng nhập lại: ");
            try {
                diemTichLuy = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ!");
            }
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
        return super.toString() + String.format(";%d;%s", getDiemTichLuy(), rank());
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println("Điểm tích lũy: " + getDiemTichLuy());
    }

    @Override
    public void Sua() {
        while (true) {
            int luaChon;
            while (true) {
                try {
                    menuSuaThanhVien();
                    System.out.println("Nhập lựa chọn sửa thành viên: ");
                    luaChon = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại: ");
                }
            }
            String inputLuaChon = Integer.toString(luaChon);
            String regex = "^[1-3]$";
            while (!inputLuaChon.matches(regex)) {
                menuSuaThanhVien();
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại: ");
                luaChon = Integer.parseInt(sc.nextLine());
            }
            switch (luaChon) {
                case 1:
                    System.out.println("Nhập điểm tích lũy mới: ");
                    setDiemTichLuy(Integer.parseInt(sc.nextLine()));
                    break;
                case 2:
                    super.Sua();
                    break;
                case 3:
                    System.out.println("Thoát sửa điểm tích lũy.");
                    return;
            }
        }
    }
}
