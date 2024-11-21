package Project_OOP;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachKhachHang implements IThaoTac_2 {

    static Scanner sc = new Scanner(System.in);

    private int soLuongKhachHang;
    private KhachHang[] DSKH;
    private KhachHang[] DSKH_File;

    public int getSoLuongKhachHang() {
        return soLuongKhachHang;
    }

    public void setSoLuongKhachHang(int soLuongKhachHang) {
        this.soLuongKhachHang = soLuongKhachHang;
    }

    public KhachHang[] getDSKH() {
        return DSKH;
    }

    public void setDSKH(KhachHang[] DSKH) {
        this.DSKH = DSKH;
    }

    public KhachHang[] getDSKH_File() {
        return DSKH_File;
    }

    public void setDSKH_File(KhachHang[] DSKH_File) {
        this.DSKH_File = DSKH_File;
    }

    public DanhSachKhachHang() {
        this.DSKH = new KhachHang[5];
        this.Nhap();
    }

    public void menuTimKiem() {
        System.out.println("1 - Tìm kiếm theo mã khách hàng.");
        System.out.println("2 - Tìm kiếm theo tên khách hàng.");
        System.out.println("3 - Tìm kiếm theo số điện thoại.");
        System.out.println("4 - Tìm kiếm theo địa chỉ.");
        System.out.println("5 - Tìm kiếm theo giới tính.");
        System.out.println("6 - Thoát tìm kiếm.");
    }

//    public void Nhap() {
//        System.out.println("Nhập số lượng khách hàng để tạo danh sách: ");
//        soLuongKhachHang = Integer.parseInt(sc.nextLine());
//        DSKH = new KhachHang[soLuongKhachHang];
//        for (int i = 0; i < soLuongKhachHang; i++) {
//            KhachHang kh = new KhachHang();
//            kh.Nhap();
//            DSKH[i] = kh;
//        }
//    }

    public void Nhap() {
        String line;
        String[] strings = new String[6];
        try {
            FileReader fr = new FileReader("KhachHang.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (soLuongKhachHang == DSKH.length) {
                    DSKH = Arrays.copyOf(DSKH, DSKH.length + 6);
                }
                strings = line.split(";");
                try {
                    KhachHang kh = new ThanhVien(strings[0],strings[1],strings[2],strings[3],strings[4],Integer.parseInt(strings[5]));
                    DSKH[soLuongKhachHang] = kh;
                    soLuongKhachHang++;
                } catch (Exception e) {

                }
            }

        } catch (Exception e) {
            System.out.println("Không đọc được file KhachHang.txt\n");
        }
        if (soLuongKhachHang < DSKH.length) {
            DSKH = Arrays.copyOf(DSKH, soLuongKhachHang);
        }

        DSKH_File = Arrays.copyOf(DSKH, DSKH.length);
    }

    public void Them() {
        System.out.println("\n \t \t---------Thêm--------");

        if (DSKH == null) {
            System.out.println("Danh sách khách hàng chưa được khởi tạo.");
            return;
        }
        if (DSKH.length == 0) {
            System.out.println("Danh sách khách hàng hiện tại đang trống. Vui lòng thêm khách hàng. \n");
            return;
        }

        int n;
        do {
            System.out.println("Nhập số lượng khách hàng muốn thêm: ");
            n = Integer.parseInt(sc.nextLine());
            if (n <= 0) {
                System.out.println("Không hợp lệ, vui lòng nhập số lượng > 0");
            }
        } while (n <= 0);

        soLuongKhachHang += n;
        DSKH = Arrays.copyOf(DSKH, DSKH.length + n);
        KhachHang kh;

        int slKHBanDau = DSKH.length - n;
        for (int i = slKHBanDau; i < DSKH.length; i++) {
            kh = new ThanhVien();
            kh.Nhap();
            DSKH[i] = kh;
        }
    }

    public void Xoa() {
        System.out.println("\n-------Xóa--------");

        if (DSKH == null) {
            System.out.println("Danh sách khách hàng chưa được khởi tạo.");
            return;
        }
        if (DSKH.length == 0) {
            System.out.println("Danh sách khách hàng hiện tại đang trống. Vui lòng thêm khách hàng. \n");
            return;
        }

        System.out.println("Nhập mã khách hàng muốn xóa: ");
        String maKH_Xoa = sc.nextLine();
        boolean kq = false;
        for (int i = 0; i < DSKH.length - 1; i++) {
            if (DSKH[i].getMaKH().equals(maKH_Xoa)) {
                for (int j = i + 1; j < DSKH.length; j++) {
                    DSKH[i] = DSKH[j];
                }
                kq = true;
            }
        }
        if (!kq) {
            System.out.println("Không tìm thấy mã khách hàng" + maKH_Xoa + "muốn xóa");
        }
        else {
            DSKH = Arrays.copyOf(DSKH, DSKH.length - 1);
            System.out.println("Xóa khách hàng thành công!\n-------------------");
            soLuongKhachHang--;
        }
    }

    public void TimKiem() {
        System.out.println("\n---------Tìm kiếm--------");

        if (DSKH == null) {
            System.out.println("Vui lòng nhập danh sách khách hàng trước !");
            return;
        }
        if (DSKH.length == 0) {
            System.out.println("Danh sách khách hàng hiện tại đang trống. Vui lòng thêm khách hàng. \n");
            return;
        }

        while (true) {
            boolean kq;
            menuTimKiem();
            int luachon = Integer.parseInt(sc.nextLine());
            while (luachon < 1 || luachon > 6) {
                System.out.println("Không có lựa chọn này, mời nhập lại lựa chọn từ 1-6");
                luachon = Integer.parseInt(sc.nextLine());
            }

            switch (luachon) {
                case 1:
                    System.out.println("Nhập mã khách hàng cần tìm: ");
                    String maKH_TimKiem = sc.nextLine();
                    kq = false;
                    for (int i = 0; i < DSKH.length; i++) {
                        if (DSKH[i].getMaKH().equals(maKH_TimKiem)) {
                            DSKH[i].Xuat();
                            kq = true;
                            System.out.println("\n \t--------------------");
                        }
                    }
                    if (!kq) {
                        System.out.println("Không tìm thấy mã khách hàng: " + maKH_TimKiem);
                    }
                    break;
                case 2:
                    System.out.println("Nhập tên khách hàng cần tìm: ");
                    String tenKhachHang_TimKiem = sc.nextLine();
                    kq = false;
                    for (int i = 0; i < DSKH.length; i++) {
                        if (DSKH[i].getTenKH().equals(tenKhachHang_TimKiem)) {
                            DSKH[i].Xuat();
                            kq = true;
                            System.out.println("\n \t--------------------");
                        }
                    }
                    if (!kq) {
                        System.out.println("Không tìm thấy khách hàng có tên: " + tenKhachHang_TimKiem);
                    }
                    break;
                case 3:
                    System.out.println("Nhập số điện thoại của khách hàng cần tìm: ");
                    String soDienKhachHang_TimKiem = sc.nextLine();
                    kq = false;
                    for (int i = 0; i < DSKH.length; i++) {
                        if (DSKH[i].getSDT().equals(soDienKhachHang_TimKiem)) {
                            DSKH[i].Xuat();
                            kq = true;
                            System.out.println("\n \t--------------------");
                        }
                    }
                    if (!kq) {
                        System.out.println("Không tìm thấy khách hàng có số điện thoại: " + soDienKhachHang_TimKiem);
                    }
                    break;
                case 4:
                    System.out.println("Nhập địa chỉ khách hàng cần tìm: ");
                    String diaChiKhachHang_TimKiem = sc.nextLine();
                    kq = false;
                    for (int i = 0; i < DSKH.length; i++) {
                        if (DSKH[i].getDiaChi().equals(diaChiKhachHang_TimKiem)) {
                            DSKH[i].Xuat();
                            kq = true;
                            System.out.println("\n \t--------------------");
                        }
                    }
                    if (!kq) {
                        System.out.println("Không tìm thấy khách hàng có địa chỉ: " + diaChiKhachHang_TimKiem);
                    }
                    break;
                case 5:
                    System.out.println("Nhập giới tính khách hàng cần tìm: ");
                    String gioiTinhKhachHang_TimKiem = sc.nextLine();
                    kq = false;
                    for (int i = 0; i < DSKH.length; i++) {
                        if (DSKH[i].getGioiTinh().equals(gioiTinhKhachHang_TimKiem)) {
                            DSKH[i].Xuat();
                            kq = true;
                            System.out.println("\n \t--------------------");
                        }
                    }
                    if (!kq) {
                        System.out.println("Không tìm thấy khách hàng nào có giới tính: " + gioiTinhKhachHang_TimKiem);
                    }
                    break;
                case 6:
                    System.out.println("Thoát tìm kiếm.");
                    return;
                default:
                    System.out.println("Không có lựa chọn tìm kiếm này !");
                    break;
            }
            if (luachon == 6) {
                break;
            }
        }
    }

    public void Xuat() {
        System.out.println("\n \t \t--------Xuất danh sách--------");

        if (DSKH == null) {
            System.out.println("Vui lòng tạo danh sách khách hàng trước !");
            return;
        }
        if (DSKH.length == 0) {
            System.out.println("Danh sách khách hàng hiện tại đang trống. Vui lòng thêm khách hàng.");
        }

        System.out.println("\t   Thông tin của danh sách khách hàng \n--------------------------");
        for (int i = 0; i < DSKH.length; i++) {
            DSKH[i].Xuat();
            System.out.println("\t--------------");
        }
    }

    public void Sua() {
        System.out.println("\n \t \t---------Sửa--------");

        if (DSKH == null) {
            System.out.println("Danh sách khách hàng chưa được khởi tạo.");
            return;
        }
        if (DSKH.length == 0) {
            System.out.println("Danh sách hiện tại đang trống. Vui lòng thêm khách hàng. \n");
            return;
        }

        System.out.println("Nhập mã của khách hàng cần sửa đổi thông tin: ");
        String maKH_Sua = sc.nextLine();
        boolean kq = false;

        for (int i = 0; i < DSKH.length; i++) {
            if (DSKH[i].getMaKH().equals(maKH_Sua)) {
                DSKH[i].Sua();
                DSKH[i].Xuat();
                kq = true;
                System.out.println("Sửa thành công ! \n -------------------");
            }
        }
        if (!kq) {
            System.out.println("Không tìm thấy mã ' \" + s + \" ' cần sửa trong danh sách khách hàng! \\n-----------------\"");
        }
    }

    public void docFile() {
        String line;
        String[] strings = new String[6];
        try {
            FileReader fr = new FileReader("KhachHang.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                strings = line.split(";");
                try {
                    KhachHang kh = new ThanhVien(strings[0],strings[1],strings[2],strings[3],strings[4],Integer.parseInt(strings[5]));
                    kh.Xuat();
                    System.out.println("------------------------------\n");
                    br.close();
                    fr.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi đọc file KhachHang.txt\n");
            e.printStackTrace();
        }
    }

    public void ghiFile() {
        System.out.println("\n---------Ghi file---------");
        if (DSKH == null) {
            System.out.println("Vui lòng tạo danh sách trước !");
            return;
        }
        if (DSKH.length == 0) {
            System.out.println("Danh sách hiện tại đang trống. Vui lòng thêm khách hàng. \n");
            return;
        }
        try {
            FileWriter fw = new FileWriter("KhachHang.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < DSKH.length; i++) {
                bw.write(DSKH[i].toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Ghi dữ liệu vào KhachHang.txt thành công.");
            DSKH_File = Arrays.copyOf(DSKH, DSKH.length);
        } catch (IOException ioException) {
            System.out.println("Lỗi ghi file: ");
            ioException.printStackTrace();
        }
    }
}
