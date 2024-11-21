package Project_OOP;

import java.util.regex.Pattern;

public class ThucAn extends SanPham {

    private String loaiThucAn;

    public ThucAn() {
        super();
    }
    public ThucAn(String maSP, String tenSP, int soLuong, double giaTien, double tienVon, String loaiThucAn) {
        super(maSP, tenSP, soLuong, giaTien, tienVon);
        this.loaiThucAn = loaiThucAn;
    }

    public void menuSua(){
        System.out.println("Chọn thông tin cần sửa : ");
        System.out.println("0.Sửa loại thức ăn");
        super.Sua();
    }
    public String getLoaiThucAn() {
        return loaiThucAn;
    }
    public void setLoaiThucAn(String loaiThucAn) {
        while(loaiThucAn == null ||loaiThucAn.trim().isEmpty()) {
            System.out.println("Loại thức ăn không được để trống, vui lòng nhập lại: ");
            loaiThucAn = sc.nextLine().trim();
        }
        String regex = "^[A-Za-zÀ-ỹ\\s]+$";
        while(!Pattern.matches(regex, loaiThucAn)){
            System.out.println("Loại thức ăn không hợp lệ, vui lòng nhập lại: ");
            loaiThucAn = sc.nextLine().trim();
        }
        this.loaiThucAn = loaiThucAn;
    }

    @Override
    public void Nhap(){
        super.Nhap();
        System.out.println("Nhập loại thức ăn: ");
        setLoaiThucAn(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + String.format(";%s", getLoaiThucAn());
    }

    @Override
    public void Xuat(){
        super.Xuat();
        System.out.println("Loại thức ăn: " + getLoaiThucAn());
    }

    @Override
    public void Sua(){
        while(true){
            menuSua();
            System.out.print("Nhập lựa chọn sửa sản phẩm: ");
            int luaChon = Integer.parseInt(sc.nextLine());
            if(luaChon == 0){
                System.out.println("Nhập loại thức ăn mới: ");
                setLoaiThucAn(sc.nextLine());
            }
            else{
                super.Sua();
            }
            break;
        }
    }
}
