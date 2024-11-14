package Project_OOP;

import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSanPham {

    static Scanner sc = new Scanner(System.in);

    private SanPham[] danhSachSanPham;
    private int soLuongSanPham;

    public void menuNhap(){
        System.out.println("1 - Nhap danh sach thuc an");
        System.out.println("1 - Nhap danh sach nuoc uong");
    }
    public void menuTimKiem(){
        System.out.println("1 - Tim kiem theo ma san pham");
        System.out.println("2 - Tim kiem theo ten san pham");
        System.out.println("3 - Tim kiem theo so luong");
        System.out.println("4 - Tim kiem theo gia tien");
        System.out.println("5 - Tim kiem theo tien von");
    }

    public void Nhap(){
        System.out.println("Nhap so luong san pham: ");
        soLuongSanPham = Integer.parseInt(sc.nextLine());
        danhSachSanPham = new SanPham[soLuongSanPham];
        for(int i = 0; i < soLuongSanPham; i++){
            SanPham sp;
            menuNhap();
            System.out.println("Nhap lua chon loai san pham muon them: ");
            int luaChon = Integer.parseInt(sc.nextLine());
            while(luaChon != 1 && luaChon != 2){
                menuNhap();
                System.out.println("Khong co lua chon nay, moi nhap lai: ");
                luaChon = Integer.parseInt(sc.nextLine());
            }

            if(luaChon == 1){
                sp = new ThucAn();
                sp.Nhap();
                danhSachSanPham[i] = sp;
            }
            if(luaChon == 2){
                sp = new NuocUong();
                sp.Nhap();
                danhSachSanPham[i] = sp;
            }
        }
    }
    public void Them(){
        danhSachSanPham = Arrays.copyOf(danhSachSanPham, danhSachSanPham.length + 1);
        SanPham sp;
        menuNhap();
        System.out.println("Nhap lua chon loai san pham muon them: ");
        int luaChon = Integer.parseInt(sc.nextLine());
        while(luaChon != 1 && luaChon != 2){
            menuNhap();
            System.out.println("Khong co lua chon nay, moi nhap lai: ");
            luaChon = Integer.parseInt(sc.nextLine());
        }

        if(luaChon == 1){
            sp = new ThucAn();
            sp.Nhap();
            danhSachSanPham[danhSachSanPham.length - 1] = sp;
        }
        if(luaChon == 2){
            sp = new NuocUong();
            sp.Nhap();
            danhSachSanPham[danhSachSanPham.length - 1] = sp;
        }
    }
    public void Xoa(){
        System.out.println("Nhap ma san pham muon xoa: ");
        String maSP_Xoa = sc.nextLine();
        boolean kq = false;
        for(int i = 0; i < danhSachSanPham.length; i++){
            if(danhSachSanPham[i].getMaSP().equals(maSP_Xoa)){
                for(int j = i + 1; j < danhSachSanPham.length; j++){
                    danhSachSanPham[i] = danhSachSanPham[j];
                }
                kq = true;
            }
        }
        if(!kq){
            System.out.println("Khong tim thay ma san pham muon xoa");
        }
        else{
            danhSachSanPham = Arrays.copyOf(danhSachSanPham, danhSachSanPham.length - 1);
        }
    }
    public void TimKiem(){
        menuTimKiem();
        int luaChon = Integer.parseInt(sc.nextLine());
        while(luaChon != 1 && luaChon != 2){
            menuNhap();
            System.out.println("Khong co lua chon nay, moi nhap lai: ");
            luaChon = Integer.parseInt(sc.nextLine());
        }
        boolean kq;
        switch(luaChon){
            case 1:
                System.out.println("Nhap ma san pham can tim: ");
                String maSP_TimKiem = sc.nextLine();
                kq = false;
                for(int i = 0; i < danhSachSanPham.length; i++){
                    if(danhSachSanPham[i].getMaSP().equals(maSP_TimKiem)){
                        danhSachSanPham[i].Xuat();
                        kq = true;
                    }
                }
                if(!kq){
                    System.out.println("Khong tim thay ma san pham muon xoa");
                }
            case 2:
                System.out.println("Nhap ten san pham can tim: ");
                String tenSP_TimKiem = sc.nextLine();
                kq = false;
                for(int i = 0; i < danhSachSanPham.length; i++){
                    if(danhSachSanPham[i].getTenSP().equals(tenSP_TimKiem)){
                        danhSachSanPham[i].Xuat();
                        kq = true;
                    }
                }
                if(!kq){
                    System.out.println("Khong tim thay ma san pham muon xoa");
                }
            case 3:
                System.out.println("Nhap so luong cua san pham can tim: ");
                int soLuongSP_TimKiem = Integer.parseInt(sc.nextLine());
                kq = false;
                for(int i = 0; i < danhSachSanPham.length; i++){
                    if(danhSachSanPham[i].getSoLuong() == soLuongSP_TimKiem){
                        danhSachSanPham[i].Xuat();
                        kq = true;
                    }
                }
                if(!kq){
                    System.out.println("Khong tim thay ma san pham muon xoa");
                }
            case 4:
                System.out.println("Nhap gia tien san pham can tim: ");
                double giaTienSP_TimKiem = Double.parseDouble(sc.nextLine());
                kq = false;
                for(int i = 0; i < danhSachSanPham.length; i++){
                    if(danhSachSanPham[i].getGiaTien() == giaTienSP_TimKiem){
                        danhSachSanPham[i].Xuat();
                        kq = true;
                    }
                }
                if(!kq){
                    System.out.println("Khong tim thay ma san pham muon xoa");
                }
            case 5:
                System.out.println("Nhap tien von cua san pham can tim: ");
                double tienVonSP_TimKiem = Double.parseDouble(sc.nextLine());
                kq = false;
                for(int i = 0; i < danhSachSanPham.length; i++){
                    if(danhSachSanPham[i].getTienVon() == tienVonSP_TimKiem){
                        danhSachSanPham[i].Xuat();
                        kq = true;
                    }
                }
                if(!kq){
                    System.out.println("Khong tim thay ma san pham muon xoa");
                }
            default:
                break;
        }
    }

    public void Xuat() {
        for(int i = 0;i<danhSachSanPham.length;i++){
            danhSachSanPham[i].Xuat();
        }
    }

    public void Sua(){
        System.out.println("Nhap ma san pham cua san pham can sua: ");
        String maSP_Sua = sc.nextLine();
        boolean kq = false;
        for(int i = 0; i < danhSachSanPham.length; i++){
            if(danhSachSanPham[i].getMaSP().equals(maSP_Sua)){
                danhSachSanPham[i].Sua();
                danhSachSanPham[i].Xuat();
                kq = true;
            }
        }
        if(!kq){
            System.out.println("Khong tim thay ma san pham muon sua");
        }
    }

    public void docFile(){

    }
    public void ghiFile(){

    }
}