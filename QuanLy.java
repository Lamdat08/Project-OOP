package Project_OOP;

import java.util.Scanner;

public class QuanLy extends NhanVien {

    private double phuCap;

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }

    public QuanLy() {

    }

    public QuanLy(String maNhanVien, String tenNhanVien, String soDienThoai, String gioiTinh, double luongCoBan, double phuCap) {
        super(maNhanVien, tenNhanVien, soDienThoai, gioiTinh, luongCoBan);
        this.phuCap = phuCap;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        String maql;
        do {
            System.out.println("Nhập mã Quản lý và mã quản lý phải bắt đầu với QL");
            maql = sc.nextLine();
        } while (!maql.startsWith("QL"));
        setMaNhanVien(maql);
        System.out.println("Nhập tên quản lý");
        setTenNhanVien(sc.nextLine());
        System.out.println("Nhập số điện thoại quản lý");
        setSoDienThoai(sc.nextLine());
        System.out.println("Nhập giới tính");
        setGioiTinh(sc.nextLine());
        System.out.println("Nhập lương cơ bản");
        setLuongCoBan(Double.parseDouble(sc.nextLine()));
        System.out.println("Nhập phụ cấp");
        setPhuCap(Double.parseDouble(sc.nextLine()));
    }

    public void Xuat() {
        System.out.println("Mã quản lý : " + getMaNhanVien());
        System.out.println("Tên Nhân Viên : " + getTenNhanVien());
        System.out.println("Số điện thoại : " + getSoDienThoai());
        System.out.println("Giới tính : " + getGioiTinh());
        System.out.println("Lương cơ bản : " + getLuongCoBan());
        System.out.println("Phụ cấp : " + getPhuCap());
        System.out.println("Tổng lương : " + tinhLuong());
    }

    public void Sua() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông tin muốn sửa");

        while (true) {
            System.out.println("1 - Mã Quản lý");
            System.out.println("2 - Tên Nhân Viên");
            System.out.println("3 - Số Điện Thoại");
            System.out.println("4 - Giới Tính");
            System.out.println("5 - Lương Cơ Bản");
            System.out.println("6 - Phụ Cấp");
            System.out.println("7 - Thoát");

            int n = Integer.parseInt(sc.nextLine());
            if (n == 1) {
                System.out.println("Thay đổi mã quản lý thành");
                setMaNhanVien(sc.nextLine());
            }
            if (n == 2) {
                System.out.println("Thay đổi tên quản lý thành");
                setTenNhanVien(sc.nextLine());
            }
            if (n == 3) {
                System.out.println("Thay đổi số điện thoại quản lý thành");
                setSoDienThoai(sc.nextLine());
            }
            if (n == 4) {
                System.out.println("Thay đổi giới tính quản lý thành");
                setGioiTinh(sc.nextLine());
            }
            if (n == 5) {
                System.out.println("Thay đổi lương cơ bản quản lý thành");
                setLuongCoBan(Double.parseDouble(sc.nextLine()));
            }
            if (n == 6) {
                System.out.println("Thay đổi phụ cấp quản lý thành");
                setPhuCap(Double.parseDouble(sc.nextLine()));
            }
            if (n == 7) {
                break;
            }
        }
    }

    public double tinhLuong() {
        return this.phuCap + this.getLuongCoBan();
    }

    @Override
    public String toString() {
        return super.toString() + ";" + String.format("%.2f", phuCap) + ";" + String.format("%.2f", tinhLuong());
    }
}
