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
    public static void menuKhachHang() {
        System.out.println("\n --------Menu các thao tác quản lý danh sách khách hàng---------");
        System.out.println("1 - Xuất danh sách khách hàng đang chỉnh sửa.");
        System.out.println("2 - Thêm khách hàng vào danh sách.");
        System.out.println("3 - Sửa khách hàng theo mã khách hàng.");
        System.out.println("4 - Xóa khách hàng theo mã.");
        System.out.println("5 - Tìm khách hàng.");
        System.out.println("6 - Ghi file.");
        System.out.println("7 - Thống kê danh sách khách hàng.");
        System.out.println("8 - Thoát menu các thao tác quản lý khách hàng.");
    }
    public void menuThoat() {
        System.out.println("Lưu ý: Nhớ ghi file !");
        System.out.println("1 - Ghi file rồi thoát.");
        System.out.println("2 - Thoát.");
        System.out.println("3 - Quay trở lại.");
    }
    public void menuQuanLyKhachHang() {
        while (true) {
            menuQLKH();
            System.out.println("Nhập lựa chọn: ");
            int luaChon1 = Integer.parseInt(sc.nextLine());
            while (luaChon1 < 1 || luaChon1 > 4) {
                menuQLKH();
                System.out.println("Không có lựa chọn này, vui lòng nhập lại các lựa chọn từ 1 - 4: ");
                luaChon1 = Integer.parseInt(sc.nextLine());
            }
            if (luaChon1 == 1) {
                DanhSachKhachHang.docFile();
            } else if (luaChon1 == 2) {
                dskh.Xuat();
            } else if (luaChon1 == 3) {
                while (true) {
                    menuKhachHang();
                    System.out.println("Nhập lựa chọn: ");
                    int luaChon2 = Integer.parseInt(sc.nextLine());
                    while (luaChon2 < 1 || luaChon2 > 8) {
                        menuKhachHang();
                        System.out.println("Không có lựa chọn này, vui lòng nhập các lựa chọn từ 1 - 10");
                        luaChon2 = Integer.parseInt(sc.nextLine());
                    }

                    if (luaChon2 == 1) {
                        dskh.Xuat();
                    } else if (luaChon2 == 2) {
                        dskh.Them();
                    } else if (luaChon2 == 3) {
                        dskh.Sua();
                    } else if (luaChon2 == 4) {
                        dskh.Xoa();
                    } else if (luaChon2 == 5) {
                        dskh.TimKiem();
                    } else if (luaChon2 == 6) {
                        dskh.ghiFile();
                    } else if (luaChon2 == 7) {
                        dskh.thongKeKhachHang();
                    } else {
                        menuThoat();
                        System.out.println("Nhập lựa chọn: ");
                        int exit = Integer.parseInt(sc.nextLine());
                        while (exit < 1 || exit > 3) {
                            menuThoat();
                            System.out.println("Không có lựa chọn này, vui lòng nhập lựa chọn từ 1 - 3: ");
                            exit = Integer.parseInt(sc.nextLine());
                        }

                        if (exit == 1) {
                            dskh.ghiFile();
                            System.out.println("Thoát menu các thao tác quản lý khách hàng.");
                            break;
                        } else if (exit == 2) {
                            System.out.println("Thoát menu các thao tác quản lý khách hàng.");
                            break;
                        } else {
                            System.out.println("\n Quay trờ lại \n------------------------------------");
                        }
                    }
                }
            } else {
                System.out.println("Thoát quản lý danh sách khách hàng.");
                return;
            }
        }
    }
}
