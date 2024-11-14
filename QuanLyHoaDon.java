package Project_OOP;

import java.util.Scanner;

public class QuanLyHoaDon {

    static Scanner sc = new Scanner(System.in);
    private DanhSachHoaDon danhSachHoaDon;  // Thuộc tính là đối tượng DanhSachHoaDon

    // Constructor để khởi tạo DanhSachHoaDon
    public QuanLyHoaDon() {
        this.danhSachHoaDon = new DanhSachHoaDon();  // Khởi tạo DanhSachHoaDon
    }

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
        danhSachHoaDon.Nhap();  // Nhập danh sách hóa đơn từ người dùng

        while (true) {
            menuHoaDon(); // Hiển thị menu
            System.out.print("Chọn chức năng: ");
            int luaChon = Integer.parseInt(sc.nextLine()); // Lấy lựa chọn từ người dùng

            // Kiểm tra lựa chọn hợp lệ
            while (luaChon < 1 || luaChon > 8) {
                menuHoaDon(); // Nếu lựa chọn không hợp lệ, hiển thị lại menu
                System.out.print("Không có lựa chọn này, vui lòng nhập lại: ");
                luaChon = Integer.parseInt(sc.nextLine());
            }

            // Các lựa chọn xử lý các chức năng tương ứng
            if (luaChon == 1) {
                danhSachHoaDon.Xuat(); // Xuất danh sách hóa đơn
            }
            if (luaChon == 2) {
                danhSachHoaDon.Sua(); // Sửa hóa đơn
            }
            if (luaChon == 3) {
                danhSachHoaDon.ghiFile(); // Ghi danh sách hóa đơn vào file
            }
            if (luaChon == 4) {
                danhSachHoaDon.docFile(); // Đọc danh sách hóa đơn từ file
            }
            if (luaChon == 5) {
                danhSachHoaDon.TimKiem(); // Tìm kiếm hóa đơn
            }
            if (luaChon == 6) {
                danhSachHoaDon.Them(); // Thêm hóa đơn
            }
            if (luaChon == 7) {
                danhSachHoaDon.Xoa(); // Xóa hóa đơn
            }
            if (luaChon == 8) {
                System.out.println("Thoát chương trình...");
                break; // Thoát khỏi vòng lặp và kết thúc chương trình
            }
        }
    }
}
