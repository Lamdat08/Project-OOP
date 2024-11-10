package SGU_OOP_Excercises.OOP_Project;

public class NuocUong extends SanPham   {

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
    public void Nhap(){
        super.Nhap();
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
    public void Xuat(){
        System.out.println(toString());
    }

    @Override
    public void Sua(){
        super.Sua();
        System.out.println("Nhap loai nuoc moi: ");
        this.setLoaiNuoc(sc.nextLine());
    }

    public double tinhLoiNhuan(){
        return getGiaTien() - getTienVon();
    }
}
