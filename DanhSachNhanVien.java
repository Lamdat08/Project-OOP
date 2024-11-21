package Project_OOP;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachNhanVien implements IThaoTac_2{
    Scanner sc = new Scanner(System.in);
//    private int soLuongPhanTuThemVao;
    private NhanVien[] arrNhanVien;
    private static int soLuong;
//    public DanhSachNhanVien() {
//        arrNhanVien = new NhanVien[0];
//    }

    private NhanVien[]arrNhanVienFile;


    public DanhSachNhanVien() {
        soLuong = 0;
        this.arrNhanVien = new NhanVien[5];
        this.Nhap();
    }

    @Override
    public void Xoa() {
        if(soLuong == 0){
            System.out.println("Danh sach trong \n");
            return;
        }
        System.out.println("Nhap Ma De Xoa");
        String maXoa = sc.nextLine();
        boolean find = false;

        for(int i = 0;i< arrNhanVien.length;i++){
            if(arrNhanVien[i].getMaNhanVien().equals(maXoa) && arrNhanVien[i].isTrangThai() == true){
                arrNhanVien[i].setTrangThai(false);
                soLuong--;
                find = true;
            }
        }
        if(!find){
            System.out.println("khong tim thay");
        }
    }

    @Override
    public void Them() {
        arrNhanVien = Arrays.copyOf(arrNhanVien,arrNhanVien.length+1);
        System.out.println("1-Nhap danh sach nhan vien");
        System.out.println("2-Nhap danh sach quan ly");

        int luaChon;

        do{

            luaChon = Integer.parseInt(sc.nextLine());

        }while(luaChon != 1 && luaChon != 2);

        if(luaChon == 1){
            NhanVienPartTime x = new NhanVienPartTime();
            x.Nhap();
            arrNhanVien[arrNhanVien.length-1] = x;
        }
        if(luaChon == 2){
            QuanLy x = new QuanLy();
            x.Nhap();
            arrNhanVien[arrNhanVien.length-1] = x;
        }

    }

    @Override
    public void TimKiem() {
        if(soLuong == 0){
            System.out.println("Danh sach trong \n");
            return;
        }
        while(true){
            System.out.println("1-Tim kiem theo ma");
            System.out.println("2-Tim kiem theo ten");
            System.out.println("3-Tim kiem theo sdt");
            System.out.println("4-Tim kiem theo gioi tinh");
            System.out.println("5-Tim kiem luong co ban");

            int n = Integer.parseInt(sc.nextLine());

            if(n == 1){
                System.out.println("Nhap ma de tim kiem theo ma");
                String maTimKiem = sc.nextLine();
                boolean find = false;
                for(int i = 0;i< arrNhanVien.length;i++){
                    if(arrNhanVien[i].getMaNhanVien().equals(maTimKiem) && arrNhanVien[i].isTrangThai() == true){
                       arrNhanVien[i].Xuat();
                       find = true;
                    }
                }
                if(!find) System.out.println("khong tim thay");
            }
            if(n == 2){
                System.out.println("Nhap ten de tim kiem theo ten");
                String tenTimKiem = sc.nextLine();
                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getTenNhanVien().equals(tenTimKiem) && arrNhanVien[i].isTrangThai() == true){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("khong tim thay");
            }
            if(n == 3){
                System.out.println("Nhap so dien thoai tim kiem theo so dien thoai");
                String soDienThoaiTimKiem = sc.nextLine();
                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getTenNhanVien().equals(soDienThoaiTimKiem) && arrNhanVien[i].isTrangThai() == true){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("khong tim thay");
            }
            if(n == 4){
                System.out.println("Nhap gioi tinh de tim kiem theo gioi tinh");
                String gioiTinhTimKiem = sc.nextLine();
                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getTenNhanVien().equals(gioiTinhTimKiem) && arrNhanVien[i].isTrangThai() == true){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("khong tim thay");
            }
            if(n == 5){
                System.out.println("Nhap luong co ban de tim kiem theo luong co ban");
                String luongCoBanTimKiem = sc.nextLine();
                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getTenNhanVien().equals(luongCoBanTimKiem) && arrNhanVien[i].isTrangThai() == true){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("khong tim thay");
            }

            if(n == 6){
                break;
            }
        }

    }

//    @Override
    public void docFile() {

        try{
            BufferedReader reader = new BufferedReader(new FileReader("NhanVien.txt"));
            String line;

            while((line = reader.readLine()) != null){
//                System.out.println(line);
                String arr[] = line.split(";");
                if(arr[0].substring(0,2).equals("NV")){
                    System.out.println("Ma Nhan Vien : " + arr[0]);
                    System.out.println("Ten Nhan Vien : " + arr[1]);
                    System.out.println("So dien thoai nhan vien : " +  arr[2]);
                    System.out.println("gioi tinh : " + arr[3]);
                    System.out.println("luong co ban : " + arr[4]);
                    System.out.println("gio lam : " + arr[5]);
                    System.out.println("tong luong : " + arr[6]);
                }
                if(arr[0].substring(0,2).equals("QL")){
                    System.out.println("Ma Quan ly : " + arr[0]);
                    System.out.println("Ten Quan ly : " + arr[1]);
                    System.out.println("So dien thoai Quan ly : " + arr[2]);
                    System.out.println("gioi tinh Quan ly : " + arr[3]);
                    System.out.println("luong co ban Quan ly : " + arr[4]);
                    System.out.println("Phu cap quan ly : " + arr[5]);
                    System.out.println("tong luong quan ly : " + arr[6]);

                }
            }

            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

//    @Override
//    public void ghiFile() {
//
//        try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))){
//
//            System.out.println("00- neu nhap nhan vien");
//            System.out.println("10- neu nhap quan ly");
//            System.out.println("11- thoat");
//
//
//            while (true) {
//                String maXacDinh = sc.nextLine();
//                if (maXacDinh.equals("11")) break;
//                if (maXacDinh.equals("00")) {
//                    NhanVienPartTime nvpt = new NhanVienPartTime();
//                    nvpt.Nhap();
//                    writer.write(nvpt.getMaNhanVien()+ " ,");
//                    writer.write(nvpt.getTenNhanVien()+ " ,");
//                    writer.write(nvpt.getSoDienThoai()+ " ,");
//                    writer.write(nvpt.getGioiTinh()+" ,");
//                    writer.write(String.valueOf(nvpt.getLuongCoBan())+" ,");
//                    writer.write(String.valueOf(nvpt.getGioLam())+ ",");
//                    writer.newLine();
//                }
//                if (maXacDinh.equals("10")) {
//                    QuanLy ql = new QuanLy();
//                    ql.Nhap();
//                    writer.write(ql.getMaNhanVien() + " ,");
//                    writer.write(ql.getTenNhanVien() + " ,");
//                    writer.write(ql.getSoDienThoai() + " ,");
//                    writer.write(ql.getGioiTinh() + " ,");
//                    writer.write(String.valueOf(ql.getLuongCoBan()) + " ,");
//                    writer.write(String.valueOf(ql.getPhuCap()) + " ,");
//                    writer.newLine();
//                }
//
//            }
//            System.out.println("file written successful");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void ghiFile() {
        if(soLuong == 0){
            System.out.println("Danh sach trong \n");
            return;
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("NhanVien.txt"))){




//            while (true) {
//                String maXacDinh = sc.nextLine();
//                if (maXacDinh.equals("11")) break;
//                if (maXacDinh.equals("00")) {
//                    NhanVienPartTime nvpt = new NhanVienPartTime();
//                    nvpt.Nhap();
//                    writer.write(nvpt.getMaNhanVien()+ " ,");
//                    writer.write(nvpt.getTenNhanVien()+ " ,");
//                    writer.write(nvpt.getSoDienThoai()+ " ,");
//                    writer.write(nvpt.getGioiTinh()+" ,");
//                    writer.write(String.valueOf(nvpt.getLuongCoBan())+" ,");
//                    writer.write(String.valueOf(nvpt.getGioLam())+ ",");
//                    writer.newLine();
//                }
//                if (maXacDinh.equals("10")) {
//                    QuanLy ql = new QuanLy();
//                    ql.Nhap();
//                    writer.write(ql.getMaNhanVien() + " ,");
//                    writer.write(ql.getTenNhanVien() + " ,");
//                    writer.write(ql.getSoDienThoai() + " ,");
//                    writer.write(ql.getGioiTinh() + " ,");
//                    writer.write(String.valueOf(ql.getLuongCoBan()) + " ,");
//                    writer.write(String.valueOf(ql.getPhuCap()) + " ,");
//                    writer.newLine();
//                }
//
//            }

            for(NhanVien x : arrNhanVien){
               writer.write(x.toString() + "\n");
            }
            System.out.println("file written successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Nhap() {
//        if(arrNhanVien == null){
//            System.out.println("Nhap so luong phan tu khoi tao ban dau");

//            soLuongPhanTuThemVao = Integer.parseInt(sc.nextLine());
//            arrNhanVien = new NhanVien[soLuongPhanTuThemVao];

//            for(int i = 0;i<soLuongPhanTuThemVao;i++){
//                System.out.println("1-Nhap danh sach nhan vien");
//                System.out.println("2-Nhap danh sach quan ly");

//                int luaChon;

//                do{

//                    luaChon = Integer.parseInt(sc.nextLine());

//                }while(luaChon != 1 && luaChon != 2);
//
//                if(luaChon == 1){
//                    NhanVienPartTime x = new NhanVienPartTime();
//                    x.Nhap();
//                    arrNhanVien[i] = x;
//                }
//                if(luaChon == 2){
//                    QuanLy x = new QuanLy();
//                    x.Nhap();
//                    arrNhanVien[i] = x;
//                }
//
//            }
//        }
//        else{
//            System.out.println("Danh sach tao roi");
//        }
        try{
            BufferedReader reader =  new BufferedReader(new FileReader("NhanVien.txt"));
            String line;
//            int i = 0;
            while((line =reader.readLine())!=null){
                    if(soLuong == arrNhanVien.length){
                        arrNhanVien = Arrays.copyOf(arrNhanVien,arrNhanVien.length+1);
                    }
                    String arr[] = line.split(";");
                    if(arr[0].substring(0,2).equals("NV")){
                        NhanVienPartTime nvpt = new NhanVienPartTime();
                           nvpt.setMaNhanVien(arr[0]);
                           nvpt.setTenNhanVien(arr[1]);
                           nvpt.setSoDienThoai(arr[2]);
                           nvpt.setGioiTinh(arr[3]);
                           nvpt.setLuongCoBan(Double.parseDouble(arr[4]));
                           nvpt.setGioLam(Double.parseDouble(arr[5]));

                           arrNhanVien[soLuong++] = nvpt;
                    }
                    if(arr[0].substring(0,2).equals("QL")){
                         QuanLy ql = new QuanLy(arr[0],arr[1],arr[2],arr[3],Double.parseDouble(arr[4]),Double.parseDouble(arr[5]));
                         arrNhanVien[soLuong++] = ql;
                    }



            }
            arrNhanVienFile = Arrays.copyOf(arrNhanVien,arrNhanVien.length);
        }catch(IOException e){
            e.printStackTrace();
        }


    }




    @Override
    public void Xuat() {
        if (arrNhanVien == null || arrNhanVien.length == 0) {
            System.out.println("Danh sach nhan vien trong.");
            return;
        }
        for(int i = 0;i<arrNhanVien.length;i++){
           if(arrNhanVien[i].isTrangThai() == true){
               arrNhanVien[i].Xuat();
           }
        }
    }

    @Override
    public void Sua() {
        if(soLuong == 0){
            System.out.println("Danh sach trong \n");
            return;
        }
        System.out.println("Vui Long Nhap Vao Ma De Sua");
        String maSua = sc.nextLine();
        boolean find = false;
        for(int i = 0;i< arrNhanVien.length;i++){
            if(arrNhanVien[i].getMaNhanVien().equals(maSua) && arrNhanVien[i].isTrangThai() == true){
                arrNhanVien[i].Sua();
                arrNhanVien[i].Xuat();
                find = true;
            }
        }
        if(!find) System.out.println("khong tim thay");
    }


    public void thongKe(){
        int soLuongQuanLy = 0;
        int soLuongNhanVien = 0;
        double luongLonNhatCuaQuanLy = (int)Integer.MIN_VALUE;
        double luongNhoNhatCuaQuanLy = (int)Integer.MAX_VALUE;
        double luongLonNhatCuaNhanVien = (int)Integer.MIN_VALUE;
        double luongNhoNhatCuaNhanVien = (int)Integer.MAX_VALUE;
        double tongLuongNhanVien = 0;
        double tongLuongQuanLy = 0;
        for(int i = 0;i<arrNhanVienFile.length;i++){
            if(arrNhanVienFile[i] instanceof QuanLy){
                soLuongQuanLy++;
            }
            if(arrNhanVienFile[i] instanceof NhanVienPartTime){
                soLuongNhanVien++;
            }
        }

        for(int i =0;i<arrNhanVienFile.length;i++){

            if(arrNhanVienFile[i] instanceof QuanLy){
                double currentLuong = ((QuanLy) arrNhanVienFile[i]).tinhLuong();
                tongLuongQuanLy += currentLuong;
                luongLonNhatCuaQuanLy = Math.max(luongLonNhatCuaQuanLy,currentLuong);
                luongNhoNhatCuaQuanLy = Math.min(luongNhoNhatCuaQuanLy,currentLuong);
            }

            if(arrNhanVienFile[i] instanceof NhanVienPartTime){
                double currentLuong = ((NhanVienPartTime) arrNhanVienFile[i]).tinhLuong();
                tongLuongNhanVien+= currentLuong;
                luongLonNhatCuaNhanVien = Math.max(luongLonNhatCuaNhanVien,currentLuong);
                luongNhoNhatCuaNhanVien = Math.max(luongNhoNhatCuaNhanVien,currentLuong);
            }

        }
        System.out.println("So Luong Nhan Vien" + soLuongNhanVien);
        System.out.println("So Luong Quan Ly" + soLuongQuanLy);

        System.out.println("Quan Ly va nhan vien co luong lon nhat: \n");

        for(int i = 0;i<arrNhanVienFile.length;i++){
            if(arrNhanVienFile[i] instanceof QuanLy){
                double currentLuong = ((QuanLy) arrNhanVienFile[i]).tinhLuong();
                if(currentLuong == luongLonNhatCuaQuanLy){
                   arrNhanVienFile[i].Xuat();
                }
            }
            if(arrNhanVienFile[i] instanceof NhanVienPartTime){
                double currentLuong = ((NhanVienPartTime) arrNhanVienFile[i]).tinhLuong();
                if(currentLuong == luongLonNhatCuaNhanVien){
                    arrNhanVienFile[i].Xuat();
                }
            }
        }

        System.out.println("Quan ly va nhan vien co luong lon nhat va nho nhat: \n");

        for(int i = 0;i<arrNhanVienFile.length;i++){
            if(arrNhanVienFile[i] instanceof QuanLy){
                double currentLuong = ((QuanLy) arrNhanVienFile[i]).tinhLuong();
                if(currentLuong == luongNhoNhatCuaQuanLy){
                    arrNhanVienFile[i].Xuat();
                }
            }
            if(arrNhanVienFile[i] instanceof NhanVienPartTime){
                double currentLuong = ((NhanVienPartTime) arrNhanVienFile[i]).tinhLuong();
                if(currentLuong == luongNhoNhatCuaNhanVien){
                    arrNhanVienFile[i].Xuat();
                }
            }
        }

        System.out.println("Tong Luong Cua Quan Ly : " + tongLuongQuanLy + "\n");
        System.out.println("Tong Luong Cua Nhan Vien : " + tongLuongNhanVien + "\n");
        System.out.println("Tong Luong Trung Binh Cua Quan Ly : " + tongLuongQuanLy/soLuongQuanLy + "\n");
        System.out.println("Tong Luong Trung Binh Cua Nhan Vien : " + tongLuongNhanVien/soLuongNhanVien + "\n");
    }

}
