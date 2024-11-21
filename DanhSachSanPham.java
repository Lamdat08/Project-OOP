package Project_OOP;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DanhSachSanPham implements IThaoTac_2 {

    private static int soLuongSanPham;
    private SanPham[] DSSP;
    private SanPham[] DSSP_File;

    static Scanner sc = new Scanner(System.in);

    public DanhSachSanPham(){
        this.DSSP = new SanPham[5]; //Ít nhất 5 sản phẩm
        this.Nhap();
    }

    public SanPham[] getDSSP() {
        return DSSP;
    }
    public void setDSSP(SanPham[] DSSP) {
        this.DSSP = DSSP;
    }

    public SanPham[] getDSSP_File() {
        return DSSP_File;
    }
    public void setDSSP_File(SanPham[] DSSP_File) {
        this.DSSP_File = DSSP_File;
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
        System.out.println("\n \t \t---------TẠO DANH SÁCH SẢN PHẨM TỪ FILE SanPham.txt---------");

        String line;
        String[] strings = new String[6];
        try{
            FileReader fr = new FileReader("SanPham.txt");
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null){
                if(soLuongSanPham == DSSP.length){
                    DSSP = Arrays.copyOf(DSSP, DSSP.length + 5);
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
                    DSSP[soLuongSanPham] = sp;
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
        if(soLuongSanPham < DSSP.length){
            DSSP = Arrays.copyOf(DSSP, soLuongSanPham);
        }
        //Copy mảng hiện tại đang chỉnh sửa vào mảng lấy dữ liệu từ File
        DSSP_File = Arrays.copyOf(DSSP, DSSP.length);
    }
    public void Them(){
        System.out.println("\n \t \t---------THÊM SẢN PHẨM---------");

        if (DSSP == null) {
            System.out.println("Danh sách sản phẩm chưa được khởi tạo. Vui lòng khởi tạo danh sách sản phẩm trước.!!! ");
            return;
        }
        if(DSSP.length == 0){
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
        DSSP = Arrays.copyOf(DSSP, DSSP.length + slSP);
        SanPham sp;

        int slSPBanDau = DSSP.length - slSP;
        for(int i = slSPBanDau; i < DSSP.length; i++){
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
                DSSP[i] = sp;
            }
            if(luaChon == 2){
                sp = new NuocUong();
                sp.Nhap();
                DSSP[i] = sp;
            }
        }
    }
    public void Xoa(){
        System.out.println("\n---------XOÁ SẢN PHẨM---------");

        if (DSSP == null) {
            System.out.println("Danh sách sản phẩm chưa được khởi tạo. Vui lòng khởi tạo danh sách sản phẩm trước.!!!");
            return;
        }
        if(DSSP.length == 0){
            System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm.!!! \n");
            return;
        }

        System.out.println("Nhập mã sản phẩm muốn xoá: ");
        String maSP_Xoa = sc.nextLine();
        boolean kq = false;
        for(int i = 0; i < DSSP.length - 1; i++){
            if(DSSP[i].getMaSP().equals(maSP_Xoa)){
                kq = true;
                DSSP[i].setStatus(false);
                System.out.println("Xóa sản phẩm thành công!\n-------------------");
                soLuongSanPham--;
                break;
            }
        }
        if(!kq){
            System.out.println("Không tìm thấy mã sản phẩm" + maSP_Xoa + " muốn xoá");
        }
    }

    public void TimKiem(){
        System.out.println("\n---------TÌM KIẾM SẢN PHẨM---------");

        if (DSSP == null) {
            System.out.println("Danh sách sản phẩm chưa được khởi tạo. Vui lòng tạo danh sách sản phẩm trước.!!!");
            return;
        }
        if (DSSP.length == 0){
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
                    while(maSP_TimKiem == null || maSP_TimKiem.trim().isEmpty()) {
                        System.out.println("Mã sản phẩm không được để trống, vui lòng nhập lại: ");
                        maSP_TimKiem = sc.nextLine().trim();
                    }
                    while(!maSP_TimKiem.startsWith("TA") && !maSP_TimKiem.startsWith("NU")){
                        System.out.println("Mã sản phẩm phải bắt đầu với TA(nếu là thức ăn) hoặc NU(nếu là nước uống), vui lòng nhập lại mã sản phẩm cần tìm: ");
                        maSP_TimKiem = sc.nextLine();
                    }
                    kq = false;
                    for(int i = 0; i < DSSP.length; i++){
                        if(DSSP[i].getMaSP().equals(maSP_TimKiem)){
                            DSSP[i].Xuat();
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
                    while(tenSP_TimKiem == null ||tenSP_TimKiem.trim().isEmpty()) {
                        System.out.println("Tên sản phẩm không được để trống, vui lòng nhập lại: ");
                        tenSP_TimKiem = sc.nextLine().trim();
                    }
                    String regexTen = "^[A-Za-zÀ-ỹ\\s]+$";
                    while(!Pattern.matches(regexTen, tenSP_TimKiem)){
                        System.out.println("Tên sản phẩm không hợp lệ, vui lòng nhập lại: ");
                        tenSP_TimKiem = sc.nextLine().trim();
                    }
                    kq = false;
                    for(int i = 0; i < DSSP.length; i++){
                        if(DSSP[i].getTenSP().equals(tenSP_TimKiem)){
                            DSSP[i].Xuat();
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
                    String inputSoLuong = Integer.toString(soLuongSP_TimKiem);
                    while(inputSoLuong == null || inputSoLuong.trim().isEmpty()){
                        System.out.println("Số lượng không được để trống, vui lòng nhập lại: ");
                        soLuongSP_TimKiem = Integer.parseInt(sc.nextLine());
                        inputSoLuong = Integer.toString(soLuongSP_TimKiem);
                    }

                    String regexSoLuong = "^[0-9]$";
                    while(!Pattern.matches(regexSoLuong, inputSoLuong)){
                        System.out.println("Số lượng của sản phẩm không hợp lệ, vui lòng nhập lại: ");
                        soLuongSP_TimKiem = Integer.parseInt(sc.nextLine());
                        inputSoLuong = Integer.toString(soLuongSP_TimKiem);
                    }
                    while(soLuongSP_TimKiem < 0){
                        System.out.println("Số lượng của sản phẩm phải là số > 0, vui lòng nhập lại số lượng của sản phẩm cần tìm: ");
                        soLuongSP_TimKiem = Integer.parseInt(sc.nextLine());
                    }
                    kq = false;
                    for(int i = 0; i < DSSP.length; i++){
                        if(DSSP[i].getSoLuong() == soLuongSP_TimKiem){
                            DSSP[i].Xuat();
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
                    String inputGiaTien = Double.toString(giaTienSP_TimKiem);
                    while(inputGiaTien == null || inputGiaTien.trim().isEmpty()){
                        System.out.println("Giá tiền không được để trống, vui lòng nhập lại: ");
                        giaTienSP_TimKiem = Double.parseDouble(sc.nextLine());
                        inputGiaTien = Double.toString(giaTienSP_TimKiem);
                    }
                    while(giaTienSP_TimKiem < 0){
                        System.out.println("Giá tiền của sản phẩm phải > 0, vui lòng nhập lại: ");
                        giaTienSP_TimKiem = Double.parseDouble(sc.nextLine());
                    }
                    kq = false;
                    for(int i = 0; i < DSSP.length; i++){
                        if(DSSP[i].getGiaTien() == giaTienSP_TimKiem){
                            DSSP[i].Xuat();
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
                    String inputTienVon = Double.toString(tienVonSP_TimKiem);
                    while(inputTienVon == null || inputTienVon.trim().isEmpty()){
                        System.out.println("Tiền vốn không được để trống, vui lòng nhập lại: ");
                        tienVonSP_TimKiem = Double.parseDouble(sc.nextLine());
                        inputTienVon = Double.toString(tienVonSP_TimKiem);
                    }
                    while(tienVonSP_TimKiem < 0){
                        System.out.println("Tiền vốn của sản phẩm phải > 0, vui lòng nhập lại: ");
                        tienVonSP_TimKiem = Double.parseDouble(sc.nextLine());
                    }
                    kq = false;
                    for(int i = 0; i < DSSP.length; i++){
                        if(DSSP[i].getTienVon() == tienVonSP_TimKiem){
                            DSSP[i].Xuat();
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
        System.out.println("\n \t \t---------XUẤT DANH SÁCH SẢN PHẨM---------");

        if (DSSP == null){
            System.out.println("Danh sách sản phẩm chưa được khởi tạo. Vui lòng tạo danh sách sản phẩm trước.!!!");
            return;
        }
        if (DSSP.length == 0){
            System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm.!!! \n");
            return;
        }

        System.out.println("\tThông tin của danh sách sản phẩm \n--------------------------");
        for(int i = 0;i<DSSP.length;i++){
            DSSP[i].Xuat();
            System.out.println("\t--------------");
        }
    }

    public void Sua(){
        System.out.println("\n \t \t---------SỬA SẢN PHẨM---------");

        if (DSSP == null) {
            System.out.println("Danh sách sản phẩm chưa được khởi tạo.");
            return;
        }
        if (DSSP.length == 0){
            System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm. \n");
            return;
        }

        System.out.println("Nhập mã của sản phẩm cần sửa: ");
        String maSP_Sua = sc.nextLine();
        boolean kq = false;

        for(int i = 0; i < DSSP.length; i++){
            if(DSSP[i].getMaSP().equals(maSP_Sua)){
                DSSP[i].Sua();
                DSSP[i].Xuat();
                kq = true;
                System.out.println("Sửa sản phẩm " + maSP_Sua + " thành công ! \n -------------------");
            }
        }
        if(!kq){
            System.out.println("Không tìm thấy mã " + maSP_Sua + " cần sửa trong danh sách sản phẩm! \\n------------------\"");
        }
    }

    public static void docFile(){
        System.out.println("\"\\n---------ĐỌC FILE SanPham.txt---------\"");

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
            System.out.println("Lỗi đọc file SanPham.txt: \n");
            e.printStackTrace();
        }
    }
    public void ghiFile(){
        System.out.println("\n---------GHI FILE SanPham.txt---------");

        if (DSSP == null ){
            System.out.println("Danh sách sản phẩm chưa được khởi tạo. Vui lòng khởi tạo danh sách sản phẩm trước.!!!");
            return;
        }
        if (DSSP.length == 0){
            System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm.!!! \n");
            return;
        }

        try{
            FileWriter fw = new FileWriter("SanPham.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i < DSSP.length; i++){
                bw.write(DSSP[i].toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Ghi dữ liệu vào SanPham.txt thành công");
            DSSP_File = Arrays.copyOf(DSSP,DSSP.length);
        }
        catch (IOException ioException) {
            System.out.printf("Lỗi ghi file SanPham.txt: ");
            ioException.printStackTrace();
        }
    }

    public void thongKeSanPham(int luaChon) {
        System.out.println("\n --------THỐNG KÊ DANH SÁCH SẢN PHẨM--------");

        if(luaChon == 1){

            if (DSSP == null) {
                System.out.println("Danh sách sản phẩm chưa được khởi tạo. Vui lòng khởi tạo danh sách sản phẩm trước.!!!");
                return;
            }
            if (DSSP.length == 0) {
                System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm.!!! \n");
                return;
            }

            SanPham minSP_LoiNhuan = DSSP[0];
            SanPham maxSP_LoiNhuan = DSSP[0];
            double tongLoiNhuan = 0;
            SanPham[] minDSSP_LoiNhuan = new SanPham[1];
            SanPham[] maxDSSP_LoiNhuan = new SanPham[1];

            SanPham minSP_SoLuong = DSSP[0];
            SanPham maxSP_SoLuong = DSSP[0];
            int tongSoLuong = 0;
            SanPham[] minDSSP_SoLuong = new SanPham[1];
            SanPham[] maxDSSP_SoLuong = new SanPham[1];

            for (int i = 0; i < DSSP.length; i++) {
                tongLoiNhuan += DSSP[i].LoiNhuan();
                if (DSSP[i].LoiNhuan() < minSP_LoiNhuan.LoiNhuan()){
                    minSP_LoiNhuan = DSSP[i];
                }
                if (DSSP[i].LoiNhuan() > maxSP_LoiNhuan.LoiNhuan()) {
                    maxSP_LoiNhuan = DSSP[i];
                }

                tongSoLuong += DSSP[i].getSoLuong();
                if(DSSP[i].getGiaTien() < minSP_SoLuong.getSoLuong()){
                    minSP_SoLuong = DSSP[i];
                }
                if(DSSP[i].getGiaTien() > maxSP_SoLuong.getSoLuong()){
                    maxSP_SoLuong = DSSP[i];
                }
            }

            for (int i = 0; i < DSSP.length; i++) {
                if (DSSP[i].LoiNhuan() == minSP_LoiNhuan.LoiNhuan()) {
                    minDSSP_LoiNhuan = Arrays.copyOf(minDSSP_LoiNhuan, minDSSP_LoiNhuan.length + 1);
                    minDSSP_LoiNhuan[i] = DSSP[i];
                }
                if (DSSP[i].LoiNhuan() == maxSP_LoiNhuan.LoiNhuan()) {
                    maxDSSP_LoiNhuan = Arrays.copyOf(maxDSSP_LoiNhuan, maxDSSP_LoiNhuan.length + 1);
                    maxDSSP_LoiNhuan[i] = DSSP[i];
                }

                if (DSSP[i].getSoLuong() == minSP_SoLuong.getSoLuong()) {
                    minDSSP_SoLuong = Arrays.copyOf(minDSSP_SoLuong, minDSSP_SoLuong.length + 1);
                    minDSSP_SoLuong[i] = DSSP[i];
                }
                if (DSSP[i].getSoLuong() == minSP_SoLuong.getSoLuong()) {
                    maxDSSP_SoLuong = Arrays.copyOf(maxDSSP_SoLuong, maxDSSP_SoLuong.length + 1);
                    maxDSSP_SoLuong[i] = DSSP[i];
                }
            }

            System.out.println("\n --------THỐNG KÊ DANH SÁCH SẢN PHẨM HIỆN TẠI--------");
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
            if (DSSP_File == null) {
                System.out.println("Danh sách sản phẩm chưa được khởi tạo. Vui lòng khởi tạo danh sách sản phẩm trước.!!!");
                return;
            }
            if (DSSP_File.length == 0) {
                System.out.println("Danh sách sản phẩm hiện tại đang trống. Vui lòng thêm sản phẩm.!!! \n");
                return;
            }

            SanPham minSP_LoiNhuan = DSSP_File[0];
            SanPham maxSP_LoiNhuan = DSSP_File[0];
            double tongLoiNhuan = 0;
            SanPham[] minDSSP_LoiNhuan = new SanPham[1];
            SanPham[] maxDSSP_LoiNhuan = new SanPham[1];

            SanPham minSP_SoLuong = DSSP_File[0];
            SanPham maxSP_SoLuong = DSSP_File[0];
            int tongSoLuong = 0;
            SanPham[] minDSSP_SoLuong = new SanPham[1];
            SanPham[] maxDSSP_SoLuong = new SanPham[1];

            for (int i = 0; i < DSSP_File.length; i++) {
                tongLoiNhuan += DSSP_File[i].LoiNhuan();
                if (DSSP_File[i].LoiNhuan() < minSP_LoiNhuan.LoiNhuan())
                    minSP_LoiNhuan = DSSP_File[i];
                if (DSSP_File[i].LoiNhuan() > maxSP_LoiNhuan.LoiNhuan())
                    maxSP_LoiNhuan = DSSP_File[i];

                tongSoLuong += DSSP_File[i].getSoLuong();
                if(DSSP_File[i].getGiaTien() < minSP_SoLuong.getSoLuong()){
                    minSP_SoLuong = DSSP_File[i];
                }
                if(DSSP_File[i].getGiaTien() > maxSP_SoLuong.getSoLuong()){
                    maxSP_SoLuong = DSSP_File[i];
                }
            }

            for (int i = 0; i < DSSP_File.length; i++) {
                if (DSSP_File[i].LoiNhuan() == minSP_LoiNhuan.LoiNhuan()) {
                    minDSSP_LoiNhuan = Arrays.copyOf(minDSSP_LoiNhuan, minDSSP_LoiNhuan.length + 1);
                    minDSSP_LoiNhuan[i] = DSSP_File[i];
                }
                if (DSSP_File[i].LoiNhuan() == maxSP_LoiNhuan.LoiNhuan()) {
                    maxDSSP_LoiNhuan = Arrays.copyOf(maxDSSP_LoiNhuan, maxDSSP_LoiNhuan.length + 1);
                    maxDSSP_LoiNhuan[i] = DSSP_File[i];
                }

                if (DSSP_File[i].getSoLuong() == minSP_SoLuong.getSoLuong()) {
                    minDSSP_SoLuong = Arrays.copyOf(minDSSP_SoLuong, minDSSP_SoLuong.length + 1);
                    minDSSP_SoLuong[i] = DSSP_File[i];
                }
                if (DSSP_File[i].getSoLuong() == minSP_SoLuong.getSoLuong()) {
                    maxDSSP_SoLuong = Arrays.copyOf(maxDSSP_SoLuong, maxDSSP_SoLuong.length + 1);
                    maxDSSP_SoLuong[i] = DSSP_File[i];
                }
            }

            System.out.println("\n --------THỐNG KÊ DANH SÁCH SẢN PHẨM CỦA FILE SanPham.txt--------");
            System.out.println("1. Tổng số lượng sản phẩm : " + DSSP_File.length);

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
