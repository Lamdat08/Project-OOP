package Project_OOP;

import java.util.Scanner;

public class QuanLyNhanVien{
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
        public void Menu(){

        dsnv.Nhap();

        while(true){
            System.out.println("1 - chon xuat");
            System.out.println("2 -  chon sua");
            System.out.println("3 - chon ghi file");
            System.out.println("4 - chon doc file");
            System.out.println("5 - chon tim kiem");
            System.out.println("6 - chon them");
            System.out.println("7 - chon xoa");
            System.out.println("8 - chon thoat");
            int n = Integer.parseInt(sc.nextLine());


            if(n == 1){
                dsnv.Xuat();
            }
            if(n == 2){
                dsnv.Sua();
            }
            if(n == 3){
                dsnv.ghiFile();
            }
            if(n == 4){
                dsnv.docFile();
            }
            if(n == 5){
                dsnv.TimKiem();
            }
            if(n == 6){
                dsnv.Them();
            }
            if(n == 7){
                dsnv.Xoa();
            }
            if(n == 8){
                break;
            }
        }
    }
}
