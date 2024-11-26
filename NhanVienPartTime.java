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
            System.out.println("Nhập mã nhân viên ( bắt đầu với 'NV' ) : ");
            maNhanVien = sc.nextLine();
        }while(!maNhanVien.startsWith("NV"));
        setMaNhanVien(maNhanVien);
        System.out.println("Nhập vào tên nhân viên : ");
        setTenNhanVien(sc.nextLine());
        System.out.println("Nhập vào số điện thoại nhân viên :");
        setSoDienThoai(sc.nextLine());
        System.out.println("Nhập vào giới tính :");
        setGioiTinh(sc.nextLine());
        System.out.println("Nhập lương cơ bản : ");
        setLuongCoBan(Double.parseDouble(sc.nextLine()));
        System.out.println("Nhập số giờ làm : ");
        setGioLam(Double.parseDouble(sc.nextLine()));
    }


    public void Xuat() {
        System.out.println("Mã nhân viên : " + getMaNhanVien());
        System.out.println("Tên nhân viên : "+getTenNhanVien());
        System.out.println("Số điện thoại : " + getSoDienThoai());
        System.out.println("Giới tính " + getGioiTinh());
        System.out.println("Lương cơ bản : " + getLuongCoBan());
        System.out.println("Số giờ làm : " + getGioLam());
        System.out.println("Tổng lương : " + tinhLuong());
    }


    public void Sua() {
        Scanner sc = new Scanner(System.in);
        while(true){

            System.out.println("1-Thay đổi mã nhân viên. ");
            System.out.println("2-Thay đổi tên nhân viên. ");
            System.out.println("3-Thay đổi số điện thoại. ");
            System.out.println("4-Thay đổi giới tính. ");
            System.out.println("5-TThay đổi lương cơ bản. ");
            System.out.println("6-Thay đổi số giờ làm. ");
            int n = Integer.parseInt(sc.nextLine());
            if (n == 1) {
                System.out.println("Thay đổi mã nhân viên thành : ");
                setMaNhanVien(sc.nextLine());
            }
            if (n == 2) {
                System.out.println("Thay đổi tên nhân viên thành : ");
                setTenNhanVien(sc.nextLine());
            }
            if (n == 3) {
                System.out.println("Thay đổi số điện thoại thành : ");
                setSoDienThoai(sc.nextLine());
            }
            if (n == 4) {
                System.out.println("Thay đổi giới tính thành : ");
                setGioiTinh(sc.nextLine());
            }
            if (n == 5) {
                System.out.println("Thay đổi lương cơ bản thành :");
                setLuongCoBan(Double.parseDouble(sc.nextLine()));
            }
            if (n == 6) {
                System.out.println("Thay đổi số giờ làm thành :");
                setGioLam(Double.parseDouble(sc.nextLine()));
            }
            if (n == 7) {
                break;
            }

        }
    }


    @Override
    public String toString() {
        return super.toString() + ";" + String.format("%.2f",gioLam) + ";" + String.format("%.2f",tinhLuong());
    }
}
