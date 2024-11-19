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
        this.danhSachSanPham = new SanPham[5]; //Ít nhất 5 sản phẩm
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

    //Lấy dữ liệu từ File SanPham.txt
    public void Nhap(){
        String line;
        String[] strings = new String[6];
        try{
            FileReader fr = new FileReader("SanPham.txt");
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null){
                if(soLuongSanPham == danhSachSanPham.length){
                    danhSachSanPham = Arrays.copyOf(danhSachSanPham, danhSachSanPham.length + 5);
                }

                strings = line.split(";");
                try{
                    SanPham sp = new SanPham();
                    //Nếu mã sản phẩm = TA... --> khởi tạo với Constructor của ThucAn
                    if(strings[0].startsWith("TA")){
                        sp = new ThucAn(strings[0], strings[1], Integer.parseInt(strings[2]), Double.parseDouble(strings[3]), Double.parseDouble(strings[4]), strings[5]);
                    }
                    //Nếu mã sản phẩm = NU... --> khởi tạo với Constructor của NuocUong
                    if(strings[0].startsWith("NU")){
                        sp = new NuocUong(strings[0], strings[1], Integer.parseInt(strings[2]), Double.parseDouble(strings[3]), Double.parseDouble(strings[4]), strings[5]);
                    }
                    //Thêm sản phẩm vào danh sách
                    danhSachSanPham[soLuongSanPham] = sp;
                    soLuongSanPham++;
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e){
            System.out.println("Lỗi đọc file SanPham.txt: ");
            e.printStackTrace();
        }
        //Thu hẹp mảng nếu mảng chưa đầy
        if(soLuongSanPham < danhSachSanPham.length){
            danhSachSanPham = Arrays.copyOf(danhSachSanPham, soLuongSanPham);
        }
        //Copy mảng hiện tại đang chỉnh sửa vào mảng lấy dữ liệu từ File
        danhSachSanPham_File = Arrays.copyOf(danhSachSanPham, danhSachSanPham.length);
    }
    public void Them(){
        System.out.println("\n \t \t---------Thêm sản phẩm---------");

        if (danhSachSanPham == null) {
            System.out.println("Danh sách sản phẩm chưa được khởi tạo. Vui lòng khởi tạo danh sách sản phẩm trước.!!! ");
            return;
        }
        if(danhSachSanPham.length == 0){
            System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm.!!! \n");
            return;
        }

        int slSP;
        do{
            System.out.println("Nhập số lượng sản phẩm muốn thêm: ");
            slSP = Integer.parseInt(sc.nextLine());
            if(slSP <= 0){
                System.out.println("Không hợp lệ, vui lòng nhập số lượng > 0: ");
            }
        } while(slSP <= 0);

        soLuongSanPham += slSP;
        danhSachSanPham = Arrays.copyOf(danhSachSanPham, danhSachSanPham.length + slSP);
        SanPham sp;

        int slSPBanDau = danhSachSanPham.length - slSP;
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
            System.out.println("Danh sách sản phẩm chưa được khởi tạo. Vui lòng khởi tạo danh sách sản phẩm trước.!!!");
            return;
        }
        if(danhSachSanPham.length == 0){
            System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm.!!! \n");
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
            //Thu hẹp mảng sau khi xoá 1 sản phẩm
            danhSachSanPham = Arrays.copyOf(danhSachSanPham, danhSachSanPham.length - 1);
            System.out.println("Xóa sản phẩm thành công!\n-------------------");
            soLuongSanPham--;
        }
    }

    public void TimKiem(){
        System.out.println("\n---------Tìm kiếm sản phẩm---------");

        if (danhSachSanPham == null) {
            System.out.println("Danh sách sản phẩm chưa được khởi tạo. Vui lòng tạo danh sách sản phẩm trước.!!!");
            return;
        }
        if (danhSachSanPham.length == 0){
            System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm.!!!\n");
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
                    while(!maSP_TimKiem.startsWith("TA") && !maSP_TimKiem.startsWith("NU")){
                        System.out.println("Mã sản phẩm phải bắt đầu với TA(nếu là thức ăn) hoặc NU(nếu là nước uống), vui lòng nhập lại mã sản phẩm cần tìm: ");
                        maSP_TimKiem = sc.nextLine();
                    }
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
                    while(soLuongSP_TimKiem < 0){
                        System.out.println("Số lượng của sản phẩm phải là số > 0, vui lòng nhập lại số lượng của sản phẩm cần tìm: ");
                        soLuongSP_TimKiem = Integer.parseInt(sc.nextLine());
                    }
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
                    while(giaTienSP_TimKiem < 0){
                        System.out.println("Giá tiền của sản phẩm phải là số > 0, vui lòng nhập lại giá tiền của sản phẩm cần tìm: ");
                        giaTienSP_TimKiem = Integer.parseInt(sc.nextLine());
                    }
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
                    while(tienVonSP_TimKiem < 0){
                        System.out.println("Tiền vốn của sản phẩm phải là số > 0, vui lòng nhập lại tiền vốn của sản phẩm cần tìm: ");
                        tienVonSP_TimKiem = Integer.parseInt(sc.nextLine());
                    }
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
        }

    }

    public void Xuat() {
        System.out.println("\n \t \t---------Xuất danh sách sản phẩm---------");

        if (danhSachSanPham == null ){
            System.out.println("Danh sách sản phẩm chưa được khởi tạo. Vui lòng tạo danh sách sản phẩm trước.!!!");
            return;
        }
        if (danhSachSanPham.length == 0){
            System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm.!!! \n");
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
            System.out.println("Danh sách sản phẩm chưa được khởi tạo. Vui lòng khởi tạo danh sách sản phẩm trước.!!!");
            return;
        }
        if (danhSachSanPham.length == 0){
            System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm.!!! \n");
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

    public void thongKeSanPham(int luaChon) {
        System.out.println("\n --------Thống Kê Sản Phẩm--------");

        if(luaChon == 1){
            if (danhSachSanPham == null) {
                System.out.println("Danh sách sản phẩm chưa được khởi tạo. Vui lòng khởi tạo danh sách sản phẩm trước.!!!");
                return;
            }
            if (danhSachSanPham.length == 0) {
                System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm.!!! \n");
                return;
            }

            SanPham minSP_LoiNhuan = danhSachSanPham[0];
            SanPham maxSP_LoiNhuan = danhSachSanPham[0];
            double tongLoiNhuan = 0;
            SanPham[] minDSSP_LoiNhuan = new SanPham[1];
            SanPham[] maxDSSP_LoiNhuan = new SanPham[1];

            SanPham minSP_SoLuong = danhSachSanPham[0];
            SanPham maxSP_SoLuong = danhSachSanPham[0];
            int tongSoLuong = 0;
            SanPham[] minDSSP_SoLuong = new SanPham[1];
            SanPham[] maxDSSP_SoLuong = new SanPham[1];

            for (int i = 0; i < danhSachSanPham.length; i++) {
                tongLoiNhuan += danhSachSanPham[i].LoiNhuan();
                if (danhSachSanPham[i].LoiNhuan() < minSP_LoiNhuan.LoiNhuan())
                    minSP_LoiNhuan = danhSachSanPham[i];
                if (danhSachSanPham[i].LoiNhuan() > maxSP_LoiNhuan.LoiNhuan())
                    maxSP_LoiNhuan = danhSachSanPham[i];

                tongSoLuong += danhSachSanPham[i].getSoLuong();
                if(danhSachSanPham[i].getGiaTien() < minSP_SoLuong.getSoLuong()){
                    minSP_SoLuong = danhSachSanPham[i];
                }
                if(danhSachSanPham[i].getGiaTien() > maxSP_SoLuong.getSoLuong()){
                    maxSP_SoLuong = danhSachSanPham[i];
                }
            }

            for (int i = 0; i < danhSachSanPham.length; i++) {
                if (danhSachSanPham[i].LoiNhuan() == minSP_LoiNhuan.LoiNhuan()) {
                    minDSSP_LoiNhuan = Arrays.copyOf(minDSSP_LoiNhuan, minDSSP_LoiNhuan.length + 1);
                    minDSSP_LoiNhuan[i] = danhSachSanPham[i];
                }
                if (danhSachSanPham[i].LoiNhuan() == maxSP_LoiNhuan.LoiNhuan()) {
                    maxDSSP_LoiNhuan = Arrays.copyOf(maxDSSP_LoiNhuan, maxDSSP_LoiNhuan.length + 1);
                    maxDSSP_LoiNhuan[i] = danhSachSanPham[i];
                }

                if (danhSachSanPham[i].getSoLuong() == minSP_SoLuong.getSoLuong()) {
                    minDSSP_SoLuong = Arrays.copyOf(minDSSP_SoLuong, minDSSP_SoLuong.length + 1);
                    minDSSP_SoLuong[i] = danhSachSanPham[i];
                }
                if (danhSachSanPham[i].getSoLuong() == minSP_SoLuong.getSoLuong()) {
                    maxDSSP_SoLuong = Arrays.copyOf(maxDSSP_SoLuong, maxDSSP_SoLuong.length + 1);
                    maxDSSP_SoLuong[i] = danhSachSanPham[i];
                }
            }

            System.out.println("\n---------Thống kê danh sách sản phẩm hiện tại---------");
            System.out.println("1. Tổng số lượng sản phẩm : " + soLuongSanPham);

            System.out.println("2.Các sản phẩm có lợi nhuận thấp nhất : ");
            for ( int i = 0 ; i < minDSSP_LoiNhuan.length ; i++ ){
                minDSSP_LoiNhuan[i].Xuat();
                System.out.println("-------------------------------------");
            }
            System.out.println("\t \t -----xxxxx----- ");

            System.out.println("3.Các sản phẩm có lợi nhuận cao nhất : " );
            for ( int i = 0 ; i < maxDSSP_LoiNhuan.length ; i++ ){
                maxDSSP_LoiNhuan[i].Xuat();
                System.out.println("-------------------------------------");
            }
            System.out.println("\t \t -----xxxxx----- ");

            System.out.println("4.Lợi nhuận trung bình của 1 sản phẩm : " + tongLoiNhuan/soLuongSanPham);

            System.out.println("5.Các sản phẩm có số lượng nhỏ nhất : " );
            for ( int i = 0 ; i < minDSSP_SoLuong.length ; i++ ){
                minDSSP_SoLuong[i].Xuat();
                System.out.println("-------------------------------------");
            }
            System.out.println("\t \t -----xxxxx----- ");

            System.out.println("6.Các sản phẩm có số lượng lớn nhất : " );
            for ( int i = 0 ; i < maxDSSP_SoLuong.length ; i++ ){
                maxDSSP_SoLuong[i].Xuat();
                System.out.println("-------------------------------------");
            }
            System.out.println("\t \t -----xxxxx----- ");

            System.out.println("-------------------------------------");
        }

        if(luaChon == 2){
            if (danhSachSanPham_File == null) {
                System.out.println("Danh sách sản phẩm chưa được khởi tạo. Vui lòng khởi tạo danh sách sản phẩm trước.!!!");
                return;
            }
            if (danhSachSanPham_File.length == 0) {
                System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm.!!! \n");
                return;
            }

            SanPham minSP_LoiNhuan = danhSachSanPham_File[0];
            SanPham maxSP_LoiNhuan = danhSachSanPham_File[0];
            double tongLoiNhuan = 0;
            SanPham[] minDSSP_LoiNhuan = new SanPham[1];
            SanPham[] maxDSSP_LoiNhuan = new SanPham[1];

            SanPham minSP_SoLuong = danhSachSanPham_File[0];
            SanPham maxSP_SoLuong = danhSachSanPham_File[0];
            int tongSoLuong = 0;
            SanPham[] minDSSP_SoLuong = new SanPham[1];
            SanPham[] maxDSSP_SoLuong = new SanPham[1];

            for (int i = 0; i < danhSachSanPham_File.length; i++) {
                tongLoiNhuan += danhSachSanPham_File[i].LoiNhuan();
                if (danhSachSanPham_File[i].LoiNhuan() < minSP_LoiNhuan.LoiNhuan())
                    minSP_LoiNhuan = danhSachSanPham_File[i];
                if (danhSachSanPham_File[i].LoiNhuan() > maxSP_LoiNhuan.LoiNhuan())
                    maxSP_LoiNhuan = danhSachSanPham_File[i];

                tongSoLuong += danhSachSanPham_File[i].getSoLuong();
                if(danhSachSanPham_File[i].getGiaTien() < minSP_SoLuong.getSoLuong()){
                    minSP_SoLuong = danhSachSanPham_File[i];
                }
                if(danhSachSanPham_File[i].getGiaTien() > maxSP_SoLuong.getSoLuong()){
                    maxSP_SoLuong = danhSachSanPham_File[i];
                }
            }

            for (int i = 0; i < danhSachSanPham_File.length; i++) {
                if (danhSachSanPham_File[i].LoiNhuan() == minSP_LoiNhuan.LoiNhuan()) {
                    minDSSP_LoiNhuan = Arrays.copyOf(minDSSP_LoiNhuan, minDSSP_LoiNhuan.length + 1);
                    minDSSP_LoiNhuan[i] = danhSachSanPham_File[i];
                }
                if (danhSachSanPham_File[i].LoiNhuan() == maxSP_LoiNhuan.LoiNhuan()) {
                    maxDSSP_LoiNhuan = Arrays.copyOf(maxDSSP_LoiNhuan, maxDSSP_LoiNhuan.length + 1);
                    maxDSSP_LoiNhuan[i] = danhSachSanPham_File[i];
                }

                if (danhSachSanPham_File[i].getSoLuong() == minSP_SoLuong.getSoLuong()) {
                    minDSSP_SoLuong = Arrays.copyOf(minDSSP_SoLuong, minDSSP_SoLuong.length + 1);
                    minDSSP_SoLuong[i] = danhSachSanPham_File[i];
                }
                if (danhSachSanPham_File[i].getSoLuong() == minSP_SoLuong.getSoLuong()) {
                    maxDSSP_SoLuong = Arrays.copyOf(maxDSSP_SoLuong, maxDSSP_SoLuong.length + 1);
                    maxDSSP_SoLuong[i] = danhSachSanPham_File[i];
                }
            }

            System.out.println("\n---------Thống kê danh sách sản phẩm trong SanPham.txt---------");
            System.out.println("1. Tổng số lượng sản phẩm : " + danhSachSanPham_File.length);

            System.out.println("2.Các sản phẩm có lợi nhuận thấp nhất : ");
            for ( int i = 0 ; i < minDSSP_LoiNhuan.length ; i++ ){
                minDSSP_LoiNhuan[i].Xuat();
                System.out.println("-------------------------------------");
            }
            System.out.println("\t \t -----xxxxx----- ");

            System.out.println("3.Các sản phẩm có lợi nhuận cao nhất : " );
            for ( int i = 0 ; i < maxDSSP_LoiNhuan.length ; i++ ){
                maxDSSP_LoiNhuan[i].Xuat();
                System.out.println("-------------------------------------");
            }
            System.out.println("\t \t -----xxxxx----- ");

            System.out.println("4.Lợi nhuận trung bình của 1 sản phẩm : " + tongLoiNhuan/soLuongSanPham);

            System.out.println("5.Các sản phẩm có số lượng nhỏ nhất : " );
            for ( int i = 0 ; i < minDSSP_SoLuong.length ; i++ ){
                minDSSP_SoLuong[i].Xuat();
                System.out.println("-------------------------------------");
            }
            System.out.println("\t \t -----xxxxx----- ");

            System.out.println("6.Các sản phẩm có số lượng lớn nhất : " );
            for ( int i = 0 ; i < maxDSSP_SoLuong.length ; i++ ){
                maxDSSP_SoLuong[i].Xuat();
                System.out.println("-------------------------------------");
            }
            System.out.println("\t \t -----xxxxx----- ");

            System.out.println("-------------------------------------");
        }
    }
}
