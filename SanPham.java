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
        while(true){
            try{
                String regexThucAn = "^(TA)[0-9]{3}$";
                String regexNuocUong = "^(NU)[0-9]{3}$";
                if(maSP == null || maSP.trim().isEmpty()) {
                    System.out.println("Mã sản phẩm không được để trống, vui lòng nhập lại: ");
                    maSP = sc.nextLine().trim();
                }
                if(this instanceof ThucAn){
                    if(!maSP.matches(regexThucAn)){
                        System.out.println("Mã thức ăn phải bắt đầu với TA, vui lòng nhập lại: ");
                        maSP = sc.nextLine().trim();
                    }
                }
                if(this instanceof NuocUong){
                    if(!maSP.matches(regexNuocUong)){
                        System.out.println("Mã nước uống phải bắt đầu với NU, vui lòng nhập lại: ");
                        maSP = sc.nextLine().trim();
                    }
                }
                break;
            }
            catch(Exception e){
                System.out.println("Mã sản phẩm không hợp lệ, vui lòng nhập lại: ");
            }
        }
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }
    public void setTenSP(String tenSP) {
        while(true){
            try{
                String regex = "^[A-Za-zÀ-ỹ\\s]+$";
                if(tenSP == null || tenSP.trim().isEmpty() || !tenSP.matches(regex)) {
                    System.out.println("Tên của sản phẩm không được để trống và chỉ được chứa các chữ cái, vui lòng nhập lại: ");
                    tenSP = sc.nextLine().trim();
                }
                break;
            }
            catch(Exception e){
                System.out.println("Tên của sản phẩm không hợp lệ, vui lòng nhập lại. ");
            }
        }
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        String regex = "^[0-9]+$";
        while(true){
            try{
                String inputSoLuong = Integer.toString(soLuong);
                if(inputSoLuong.trim().isEmpty() || !inputSoLuong.matches(regex)){
                    System.out.println("Số lượng của sản phẩm không được để trống và phải là 1 số nguyên, vui lòng nhập lại: ");
                    soLuong = Integer.parseInt(sc.nextLine().trim());
                }
                break;
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("Số lượng của sản phẩm không hợp lệ, vui lòng nhập lại. ");
            }
        }
        this.soLuong = soLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }
    public void setGiaTien(double giaTien) {
        String regex = "^[1-9]\\d*\\.\\d+$";
        while(true){
            try{
                String inputGiaTien = Double.toString(giaTien);
                if(inputGiaTien.trim().isEmpty() || !inputGiaTien.matches(regex)){
                    System.out.println("Giá tiền của sản phẩm không được để trống và phải là 1 số thực, vui lòng nhập lại: ");
                    giaTien = Double.parseDouble(sc.nextLine().trim());
                }
                break;
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("Giá tiền của sản phẩm không hợp lệ, vui lòng nhập lại.");
            }
        }
        this.giaTien = giaTien;
    }

    public double getTienVon() {
        return tienVon;
    }
    public void setTienVon(double tienVon) {
        String regex = "^[1-9]\\d*\\.\\d+$";
        while(true){
            try{
                String inputTienVon = Double.toString(tienVon);
                if(inputTienVon.trim().isEmpty() || !inputTienVon.matches(regex)){
                    System.out.println("Tiền vốn của sản phẩm không được để trống và phải là 1 số thực, vui lòng nhập lại: ");
                    tienVon = Double.parseDouble(sc.nextLine().trim());
                }
                break;
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("Tiền vốn của sản phẩm không hợp lệ, vui lòng nhập lại.");
            }
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
                System.out.println("Nhập số lượng: ");
                setSoLuong(Integer.parseInt(sc.nextLine().trim()));
                break;
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("Số lượng của sản phẩm không hợp lệ, vui lòng nhập lại. ");
            }
        }
        while(true){
            try{
                System.out.println("Nhập giá tiền: ");
                setGiaTien(Double.parseDouble(sc.nextLine().trim()));
                break;
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("Giá tiền của sản phẩm không hợp lệ, vui lòng nhập lại.");
            }
        }
        while(true){
            try{
                System.out.println("Nhập tiền vốn: ");
                setTienVon(Double.parseDouble(sc.nextLine().trim()));
                break;
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("Tiền vốn của sản phẩm không hợp lệ, vui lòng nhập lại.");
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
                    String inputLuaChon = Integer.toString(luaChon);
                    String regex = "^[1-6]$";
                    if(!inputLuaChon.matches(regex)){
                        menuSuaSanPham();
                        System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại. ");
                    }
                    break;
                }
                catch(NumberFormatException numberFormatException){
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại: ");
                }
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
                    while(true){
                        try{
                            System.out.println("Nhập số lượng mới: ");
                            setSoLuong(Integer.parseInt(sc.nextLine().trim()));
                            break;
                        }
                        catch(NumberFormatException numberFormatException){
                            System.out.println("Số lượng của sản phẩm không hợp lệ, vui lòng nhập lại. ");
                        }
                    }
                    break;
                case 4:
                    while(true){
                        try{
                            System.out.println("Nhập giá tiền mới: ");
                            setGiaTien(Double.parseDouble(sc.nextLine().trim()));
                            break;
                        }
                        catch(NumberFormatException numberFormatException){
                            System.out.println("Giá tiền của sản phẩm không hợp lệ, vui lòng nhập lại.");
                        }
                    }
                    break;
                case 5:
                    while(true){
                        try{
                            System.out.println("Nhập tiền vốn mới: ");
                            setTienVon(Double.parseDouble(sc.nextLine().trim()));
                            break;
                        }
                        catch(NumberFormatException numberFormatException){
                            System.out.println("Tiền vốn của sản phẩm không hợp lệ, vui lòng nhập lại.");
                        }
                    }
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
