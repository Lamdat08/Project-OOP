package Project_OOP;

import java.util.Scanner;

public class QuanLy extends NhanVien{

    private double phuCap;

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }



    public void Nhap() {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap ma quan ly");
//        setMaNhanVien(sc.nextLine());
        String maql;
        do{
            System.out.println("nhap ma Quan ly va ma quan ly phai bat dau voi QL");
            maql = sc.nextLine();

        }while(!maql.startsWith("QL"));
        setMaNhanVien(maql);
        System.out.println("Nhap ten quan ly");
        setTenNhanVien(sc.nextLine());
        System.out.println("Nhap so dien thoai quan ly");
        setSoDienThoai(sc.nextLine());
        System.out.println("Nhap gioi tinh");
        setGioiTinh(sc.nextLine());
        System.out.println("Nhap luong co ban");
        setLuongCoBan(Double.parseDouble(sc.nextLine()));
        System.out.println("Nhap phu cap");
        setPhuCap(Double.parseDouble(sc.nextLine()));
    }


    public void Xuat() {
        System.out.println("Ma quan ly : " + getMaNhanVien());
        System.out.println("Ten Nhan Vien : "+getTenNhanVien());
        System.out.println("So dien thoai : " + getSoDienThoai());
        System.out.println("gioi tinh : " + getGioiTinh());
        System.out.println("luong co ban : " + getLuongCoBan());
        System.out.println("phu cap: " + getPhuCap());
        System.out.println("tong luong : " + tinhLuong());
    }

    public void Sua() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin muon sua");

        while(true){
            System.out.println("1-Ma Quan ly");
            System.out.println("2-Ten Nhan Vien");
            System.out.println("3-So Dien Thoai");
            System.out.println("4-Gioi Tinh");
            System.out.println("5-Luong Co ban");
            System.out.println("6-Phu Cap");

            int n = Integer.parseInt(sc.nextLine());
            if(n == 1){
                System.out.println("Thay doi ma quan ly thanh");
                setMaNhanVien(sc.nextLine());
            }
            if(n == 2){
                System.out.println("Thay doi ten quan ly thanh");
                setTenNhanVien(sc.nextLine());
            }
            if(n == 3){
                System.out.println("Thay doi so dien thoai quan ly thanh");
                setSoDienThoai(sc.nextLine());
            }
            if(n == 4){
                System.out.println("Thay doi gioi tinh quan ly thanh");
                setGioiTinh(sc.nextLine());
            }
            if(n == 5){
                System.out.println("Thay doi luong co ban quan ly thanh");
                setLuongCoBan(Double.parseDouble(sc.nextLine()));
            }
            if(n == 6){
                System.out.println("Thay doi phu cap quan ly thanh");
                setPhuCap(Double.parseDouble(sc.nextLine()));
            }

            if(n == 7){
                break;
            }
        }

    }




    public double tinhLuong() {
        return this.phuCap + this.getLuongCoBan();
    }

    @Override
    public String toString() {
        return super.toString() + ";" + String.format("%.2f",phuCap) + ";" + String.format("%.2f",tinhLuong());
    }


}
