package Project_OOP;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachKhachHang implements IThaoTac_2 {

    static Scanner sc = new Scanner(System.in);

    private KhachHang[] danhSachKhachHang;
    private int soLuongKhachHang;

    public void menuNhap() {
        System.out.println("Nhập danh sách khách hàng: ");
    }

    public void menuTimKiem() {
        System.out.println("1 - Tìm kiếm theo mã khách hàng.");
        System.out.println("2 - Tìm kiếm theo tên khách hàng.");
        System.out.println("3 - Tìm kiếm theo số điện thoại.");
        System.out.println("4 - Tìm kiếm theo địa chỉ.");
        System.out.println("5 - Tìm kiếm theo giới tính.");
        System.out.println("6 - Thoát tìm kiếm.");
    }

    public void Nhap() {
        System.out.println("Nhập số lượng khách hàng để tạo danh sách: ");
        soLuongKhachHang = Integer.parseInt(sc.nextLine());
        danhSachKhachHang = new KhachHang[soLuongKhachHang];
        for (int i = 0; i < soLuongKhachHang; i++) {
            KhachHang kh = new KhachHang();
            kh.Nhap();
            danhSachKhachHang[i] = kh;
        }
    }

    public void Them() {
        danhSachKhachHang = Arrays.copyOf(danhSachKhachHang, danhSachKhachHang.length + 1);
        KhachHang kh = new KhachHang();
        kh.Nhap();
        danhSachKhachHang[danhSachKhachHang.length - 1] = kh;
    }

    public void Xoa() {
        System.out.println("Nhập mã khách hàng muốn xóa: ");
        String maKH_Xoa = sc.nextLine();
        boolean kq = false;
        for (int i = 0; i < danhSachKhachHang.length; i++) {
            if (danhSachKhachHang[i].getMaKH().equals(maKH_Xoa)) {
                for (int j = i + 1; j < danhSachKhachHang.length; j++) {
                    danhSachKhachHang[i] = danhSachKhachHang[j];
                }
                kq = true;
            }
        }
        if (!kq) {
            System.out.println("Không tìm thấy mã khách hàng muốn xóa.");
        }
        else {
            danhSachKhachHang = Arrays.copyOf(danhSachKhachHang, danhSachKhachHang.length - 1);
        }
    }

    public void TimKiem() {
        while (true) {
            menuTimKiem();
            int luachon = Integer.parseInt(sc.nextLine());
            boolean kq;
            switch (luachon) {
                case 1:
                    System.out.println("Nhập mã khách hàng cần tìm: ");
                    String maKH_TimKiem = sc.nextLine();
                    kq = false;
                    for (int i = 0; i < danhSachKhachHang.length; i++) {
                        if (danhSachKhachHang[i].getMaKH().equals(maKH_TimKiem)) {
                            danhSachKhachHang[i].Xuat();
                            kq = true;
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
                    for (int i = 0; i < danhSachKhachHang.length; i++) {
                        if (danhSachKhachHang[i].getTenKH().equals(tenKhachHang_TimKiem)) {
                            danhSachKhachHang[i].Xuat();
                            kq = true;
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
                    for (int i = 0; i < danhSachKhachHang.length; i++) {
                        if (danhSachKhachHang[i].getSDT().equals(soDienKhachHang_TimKiem)) {
                            danhSachKhachHang[i].Xuat();
                            kq = true;
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
                    for (int i = 0; i < danhSachKhachHang.length; i++) {
                        if (danhSachKhachHang[i].getDiaChi().equals(diaChiKhachHang_TimKiem)) {
                            danhSachKhachHang[i].Xuat();
                            kq = true;
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
                    for (int i = 0; i < danhSachKhachHang.length; i++) {
                        if (danhSachKhachHang[i].getGioiTinh().equals(gioiTinhKhachHang_TimKiem)) {
                            danhSachKhachHang[i].Xuat();
                            kq = true;
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
        if (danhSachKhachHang == null || danhSachKhachHang.length == 0) {
            System.out.println("Danh sách khách hàng trống.");
            return;
        }
        for (int i = 0; i < danhSachKhachHang.length; i++) {
            danhSachKhachHang[i].Xuat();
        }
    }

    public void Sua() {
        System.out.println("Nhập mã của khách hàng cần sửa đổi thông tin: ");
        String maKH_Sua = sc.nextLine();
        boolean kq = false;
        for (int i = 0; i < danhSachKhachHang.length; i++) {
            if (danhSachKhachHang[i].getMaKH().equals(maKH_Sua)) {
                danhSachKhachHang[i].Sua();
                danhSachKhachHang[i].Xuat();
                kq = true;
            }
        }
        if (!kq) {
            System.out.println("Không tìm thấy mã của khách hàng cần sửa đổi thông tin");
        }
    }

    public void docFile() {
        try {
            FileReader fr = new FileReader("KhachHang.txt");
            BufferedReader br = new BufferedReader(fr);
            String st;
            while ((st = br.readLine()) != null) {
                String[] phan = st.split(",");
                KhachHang kh = new KhachHang();
                kh.setMaKH(phan[0]);
                kh.setTenKH(phan[1]);
                kh.setSDT(phan[2]);
                kh.setDiaChi(phan[3]);
                kh.setGioiTinh(phan[4]);
                danhSachKhachHang = Arrays.copyOf(danhSachKhachHang, danhSachKhachHang.length + 1);
                danhSachKhachHang[danhSachKhachHang.length - 1] = kh;
            }
            br.close();
            fr.close();
            System.out.println("Doc file KhachHang.txt thành công.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void ghiFile() {
        try {
            FileWriter fw = new FileWriter("KhachHang.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < danhSachKhachHang.length; i++) {
                bw.write(danhSachKhachHang[i].toString() + "\n");
            }
            bw.close();
            fw.close();
            System.out.println("Ghi file KhachHang.txt thành công.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
