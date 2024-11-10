package SGU_OOP_Excercises.OOP_Project;

public class NuocUong extends SanPham implements IThaoTac {

    private String loaiNuoc;

    public NuocUong() {
    }

    public String getLoaiNuoc() {
        return loaiNuoc;
    }

    public void setLoaiNuoc(String loaiNuoc) {
        this.loaiNuoc = loaiNuoc;
    }

    @Override
    public void nhap(){
        super.nhap();
        System.out.println("Nhap loai nuoc: ");
        setLoaiNuoc(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + "NuocUong{" +
                "loaiNuoc='" + loaiNuoc + '\'' +
                '}';
    }
    @Override
    public void xuat(){
        System.out.println(toString());
    }

    @Override
    public void sua(){
        super.sua();
        System.out.println("Nhap loai nuoc moi: ");
        this.setLoaiNuoc(sc.nextLine());
    }

    public double tinhLoiNhuan(){
        return getGiaTien() - getTienVon();
    }
}
