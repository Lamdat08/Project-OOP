package Project_OOP;
import java.util.Scanner;

public class QLCuaHang {
    public static void main(String[] args) {

        QLCuaHang QLCH = new QLCuaHang();
        QLCH.Menu();
    }


    Scanner sc = new Scanner(System.in);
    QuanLySuKien qlsk = new QuanLySuKien();
    QuanLyNhanVien qlnv = new QuanLyNhanVien();
    QuanLySanPham qlsp = new QuanLySanPham();
    QuanLyKhachHang qlkh = new QuanLyKhachHang();
    QuanLyHoaDon qlhd = new QuanLyHoaDon();

    public void Menu()
    {
        while (true)
        {
            int x;
            do {
                System.out.println("1.Quản lý sản phẩm.");
                System.out.println("2.Quản lý hóa đơn.");
                System.out.println("3.Quản lý khách hàng.");
                System.out.println("4.Quản lý nhân viên.");
                System.out.println("5.Quản lý sự kiện.");
                System.out.println("6.Thoát.");
                System.out.printf(" Nhập lựa chọn : ");
                x = sc.nextInt(); sc.nextLine();
                if ( x < 1 || x > 6)
                    System.out.println("Vui lòng nhập lựa chọn từ 1 -> 6 : ");
            } while (x < 1 || x > 6);

                switch (x) {
                    case 1:
                        qlsp.menuQuanLySanPham();
                        break;

                    case 2:
                        qlhd.menu();
                        break;

                    case 3:
                        qlkh.menuQuanLyKhachHang();
                        break;

                    case 4:
                        qlnv.Menu();
                        break;

                    case 5:
                        qlsk.Menu();
                        break;

                    case 6:
                        return;
                }
        }
    }
}
