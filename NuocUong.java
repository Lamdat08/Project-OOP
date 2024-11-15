package Project_OOP;

public class NuocUong extends SanPham{

    private String loaiNuoc;

    public NuocUong() {
    }

    public NuocUong(String maSP, String tenSP, int soLuong, double giaTien, double tienVon, String loaiNuoc) {
        super(maSP, tenSP, soLuong, giaTien, tienVon);
        this.loaiNuoc = loaiNuoc;
    }

    public String getLoaiNuoc() {
        return loaiNuoc;
    }

    public void setLoaiNuoc(String loaiNuoc) {
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
        return super.toString() + "NuocUong{" +
                "Loại Nước: '" + loaiNuoc + '\'' +
                '}';
    }
    @Override
    public void Xuat(){
        System.out.println(toString());
    }

    @Override
    public void Sua(){
        super.Sua();
        System.out.println("Nhập loại nước mới: ");
        this.setLoaiNuoc(sc.nextLine());
    }
}
