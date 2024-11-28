package Project_OOP;

import java.util.Scanner;

public class QuanLyNhanVien {
//    public static void main(String[] args) {
//       NhanVienPartTime nvpt = new NhanVienPartTime();
//       nvpt.nhap();
//       nvpt.xuat();

//        QuanLy ql = new QuanLy();
//        ql.nhap();
//        ql.xuat();
//
//        ql.sua();
//
//        ql.xuat();

//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        NhanVienPartTime []nvpt = new NhanVienPartTime[n];


//        nvpt.Nhap();
//        nvpt.Xuat();
//        nvpt.Sua();
//        nvpt.Xuat();

//            DanhSachNhanVien x = new DanhSachNhanVien();
//            x.Nhap();
//            x.Them();
//            x.Xuat();
//            x.TimKiem();
//            x.Sua();
//            x.Xoa();
//            x.Xuat();
//            x.Nhap();
//            x.ghiFile();
//            x.docFile();


    Scanner sc = new Scanner(System.in);
    DanhSachNhanVien dsnv = new DanhSachNhanVien();

    public void Menu() {


        while (true) {

            System.out.println("1 - Chọn xuất");
            System.out.println("2 - Chọn sửa");
            System.out.println("3 - Chọn ghi file");
            System.out.println("4 - Chọn đọc file");
            System.out.println("5 - Chọn tìm kiếm");
            System.out.println("6 - Chọn thêm");
            System.out.println("7 - Chọn xóa");
            System.out.println("8 - Thống kê");
            System.out.println("9 - Chọn thoát");
            int n=0;
            boolean validInput2= false;
            while (!validInput2)
            {
                try {
                    System.out.printf("Nhập lựa chọn : ");
                    n = Integer.parseInt(sc.nextLine());

                    if ( n < 1 || n > 9) {
                        validInput2 = false;
                        System.out.println("Nhập số từ 1 đến 9");
                    }
                    else
                        validInput2 = true;
                } catch (Exception e) {
//                    System.out.println(e);
                    System.out.println("Chỉ nhập số");
                }
            }

            if (n == 1) {
                dsnv.Xuat();
            }
            if (n == 2) {
                dsnv.Sua();
            }
            if (n == 3) {
                dsnv.ghiFile();
            }
            if (n == 4) {
                dsnv.docFile();
            }
            if (n == 5) {
                dsnv.TimKiem();
            }
            if (n == 6) {
                dsnv.Them();
            }
            if (n == 7) {
                dsnv.Xoa();
            }
            if (n == 8) {
                dsnv.thongKe();
            }
            if (n == 9) {
                break;
            }
        }
    }
}
