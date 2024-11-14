package Project_OOP;

import java.util.Scanner;

public class QuanLyKhachHang {

    static Scanner sc = new Scanner(System.in);

    public void menuKhachHang() {
        System.out.println("1 - Xuat danh sach khach hang");
        System.out.println("2 - Sua thong tin khach hang");
        System.out.println("3 - Ghi file khach hang");
        System.out.println("4 - Doc file khach hang");
        System.out.println("5 - Tim kiem khach hang");
        System.out.println("6 - Them khach hang");
        System.out.println("7 - Xoa Khach hang");
        System.out.println("8 - Thoat");
    }

    public void menuQuanLyKhachHang() {
        menuKhachHang();
    }
}
