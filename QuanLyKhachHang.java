package Project_OOP;

import java.util.Scanner;

public class QuanLyKhachHang {

    static Scanner sc = new Scanner(System.in);

    DanhSachKhachHang dskh = new DanhSachKhachHang();

    public void menuQLKH() {
        System.out.println("\n---------Quản lý danh sách khách hàng---------");
        System.out.println("1 - Đọc file.");
        System.out.println("2 - Thống kê từ file.");
        System.out.println("3 - Các thao tác khác.");
        System.out.println("4 - Thoát quản lý danh sách khách hàng.");
    }

    public void menuKhachHang() {
        System.out.println("\n --------Menu các thao tác quản lý danh sách khách hàng---------");
        System.out.println("1 - Tạo danh sách mới và nhập.");
        System.out.println("2 - Xuất danh sách khách hàng.");
        System.out.println("3 - Thêm khách hàng vào danh sách.");
        System.out.println("4 - Sửa khách hàng theo mã khách hàng.");
        System.out.println("5 - Xóa khách hàng theo mã.");
        System.out.println("6 - Tìm khách hàng.");
        System.out.println("7 - Đọc file.");
        System.out.println("8 - Ghi file.");
        System.out.println("9 - Thống kê danh sách khách hàng");
        System.out.println("10 - Thoát menu các thao tác quản lý khách hàng.\"");
    }

    public void menuThoat() {
        System.out.println("1 - Ghi file rồi thoát.");
        System.out.println("2 - Thoát");
    }

    public void menuQuanLyKhachHang() {
        while (true) {
            menuQLKH();
            System.out.println("Nhập lựa chọn: ");
            int luaChon1 = Integer.parseInt(sc.nextLine());
            while (luaChon1 < 1 || luaChon1 > 4) {
                menuQLKH();
                System.out.println("Không có lựa chọn này, vui lòng nhập lại các lựa chọn từ 1 - 6: ");
                luaChon1 = Integer.parseInt(sc.nextLine());
            }
            switch (luaChon1) {
                case 1:
                    dskh.docFile();
                    break;
                case 2:
                    dskh.Xuat();
                    break;
                case 3:
                    while (true) {
                        menuKhachHang();
                        System.out.println("Nhập lựa chọn: ");
                        int luaChon2 = Integer.parseInt(sc.nextLine());
                        while (luaChon2 < 1 || luaChon2 > 9) {
                            menuQLKH();
                            System.out.println("Không có lựa chọn này, vui lòng nhập các lựa chọn từ 1 - 4");
                            luaChon2 = Integer.parseInt(sc.nextLine());
                        }
                        switch (luaChon2) {
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
                                //Thống kê
                                break;
                            case 10:
                                menuKhachHang();
                                System.out.println("Nhập lựa chọn: ");
                                int exit = Integer.parseInt(sc.nextLine());
                                while (exit < 1 || exit > 2) {
                                    menuQLKH();
                                    System.out.println("Không có lựa chọn này, vui lòng nhập lựa chọn 1 hoặc 2: ");
                                    exit = Integer.parseInt(sc.nextLine());
                                }
                                if (exit == 1) {
                                    dskh.ghiFile();
                                    System.out.println("Thoát menu các thao tác quản lý khách hàng.");
                                    break;
                                }
                                if (exit == 2) {
                                    System.out.println("Thoát menu các thao tác quản lý khách hàng.");
                                    break;
                                }
                        }
                        break;
                    }
                case 4:
                    System.out.println("Thoát quản lý danh sách các sản phẩm.");
                    return;
            }
        }
    }
}
