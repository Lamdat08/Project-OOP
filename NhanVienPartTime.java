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
    public NhanVienPartTime(String maNhanVien, String tenNhanVien, String soDienThoai, String gioiTinh, double luongCoBan, double gioLam) {
        super(maNhanVien, tenNhanVien, soDienThoai, gioiTinh, luongCoBan);
        this.gioLam = gioLam;
    }
    //    public NhanVienPartTime(double gioLam) {
//        this.gioLam = gioLam;
//    }






    public void Nhap() {
        Scanner sc = new Scanner(System.in);
//        System.out.println("nhap ma nhan vien");
//        setMaNhanVien(sc.nextLine());
//       String maNhanVien;
//        do{
//            System.out.println("Nhập mã nhân viên ( bắt đầu với 'NV' ) : ");
//            maNhanVien = sc.nextLine();
//        }while(!maNhanVien.startsWith("NV"));
        String regex = "^NV\\d+$";
        String MaNV;
        do {
            System.out.printf("Nhập vào mã nhân viên parttime : ");
            MaNV = sc.nextLine();
            if (!MaNV.matches(regex))
                System.out.println("Mã nhân viên phải bắt đầu bằng NV và sau đó là các chữ số, vui lòng nhập lại mã nhân viên .");
        }while (!MaNV.matches(regex));
        setMaNhanVien(MaNV);

//        System.out.println("Nhập vào tên nhân viên : ");
//        setTenNhanVien(sc.nextLine());

        String TenNV;
        do {
            System.out.printf("Nhập vào tên nhân viên parttime: ");
            TenNV = sc.nextLine();
            if (!TenNV.matches(regexLetters))
                System.out.println("Vui lòng nhập đúng định dạng (chỉ nhập chữ) ");
        }while (!TenNV.matches(regexLetters));
        setTenNhanVien(TenNV);


//        System.out.println("Nhập vào số điện thoại nhân viên :");
//        setSoDienThoai(sc.nextLine());
        String SDT;
        do {
            do {
                System.out.printf("Nhập vào số điện thoại  : ");
                SDT = sc.nextLine();
                if (!SDT.matches(regNumbers))
                    System.out.println("Vui lòng chỉ nhập số !");
            }while (!SDT.matches(regNumbers));

           if ( SDT.length() != 10)
               System.out.println("Vui lòng nhập đúng 10 số !");
        }while (SDT.length() != 10 );
        setSoDienThoai(SDT);

//        System.out.println("Nhập vào giới tính :");
//        setGioiTinh(sc.nextLine());

        String gioiTinhTimKiem;
        while (true){
            do {
                System.out.printf("Nhập vào giới tính : ");
                gioiTinhTimKiem = sc.nextLine();
                if (!gioiTinhTimKiem.matches(regexLetters))
                    System.out.println("Vui lòng chỉ nhập chữ ");
            }while (!gioiTinhTimKiem.matches(regexLetters));
            if (gioiTinhTimKiem.toLowerCase().equals("nam") || gioiTinhTimKiem.equals("nu"))
                break;
            else
                System.out.println("Vui lòng nhập giới tính hợp lý ( nam hoac nu ).");
        }
        setGioiTinh(gioiTinhTimKiem.toLowerCase());


//        System.out.println("Nhập lương cơ bản : ");
//        setLuongCoBan(Double.parseDouble(sc.nextLine()));
        String LCB;
        do {
            do {
                System.out.printf("Nhập vào lương cơ bản : ");
                LCB = sc.nextLine();
                if (!LCB.matches(regNumbers))
                    System.out.println("Vui lòng chỉ nhập số ! ");
            }while (!LCB.matches(regNumbers));

            if (Double.parseDouble(LCB) <= 0)
                System.out.println("Lương phải lớn hơn 0.");
        }while (Double.parseDouble(LCB) <= 0 );
        setLuongCoBan(Double.parseDouble(LCB));




//        System.out.println("Nhập số giờ làm : ");
//        setGioLam(Double.parseDouble(sc.nextLine()));
        String gio;
        do {
            do {
                System.out.printf("Nhập vào giờ làm : ");
                gio = sc.nextLine();
                if (!gio.matches(regDoubleNums))
                    System.out.println("Vui lòng chỉ nhập số ! ");
            }while (!gio.matches(regDoubleNums));

            if (Double.parseDouble(gio) <= 0)
                System.out.println("Giờ làm lớn hơn 0.");
        }while (Double.parseDouble(gio) <= 0 );
        setGioLam(Double.parseDouble(gio));

    }


    public void Xuat() {
        System.out.println("Mã nhân viên : " + getMaNhanVien());
        System.out.println("Tên nhân viên : "+getTenNhanVien());
        System.out.println("Số điện thoại : " + getSoDienThoai());
        System.out.println("Giới tính " + getGioiTinh());
        System.out.println("Lương cơ bản : " + getLuongCoBan());
        System.out.println("Số giờ làm : " + getGioLam());
        System.out.println("Tổng lương : " + tinhLuong());
        System.out.println("--------------------------------------------------");
    }


    public void Sua() {
        Scanner sc = new Scanner(System.in);
        while(true){

            System.out.println("1-Thay đổi mã nhân viên. ");
            System.out.println("2-Thay đổi tên nhân viên. ");
            System.out.println("3-Thay đổi số điện thoại. ");
            System.out.println("4-Thay đổi giới tính. ");
            System.out.println("5-Thay đổi lương cơ bản. ");
            System.out.println("6-Thay đổi số giờ làm. ");
            System.out.println("7-Thoát");
            int n = 0;
            boolean validInput= false;
            while (!validInput)
            {
                try {
                    System.out.printf("Nhập lựa chọn : ");
                    n = Integer.parseInt(sc.nextLine());

                    if ( n < 1 || n > 7) {
                        validInput = false;
                        System.out.println("Vui lòng nhập lựa chọn từ 1 -> 7 : ");

                    }
                    else
                        validInput = true;
                } catch (Exception e) {
                    System.out.println("Vui lòng chỉ nhập số !");
                }
            }


            if (n == 1) {
                String regex = "^NV\\d+$";
                String MaNV;
                do {
                    System.out.printf("Nhập vào mã nhân viên parttime : ");
                    MaNV = sc.nextLine();
                    if (!MaNV.matches(regex))
                        System.out.println("Mã nhân viên phải bắt đầu bằng NV và sau đó là các chữ số, vui lòng nhập lại mã nhân viên .");
                }while (!MaNV.matches(regex));
                setMaNhanVien(MaNV);
            }
            if (n == 2) {
                String TenNV;
                do {
                    System.out.printf("Nhập vào tên nhân viên: ");
                    TenNV = sc.nextLine();
                    if (!TenNV.matches(regexLetters))
                        System.out.println("Vui lòng nhập đúng định dạng (chỉ nhập chữ) ");
                }while (!TenNV.matches(regexLetters));
//                setMaNhanVien(TenNV);
                setTenNhanVien(TenNV);
            }

            if (n == 3) {
                String SDT;
                do {
                    do {
                        System.out.printf("Nhập vào số điện thoại : ");
                        SDT = sc.nextLine();
                        if (!SDT.matches(regNumbers))
                            System.out.println("Vui lòng chỉ nhập số !");
                    }while (!SDT.matches(regNumbers));

                    if ( SDT.length() != 10)
                        System.out.println("Vui lòng nhập đúng 10 số !");
                }while (SDT.length() != 10 );
                setSoDienThoai(SDT);
            }
            if (n == 4) {
                String gioiTinhTimKiem;
                while (true){
                    do {
                        System.out.printf("Nhập vào giới tính : ");
                        gioiTinhTimKiem = sc.nextLine();
                        if (!gioiTinhTimKiem.matches(regexLetters))
                            System.out.println("Vui lòng chỉ nhập chữ ");
                    }while (!gioiTinhTimKiem.matches(regexLetters));
                    if (gioiTinhTimKiem.toLowerCase().equals("nam") || gioiTinhTimKiem.equals("nu"))
                        break;
                    else
                        System.out.println("Vui lòng nhập giới tính hợp lý ( nam hoặc nu ).");
                }
                setGioiTinh(gioiTinhTimKiem.toLowerCase());
            }
            if (n == 5) {
                String LCB;
                do {
                    do {
                        System.out.printf("Nhập vào lương cơ bản : ");
                        LCB = sc.nextLine();
                        if (!LCB.matches(regNumbers))
                            System.out.println("Vui lòng chỉ nhập số ! ");
                    }while (!LCB.matches(regNumbers));

                    if (Double.parseDouble(LCB) < 0)
                        System.out.println("Lương phải lớn hơn 0.");
                }while (Double.parseDouble(LCB) < 0 );
                setLuongCoBan(Double.parseDouble(LCB));
            }

            if (n == 6) {
                String gio;
                do {
                    do {
                        System.out.printf("Nhập vào giờ làm : ");
                        gio = sc.nextLine();
                        if (!gio.matches(regDoubleNums))
                            System.out.println("Vui lòng chỉ nhập số ! ");
                    }while (!gio.matches(regDoubleNums));

                    if (Double.parseDouble(gio) < 0)
                        System.out.println("Giờ làm lớn hơn 0.");
                }while (Double.parseDouble(gio) < 0 );
                setGioLam(Double.parseDouble(gio));
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
