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
        System.out.println("Nhap danh sach khach hang: ");
    }

    public void menuTimKiem() {
        System.out.println("1 - Tiem kiem theo ma khach hang");
        System.out.println("2 - Tim kiem theo ten khach hang");
        System.out.println("3 - Tim kiem theo so dien thoai");
        System.out.println("4 - Tim kiem theo dia chi");
        System.out.println("5 - Tim kiem gioi tinh");
        System.out.println("6 - Thoat tim kiem");
    }

    public void Nhap() {
        System.out.println("Nhap so luong khach hang: ");
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
        System.out.println("Nhap ma khach hang muon xoa: ");
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
            System.out.println("Khong tim thay ma khach hang muon xoa");
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
                    System.out.println("Nhap ma khach hang can tim: ");
                    String maKH_TimKiem = sc.nextLine();
                    kq = false;
                    for (int i = 0; i < danhSachKhachHang.length; i++) {
                        if (danhSachKhachHang[i].getMaKH().equals(maKH_TimKiem)) {
                            danhSachKhachHang[i].Xuat();
                            kq = true;
                        }
                    }
                    if (!kq) {
                        System.out.println("Khong tim thay ma khach hang: " + maKH_TimKiem);
                    }
                    break;
                case 2:
                    System.out.println("Nhap ten khach hang can tim: ");
                    String tenKhachHang_TimKiem = sc.nextLine();
                    kq = false;
                    for (int i = 0; i < danhSachKhachHang.length; i++) {
                        if (danhSachKhachHang[i].getTenKH().equals(tenKhachHang_TimKiem)) {
                            danhSachKhachHang[i].Xuat();
                            kq = true;
                        }
                    }
                    if (!kq) {
                        System.out.println("Khong tim thay khach hang nao co ten: " + tenKhachHang_TimKiem);
                    }
                    break;
                case 3:
                    System.out.println("Nhap so dien thoai khach hang can tim: ");
                    String soDienKhachHang_TimKiem = sc.nextLine();
                    kq = false;
                    for (int i = 0; i < danhSachKhachHang.length; i++) {
                        if (danhSachKhachHang[i].getSDT().equals(soDienKhachHang_TimKiem)) {
                            danhSachKhachHang[i].Xuat();
                            kq = true;
                        }
                    }
                    if (!kq) {
                        System.out.println("Khong tim thay khach hang co SDT: " + soDienKhachHang_TimKiem);
                    }
                    break;
                case 4:
                    System.out.println("Nhap dia chi khach hang can tim: ");
                    String diaChiKhachHang_TimKiem = sc.nextLine();
                    kq = false;
                    for (int i = 0; i < danhSachKhachHang.length; i++) {
                        if (danhSachKhachHang[i].getDiaChi().equals(diaChiKhachHang_TimKiem)) {
                            danhSachKhachHang[i].Xuat();
                            kq = true;
                        }
                    }
                    if (!kq) {
                        System.out.println("Khong tim thay khach hang nao co dia chi: " + diaChiKhachHang_TimKiem);
                    }
                    break;
                case 5:
                    System.out.println("Nhap gioi tinh khach hang can tim: ");
                    String gioiTinhKhachHang_TimKiem = sc.nextLine();
                    kq = false;
                    for (int i = 0; i < danhSachKhachHang.length; i++) {
                        if (danhSachKhachHang[i].getGioiTinh().equals(gioiTinhKhachHang_TimKiem)) {
                            danhSachKhachHang[i].Xuat();
                            kq = true;
                        }
                    }
                    if (!kq) {
                        System.out.println("Khong tim thay khach hang nao co gioi tinh: " + gioiTinhKhachHang_TimKiem);
                    }
                    break;
                case 6:
                    System.out.println("Thoat tim kiem");
                default:
                    System.out.println("Khong co lua chon tim kiem nay. Moi nhap lai lua chon !");
                    break;
            }
            if (luachon == 6) {
                break;
            }
        }
    }

    public void Xuat() {
        if (danhSachKhachHang == null || danhSachKhachHang.length == 0) {
            System.out.println("Danh sach khach hang trong.");
            return;
        }
        for (int i = 0; i < danhSachKhachHang.length; i++) {
            danhSachKhachHang[i].Xuat();
        }
    }

    public void Sua() {
        System.out.println("Nhap ma khach hang cua khach hang can sua doi thong tin: ");
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
            System.out.println("Khong tim thay ma khach hang can sua");
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
            System.out.println("Doc file KhachHang.txt thanh cong.");
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
            System.out.println("Ghi file KhachHang.txt thanh cong.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
