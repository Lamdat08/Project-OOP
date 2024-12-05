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

        String maXoa;
        String regexNV = "^NV\\d+$";
        String regexQL = "^QL\\d+$";
        while(true){
            System.out.printf("Nhập vào mã nhân viên : ");
            maXoa = sc.nextLine();
            if (maXoa.matches(regexNV) || maXoa.matches(regexQL)){
                break;
            }
            else{
                System.out.println("Mã nhân viên bắt đầu là QL hoặc NV, sau đó là các chữ số,\n  vui lòng nhập lại mã nhân viên.");

            }
        }


        boolean find = false;

        for(int i = 0;i< arrNhanVien.length;i++){
            if(arrNhanVien[i].getMaNhanVien().equals(maXoa) && arrNhanVien[i].isTrangThai() == true){
                arrNhanVien[i].setTrangThai(false);
                soLuong--;
                System.out.println("Xóa thành công !!");
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

        int luaChon = 0;
        boolean isValid = false;
//
//        do{
//
//            luaChon = Integer.parseInt(sc.nextLine());
//
//        }while(luaChon != 1 && luaChon != 2);
        while(!isValid){
            try{
                luaChon = Integer.parseInt(sc.nextLine());
                if(luaChon == 1 || luaChon == 2){
                    isValid = true;
                }
                else{
                    System.out.println("Lựa chọn phải là 1 hoặc 2");
                }
            }catch(Exception e){
//                System.out.println(e);
                System.out.println("Chỉ nhập số");
            }
        }




        if(luaChon == 1){
            NhanVienPartTime x = new NhanVienPartTime();
            x.Nhap();
            arrNhanVien[arrNhanVien.length-1] = x;
            soLuong++;
        }
        if(luaChon == 2){
            QuanLy x = new QuanLy();
            x.Nhap();
            arrNhanVien[arrNhanVien.length-1] = x;
            soLuong++;
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
            System.out.println("6 - Thoat");

            int b = 0;
            boolean validInput= false;
            while (!validInput)
            {
                try {
                    System.out.printf("Nhập lựa chọn : ");
                    b = Integer.parseInt(sc.nextLine());

                    if ( b < 1 || b > 6) {
                        validInput = false;
                        System.out.println("Nhập từ 1 đến 6");
                    }
                    else
                        validInput = true;
                } catch (Exception e) {
//                    System.out.println(e);
                    System.out.println("Chỉ được nhập số");
                }
            }
            int n = b;


            if(n == 1){
                String maTimKiem;
                String regexNV = "^NV\\d+$";
                String regexQL = "^QL\\d+$";
                while (true) {
                    System.out.printf("Nhập vào mã nhân viên : ");
                    maTimKiem = sc.nextLine();
                    if (maTimKiem.matches(regexNV) || maTimKiem.matches(regexQL))
                        break;
                    else
                        System.out.println("Mã nhân viên bắt đầu là QL hoặc NV, sau đó là các chữ số,\n  vui lòng nhập lại mã nhân viên.");

                }
                boolean find = false;
                for(int i = 0;i< arrNhanVien.length;i++){
                    if(arrNhanVien[i].getMaNhanVien().equals(maTimKiem) && arrNhanVien[i].isTrangThai() == true){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("Không tìm thấy nhân viên có mã là " + maTimKiem);
            }
            if(n == 2){
                String tenTimKiem;
                do {
                    System.out.printf("Nhập vào tên : ");
                    tenTimKiem = sc.nextLine();
                    if (!tenTimKiem.matches(regexLetters))
                        System.out.println("Vui lòng nhập đúng định dạng (chỉ nhập chữ) ");
                }while (!tenTimKiem.matches(regexLetters));

                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getTenNhanVien().equals(tenTimKiem) && arrNhanVien[i].isTrangThai() == true){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("Không tìm thấy nhân viên có tên " + tenTimKiem);
            }
            if(n == 3){
                String soDienThoaiTimKiem;
                do {
                    do {
                        System.out.printf("Nhập vào SĐT : ");
                        soDienThoaiTimKiem = sc.nextLine();
                        if (!soDienThoaiTimKiem.matches(regNumbers))
                            System.out.println("Sai định dạng");
                    }while (!soDienThoaiTimKiem.matches(regNumbers));

                    if ( soDienThoaiTimKiem.length() != 10)
                        System.out.println("SĐT phải có 10 số");
                }while (soDienThoaiTimKiem.length() != 10 );

                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getSoDienThoai().equals(soDienThoaiTimKiem) && arrNhanVien[i].isTrangThai() == true){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("Không tìm thấy nhân viên có SĐT : " + soDienThoaiTimKiem);
            }
            if(n == 4){
                String gioiTinhTimKiem;
                while (true){
                    do {
                        System.out.printf("Nhập vào giới tính : ");
                        gioiTinhTimKiem = sc.nextLine();
                        if (!gioiTinhTimKiem.matches(regexLetters))
                            System.out.println("Sai định dạng");
                    }while (!gioiTinhTimKiem.matches(regexLetters));
                    if (gioiTinhTimKiem.toLowerCase().equals("nam") || gioiTinhTimKiem.equals("nu"))
                        break;
                    else
                        System.out.println("Nhập 'nam' hoặc 'nu'.");


                }


                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getGioiTinh().toLowerCase().equals(gioiTinhTimKiem) && arrNhanVien[i].isTrangThai() == true){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("Không tìm thấy nhân viên có giới tính là " + gioiTinhTimKiem);
            }
            if(n == 5){
                String luongCoBanTimKiem;
                do {
                    do {
                        System.out.printf("Nhập vào lương cơ bản : ");
                        luongCoBanTimKiem = sc.nextLine();
                        if (!luongCoBanTimKiem.matches(regNumbers))
                            System.out.println("Sai định dạng");
                    }while (!luongCoBanTimKiem.matches(regNumbers));

                    if (Double.parseDouble(luongCoBanTimKiem) < 0)
                        System.out.println("LCB > 0");
                }while (Double.parseDouble(luongCoBanTimKiem) < 0 );

                boolean find = false;
                for(int i = 0;i<arrNhanVien.length;i++){
                    if(arrNhanVien[i].getTenNhanVien().equals(luongCoBanTimKiem) && arrNhanVien[i].isTrangThai() == true){
                        arrNhanVien[i].Xuat();
                        find = true;
                    }
                }
                if(!find) System.out.println("Không tìm thấy nhân viên có lương cơ bản = " + luongCoBanTimKiem);
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
            System.out.println("Đọc file NhanVien : \n ");
            while((line = reader.readLine()) != null){
//                System.out.println(line);
                System.out.println();
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
                System.out.println("\n-----------------------------");
            }

            reader.close();
        }catch(IOException e){
            e.printStackTrace();
//            System.out.println();
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
                if (x.isTrangThai())
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
        System.out.println("\n Danh sách nhân viên : \n");
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
        String maSua;
        String regexNV = "^NV\\d+$";
        String regexQL = "^QL\\d+$";
        while (true){
            System.out.printf("Nhập vào mã nhân viên : ");
            maSua = sc.nextLine();
            if (maSua.matches(regexNV) || maSua.matches(regexQL))
                break;
            else
                System.out.println("Mã xoa bat dau QL hoac NV và sau đó là các chữ số, vui lòng nhập lại mã sự kiện .");
        }


        boolean find = false;
        for(int i = 0;i< arrNhanVien.length;i++){
            if(arrNhanVien[i].getMaNhanVien().equals(maSua) && arrNhanVien[i].isTrangThai() == true){
                arrNhanVien[i].Sua();
                arrNhanVien[i].Xuat();
                find = true;
            }
        }
        if(!find) System.out.println("Không tìm thấy mã " + maSua + " trong danh sách");
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
        System.out.println("Số lượng nhân viên parttime :  " + soLuongNhanVien);
        System.out.println("Số lượng quản lý : " + soLuongQuanLy);
        System.out.println("Tổng nhân viên : " + soLuong);

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
        System.out.println("Lương trung bình của quản lý : " + tongLuongQuanLy/soLuongQuanLy + "\n");
        System.out.println("Lương trung bình của nhân viên  :" + tongLuongNhanVien/soLuongNhanVien + "\n");
    }

}
