package Project_OOP;

import java.util.Arrays;
import java.util.Scanner;

public class DanhSachNhanVien implements IThaoTac_2{
    Scanner sc = new Scanner(System.in);
    private int soLuongPhanTuThemVao;
    private NhanVien[] arrNhanVien;



    @Override
    public void Xoa() {
        System.out.println("Nhap Ma De Xoa");
        String maXoa = sc.nextLine();
        boolean find = false;
        for(int i = 0;i< arrNhanVien.length;i++){
            if(arrNhanVien[i].getMaNhanVien().equals(maXoa)){
              for(int j = i+1;j<arrNhanVien.length;j++){
                 arrNhanVien[j-1] = arrNhanVien[j];
              }
              find = true;
            }
        }
        if(!find){
            System.out.println("khong tim thay");
        }
        else{
            arrNhanVien = Arrays.copyOf(arrNhanVien,arrNhanVien.length-1);
        }
    }

    @Override
    public void Them() {
        arrNhanVien = Arrays.copyOf(arrNhanVien,arrNhanVien.length+1);
        System.out.println("1-Nhap danh sach nhan vien");
        System.out.println("2-Nhap danh sach quan ly");

        int luaChon;

        do{

            luaChon = Integer.parseInt(sc.nextLine());

        }while(luaChon != 1 && luaChon != 2);

        if(luaChon == 1){
            NhanVienPartTime x = new NhanVienPartTime();
            x.Nhap();
            arrNhanVien[arrNhanVien.length-1] = x;
        }
        if(luaChon == 2){
            QuanLy x = new QuanLy();
            x.Nhap();
            arrNhanVien[arrNhanVien.length-1] = x;
        }

    }

    @Override
    public void TimKiem() {
        while(true){
            System.out.println("1-Tim kiem theo ma");
            System.out.println("2-Tim kiem theo ten");
            System.out.println("3-Tim kiem theo sdt");
            System.out.println("4-Tim kiem theo gioi tinh");
            System.out.println("5-Tim kiem luong co ban");

            int n = Integer.parseInt(sc.nextLine());

            if(n == 1){
                System.out.println("Nhap ma de tim kiem theo ma");
                String maTimKiem = sc.nextLine();
                boolean find = false;
                for(int i = 0;i< arrNhanVien.length;i++){
                    if(arrNhanVien[i].getMaNhanVien().equals(maTimKiem)){
                       arrNhanVien[i].Xuat();
                       find = true;
                    }
                }
                if(!find) System.out.println("khong tim thay");
            }
            if(n == 2){
                System.out.println("Nhap ten de tim kiem theo ten");
                String tenTimKiem = sc.nextLine();
                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getTenNhanVien().equals(tenTimKiem)){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("khong tim thay");
            }
            if(n == 3){
                System.out.println("Nhap so dien thoai tim kiem theo so dien thoai");
                String soDienThoaiTimKiem = sc.nextLine();
                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getTenNhanVien().equals(soDienThoaiTimKiem)){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("khong tim thay");
            }
            if(n == 4){
                System.out.println("Nhap gioi tinh de tim kiem theo gioi tinh");
                String gioiTinhTimKiem = sc.nextLine();
                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getTenNhanVien().equals(gioiTinhTimKiem)){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("khong tim thay");
            }
            if(n == 5){
                System.out.println("Nhap luong co ban de tim kiem theo luong co ban");
                String luongCoBanTimKiem = sc.nextLine();
                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getTenNhanVien().equals(luongCoBanTimKiem)){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("khong tim thay");
            }

            if(n == 6){
                break;
            }
        }

    }

    @Override
    public void docFile() {

    }

    @Override
    public void ghiFile() {

    }

    @Override
    public void Nhap() {
        soLuongPhanTuThemVao = Integer.parseInt(sc.nextLine());
        arrNhanVien = new NhanVien[soLuongPhanTuThemVao];

        for(int i = 0;i<soLuongPhanTuThemVao;i++){
            System.out.println("1-Nhap danh sach nhan vien");
            System.out.println("2-Nhap danh sach quan ly");

            int luaChon;

            do{

                luaChon = Integer.parseInt(sc.nextLine());

            }while(luaChon != 1 && luaChon != 2);

            if(luaChon == 1){
                NhanVienPartTime x = new NhanVienPartTime();
                x.Nhap();
                arrNhanVien[i] = x;
            }
            if(luaChon == 2){
                QuanLy x = new QuanLy();
                x.Nhap();
                arrNhanVien[i] = x;
            }

        }
    }




    @Override
    public void Xuat() {
        for(int i = 0;i<arrNhanVien.length;i++){
            arrNhanVien[i].Xuat();
        }
    }

    @Override
    public void Sua() {
        System.out.println("Vui Long Nhap Vao Ma De Sua");
        String maSua = sc.nextLine();
        boolean find = false;
        for(int i = 0;i< arrNhanVien.length;i++){
            if(arrNhanVien[i].getMaNhanVien().equals(maSua)){
                arrNhanVien[i].Sua();
                arrNhanVien[i].Xuat();
                find = true;
            }
        }
        if(!find) System.out.println("khong tim thay");
    }


}
