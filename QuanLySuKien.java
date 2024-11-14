package Project_OOP;

import java.util.Scanner;

public class QuanLySuKien {
    DanhSachSuKien DSsk = new DanhSachSuKien();
    Scanner sc = new Scanner(System.in);

    public void Menu(){
        while (true){
            System.out.println("\n --------Quản lý danh sách sự kiện---------");
            System.out.println("1.Tạo danh sách mới và nhập");
            System.out.println("2.Xuất danh sách.");
            System.out.println("3.Thêm sự kiện vào danh sách.");
            System.out.println("4.Sửa sự kiện theo mã.");
            System.out.println("5.Xóa sự kiện theo mã.");
            System.out.println("6.Tìm sự kiện.");
            System.out.println("7.Đọc file.");
            System.out.println("8.Ghi file.");
            System.out.println("9.Thoát.");
            int c;
            do {
                c = sc.nextInt(); sc.nextLine();
                if( c<1 || c>9)
                    System.out.println("Nhập lựa chọn từ 1->9 !! ");
            }while ( c < 1 || c > 9);

            switch (c)
            {
                case 1:
                    DSsk.Nhap();
                    break;

                case 2:
                    DSsk.Xuat();
                    break;

                case 3:
                    DSsk.Them();
                    break;

                case 4:
                    DSsk.Sua();
                    break;

                case 5:
                    DSsk.Xoa();
                    break;

                case 6 :
                    DSsk.TimKiem();
                    break;

                case 7 :
                    DSsk.docFile();
                    break;

                case 8 :
                    DSsk.ghiFile();
                    break;

                case 9 : return;
            }



        }
    }

}
