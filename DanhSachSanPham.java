package Project_OOP;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSanPham implements IThaoTac_2 {

    static Scanner sc = new Scanner(System.in);

    private SanPham[] danhSachSanPham;
    private int soLuongSanPham;

    public void menuNhap(){
        System.out.println("1 - Nhập danh sách thức ăn");
        System.out.println("2 - Nhập danh sách nước uống");
    }
    public void menuTimKiem(){
        System.out.println("1 - Tìm kiếm theo mã sản phầm");
        System.out.println("2 - Tìm kiếm theo tên sản phẩm");
        System.out.println("3 - Tìm kiếm theo số lượng");
        System.out.println("4 - Tìm kiếm theo giá tiền");
        System.out.println("5 - Tìm kiếm theo tiền vốn");
        System.out.println("6 - Thoát tìm kiếm");
    }

    public void Nhap(){
        System.out.println("Nhập số lượng sản phẩm muốn tạo của danh sách: ");
        soLuongSanPham = Integer.parseInt(sc.nextLine());
        danhSachSanPham = new SanPham[soLuongSanPham];
        for(int i = 0; i < soLuongSanPham; i++){
            SanPham sp;
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
    public void Them(){
        danhSachSanPham = Arrays.copyOf(danhSachSanPham, danhSachSanPham.length + 1);
        SanPham sp;
        menuNhap();
        System.out.println("Nhập loại sản phẩm muốn thêm: ");
        int luaChon = Integer.parseInt(sc.nextLine());
        while(luaChon != 1 && luaChon != 2){
            menuNhap();
            System.out.println("Không có loại sản phẩm này, mời nhập lại: ");
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
        System.out.println("Nhập mã sản phẩm muốn xoá: ");
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
            System.out.println("Không tìm thấy mã sản phẩm muốn xoá");
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
                    System.out.println("Nhập mã sản phẩm cần tìm: ");
                    String maSP_TimKiem = sc.nextLine();
                    kq = false;
                    for(int i = 0; i < danhSachSanPham.length; i++){
                        if(danhSachSanPham[i].getMaSP().equals(maSP_TimKiem)){
                            danhSachSanPham[i].Xuat();
                            kq = true;
                        }
                    }
                    if(!kq){
                        System.out.println("Không tìm thấy mã sản phẩm: " + maSP_TimKiem);
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
                        System.out.println("Không tìm thấy tên sản phẩm: " + tenSP_TimKiem);
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
                        System.out.println("Không tìm thấy sản phẩm có số lượng: " + soLuongSP_TimKiem);
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
                        System.out.println("Không tìm thấy sản phẩm có giá tiền: " + giaTienSP_TimKiem);
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
                        System.out.println("Không tìm thấy sản phẩm có tiền vốn: " + tienVonSP_TimKiem);
                    }
                    break;
                case 6:
                    System.out.println("Thoát tìm kiếm");
                    return;
                default:
                    System.out.println("Không có lựa chọn tìm kiếm này");
                    break;
            }
            if(luaChon == 6){
                break;
            }
        }

    }

    public void Xuat() {
        if (danhSachSanPham == null || danhSachSanPham.length == 0) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }
        for(int i = 0;i<danhSachSanPham.length;i++){
            danhSachSanPham[i].Xuat();
        }
    }

    public void Sua(){
        System.out.println("Nhập mã của sản phẩm cần sửa: ");
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
            System.out.println("Không tìm thấy sản phầm cần sửa");
        }
    }

    public void docFile(){
        try{
            FileReader fr = new FileReader("SanPham.txt");
            BufferedReader br = new BufferedReader(fr);
            String st;
            while((st = br.readLine()) != null){
                String[] phan = st.split(",");
                if(phan[0] == "Thức ăn"){
                    ThucAn sp = new ThucAn();
                    sp.setMaSP(phan[1]);
                    sp.setTenSP(phan[2]);
                    sp.setSoLuong(Integer.parseInt(phan[3]));
                    sp.setGiaTien(Double.parseDouble(phan[4]));
                    sp.setTienVon(Double.parseDouble(phan[5]));
                    sp.setLoaiThucAn(phan[6]);
                    //Thêm thức ăn vào danh sách sản phầm
                    danhSachSanPham = Arrays.copyOf(danhSachSanPham, danhSachSanPham.length + 1);
                    danhSachSanPham[danhSachSanPham.length - 1] = sp;
                }
                if(phan[0] == "Nước uống"){
                    NuocUong sp = new NuocUong();
                    sp.setMaSP(phan[1]);
                    sp.setTenSP(phan[2]);
                    sp.setSoLuong(Integer.parseInt(phan[3]));
                    sp.setGiaTien(Double.parseDouble(phan[4]));
                    sp.setTienVon(Double.parseDouble(phan[5]));
                    sp.setLoaiNuoc(phan[6]);
                    //Thêm nước uống vào danh sách sản phầm
                    danhSachSanPham = Arrays.copyOf(danhSachSanPham, danhSachSanPham.length + 1);
                    danhSachSanPham[danhSachSanPham.length - 1] = sp;
                }
            }
            br.close();
            fr.close();
            System.out.println("Đọc File SanPham.txt thành công");
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
            System.out.println("Ghi File SanPham.txt thành công");
        }
        catch (IOException ioException) {
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
}
