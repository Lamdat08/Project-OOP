package Project_OOP;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLySuKien qlsk = new QuanLySuKien();
        QuanLyNhanVien qlnv = new QuanLyNhanVien();
        QuanLySanPham qlsp = new QuanLySanPham();

        int x;
        do {
            System.out.println("1.Quản lý sản phẩm.");
            System.out.println("2.Quản lý hóa đơn.");
            System.out.println("3.Quản lý khách hàng.");
            System.out.println("4.Quản lý nhân viên.");
            System.out.println("5.Quản lý sự kiện.");
            System.out.println("6.Thoát.");
            System.out.printf("Nhập lựa chọn : ");
            x = sc.nextInt(); sc.nextLine();

            if ( x < 1 || x > 6)
                System.out.println("Vui lòng nhập lựa chọn từ 1 -> 6");
        }
        while (x < 1 || x > 6);

        switch (x){
            case 1 :
                qlsp.menuQuanLySanPham();
                break;

            case 2 :
                System.out.println("sắp xong roif");
                break;

            case 3 :
                System.out.println("sắp xong nốt");
                break;

            case 4 :
                //qlnv.Menu();    // Tạo phương thức Menu trong QLNV đê :D
                break;

            case 5 :
                qlsk.Menu();
                break;
        }
    }
}
