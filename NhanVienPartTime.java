package Project_OOP;

import java.util.Scanner;

public class NhanVienPartTime extends NhanVien{

    private double gioLam;



    public double getGioLam() {
        return gioLam;
    }

    public void setGioLam(double gioLam) {
        this.gioLam = gioLam;
    }


    public double tinhLuong() {
        return this.gioLam * this.getLuongCoBan();
    }

    public NhanVienPartTime() {
        super();
    }

    //    public NhanVienPartTime(double gioLam) {
//        this.gioLam = gioLam;
//    }






    public void Nhap() {
        Scanner sc = new Scanner(System.in);
//        System.out.println("nhap ma nhan vien");
//        setMaNhanVien(sc.nextLine());
       String maNhanVien;
        do{
            System.out.println("nhap ma nhan vien va ma nhan vien phai bat dau voi NV");
            maNhanVien = sc.nextLine();
        }while(!maNhanVien.startsWith("NV"));
        setMaNhanVien(maNhanVien);
        System.out.println("Nhap ten nhan vien");
        setTenNhanVien(sc.nextLine());
        System.out.println("nhap so dien thoai nhan vien");
        setSoDienThoai(sc.nextLine());
        System.out.println("nhap gioi tinh");
        setGioiTinh(sc.nextLine());
        System.out.println("nhap luong co ban");
        setLuongCoBan(Double.parseDouble(sc.nextLine()));
        System.out.println("nhap so gio lam");
        setGioLam(Double.parseDouble(sc.nextLine()));
    }


    public void Xuat() {
        System.out.println("Ma Nhan Vien : " + getMaNhanVien());
        System.out.println("Ten Nhan Vien : "+getTenNhanVien());
        System.out.println("So dien thoai : " + getSoDienThoai());
        System.out.println("gioi tinh : " + getGioiTinh());
        System.out.println("luong co ban : " + getLuongCoBan());
        System.out.println("so gio lam : " + getGioLam());
        System.out.println("tong luong : " + tinhLuong());
    }


    public void Sua() {
        Scanner sc = new Scanner(System.in);
        while(true){

            System.out.println("1-Thay doi ma nhan vien");
            System.out.println("2-Thay doi ten nhan vien");
            System.out.println("3-Thay doi so dien thoai");
            System.out.println("4-Thay doi gioi tinh");
            System.out.println("5-Thay doi luong co ban");
            System.out.println("6-Thay doi so gio lam");
            int n = Integer.parseInt(sc.nextLine());

            if(n == 1){
                System.out.println("Thay doi ma nhan vien thanh");
                setMaNhanVien(sc.nextLine());
            }
            if(n == 2){
                System.out.println("Thay doi ten nhan vien thanh");
                setTenNhanVien(sc.nextLine());
            }
            if(n == 3){
                System.out.println("Thay doi so dien thoai thanh");
                setSoDienThoai(sc.nextLine());
            }
            if(n == 4){
                System.out.println("Thay doi gioi tinh thanh");
                setGioiTinh(sc.nextLine());
            }
            if(n == 5){
                System.out.println("Thay doi luong co ban Thanh");
                setLuongCoBan(Double.parseDouble(sc.nextLine()));
            }
            if(n == 6){
                System.out.println("Thay doi so gio lam thanh");
                setGioLam(Double.parseDouble(sc.nextLine()));
            }
            if(n == 7){
                break;
            }
        }
    }


    @Override
    public String toString() {
        return super.toString() + ";" + String.format("%.2f",gioLam) + ";" + String.format("%.2f",tinhLuong());
    }
}
