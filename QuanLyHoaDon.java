package Project_OOP;

import java.util.Scanner;

public class QuanLyHoaDon {

    static Scanner sc = new Scanner(System.in);

    // Phương thức hiển thị menu của quản lý hóa đơn
    public void menuHoaDon() {
        System.out.println("1 - Xuất danh sách hóa đơn");
        System.out.println("2 - Sửa hóa đơn");
        System.out.println("3 - Ghi file hóa đơn");
        System.out.println("4 - Đọc file hóa đơn");
        System.out.println("5 - Tìm kiếm hóa đơn");
        System.out.println("6 - Thêm hóa đơn");
        System.out.println("7 - Xóa hóa đơn");
        System.out.println("8 - Thoát");
    }

    // Phương thức để quản lý danh sách hóa đơn
    public void menuQuanLyHoaDon() {
        menuHoaDon(); // Hiển thị menu
        DanhSachHoaDon dshd = new DanhSachHoaDon(); // Tạo đối tượng DanhSachHoaDon
        dshd.Nhap(); // Nhập danh sách hóa đơn

        while (true) {
            int luaChon = Integer.parseInt(sc.nextLine()); // Lấy lựa chọn từ người dùng

            // Kiểm tra lựa chọn hợp lệ
            while (luaChon < 1 || luaChon > 8) {
                menuHoaDon(); // Nếu lựa chọn không hợp lệ, hiển thị lại menu
                System.out.print("Không có lựa chọn này, vui lòng nhập lại: ");
                luaChon = Integer.parseInt(sc.nextLine());
            }

            // Các lựa chọn xử lý các chức năng tương ứng
            if (luaChon == 1) {
                dshd.Xuat(); // Xuất danh sách hóa đơn
            }
            if (luaChon == 2) {
                dshd.Sua(); // Sửa hóa đơn
            }
            if (luaChon == 3) {
                dshd.ghiFile(); // Ghi danh sách hóa đơn vào file
            }
            if (luaChon == 4) {
                dshd.docFile(); // Đọc danh sách hóa đơn từ file
            }
            if (luaChon == 5) {
                dshd.TimKiem(); // Tìm kiếm hóa đơn
            }
            if (luaChon == 6) {
                dshd.Them(); // Thêm hóa đơn
            }
            if (luaChon == 7) {
                dshd.Xoa(); // Xóa hóa đơn
            }
            if (luaChon == 8) {
                break; // Thoát khỏi vòng lặp và kết thúc chương trình
            }
        }
    }
}
