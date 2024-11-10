package SGU_OOP_Excercises.OOP_Project;

public class ThucAn extends SanPham implements IThaoTac{

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
    public void nhap(){
        super.nhap();
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
    public void xuat(){
        System.out.println(toString());
    }

    @Override
    public void sua(){
        super.sua();
        System.out.println("Nhap loai thuc an moi: ");
        this.setLoaiThucAn(sc.nextLine());
    }

    public double tinhLoiNhuan(){
        return getGiaTien() - getTienVon();
    }
}
