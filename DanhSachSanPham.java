package Project_OOP;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSanPham implements IThaoTac_2 {

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
        System.out.println("6 - Thoat tim kiem");
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
        while(true){
            menuTimKiem();
            int luaChon = Integer.parseInt(sc.nextLine());
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
                        System.out.println("Khong tim thay ma san pham: " + maSP_TimKiem);
                    }
                    break;
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
                        System.out.println("Khong tim thay ten san pham: " + tenSP_TimKiem);
                    }
                    break;
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
                        System.out.println("Khong tim thay san pham co so luong: " + soLuongSP_TimKiem);
                    }
                    break;
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
                        System.out.println("Khong tim thay san pham co gia tien: " + giaTienSP_TimKiem);
                    }
                    break;
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
                        System.out.println("Khong tim thay san pham co tien von: " + tienVonSP_TimKiem);
                    }
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh");
                    return;
                default:
                    System.out.println("Khong co lua chon tim kiem nay. Moi nhap 6 de thoat tim kiem hoac nhap 1 - 5 de tim kiem");
                    break;
            }
            if(luaChon == 6){
                break;
            }
        }

    }

    public void Xuat() {
        if (danhSachSanPham == null || danhSachSanPham.length == 0) {
            System.out.println("Danh sach san pham trong.");
            return;
        }
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
        try{
            FileReader fr = new FileReader("SanPham.txt");
            BufferedReader br = new BufferedReader(fr);
            String st;
            while((st = br.readLine()) != null){
                String[] phan = st.split(",");
                if(phan[0] == "Thuc An"){
                    ThucAn sp = new ThucAn();
                    sp.setMaSP(phan[1]);
                    sp.setTenSP(phan[2]);
                    sp.setSoLuong(Integer.parseInt(phan[3]));
                    sp.setGiaTien(Double.parseDouble(phan[4]));
                    sp.setTienVon(Double.parseDouble(phan[5]));
                    sp.setLoaiThucAn(phan[6]);
                    //Them Thuc An vao danh sach san pham
                    danhSachSanPham = Arrays.copyOf(danhSachSanPham, danhSachSanPham.length + 1);
                    danhSachSanPham[danhSachSanPham.length - 1] = sp;
                }
                if(phan[0] == "Nuoc uong"){
                    NuocUong sp = new NuocUong();
                    sp.setMaSP(phan[1]);
                    sp.setTenSP(phan[2]);
                    sp.setSoLuong(Integer.parseInt(phan[3]));
                    sp.setGiaTien(Double.parseDouble(phan[4]));
                    sp.setTienVon(Double.parseDouble(phan[5]));
                    sp.setLoaiNuoc(phan[6]);
                    //Them Nuoc uong vao danh sach san pham
                    danhSachSanPham = Arrays.copyOf(danhSachSanPham, danhSachSanPham.length + 1);
                    danhSachSanPham[danhSachSanPham.length - 1] = sp;
                }
            }
            br.close();
            fr.close();
            System.out.println("Doc file SanPham.txt thanh cong");
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    public void ghiFile(){
        try{
            FileWriter fw = new FileWriter("SanPham.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i < danhSachSanPham.length; i++){
                bw.write(danhSachSanPham[i].toString() + "\n");
            }
            bw.close();
            fw.close();
            System.out.println("Ghi file SanPham.txt thanh cong");
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
