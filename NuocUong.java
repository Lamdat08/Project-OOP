package Project_OOP;

import java.util.regex.Pattern;

public class NuocUong extends SanPham{

    private String loaiNuoc;

    public NuocUong() {
        super();
    }

    public NuocUong(String maSP, String tenSP, int soLuong, double giaTien, double tienVon, String loaiNuoc) {
        super(maSP, tenSP, soLuong, giaTien, tienVon);
        this.loaiNuoc = loaiNuoc;
    }

    public void menuSua(){
        System.out.println("Chọn thông tin cần sửa : ");
        System.out.println("0.Sửa loại nước uống");
        super.Sua();
    }

    public String getLoaiNuoc() {
        return loaiNuoc;
    }

    public void setLoaiNuoc(String loaiNuoc) {
        while(loaiNuoc == null ||loaiNuoc.trim().isEmpty()) {
            System.out.println("Loại nước uống không được để trống, vui lòng nhập lại: ");
            loaiNuoc = sc.nextLine().trim();
        }
        String regex = "^[A-Za-zÀ-ỹ\\s]+$";
        while(!loaiNuoc.matches(regex)){
            System.out.println("Loại nước uống không hợp lệ, vui lòng nhập lại: ");
            loaiNuoc = sc.nextLine().trim();
        }
        this.loaiNuoc = loaiNuoc;
    }

    @Override
    public void Nhap(){
        super.Nhap();
        System.out.println("Nhập loại nước: ");
        setLoaiNuoc(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + String.format(";%s", getLoaiNuoc());
    }
    @Override
    public void Xuat(){
        super.Xuat();
        System.out.println("Loại nước uống : " + getLoaiNuoc());
    }

    @Override
    public void Sua(){
        while(true){
            menuSua();
            System.out.print("Nhập lựa chọn sửa sản phẩm: ");
            int luaChon = Integer.parseInt(sc.nextLine());
            if(luaChon == 0){
                System.out.println("Nhập loại nước uống mới: ");
                setLoaiNuoc(sc.nextLine());
            }
            else{
                super.Sua();
            }
            break;
        }
    }
}
