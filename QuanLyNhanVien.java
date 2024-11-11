package Project_OOP;

import java.util.Scanner;

public class QuanLyNhanVien{
    public static void main(String[] args) {
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

        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        NhanVienPartTime []nvpt = new NhanVienPartTime[n];


//        nvpt.Nhap();
//        nvpt.Xuat();
//        nvpt.Sua();
//        nvpt.Xuat();

            DanhSachNhanVien x = new DanhSachNhanVien();
            x.Nhap();
//            x.Them();
//            x.Xuat();
//            x.TimKiem();
//            x.Sua();
            x.Xoa();
            x.Xuat();

    }
}
