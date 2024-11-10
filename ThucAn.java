package Project_OOP;

public class ThucAn extends SanPham {

    private String loaiThucAn;

    public ThucAn() {
    }

    public String getLoaiNuoc() {
        return loaiThucAn;
    }

    public void setLoaiThucAn(String loaiThucAn) {
        this.loaiThucAn = loaiThucAn;
    }

    @Override
    public void Nhap(){
        super.Nhap();
        System.out.println("Nhap loai thuc an: ");
        setLoaiThucAn(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + "ThucAn{" +
                "loaiThucAn='" + loaiThucAn + '\'' +
                '}';
    }

    @Override
    public void Xuat(){
        System.out.println(toString());
    }

    @Override
    public void Sua(){
        super.Sua();
        System.out.println("Nhap loai thuc an moi: ");
        this.setLoaiThucAn(sc.nextLine());
    }

    @Override
    public double LoiNhuan(){
        return getGiaTien() - getTienVon();
    }
}
