package Project_OOP;

import java.util.Scanner;

public class SanPham implements IThaoTac {

    static Scanner sc = new Scanner(System.in);

    private String maSP;
    private String tenSP;
    private int soLuong;
    private double giaTien;
    private double tienVon;

    private boolean status;

    public void menuSuaSanPham(){
        System.out.println("1.Mã sản phẩm.");
        System.out.println("2.Tên sản phẩm.");
        System.out.println("3.Số lượng của sản phẩm.");
        System.out.println("4.Giá tiền của sản phẩm.");
        System.out.println("5.Tiền vốn của sản phẩm.");
        System.out.println("6.Thoát sửa thông tin khác của sản phẩm");
    }

    public SanPham() {
        this.status = true;
    }

    public SanPham(String maSP, String tenSP, int soLuong, double giaTien, double tienVon) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.tienVon = tienVon;
        this.status  = true;
    }

    public String getMaSP() {
        return maSP;
    }
    public void setMaSP(String maSP) {
        String regexThucAn = "^(TA)[0-9]{3}$";
        String regexNuocUong = "^(NU)[0-9]{3}$";
        while(maSP == null || maSP.trim().isEmpty()) {
            System.out.println("Mã sản phẩm không được để trống, vui lòng nhập lại: ");
            maSP = sc.nextLine().trim();
        }
        if(this instanceof ThucAn){
            while(!maSP.matches(regexThucAn)){
                System.out.println("Mã thức ăn phải bắt đầu với TA, vui lòng nhập lại: ");
                maSP = sc.nextLine().trim();
            }
        }
        if(this instanceof NuocUong){
            while(!maSP.matches(regexNuocUong)){
                System.out.println("Mã nước uống phải bắt đầu với NU, vui lòng nhập lại: ");
                maSP = sc.nextLine().trim();
            }
        }
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }
    public void setTenSP(String tenSP) {
        while(tenSP == null || tenSP.trim().isEmpty()) {
            System.out.println("Tên của sản phẩm không được để trống, vui lòng nhập lại: ");
            tenSP = sc.nextLine().trim();
        }
        String regex = "^[A-Za-zÀ-ỹ\\s]+$";
        while(!tenSP.matches(regex)){
            System.out.println("Tên của sản phẩm không hợp lệ, vui lòng nhập lại: ");
            tenSP = sc.nextLine().trim();
        }
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        String regex = "^[0-9]+$";
        String inputSoLuong = Integer.toString(soLuong);
        while(inputSoLuong.trim().isEmpty()){
            System.out.println("Số lượng của sản phẩm không được để trống, vui lòng nhập lại: ");
            soLuong = Integer.parseInt(sc.nextLine().trim());
            inputSoLuong = Integer.toString(soLuong);
        }
        while(!inputSoLuong.matches(regex)){
            System.out.println("Số lượng của sản phẩm không hợp lệ. Vui lòng nhập lại: ");
            soLuong = Integer.parseInt(sc.nextLine().trim());
            inputSoLuong = Integer.toString(soLuong);
        }
        this.soLuong = soLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }
    public void setGiaTien(double giaTien) {
        String regex = "^[1-9]\\d*\\.\\d+$";
        String inputGiaTien = Double.toString(giaTien);
        while(inputGiaTien.trim().isEmpty()){
            System.out.println("Giá tiền của sản phẩm không được để trống, vui lòng nhập lại: ");
            giaTien = Double.parseDouble(sc.nextLine().trim());
            inputGiaTien = Double.toString(giaTien);
        }
        while(!inputGiaTien.matches(regex)){
            System.out.println("Giá tiền của sản phẩm không hợp lệ. Vui lòng nhập lại: ");
            giaTien = Double.parseDouble(sc.nextLine().trim());
            inputGiaTien = Double.toString(giaTien);
        }
        this.giaTien = giaTien;
    }

    public double getTienVon() {
        return tienVon;
    }
    public void setTienVon(double tienVon) {
        String regex = "^[1-9]\\d*\\.\\d+$";
        String inputTienVon = Double.toString(tienVon);
        while(inputTienVon.trim().isEmpty()){
            System.out.println("Tiền vốn của sản phẩm không được để trống, vui lòng nhập lại: ");
            tienVon = Double.parseDouble(sc.nextLine().trim());
            inputTienVon = Double.toString(tienVon);
        }
        while(!inputTienVon.matches(regex)){
            System.out.println("Tiền vốn của sản phẩm không hợp lệ. Vui lòng nhập lại: ");
            tienVon = Double.parseDouble(sc.nextLine().trim());
            inputTienVon = Double.toString(tienVon);
        }
        this.tienVon = tienVon;
    }

    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public void Nhap(){
        System.out.println("Nhập mã sản phẩm: ");
        setMaSP(sc.nextLine());
        System.out.println("Nhập tên sản phẩm: ");
        setTenSP(sc.nextLine());
        while(true){
            try{
                System.out.println("Nhập số lượng của sản phẩm: ");
                setSoLuong(Integer.parseInt(sc.nextLine()));
                break;
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("Số lượng của sản phẩm không hợp lệ, vui lòng nhập 1 số: ");
            }
        }
        while(true){
            try{
                System.out.println("Nhập giá tiền của sản phẩm: ");
                setGiaTien(Double.parseDouble(sc.nextLine()));
                break;
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("Giá tiền của sản phẩm không hợp lệ, vui lòng nhập 1 số: ");
            }
        }
        while(true){
            try{
                System.out.println("Nhập tiền vốn của sản phẩm: ");
                setTienVon(Double.parseDouble(sc.nextLine()));
                break;
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("Tiền vốn của sản phẩm không hợp lệ, vui lòng nhập 1 số: ");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%d;%.2f;%.2f;%.2f",getMaSP(),getTenSP(),getSoLuong(),
                getGiaTien(), getTienVon(), LoiNhuan());
    }
    public void Xuat(){
        System.out.println("Mã sản phẩm : " + getMaSP());
        System.out.println("Tên sản phẩm : " + getTenSP());
        System.out.println("Số lượng của sản phẩm : " + getSoLuong());
        System.out.println("Giá tiền của sản phẩm : " + getGiaTien());
        System.out.println("Tiền vốn của sản phẩm : " + getTienVon());
        System.out.println("Lợi nhuận của sản phẩm : " + LoiNhuan());
        System.out.println("\\n-------------------\"");
    }

    public void Sua(){
        while(true){
            int luaChon;
            while(true){
                try{
                    menuSuaSanPham();
                    System.out.print("Nhập lựa chọn sửa sản phẩm: ");
                    luaChon = Integer.parseInt(sc.nextLine());
                    break;
                }
                catch(NumberFormatException numberFormatException){
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại: ");
                }
            }
            String inputLuaChon = Integer.toString(luaChon);
            String regex = "^[1-6]$";
            while(!inputLuaChon.matches(regex)){
                menuSuaSanPham();
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại: ");
                luaChon = Integer.parseInt(sc.nextLine());
            }
            switch(luaChon){
                case 1:
                    System.out.println("Nhập mã sản phẩm mới: ");
                    setMaSP(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập tên sản phẩm mới: ");
                    setTenSP(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Nhập số lượng mới: ");
                    setSoLuong(Integer.parseInt(sc.nextLine()));
                    break;
                case 4:
                    System.out.println("Nhập giá tiền mới: ");
                    setGiaTien(Double.parseDouble(sc.nextLine()));
                    break;
                case 5:
                    System.out.println("Nhập tiền vốn mới: ");
                    setTienVon(Double.parseDouble(sc.nextLine()));
                    break;
                case 6:
                    System.out.println("Thoát sửa sản phẩm");
                    return;
            }
        }
    }

    public double LoiNhuan(){
        return getGiaTien() - getTienVon();
    }
}
