package Project_OOP;

import java.util.Scanner;

public class QuanLyHoaDon {
    DanhSachHoaDon DShd = new DanhSachHoaDon(); // Danh sách hóa đơn
    Scanner sc = new Scanner(System.in);

    // Constructor
    public QuanLyHoaDon() {
        // Có thể thêm các thao tác khởi tạo nếu cần
    }

    // Menu quản lý hóa đơn
    public void Menu() {
        while (true) {
            System.out.println("\n --------Quản lý danh sách hóa đơn---------");
            System.out.println("1. Đọc file.");
            System.out.println("2. Thống kê từ file.");
            System.out.println("3. Các thao tác khác.");
            System.out.println("4. Thoát.");

            int x;
            do {
                System.out.printf("Nhập lựa chọn: ");
                x = sc.nextInt();
                sc.nextLine();
                if (x < 1 || x > 4)
                    System.out.println("Nhập lựa chọn từ 1->4 !! ");
            } while (x < 1 || x > 4);

            if (x == 1) {
                DShd.docFile(); // Đọc file hóa đơn
            } else if (x == 2) {
                DShd.ThongKe(2); // Thống kê từ file
            } else if (x == 3) {
                // Menu thao tác với hóa đơn
                while (true) {
                    System.out.println("--------Menu các thao tác quản lý hóa đơn--------");
                    System.out.println("1. Xuất danh sách hóa đơn.");
                    System.out.println("2. Thêm hóa đơn vào danh sách.");
                    System.out.println("3. Sửa hóa đơn theo mã.");
                    System.out.println("4. Xóa hóa đơn theo mã.");
                    System.out.println("5. Tìm hóa đơn.");
                    System.out.println("6. Ghi file.");
                    System.out.println("7. Thống kê danh sách đang chỉnh sửa.");
                    System.out.println("8. Thoát.");
                    int c;
                    do {
                        System.out.printf("Nhập lựa chọn: ");
                        c = sc.nextInt();
                        sc.nextLine();
                        if (c < 1 || c > 8)
                            System.out.println("Nhập lựa chọn từ 1->8 !! ");
                    } while (c < 1 || c > 8);

                    if (c == 1) {
                        DShd.Xuat(); // Xuất danh sách hóa đơn
                    } else if (c == 2) {
                        DShd.Them(); // Thêm hóa đơn vào danh sách
                    } else if (c == 3) {
                        DShd.Sua(); // Sửa hóa đơn theo mã
                    } else if (c == 4) {
                        DShd.Xoa(); // Xóa hóa đơn theo mã
                    } else if (c == 5) {
                        DShd.TimKiem(); // Tìm kiếm hóa đơn
                    } else if (c == 6) {
                        DShd.ghiFile(); // Ghi file hóa đơn
                    } else if (c == 7) {
                        DShd.ThongKe(1); // Thống kê danh sách hóa đơn
                    } else {
                        // Lưu ý: Nhớ ghi file trước khi thoát
                        System.out.println("Lưu ý : Nhớ ghi file trước khi thoát !!! ");
                        System.out.println("1. Ghi file rồi thoát.");
                        System.out.println("2. Thoát.");
                        System.out.println("3. Quay trở lại.");
                        int exit;
                        do {
                            System.out.printf("Nhập lựa chọn: ");
                            exit = sc.nextInt();
                            sc.nextLine();
                        } while (exit < 1 || exit > 3);

                        if (exit == 1) {
                            DShd.ghiFile(); // Ghi file rồi thoát
                            break;
                        } else if (exit == 2) {
                            break; // Thoát chương trình
                        } else {
                            System.out.println("\n Quay trở lại \n------------------------------------");
                        }
                    }
                }
            } else {
                return; // Thoát chương trình quản lý hóa đơn
            }
        }
    }
}
