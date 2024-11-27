package Project_OOP;

import java.util.Scanner;

public class QuanLyHoaDon {

    private DanhSachHoaDon DShd = new DanhSachHoaDon();  // Đối tượng DanhSachHoaDon


    // Phương thức khởi tạo
//     public QuanLyHoaDon() {
//         DShd = new DanhSachHoaDon(dssp, dskh);  // Khởi tạo đối tượng DanhSachHoaDon
//     }
   public QuanLyHoaDon() {

    }

    // Phương thức hiển thị menu cho người dùng
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int luaChon;

        do {
            System.out.println("\n---------QUẢN LÝ HÓA ĐƠN---------");
            System.out.println("1. Nhập danh sách hóa đơn từ file");
            System.out.println("2. Thêm hóa đơn");
            System.out.println("3. Sửa hóa đơn");
            System.out.println("4. Xóa hóa đơn");
            System.out.println("5. Tìm kiếm hóa đơn");
            System.out.println("6. Xuất danh sách hóa đơn");
            System.out.println("7. Thống kê hóa đơn");
            System.out.println("8. Đọc và xuất file HoaDon.txt");
            System.out.println("9. Ghi file HoaDon.txt");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng (0-9): ");
            luaChon = Integer.parseInt(sc.nextLine());

            switch (luaChon) {
                case 1:
                    DShd.Nhap();  // Nhập danh sách hóa đơn từ file
                    break;
                case 2:
                    DShd.Them();  // Thêm hóa đơn
                    break;
                case 3:
                    DShd.Sua();  // Sửa hóa đơn
                    break;
                case 4:
                    DShd.Xoa();  // Xóa hóa đơn
                    break;
                case 5:
                    DShd.TimKiem();  // Tìm kiếm hóa đơn
                    break;
                case 6:
                    DShd.Xuat();  // Xuất danh sách hóa đơn
                    break;
                case 7:
                    DShd.ThongKe(1);  // Thống kê hóa đơn
                    break;
                case 8:
                    DShd.docFile();  // Đọc và xuất file HoaDon.txt
                    break;
                case 9:
                    DShd.ghiFile();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }

        } while (luaChon != 0);
    }
}
