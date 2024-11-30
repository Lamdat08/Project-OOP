package Project_OOP;


public class NuocUong extends SanPham{

    private String loaiNuoc;

    public NuocUong() {
        super();
    }

    public NuocUong(String maSP, String tenSP, int soLuong, double giaTien, double tienVon, String loaiNuoc) {
        super(maSP, tenSP, soLuong, giaTien, tienVon);
        this.loaiNuoc = loaiNuoc;
    }

    public void menuSuaNuocUong(){
        System.out.println("Chọn thông tin cần sửa : ");
        System.out.println("1.Sửa loại nước uống");
        System.out.println("2.Sửa thông tin khác của sản phẩm");
        System.out.println("3.Thoát sửa loại nước uống");
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
        System.out.println("Loại nước uống: " + getLoaiNuoc());
    }

    @Override
    public void Sua(){
        while(true){
            int luaChon;
            while(true){
                try{
                    menuSuaNuocUong();
                    System.out.print("Nhập lựa chọn sửa nước uống: ");
                    luaChon = Integer.parseInt(sc.nextLine().trim());
                    break;
                }
                catch(NumberFormatException numberFormatException){
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại: ");
                }
            }
            String inputLuaChon = Integer.toString(luaChon);
            String regex = "^[1-3]$";
            while(!inputLuaChon.matches(regex)){
                menuSuaNuocUong();
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại: ");
                luaChon = Integer.parseInt(sc.nextLine().trim());
            }
            switch(luaChon){
                case 1:
                    System.out.println("Nhập loại nước uống mới: ");
                    setLoaiNuoc(sc.nextLine());
                    break;
                case 2:
                    super.Sua();
                    break;
                case 3:
                    System.out.println("Thoát sửa loại nước uống");
                    return;
            }
        }
    }
}
