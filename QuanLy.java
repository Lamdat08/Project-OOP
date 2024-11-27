package Project_OOP;

import java.util.Scanner;

public class QuanLy extends NhanVien {

    private double phuCap;

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }

    public QuanLy() {

    }

    public QuanLy(String maNhanVien, String tenNhanVien, String soDienThoai, String gioiTinh, double luongCoBan, double phuCap) {
        super(maNhanVien, tenNhanVien, soDienThoai, gioiTinh, luongCoBan);
        this.phuCap = phuCap;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
//        String maql;
//        do {
//            System.out.println("Nhập mã Quản lý và mã quản lý phải bắt đầu với QL");
//            maql = sc.nextLine();
//        } while (!maql.startsWith("QL"));
//        setMaNhanVien(maql);

        String regex = "^QL\\d+$";
        String MaNV;
        do {
            System.out.printf("Nhập vào mã quan ly  : ");
            MaNV = sc.nextLine();
            if (!MaNV.matches(regex))
                System.out.println("Mã quan ly phải bắt đầu bằng QL và sau đó là các chữ số, vui lòng nhập lại mã quan ly .");
        }while (!MaNV.matches(regex));
        setMaNhanVien(MaNV);

//        System.out.println("Nhập tên quản lý");
//        setTenNhanVien(sc.nextLine());
        String TenNV;
        do {
            System.out.printf("Nhập vào ten : ");
            TenNV = sc.nextLine();
            if (!TenNV.matches(regexLetters))
                System.out.println("Vui lòng nhập đúng định dạng (chỉ nhập chữ) ");
        }while (!TenNV.matches(regexLetters));
        setTenNhanVien(TenNV);


//        System.out.println("Nhập số điện thoại quản lý");
//        setSoDienThoai(sc.nextLine());
        String SDT;
        do {
            do {
                System.out.printf("Nhập vào SDT : ");
                SDT = sc.nextLine();
                if (!SDT.matches(regNumbers))
                    System.out.println("Sai dinh dang");
            }while (!SDT.matches(regNumbers));

            if ( SDT.length() != 10)
                System.out.println("SDT co 10 so");
        }while (SDT.length() == 10 );
        setSoDienThoai(SDT);


//        System.out.println("Nhập giới tính");
//        setGioiTinh(sc.nextLine());

        String gt;
        do {
            do {
                System.out.printf("Nhập vào gioi tinh : ");
                gt = sc.nextLine();
                if (!gt.matches(regexLetters))
                    System.out.println("Sai dinh dang");
            }while (!gt.matches(regexLetters));

        }while (gt.toLowerCase().matches("nam") || gt.toLowerCase().matches("nu"));
        setGioiTinh(gt.toLowerCase());


//        System.out.println("Nhập lương cơ bản");
//        setLuongCoBan(Double.parseDouble(sc.nextLine()));
        String LCB;
        do {
            do {
                System.out.printf("Nhập vào luong co ban : ");
                LCB = sc.nextLine();
                if (!LCB.matches(regNumbers))
                    System.out.println("Sai dinh dang");
            }while (!LCB.matches(regNumbers));

            if (Double.parseDouble(LCB) < 0)
                System.out.println("LCB > 0");
        }while (Double.parseDouble(LCB) < 0 );
        setLuongCoBan(Double.parseDouble(LCB));

        String PC;
        do {
            do {
                System.out.printf("Nhập vào luong co ban : ");
                PC = sc.nextLine();
                if (!PC.matches(regNumbers))
                    System.out.println("Sai dinh dang");
            }while (!PC.matches(regNumbers));

            if (Double.parseDouble(PC) < 0)
                System.out.println("PC > 0");
        }while (Double.parseDouble(PC) < 0 );
        setLuongCoBan(Double.parseDouble(PC));
    }

    public void Xuat() {
        System.out.println("Mã quản lý : " + getMaNhanVien());
        System.out.println("Tên Nhân Viên : " + getTenNhanVien());
        System.out.println("Số điện thoại : " + getSoDienThoai());
        System.out.println("Giới tính : " + getGioiTinh());
        System.out.println("Lương cơ bản : " + getLuongCoBan());
        System.out.println("Phụ cấp : " + getPhuCap());
        System.out.println("Tổng lương : " + tinhLuong());
    }

    public void Sua() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông tin muốn sửa");

        while (true) {
            System.out.println("1 - Mã Quản lý");
            System.out.println("2 - Tên Nhân Viên");
            System.out.println("3 - Số Điện Thoại");
            System.out.println("4 - Giới Tính");
            System.out.println("5 - Lương Cơ Bản");
            System.out.println("6 - Phụ Cấp");
            System.out.println("7 - Thoát");

            int n = 0;
            boolean validInput= false;
            while (!validInput)
            {
                try {
                    System.out.printf("Nhập lựa chọn : ");
                    n = Integer.parseInt(sc.nextLine());

                    if ( n < 1 || n > 7) {
                        validInput = false;
                        System.out.println("0 < n < 7");
                    }
                    else
                        validInput = true;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            if (n == 1) {
                String regex = "^QL\\d+$";
                String MaNV;
                do {
                    System.out.printf("Nhập vào mã QL : ");
                    MaNV = sc.nextLine();
                    if (!MaNV.matches(regex))
                        System.out.println("Mã nhân viên phải bắt đầu bằng QL và sau đó là các chữ số, vui lòng nhập lại mã nhân viên .");
                }while (!MaNV.matches(regex));
                setMaNhanVien(MaNV);
            }
            if (n == 2) {
                String TenNV;
                do {
                    System.out.printf("Nhập vào ten : ");
                    TenNV = sc.nextLine();
                    if (!TenNV.matches(regexLetters))
                        System.out.println("Vui lòng nhập đúng định dạng (chỉ nhập chữ) ");
                }while (!TenNV.matches(regexLetters));
                setMaNhanVien(TenNV);
            }
            if (n == 3) {
                String SDT;
                do {
                    do {
                        System.out.printf("Nhập vào SDT : ");
                        SDT = sc.nextLine();
                        if (!SDT.matches(regNumbers))
                            System.out.println("Sai dinh dang");
                    }while (!SDT.matches(regNumbers));

                    if ( SDT.length() != 10)
                        System.out.println("SDT co 10 so");
                }while (SDT.length() == 10 );
                setSoDienThoai(SDT);
            }
            if (n == 4) {
                String gioiTinhTimKiem;
                while (true){
                    do {
                        System.out.printf("Nhập vào gioi tinh : ");
                        gioiTinhTimKiem = sc.nextLine();
                        if (!gioiTinhTimKiem.matches(regexLetters))
                            System.out.println("Sai dinh dang");
                    }while (!gioiTinhTimKiem.matches(regexLetters));
                    if (gioiTinhTimKiem.toLowerCase().equals("nam") || gioiTinhTimKiem.equals("nu"))
                        break;
                    else
                        System.out.println("Nhap nam hoac nu.");
                }
                setGioiTinh(gioiTinhTimKiem);
            }
            if (n == 5) {
                String LCB;
                do {
                    do {
                        System.out.printf("Nhập vào luong co ban : ");
                        LCB = sc.nextLine();
                        if (!LCB.matches(regNumbers))
                            System.out.println("Sai dinh dang");
                    }while (!LCB.matches(regNumbers));

                    if (Double.parseDouble(LCB) < 0)
                        System.out.println("LCB > 0");
                }while (Double.parseDouble(LCB) < 0 );
                setLuongCoBan(Double.parseDouble(LCB));
            }
            if (n == 6) {

                String PC;
                do {
                    do {
                        System.out.printf("Nhập vào luong co ban : ");
                        PC = sc.nextLine();
                        if (!PC.matches(regNumbers))
                            System.out.println("Sai dinh dang");
                    }while (!PC.matches(regNumbers));

                    if (Double.parseDouble(PC) < 0)
                        System.out.println("PC > 0");
                }while (Double.parseDouble(PC) < 0 );
                setLuongCoBan(Double.parseDouble(PC));
            }
            if (n == 7) {
                break;
            }
        }
    }

    public double tinhLuong() {
        return this.phuCap + this.getLuongCoBan();
    }

    @Override
    public String toString() {
        return super.toString() + ";" + String.format("%.2f", phuCap) + ";" + String.format("%.2f", tinhLuong());
    }
}
