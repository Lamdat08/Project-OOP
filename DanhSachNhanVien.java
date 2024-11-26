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
            System.out.println("Danh sách trống \n");
            return;
        }
        System.out.println("Nhập mã để xóa : ");
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
            System.out.println("Không tìm thấy ");
        }
    }

    @Override
    public void Them() {
        arrNhanVien = Arrays.copyOf(arrNhanVien,arrNhanVien.length+1);
        System.out.println("1 - Nhập danh sách nhân viên");
        System.out.println("2 - Nhập danh sách quản lý");

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
            System.out.println("Danh sách trống \n");
            return;
        }
        while(true){
            System.out.println("1 - Tìm kiếm theo mã");
            System.out.println("2 - Tìm kiếm theo tên");
            System.out.println("3 - Tìm kiếm theo SĐT");
            System.out.println("4 - Tìm kiếm theo giới tính");
            System.out.println("5 - Tìm kiếm theo lương cơ bản");

            int n = Integer.parseInt(sc.nextLine());

            if(n == 1){
                System.out.println("Nhập mã để tìm kiếm theo mã");
                String maTimKiem = sc.nextLine();
                boolean find = false;
                for(int i = 0;i< arrNhanVien.length;i++){
                    if(arrNhanVien[i].getMaNhanVien().equals(maTimKiem) && arrNhanVien[i].isTrangThai() == true){
                       arrNhanVien[i].Xuat();
                       find = true;
                    }
                }
                if(!find) System.out.println("Không tìm thấy mã " + maTimKiem);
            }
            if(n == 2){
                System.out.println("Nhập tên để tìm kiếm theo tên : ");
                String tenTimKiem = sc.nextLine();
                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getTenNhanVien().equals(tenTimKiem) && arrNhanVien[i].isTrangThai() == true){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("Không tìm thấy " + tenTimKiem);
            }
            if(n == 3){
                System.out.println("Nhập số điện thoại cần tìm kiếm:");
                String soDienThoaiTimKiem = sc.nextLine();
                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getTenNhanVien().equals(soDienThoaiTimKiem) && arrNhanVien[i].isTrangThai() == true){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("Không tìm thấy " + soDienThoaiTimKiem);
            }
            if(n == 4){
                System.out.println("Nhập giới tính cần tìm : ");
                String gioiTinhTimKiem = sc.nextLine();
                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getTenNhanVien().equals(gioiTinhTimKiem) && arrNhanVien[i].isTrangThai() == true){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("Không tìm thấy " + gioiTinhTimKiem);
            }
            if(n == 5){
                System.out.println("Nhập lương cơ bản cần tìm : ");
                String luongCoBanTimKiem = sc.nextLine();
                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getTenNhanVien().equals(luongCoBanTimKiem) && arrNhanVien[i].isTrangThai() == true){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("Không tìm thấy " + luongCoBanTimKiem);
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
                    System.out.println("Mã nhân viên : " + arr[0]);
                    System.out.println("Tên nhân viên : : " + arr[1]);
                    System.out.println("Số điện thoại : " +  arr[2]);
                    System.out.println("Giới tính : " + arr[3]);
                    System.out.println("Lương cơ bản : " + arr[4]);
                    System.out.println("Giờ làm : " + arr[5]);
                    System.out.println("Tổng lương nhân viên: " + arr[6]);
                }
                if(arr[0].substring(0,2).equals("QL")){
                    System.out.println("Mã quản lý :" + arr[0]);
                    System.out.println("Tên quản lý : " + arr[1]);
                    System.out.println("Số điện thoại : " + arr[2]);
                    System.out.println("Giới tính : " + arr[3]);
                    System.out.println("Lương cơ bản : " + arr[4]);
                    System.out.println("Phụ cấp : " + arr[5]);
                    System.out.println("Tổng lương quản lý : " + arr[6]);

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
            System.out.println("Danh sách trống \n");
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

            if (soLuong < arrNhanVien.length){
                arrNhanVien = Arrays.copyOf(arrNhanVien, soLuong);
            }

            arrNhanVienFile = Arrays.copyOf(arrNhanVien,arrNhanVien.length);
        }catch(IOException e){
            e.printStackTrace();
        }


    }




    @Override
    public void Xuat() {
        if (arrNhanVien == null || arrNhanVien.length == 0) {
            System.out.println("Danh sách nhân viên trống.");
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
            System.out.println("Danh sách nhân viên trống.");
            return;
        }
        System.out.println("Vui lòng nhập vào mã để sửa : ");
        String maSua = sc.nextLine();
        boolean find = false;
        for(int i = 0;i< arrNhanVien.length;i++){
            if(arrNhanVien[i].getMaNhanVien().equals(maSua) && arrNhanVien[i].isTrangThai() == true){
                arrNhanVien[i].Sua();
                arrNhanVien[i].Xuat();
                find = true;
            }
        }
        if(!find) System.out.println("Không tìm thấy mã" + maSua + " trong danh sách");
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
        System.out.println("Số lượng nhân viên :  " + soLuongNhanVien);
        System.out.println("Số lượng quản lý : " + soLuongQuanLy);

        System.out.println("các quản lý và nhân viên có lương lớn nhất : \n");

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

        System.out.println("các quản lý và nhân viên có lương nhỏ nhất : \n");

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

        System.out.println("Tổng lương của quản lý : " + tongLuongQuanLy + "\n");
        System.out.println("Tổng lương của nhân viên : " + tongLuongNhanVien + "\n");
        System.out.println("ương trung bình của quản lý : " + tongLuongQuanLy/soLuongQuanLy + "\n");
        System.out.println("Lương trung bình của nhân viên  :" + tongLuongNhanVien/soLuongNhanVien + "\n");
    }

}
