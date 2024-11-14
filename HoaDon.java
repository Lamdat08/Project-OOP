package Project_OOP;

import java.util.Arrays;
import java.util.Scanner;

public class HoaDon implements IThaoTac {

    static Scanner sc = new Scanner(System.in);

    private String maHD;
    private String thoiGian;
    private DanhSachKhachHang dskh;
    private KhachHang khachHang;
    private DanhSachSanPham dssp;
    private SanPham[] sanpham;
    private int[] soLuongSP;
    private String phuongThucThanhToan;

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public DanhSachKhachHang getDskh() {
        return dskh;
    }

    public void setDskh(DanhSachKhachHang dskh) {
        this.dskh = dskh;
    }

    public DanhSachSanPham getDssp() {
        return dssp;
    }

    public void setDssp(DanhSachSanPham dssp) {
        this.dssp = dssp;
    }

    public int[] getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int[] soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public HoaDon(DanhSachSanPham dssp, DanhSachKhachHang dskh) {
        this.dssp = dssp;
        this.dskh = dskh;
        this.sanpham = new SanPham[10];
        this.soLuongSP = new int[10];
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public SanPham[] getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham[] sanpham) {
        this.sanpham = sanpham;
    }

    @Override
    public void Nhap() {
        System.out.print("Nhập mã hóa đơn: ");
        this.maHD = sc.nextLine();

        System.out.print("Nhập thời gian: ");
        this.thoiGian = sc.nextLine();

        System.out.println("Nhập SDT: ");
        String sdtKH = sc.nextLine();
        for (KhachHang x : dskh.getDSKH()) {
            if (sdtKH.equalsIgnoreCase(x.getSDT())) {
                this.khachHang = x;
            }
        }

        int i = 0;
        while (i < sanpham.length) {
            System.out.println("Nhập tên sản phẩm: ");
            boolean timSP = false;
            String tenSP = sc.nextLine();
            System.out.println("Nhập số lượng sản phẩm: ");
            int sl = Integer.parseInt(sc.nextLine());

            for (SanPham x : dssp.getDSKP()) {
                if (tenSP.equalsIgnoreCase(x.getTenSP())) {
                    sanpham[i] = x;
                    soLuongSP[i] = sl;
                    timSP = true;
                    break;
                }
            }
            if (!timSP) {
                System.out.println("Không tìm thấy sản phẩm.");
            }

            System.out.println("Bạn muốn thêm sản phẩm không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int luaChon = Integer.parseInt(sc.nextLine());
            if (luaChon == 2) break;
            i++;
        }

        System.out.print("Nhập phương thức thanh toán: ");
        this.phuongThucThanhToan = sc.nextLine();
    }

    @Override
    public String toString() {
        String result = "Hóa đơn: ";
        result += "Mã hóa đơn: " + getMaHD() + ", Thời gian: " + getThoiGian();
        result += ", Khách hàng: " + khachHang.Xuat();
        for (int i = 0; i < sanpham.length; i++) {
            if (sanpham[i] != null) {
                result += " Sản phẩm " + (i + 1) + ": " + sanpham[i].Xuat() + ", Số lượng: " + soLuongSP[i]
                        + ", Giá: " + sanpham[i].getGia() + ", Thành tiền: " + soLuongSP[i] * sanpham[i].getGia();
            }
        }
        result += ", Phương thức thanh toán: " + getPhuongThucThanhToan();
        return result;
    }

    @Override
    public void Xuat() {
        System.out.println(toString());
    }

    @Override
    public double TongTien() {
        double tongTien = 0;
        for (int i = 0; i < sanpham.length; i++) {
            if (sanpham[i] != null) {
                tongTien += sanpham[i].getGia() * soLuongSP[i];
            }
        }
        return tongTien;
    }

    public void Sua() {
        System.out.println("Chọn thông tin cần sửa:");
        System.out.println("1. Mã hóa đơn");
        System.out.println("2. Thời gian");
        System.out.println("3. Khách hàng");
        System.out.println("4. Thêm sản phẩm");
        System.out.println("5. Xóa sản phẩm");
        System.out.println("6. Phương thức thanh toán");

        int luaChon = Integer.parseInt(sc.nextLine());

        switch (luaChon) {
            case 1:
                System.out.print("Nhập lại mã hóa đơn: ");
                this.maHD = sc.nextLine();
                break;
            case 2:
                System.out.print("Nhập lại thời gian: ");
                this.thoiGian = sc.nextLine();
                break;
            case 3:
                System.out.println("Nhập lại số điện thoại khách hàng (SDT): ");
                String sdtKH = sc.nextLine();
                boolean timKhachHang = false;
                for (KhachHang kh : dskh.getDSKH()) {
                    if (sdtKH.equalsIgnoreCase(kh.getSDT())) {
                        this.khachHang = kh;
                        timKhachHang = true;
                        break;
                    }
                }
                if (!timKhachHang) {
                    System.out.println("Không tìm thấy khách hàng với số điện thoại này.");
                }
                break;
            case 4:
                boolean themSP = false;
                for (int i = 0; i < sanpham.length; i++) {
                    if (sanpham[i] == null) {
                        System.out.println("Nhập tên sản phẩm: ");
                        String tenSP = sc.nextLine();
                        boolean timSP = false;
                        for (SanPham sp : dssp.getDSKP()) {
                            if (tenSP.equalsIgnoreCase(sp.getTenSP())) {
                                sanpham[i] = sp;
                                System.out.println("Nhập số lượng sản phẩm: ");
                                soLuongSP[i] = Integer.parseInt(sc.nextLine());
                                themSP = true;
                                timSP = true;
                                break;
                            }
                        }
                        if (!timSP) {
                            System.out.println("Không tìm thấy sản phẩm.");
                        }
                        break;
                    }
                }
                if (!themSP) {
                    System.out.println("Không còn chỗ để thêm sản phẩm.");
                }
                break;
            case 5:
                System.out.println("Nhập chỉ số sản phẩm cần xóa (0 - " + (sanpham.length - 1) + "): ");
                int chiSoXoa = Integer.parseInt(sc.nextLine());
                if (chiSoXoa >= 0 && chiSoXoa < sanpham.length && sanpham[chiSoXoa] != null) {
                    for (int i = chiSoXoa; i < sanpham.length - 1; i++) {
                        sanpham[i] = sanpham[i + 1];
                        soLuongSP[i] = soLuongSP[i + 1];
                    }
                    sanpham = Arrays.copyOf(sanpham, sanpham.length - 1);
                    soLuongSP = Arrays.copyOf(soLuongSP, soLuongSP.length - 1);
                    System.out.println("Sản phẩm đã được xóa.");
                } else {
                    System.out.println("Chỉ số sản phẩm không hợp lệ.");
                }
                break;
            case 6:
                System.out.print("Nhập lại phương thức thanh toán: ");
                this.phuongThucThanhToan = sc.nextLine();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }
}
