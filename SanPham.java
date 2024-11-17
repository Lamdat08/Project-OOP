package Project_OOP;

import java.util.Scanner;

public class SanPham implements IThaoTac {

    static Scanner sc = new Scanner(System.in);

    private String maSP;
    private String tenSP;
    private int soLuong;
    private double giaTien;
    private double tienVon;

    public void menuSua(){
        System.out.println("1.Mã sản phẩm.");
        System.out.println("2.Tên sản phẩm.");
        System.out.println("3.Số lượng của sản phẩm.");
        System.out.println("4.Giá tiền của sản phẩm.");
        System.out.println("5.Tiền vốn của sản phẩm.");
        System.out.println("6.Thoát sửa sản phẩm");
    }

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, int soLuong, double giaTien, double tienVon) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.tienVon = tienVon;
    }

    public String getMaSP() {
        return maSP;
    }
    public void setMaSP(String maSP) {
        while(true){
            if(!maSP.startsWith("TA") || !maSP.startsWith("NU")){
                System.out.println("Mã sản phẩm phải bắt đầu với TA(nếu là thức ăn), hoặc NU(nếu là nước uống), vui lòng nhập lại: ");
                maSP = sc.nextLine();
            }
            this.maSP = maSP;
            break;
        }
    }

    public String getTenSP() {
        return tenSP;
    }
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        while(true){
            if(soLuong < 0){
                System.out.println("Số lượng của sản phẩm phải > 0, vui lòng nhập lại: ");
                soLuong = Integer.parseInt(sc.nextLine());
            }
            this.soLuong = soLuong;
            break;
        }
    }

    public double getGiaTien() {
        return giaTien;
    }
    public void setGiaTien(double giaTien) {
        while(true){
            if(giaTien < getTienVon()){
                System.out.println("Giá tiền phải > tiền vốn(nếu không sẽ bị lỗ), vui lòng nhập lại: ");
                giaTien = Double.parseDouble(sc.nextLine());
            }
            this.giaTien = giaTien;
            break;
        }
    }

    public double getTienVon() {
        return tienVon;
    }
    public void setTienVon(double tienVon) {
        this.tienVon = tienVon;
    }

    public void Nhap(){
        System.out.println("Nhập mã sản phẩm: ");
        setMaSP(sc.nextLine());
        System.out.println("Nhập tên sản phẩm: ");
        setTenSP(sc.nextLine());
        System.out.println("Nhập số lượng của sản phẩm: ");
        setSoLuong(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhập giá tiền của sản phẩm: ");
        setGiaTien(Double.parseDouble(sc.nextLine()));
        System.out.println("Nhập tiền vốn của sản phẩm: ");
        setTienVon(Double.parseDouble(sc.nextLine()));
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
            menuSua();
            System.out.print("Nhập lựa chọn sửa sản phẩm: ");
            int luaChon = Integer.parseInt(sc.nextLine());
            while(luaChon < 1 || luaChon > 6){
                menuSua();
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
