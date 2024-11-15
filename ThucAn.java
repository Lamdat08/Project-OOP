package Project_OOP;

public class ThucAn extends SanPham {

    private String loaiThucAn;

    public ThucAn() {
    }
    public ThucAn(String maSP, String tenSP, int soLuong, double giaTien, double tienVon, String loaiThucAn) {
        super(maSP, tenSP, soLuong, giaTien, tienVon);
        this.loaiThucAn = loaiThucAn;
    }

    public String getLoaiThucAn() {
        return loaiThucAn;
    }

    public void setLoaiThucAn(String loaiThucAn) {
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
        return super.toString() + "ThucAn{" +
                "Loại thức ăn: '" + loaiThucAn + '\'' +
                '}';
    }

    @Override
    public void Xuat(){
        System.out.println(toString());
    }

    @Override
    public void Sua(){
        super.Sua();
        System.out.println("Nhập loại thức ăn mới: ");
        this.setLoaiThucAn(sc.nextLine());
    }
}
