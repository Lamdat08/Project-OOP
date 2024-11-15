package Project_OOP;

import java.util.Scanner;

public class QuanLyKhachHang {

    static Scanner sc = new Scanner(System.in);

    DanhSachKhachHang dskh = new DanhSachKhachHang();

    public void menuKhachHang() {
        System.out.println("\n --------Quản lý danh sách khách hàng---------");
        System.out.println("1 - Tạo danh sách mới và nhập.");
        System.out.println("2 - Xuất danh sách khách hàng.");
        System.out.println("3 - Thêm khách hàng vào danh sách.");
        System.out.println("4 - Sửa khách hàng theo mã khách hàng.");
        System.out.println("5 - Xóa khách hàng theo mã.");
        System.out.println("6 - Tìm khách hàng.");
        System.out.println("7 - Đọc file.");
        System.out.println("8 - Ghi file.");
        System.out.println("9 - Thoát.");
    }

    public void menuQuanLyKhachHang() {
        while (true) {
            menuKhachHang();
            System.out.println("Nhập lựa chọn: ");
            int luaChon = Integer.parseInt(sc.nextLine());
            while (luaChon < 1 || luaChon > 9) {
                menuKhachHang();
                System.out.println("Không có lựa chọn này, mời nhập lại: ");
                luaChon = Integer.parseInt(sc.nextLine());
            }
            switch (luaChon) {
                case 1:
                    dskh.Nhap();
                    break;
                case 2:
                    dskh.Xuat();
                    break;
                case 3:
                    dskh.Them();
                    break;
                case 4:
                    dskh.Sua();
                    break;
                case 5:
                    dskh.Xoa();
                    break;
                case 6:
                    dskh.TimKiem();
                    break;
                case 7:
                    dskh.docFile();
                    break;
                case 8:
                    dskh.ghiFile();
                    break;
                case 9:
                    System.out.println("Thoát quản lý khách hàng.");
                    break;
            }
        }
    }
}
