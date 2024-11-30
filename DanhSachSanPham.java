package Project_OOP;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSanPham implements IThaoTac_2 {

    private static int soLuongSanPham; //số lượng sản phẩm của mảng DSSP
    private SanPham[] DSSP; //danh sách sản phẩm đang chỉnh sửa
    private SanPham[] DSSP_File; //danh sách sản phẩm của File SanPham.txt

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
                    System.out.println("Lỗi tạo danh sách sản phẩm từ file SanPham.txt ");
                }
            }
        }
        catch (Exception e){
            System.out.println("Lỗi đọc file SanPham.txt: ");
        }
        //Thu hẹp mảng nếu mảng chưa đầy
        if(soLuongSanPham < DSSP.length){
            DSSP = Arrays.copyOf(DSSP, soLuongSanPham);
        }
        //Copy mảng hiện tại đang chỉnh sửa vào mảng lấy dữ liệu từ File
        DSSP_File = Arrays.copyOf(DSSP, DSSP.length);
        DanhSachHoaDon.DSSP = Arrays.copyOf(DSSP_File,DSSP_File.length);
    }
    public void Them(){
        System.out.println("\n \t \t---------THÊM SẢN PHẨM---------");

        int slSP;
        while(true){
            try{
                System.out.println("Nhập số lượng sản phẩm muốn thêm: ");
                slSP = Integer.parseInt(sc.nextLine().trim());
                break;
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("Số lượng sản phẩm không hợp lệ, vui lòng nhập lại: ");
            }
        }
        String inputSLSP = Integer.toString(slSP);
        String regex = "^[1-9]+$";
        while(!inputSLSP.matches(regex)){
            System.out.println("Không hợp lệ, vui lòng nhập số lượng sản phẩm > 0: ");
            slSP = Integer.parseInt(sc.nextLine().trim());
            inputSLSP = Integer.toString(slSP);
        }

        soLuongSanPham += slSP;
        DSSP = Arrays.copyOf(DSSP, DSSP.length + slSP);
        SanPham sp;

        int slSPBanDau = DSSP.length - slSP;
        for(int i = slSPBanDau; i < DSSP.length; i++){
            int luaChon;
            while(true){
                try{
                    menuNhap();
                    System.out.println("Nhập lựa chọn: ");
                    luaChon = Integer.parseInt(sc.nextLine().trim());
                    break;
                }
                catch(NumberFormatException numberFormatException){
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại: ");
                }
            }
            String regex1 = "^(1|2)$";
            String inputLuaChon = Integer.toString(luaChon);
            while(!inputLuaChon.matches(regex1)){
                menuNhap();
                System.out.println("Không có loại sản phẩm này, mới nhập lại: ");
                luaChon = Integer.parseInt(sc.nextLine());
                inputLuaChon = Integer.toString(luaChon);
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
            System.out.println("Thêm sản phẩm thành công!\n-------------------");
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
        String maSP_Xoa = sc.nextLine().trim();
        while(maSP_Xoa.isEmpty()) {
            System.out.println("Mã sản phẩm không được để trống, vui lòng nhập lại: ");
            maSP_Xoa = sc.nextLine().trim();
        }
        String regexMaSP = "^(TA|ta|Ta|tA|NU|nu|Nu|nU)[0-9]{3}$";
        while(!maSP_Xoa.matches(regexMaSP)){
            System.out.println("Mã sản phẩm phải bắt đầu với TA hoặc NU, vui lòng nhập lại: ");
            maSP_Xoa = sc.nextLine().trim();
        }
        boolean kq = false;
        for(int i = 0; i < DSSP.length; i++){
            if(maSP_Xoa.equalsIgnoreCase(DSSP[i].getMaSP())){
                kq = true;
                DSSP[i].setStatus(false);
                System.out.println("Xóa sản phẩm thành công!\n-------------------");
                soLuongSanPham--;
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
        String regex = "^[1-6]$";
        while(true){
            int luaChon;
            while(true){
                try{
                    menuTimKiem();
                    System.out.println("Nhập lựa chọn tìm kiếm: ");
                    luaChon = Integer.parseInt(sc.nextLine().trim());
                    break;
                }
                catch(NumberFormatException numberFormatException){
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại: ");
                }
            }
            boolean kq;
            String inputLuaChon = Integer.toString(luaChon);
            while(!inputLuaChon.matches(regex)){
                menuNhap();
                System.out.println("Không có lựa chọn này, mời nhập lại: ");
                luaChon = Integer.parseInt(sc.nextLine().trim());
                inputLuaChon = Integer.toString(luaChon);
            }

            switch(luaChon){
                case 1:
                    System.out.println("Nhập mã sản phẩm cần tìm: ");
                    String maSP_TimKiem = sc.nextLine().trim();
                    String regexMaSP = "^(TA|ta|Ta|tA|NU|nu|Nu|nU)[0-9]{3}$";
                    while(maSP_TimKiem.isEmpty() || !maSP_TimKiem.matches(regexMaSP)) {
                        System.out.println("Mã sản phẩm phải bắt đầu với TA hoặc NU, vui lòng nhập lại: ");
                        maSP_TimKiem = sc.nextLine().trim();
                    }
                    kq = false;
                    for(int i = 0; i < DSSP.length; i++){
                        if(DSSP[i].getStatus()){
                            if(maSP_TimKiem.equalsIgnoreCase(DSSP[i].getMaSP())){
                                DSSP[i].Xuat();
                                kq = true;
                                System.out.println("\n \t--------------------");
                            }
                        }
                    }
                    if(!kq){
                        System.out.println("Không tìm thấy mã sản phẩm: " + maSP_TimKiem + " trong danh sách sản phẩm!");
                    }
                    break;
                case 2:
                    System.out.println("Nhập tên sản phẩm cần tìm: ");
                    String tenSP_TimKiem = sc.nextLine().trim();
                    String regexTenSP = "^[A-Za-zÀ-ỹ\\s]+$";
                    while(tenSP_TimKiem.isEmpty() || !tenSP_TimKiem.matches(regexTenSP)) {
                        System.out.println("Tên sản phẩm không hợp lệ, vui lòng nhập lại: ");
                        tenSP_TimKiem = sc.nextLine().trim();
                    }
                    kq = false;
                    for(int i = 0; i < DSSP.length; i++){
                        if(DSSP[i].getStatus()){
                            if(tenSP_TimKiem.equalsIgnoreCase(DSSP[i].getTenSP())){
                                DSSP[i].Xuat();
                                kq = true;
                            }
                        }
                    }
                    if(!kq){
                        System.out.println("Không tìm thấy tên sản phẩm: " + tenSP_TimKiem + " trong danh sách sản phẩm!");
                    }
                    break;
                case 3:
                    System.out.println("Nhập số lượng của sản phẩm cần tìm: ");
                    int soLuongSP_TimKiem = Integer.parseInt(sc.nextLine().trim());
                    String regexSoLuong = "^[0-9]+$";
                    String inputSoLuong = Integer.toString(soLuongSP_TimKiem);
                    while(!inputSoLuong.matches(regexSoLuong)){
                        System.out.println("Số lượng của sản phẩm không hợp lệ, vui lòng nhập lại: ");
                        soLuongSP_TimKiem = Integer.parseInt(sc.nextLine().trim());
                        inputSoLuong = Integer.toString(soLuongSP_TimKiem);
                    }
                    kq = false;
                    for(int i = 0; i < DSSP.length; i++){
                        if(DSSP[i].getStatus()){
                            if(soLuongSP_TimKiem == DSSP[i].getSoLuong()){
                                DSSP[i].Xuat();
                                kq = true;
                            }
                        }
                    }
                    if(!kq){
                        System.out.println("Không tìm thấy sản phẩm có số lượng: " + soLuongSP_TimKiem + " trong danh sách sản phẩm!");
                    }
                    break;
                case 4:
                    System.out.println("Nhập giá tiền của sản phẩm cần tìm: ");
                    double giaTienSP_TimKiem = Double.parseDouble(sc.nextLine().trim());
                    String regexGiaTien = "^[1-9]\\d*\\.\\d+$";
                    String inputGiaTien = Double.toString(giaTienSP_TimKiem);
                    while(!inputGiaTien.matches(regexGiaTien)){
                        System.out.println("Giá tiền của sản phẩm không hợp lệ. Vui lòng nhập lại: ");
                        giaTienSP_TimKiem = Double.parseDouble(sc.nextLine().trim());
                        inputGiaTien = Double.toString(giaTienSP_TimKiem);
                    }
                    kq = false;
                    for(int i = 0; i < DSSP.length; i++){
                        if(DSSP[i].getStatus()){
                            if(giaTienSP_TimKiem == DSSP[i].getGiaTien()){
                                DSSP[i].Xuat();
                                kq = true;
                            }
                        }
                    }
                    if(!kq){
                        System.out.println("Không tìm thấy sản phẩm có giá tiền: " + giaTienSP_TimKiem + " trong danh sách sản phẩm!");
                    }
                    break;
                case 5:
                    System.out.println("Nhập tiền vốn của sản phẩm cần tìm: ");
                    double tienVonSP_TimKiem = Double.parseDouble(sc.nextLine().trim());
                    String regexTienVon = "^[1-9]\\d*\\.\\d+$";
                    String inputTienVon = Double.toString(tienVonSP_TimKiem);
                    while(!inputTienVon.matches(regexTienVon)){
                        System.out.println("Tiền vốn của sản phẩm không hợp lệ. Vui lòng nhập lại: ");
                        tienVonSP_TimKiem = Double.parseDouble(sc.nextLine().trim());
                        inputTienVon = Double.toString(tienVonSP_TimKiem);
                    }
                    kq = false;
                    for(int i = 0; i < DSSP.length; i++){
                        if(DSSP[i].getStatus()){
                            if(tienVonSP_TimKiem == DSSP[i].getTienVon()){
                                DSSP[i].Xuat();
                                kq = true;
                            }
                        }
                    }
                    if(!kq){
                        System.out.println("Không tìm thấy sản phẩm có tiền vốn: " + tienVonSP_TimKiem + " trong danh sách sản phẩm!");
                    }
                    break;
                case 6:
                    System.out.println("Thoát tìm kiếm sản phẩm");
                    return;
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
            if(DSSP[i].getStatus()){
                DSSP[i].Xuat();
                System.out.println("\t--------------");
            }
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
        String maSP_Sua = sc.nextLine().trim();
        while(maSP_Sua.isEmpty()) {
            System.out.println("Mã sản phẩm không được để trống, vui lòng nhập lại: ");
            maSP_Sua = sc.nextLine().trim();
        }
        String regexMaSP = "^(TA|NU)[0-9]{3}$";
        while(!maSP_Sua.matches(regexMaSP)){
            System.out.println("Mã sản phẩm phải bắt đầu với TA hoặc NU, vui lòng nhập lại: ");
            maSP_Sua = sc.nextLine().trim();
        }
        boolean kq = false;

        for(int i = 0; i < DSSP.length; i++){
            if(DSSP[i].getStatus()){
                if(maSP_Sua.equalsIgnoreCase(DSSP[i].getMaSP())){
                    DSSP[i].Sua();
                    DSSP[i].Xuat();
                    kq = true;
                    System.out.println("Sửa sản phẩm " + maSP_Sua + " thành công ! \n -------------------");
                }
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
                }
                catch (Exception e){
                    System.out.println("Lỗi xuất sản phẩm từ file SanPham.txt");
                }
            }
            br.close();
            fr.close();
        }
        catch (Exception e) {
            System.out.println("Lỗi đọc file SanPham.txt \n");
        }
    }
    public void ghiFile(){
        System.out.println("\n---------GHI FILE SanPham.txt---------");

        if (DSSP == null){
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
            for(int i = DSSP_File.length; i < DSSP.length; i++){
                bw.write(DSSP[i].toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Ghi dữ liệu vào SanPham.txt thành công");
            DSSP_File = Arrays.copyOf(DSSP,DSSP.length);
        }
        catch (IOException ioException) {
            System.out.println("Lỗi ghi file SanPham.txt ");
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

            //Tìm vị trí sản phẩm đầu tiên có status = true (không bị xoá)
            int viTri = 0;
            for ( int i = 0 ; i < DSSP.length ; i++ ){
                if (DSSP[i].getStatus()){
                    viTri = i;
                    break;
                }
            }
            SanPham minSP_LoiNhuan = DSSP[viTri];
            SanPham maxSP_LoiNhuan = DSSP[viTri];
            double tongLoiNhuan = 0;
            SanPham[] minDSSP_LoiNhuan = new SanPham[1];
            SanPham[] maxDSSP_LoiNhuan = new SanPham[1];
            int indexMinLN = 0;
            int indexMaxLN = 0;

            SanPham minSP_SoLuong = DSSP[viTri];
            SanPham maxSP_SoLuong = DSSP[viTri];
            int tongSoLuong = 0;
            SanPham[] minDSSP_SoLuong = new SanPham[1];
            SanPham[] maxDSSP_SoLuong = new SanPham[1];
            int indexMinSL = 0;
            int indexMaxSL = 0;

            for (int i = 0; i < DSSP.length; i++) {
                if(DSSP[i].getStatus()){
                    tongLoiNhuan += DSSP[i].LoiNhuan();
                    if (DSSP[i].LoiNhuan() < minSP_LoiNhuan.LoiNhuan()){
                        minSP_LoiNhuan = DSSP[i];
                    }
                    if (DSSP[i].LoiNhuan() > maxSP_LoiNhuan.LoiNhuan()) {
                        maxSP_LoiNhuan = DSSP[i];
                    }

                    tongSoLuong += DSSP[i].getSoLuong();
                    if(DSSP[i].getSoLuong() < minSP_SoLuong.getSoLuong()){
                        minSP_SoLuong = DSSP[i];
                    }
                    if(DSSP[i].getSoLuong() > maxSP_SoLuong.getSoLuong()){
                        maxSP_SoLuong = DSSP[i];
                    }
                }
            }

            for (int i = 0; i < DSSP.length; i++) {
                if(DSSP[i].getStatus()){
                    if (DSSP[i].LoiNhuan() == minSP_LoiNhuan.LoiNhuan()) {
                        if(indexMinLN == minDSSP_LoiNhuan.length){
                            minDSSP_LoiNhuan = Arrays.copyOf(minDSSP_LoiNhuan, minDSSP_LoiNhuan.length + 1);
                        }
                        minDSSP_LoiNhuan[indexMinLN] = DSSP[i];
                        indexMinLN++;
                    }
                    if (DSSP[i].LoiNhuan() == maxSP_LoiNhuan.LoiNhuan()) {
                        if(indexMaxLN == maxDSSP_LoiNhuan.length){
                            maxDSSP_LoiNhuan = Arrays.copyOf(maxDSSP_LoiNhuan, maxDSSP_LoiNhuan.length + 1);
                        }
                        maxDSSP_LoiNhuan[indexMaxLN] = DSSP[i];
                        indexMaxLN++;
                    }

                    if (DSSP[i].getSoLuong() == minSP_SoLuong.getSoLuong()) {
                        if(indexMinSL == minDSSP_SoLuong.length){
                            minDSSP_SoLuong = Arrays.copyOf(minDSSP_SoLuong, minDSSP_SoLuong.length + 1);
                        }
                        minDSSP_SoLuong[indexMinSL] = DSSP[i];
                        indexMinSL++;
                    }
                    if (DSSP[i].getSoLuong() == maxSP_SoLuong.getSoLuong()) {
                        if(indexMaxSL == maxDSSP_SoLuong.length){
                            maxDSSP_SoLuong = Arrays.copyOf(maxDSSP_SoLuong, maxDSSP_SoLuong.length + 1);
                        }
                        maxDSSP_SoLuong[indexMaxSL] = DSSP[i];
                        indexMaxSL++;
                    }
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
            System.out.println("7.Tổng số lượng các sản phẩm: " + tongSoLuong);

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
            int indexMinLN = 0;
            int indexMaxLN = 0;

            SanPham minSP_SoLuong = DSSP_File[0];
            SanPham maxSP_SoLuong = DSSP_File[0];
            int tongSoLuong = 0;
            SanPham[] minDSSP_SoLuong = new SanPham[1];
            SanPham[] maxDSSP_SoLuong = new SanPham[1];
            int indexMinSL = 0;
            int indexMaxSL = 0;

            for (int i = 0; i < DSSP_File.length; i++) {
                tongLoiNhuan += DSSP_File[i].LoiNhuan();
                if (DSSP_File[i].LoiNhuan() < minSP_LoiNhuan.LoiNhuan()){
                    minSP_LoiNhuan = DSSP_File[i];
                }
                if (DSSP_File[i].LoiNhuan() > maxSP_LoiNhuan.LoiNhuan()){
                    maxSP_LoiNhuan = DSSP_File[i];
                }

                tongSoLuong += DSSP_File[i].getSoLuong();
                if(DSSP_File[i].getSoLuong() < minSP_SoLuong.getSoLuong()){
                    minSP_SoLuong = DSSP_File[i];
                }
                if(DSSP_File[i].getSoLuong() > maxSP_SoLuong.getSoLuong()){
                    maxSP_SoLuong = DSSP_File[i];
                }
            }

            for (int i = 0; i < DSSP_File.length; i++) {
                if (DSSP_File[i].LoiNhuan() == minSP_LoiNhuan.LoiNhuan()) {
                    if(indexMinLN == minDSSP_LoiNhuan.length){
                        minDSSP_LoiNhuan = Arrays.copyOf(minDSSP_LoiNhuan, minDSSP_LoiNhuan.length + 1);
                    }
                    minDSSP_LoiNhuan[indexMinLN] = DSSP_File[i];
                    indexMinLN++;
                }
                if (DSSP_File[i].LoiNhuan() == maxSP_LoiNhuan.LoiNhuan()) {
                    if(indexMaxLN == maxDSSP_LoiNhuan.length){
                        maxDSSP_LoiNhuan = Arrays.copyOf(maxDSSP_LoiNhuan, maxDSSP_LoiNhuan.length + 1);
                    }
                    maxDSSP_LoiNhuan[indexMaxLN] = DSSP_File[i];
                    indexMaxLN++;
                }

                if (DSSP_File[i].getSoLuong() == minSP_SoLuong.getSoLuong()) {
                    if(indexMinSL == minDSSP_SoLuong.length){
                        minDSSP_SoLuong = Arrays.copyOf(minDSSP_SoLuong, minDSSP_SoLuong.length + 1);
                    }
                    minDSSP_SoLuong[indexMinSL] = DSSP_File[i];
                    indexMinSL++;
                }
                if (DSSP_File[i].getSoLuong() == maxSP_SoLuong.getSoLuong()) {
                    if(indexMaxSL == maxDSSP_SoLuong.length){
                        maxDSSP_SoLuong = Arrays.copyOf(maxDSSP_SoLuong, maxDSSP_SoLuong.length + 1);
                    }
                    maxDSSP_SoLuong[indexMaxSL] = DSSP_File[i];
                    indexMaxSL++;
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

            System.out.println("7.Tổng số lượng các sản phẩm: " + tongSoLuong);

            System.out.println("\t \t -----xxxxx----- ");

            System.out.println("-------------------------------------");
        }
    }
}