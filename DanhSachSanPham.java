package Project_OOP;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSanPham implements IThaoTac_2 {

    private static int soLuongSanPham;
    private SanPham[] danhSachSanPham;
    private SanPham[] danhSachSanPham_File;

    static Scanner sc = new Scanner(System.in);

    public DanhSachSanPham(){
        this.danhSachSanPham = new SanPham[5];
        this.Nhap();
    }

    public void menuNhap(){
        System.out.println("1 - Nhập thức ăn");
        System.out.println("2 - Nhập nước uống");
    }
    public void menuTimKiem(){
        System.out.println("1 - Tìm kiếm theo mã sản phầm");
        System.out.println("2 - Tìm kiếm theo tên sản phẩm");
        System.out.println("3 - Tìm kiếm theo số lượng sản phẩm");
        System.out.println("4 - Tìm kiếm theo giá tiền sản phẩm");
        System.out.println("5 - Tìm kiếm theo tiền vốn sản phẩm");
        System.out.println("6 - Thoát tìm kiếm sản phẩm");
    }

//    public void Nhap(){
//        System.out.println("Nhập số lượng sản phẩm muốn tạo của danh sách: ");
//        soLuongSanPham = Integer.parseInt(sc.nextLine());
//        danhSachSanPham = new SanPham[soLuongSanPham];
//        for(int i = 0; i < soLuongSanPham; i++){
//            SanPham sp;
//            menuNhap();
//            System.out.println("Nhập loại sản phẩm muốn thêm: ");
//            int luaChon = Integer.parseInt(sc.nextLine());
//            while(luaChon != 1 && luaChon != 2){
//                menuNhap();
//                System.out.println("Không có loại sản phẩm này, mới nhập lại: ");
//                luaChon = Integer.parseInt(sc.nextLine());
//            }
//
//            if(luaChon == 1){
//                sp = new ThucAn();
//                sp.Nhap();
//                danhSachSanPham[i] = sp;
//            }
//            if(luaChon == 2){
//                sp = new NuocUong();
//                sp.Nhap();
//                danhSachSanPham[i] = sp;
//            }
//        }
//    }
    public void Nhap(){
        String line;
        String[] strings = new String[6];
        try{
            FileReader fr = new FileReader("SanPham.txt");
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null){
                if(soLuongSanPham == danhSachSanPham.length){
                    danhSachSanPham = Arrays.copyOf(danhSachSanPham, danhSachSanPham.length + 6);
                }

                strings = line.split(";");
                try{
                    SanPham sp = new SanPham();
                    if(strings[0].startsWith("TA")){
                        sp = new ThucAn(strings[0], strings[1], Integer.parseInt(strings[2]), Double.parseDouble(strings[3]), Double.parseDouble(strings[4]), strings[5]);
                    }
                    if(strings[0].startsWith("NU")){
                        sp = new NuocUong(strings[0], strings[1], Integer.parseInt(strings[2]), Double.parseDouble(strings[3]), Double.parseDouble(strings[4]), strings[5]);
                    }
                    danhSachSanPham[soLuongSanPham] = sp;
                    soLuongSanPham++;
                }
                catch (Exception e){

                }
            }
        }
        catch (Exception e){
            System.out.println("Lỗi đọc file SanPham.txt: ");
            e.printStackTrace();
        }
        if(soLuongSanPham < danhSachSanPham.length){
            danhSachSanPham = Arrays.copyOf(danhSachSanPham, soLuongSanPham);
        }

        danhSachSanPham_File = Arrays.copyOf(danhSachSanPham, danhSachSanPham.length);
    }
    public void Them(){
        System.out.println("\n \t \t---------Thêm sản phẩm---------");

        if (danhSachSanPham == null) {
            System.out.println("Danh sách sản phẩm chưa được khởi tạo.");
            return;
        }
        if(danhSachSanPham.length == 0){
            System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm. \n");
            return;
        }

        int n;
        do{
            System.out.println("Nhập số lượng sản phẩm muốn thêm: ");
            n = Integer.parseInt(sc.nextLine());
            if(n <= 0){
                System.out.println("Không hợp lệ, vui lòng nhập số lượng > 0: ");
            }
        } while(n <= 0);

        soLuongSanPham += n;
        danhSachSanPham = Arrays.copyOf(danhSachSanPham, danhSachSanPham.length + n);
        SanPham sp;

        int slSPBanDau = danhSachSanPham.length - n;
        for(int i = slSPBanDau; i < danhSachSanPham.length; i++){
            menuNhap();
            System.out.println("Nhập loại sản phẩm muốn thêm: ");
            int luaChon = Integer.parseInt(sc.nextLine());
            while(luaChon != 1 && luaChon != 2){
                menuNhap();
                System.out.println("Không có loại sản phẩm này, mới nhập lại: ");
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
    public void Xoa(){
        System.out.println("\n---------Xóa sản phẩm---------");

        if (danhSachSanPham == null) {
            System.out.println("Danh sách sản phẩm chưa được khởi tạo.");
            return;
        }
        if(danhSachSanPham.length == 0){
            System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm. \n");
            return;
        }

        System.out.println("Nhập mã sản phẩm muốn xoá: ");
        String maSP_Xoa = sc.nextLine();
        boolean kq = false;
        for(int i = 0; i < danhSachSanPham.length - 1; i++){
            if(danhSachSanPham[i].getMaSP().equals(maSP_Xoa)){
                for(int j = i + 1; j < danhSachSanPham.length; j++){
                    danhSachSanPham[i] = danhSachSanPham[j];
                }
                kq = true;
            }
        }
        if(!kq){
            System.out.println("Không tìm thấy mã sản phẩm" + maSP_Xoa + " muốn xoá");
        }
        else{
            danhSachSanPham = Arrays.copyOf(danhSachSanPham, danhSachSanPham.length - 1);
            System.out.println("Xóa sản phẩm thành công!\n-------------------");
            soLuongSanPham--;
        }
    }

    public void TimKiem(){
        System.out.println("\n---------Tìm kiếm sản phẩm---------");

        if (danhSachSanPham == null) {
            System.out.println("Vui lòng tạo danh sách sản phẩm trước !!");
            return;
        }
        if (danhSachSanPham.length == 0){
            System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm. \n");
            return;
        }

        while(true){
            boolean kq;
            menuTimKiem();
            System.out.println("Nhập loại sản phẩm muốn thêm: ");
            int luaChon = Integer.parseInt(sc.nextLine());
            while(luaChon < 1 || luaChon > 6){
                menuNhap();
                System.out.println("Không có loại sản phẩm này, mời nhập lại: ");
                luaChon = Integer.parseInt(sc.nextLine());
            }

            switch(luaChon){
                case 1:
                    System.out.println("Nhập mã sản phẩm cần tìm: ");
                    String maSP_TimKiem = sc.nextLine();
                    kq = false;
                    for(int i = 0; i < danhSachSanPham.length; i++){
                        if(danhSachSanPham[i].getMaSP().equals(maSP_TimKiem)){
                            danhSachSanPham[i].Xuat();
                            kq = true;
                            System.out.println("\n \t--------------------");
                        }
                    }
                    if(!kq){
                        System.out.println("Không tìm thấy mã sản phẩm: " + maSP_TimKiem + " trong danh sách sản phẩm!");
                    }
                    break;
                case 2:
                    System.out.println("Nhập tên sản phẩm cần tìm: ");
                    String tenSP_TimKiem = sc.nextLine();
                    kq = false;
                    for(int i = 0; i < danhSachSanPham.length; i++){
                        if(danhSachSanPham[i].getTenSP().equals(tenSP_TimKiem)){
                            danhSachSanPham[i].Xuat();
                            kq = true;
                        }
                    }
                    if(!kq){
                        System.out.println("Không tìm thấy tên sản phẩm: " + tenSP_TimKiem + " trong danh sách sản phẩm!");
                    }
                    break;
                case 3:
                    System.out.println("Nhập số lượng của sản phẩm cần tìm: ");
                    int soLuongSP_TimKiem = Integer.parseInt(sc.nextLine());
                    kq = false;
                    for(int i = 0; i < danhSachSanPham.length; i++){
                        if(danhSachSanPham[i].getSoLuong() == soLuongSP_TimKiem){
                            danhSachSanPham[i].Xuat();
                            kq = true;
                        }
                    }
                    if(!kq){
                        System.out.println("Không tìm thấy sản phẩm có số lượng: " + soLuongSP_TimKiem + " trong danh sách sản phẩm!");
                    }
                    break;
                case 4:
                    System.out.println("Nhập giá tiền của san phẩm cần tìm: ");
                    double giaTienSP_TimKiem = Double.parseDouble(sc.nextLine());
                    kq = false;
                    for(int i = 0; i < danhSachSanPham.length; i++){
                        if(danhSachSanPham[i].getGiaTien() == giaTienSP_TimKiem){
                            danhSachSanPham[i].Xuat();
                            kq = true;
                        }
                    }
                    if(!kq){
                        System.out.println("Không tìm thấy sản phẩm có giá tiền: " + giaTienSP_TimKiem + " trong danh sách sản phẩm!");
                    }
                    break;
                case 5:
                    System.out.println("Nhập tiền vốn của sản phẩm cần tìm: ");
                    double tienVonSP_TimKiem = Double.parseDouble(sc.nextLine());
                    kq = false;
                    for(int i = 0; i < danhSachSanPham.length; i++){
                        if(danhSachSanPham[i].getTienVon() == tienVonSP_TimKiem){
                            danhSachSanPham[i].Xuat();
                            kq = true;
                        }
                    }
                    if(!kq){
                        System.out.println("Không tìm thấy sản phẩm có tiền vốn: " + tienVonSP_TimKiem + " trong danh sách sản phẩm!");
                    }
                    break;
                case 6:
                    System.out.println("Thoát tìm kiếm sản phẩm");
                    return;
                default:
                    System.out.println("Không có lựa chọn tìm kiếm sản phẩm này");
                    break;
            }
            if(luaChon == 6){
                break;
            }
        }

    }

    public void Xuat() {
        System.out.println("\n \t \t---------Xuất danh sách sản phẩm---------");

        if (danhSachSanPham == null ){
            System.out.println("Vui lòng tạo danh sách sản phẩm trước !!");
            return;
        }
        if (danhSachSanPham.length == 0){
            System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm. \n");
            return;
        }

        System.out.println("\tThông tin của danh sách sản phẩm \n--------------------------");
        for(int i = 0;i<danhSachSanPham.length;i++){
            danhSachSanPham[i].Xuat();
            System.out.println("\t--------------");
        }
    }

    public void Sua(){
        System.out.println("\n \t \t---------Sửa sản phẩm---------");

        if (danhSachSanPham == null) {
            System.out.println("Danh sách sản phẩm chưa được khởi tạo.");
            return;
        }
        if (danhSachSanPham.length == 0){
            System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm. \n");
            return;
        }

        System.out.println("Nhập mã của sản phẩm cần sửa: ");
        String maSP_Sua = sc.nextLine();
        boolean kq = false;

        for(int i = 0; i < danhSachSanPham.length; i++){
            if(danhSachSanPham[i].getMaSP().equals(maSP_Sua)){
                danhSachSanPham[i].Sua();
                danhSachSanPham[i].Xuat();
                kq = true;
                System.out.println("Sửa sản phẩm " + maSP_Sua + " thành công ! \n -------------------");
            }
        }
        if(!kq){
            System.out.println("Không tìm thấy mã " + maSP_Sua + " cần sửa trong danh sách sản phẩm! \\n------------------\"");
        }
    }

    public void docFile(){
        String line;
        String[] strings = new String[6];
        try{
            FileReader fr = new FileReader("SanPham.txt");
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null){
                strings = line.split(";");
                try{
                    SanPham sp = new SanPham();
                    if(strings[0].startsWith("TA")){
                        sp = new ThucAn(strings[0], strings[1], Integer.parseInt(strings[2]), Double.parseDouble(strings[3]), Double.parseDouble(strings[4]), strings[5]);
                    }
                    if(strings[0].startsWith("NU")){
                        sp = new NuocUong(strings[0], strings[1], Integer.parseInt(strings[2]), Double.parseDouble(strings[3]), Double.parseDouble(strings[4]), strings[5]);
                    }
                    sp.Xuat();
                    System.out.println("--------------------------------\n");
                    br.close();
                    fr.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e) {
            System.out.println("Lỗi đọc file SanPham.txt\n");
            e.printStackTrace();
        }
    }
    public void ghiFile(){
        System.out.println("\n---------Ghi file sản phẩm---------");
        if (danhSachSanPham == null ){
            System.out.println("Vui lòng tạo danh sách sản phẩm trước !!");
            return;
        }
        if (danhSachSanPham.length == 0){
            System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm. \n");
            return;
        }

        try{
            FileWriter fw = new FileWriter("SanPham.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i < danhSachSanPham.length; i++){
                bw.write(danhSachSanPham[i].toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Ghi dữ liệu vào SanPham.txt thành công");
            danhSachSanPham_File = Arrays.copyOf(danhSachSanPham,danhSachSanPham.length);
        }
        catch (IOException ioException) {
            System.out.printf("Lỗi ghi file SanPham.txt: ");
            ioException.printStackTrace();
        }
    }

//    public void thongKeSanPham(){
//        System.out.println("\n --------Thống Kê Sản Phẩm--------");
//        for(int i = 0; i < danhSachSanPham.length; i++){
//            int n = soLuongSP[i];
//            int conlai = danhSachSanPham[i].getSoLuong() - soLuongSP[i];
//            System.out.println("Số lượng " + danhSachSanPham[i].getTenSP() + " còn lại: ");
//        }
//    }
//
//    public static void tinhTongDoanhThu(SanPham[] danhSachSanPham){
//        for(int i = 0; i < danhSachSanPham.length; i++){
//            doanhThu = doanhThu + danhSachSanPham[i].LoiNhuan();
//        }
//
//    }
}
