package Project_OOP;

import Project_OOP.IThaoTac;
import Project_OOP.KhachHang;
import Project_OOP.SanPham;

import java.io.*;
import java.util.Arrays;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HoaDon implements IThaoTac {

    static Scanner sc = new Scanner(System.in);

    private String maHD;
    private String thoiGian;
    private KhachHang[] khachHang=new KhachHang[0];
    private KhachHang khachhangtheodon=new KhachHang();
    private SanPham[] sanpham=new SanPham[0];
    private SanPham[] sanphamtheodon=new SanPham[0];
    private int[] soLuongSP=new int[0];
    private String phuongThucThanhToan;
    private boolean Status;

    public HoaDon() {
        this.setStatus(true);
        this.loadKhachHangFromFile();
        this.loadSanPhamFromFile();

    }



    public KhachHang getKhachhangtheodon() {
        return khachhangtheodon;
    }

    public void setKhachhangtheodon(KhachHang khachhangtheodon) {
        this.khachhangtheodon = khachhangtheodon;
    }

    public SanPham[] getSanphamtheodon() {
        return sanphamtheodon;
    }

    public void setSanphamtheodon(SanPham[] sanphamtheodon) {
        this.sanphamtheodon = sanphamtheodon;
    }



    // Getter and Setter methods
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        while (maHD == null || maHD.trim().isEmpty()) {
            System.out.println("Mã hóa đơn không được để trống. Vui lòng nhập lại mã hóa đơn: ");
            maHD = sc.nextLine().trim();
        }
        String regex = "^HD\\d+$";
        while (!Pattern.matches(regex, maHD)) {
            System.out.println("Mã hóa đơn không hợp lệ. Vui lòng nhập lại mã hóa đơn (HDxxxx): ");
            maHD = sc.nextLine().trim();
        }
        this.maHD = maHD;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        while (thoiGian == null || thoiGian.trim().isEmpty()) {
            System.out.println("Thời gian không được để trống. Vui lòng nhập lại thời gian: ");
            thoiGian = sc.nextLine().trim();
        }
        String regex = "^(\\d{4})-(\\d{2})-(\\d{2})$";
        while (!Pattern.matches(regex, thoiGian)) {
            System.out.println("Thời gian không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd: ");
            thoiGian = sc.nextLine().trim();
        }
        this.thoiGian = thoiGian;
    }

    public KhachHang getKhachHang() {
        return khachHang[0];
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang[0] = khachHang;
    }

    public SanPham[] getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham[] sanpham) {
        this.sanpham = sanpham;
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
        while (phuongThucThanhToan == null || phuongThucThanhToan.trim().isEmpty()) {
            System.out.println("Phương thức thanh toán không được để trống. Vui lòng nhập lại phương thức thanh toán: ");
            phuongThucThanhToan = sc.nextLine().trim();
        }
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    // Method to load KhachHang data from file
    public void loadKhachHangFromFile() {
        String fileName = "KhachHang.txt";
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File không tồn tại: " + fileName);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int index = 0;
            // Initial empty array (can grow as needed)
            khachHang = new KhachHang[0];

            while ((line = br.readLine()) != null) {
                String[] strings = line.split(";");
                try {
                    // Create a new KhachHang object
                    KhachHang kh = new ThanhVien(strings[0], strings[1], strings[2], strings[3], strings[4], Integer.parseInt(strings[5]));

                    // Resize the array by copying the existing array to a new one with 1 additional space
                    khachHang = Arrays.copyOf(khachHang, khachHang.length + 1);

                    // Add the new KhachHang at the last index of the array
                    khachHang[khachHang.length - 1] = kh;

                    index++;
                } catch (Exception e) {
                    System.out.println("Lỗi khi xử lý dòng: " + line);
                    e.printStackTrace();
                }
            }

            System.out.println("Đọc thành công dữ liệu khách hàng từ file.");

        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }


    // Method to load SanPham data from file
    public void loadSanPhamFromFile() {
        String fileName = "SanPham.txt";
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File không tồn tại: " + fileName);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int index = 0;
            // Initial empty array for sanpham
            sanpham = new SanPham[0];

            while ((line = br.readLine()) != null) {
                String[] strings = line.split(";");
                try {
                    // Resize the array as needed
                    sanpham = Arrays.copyOf(sanpham, sanpham.length + 1); // Add one more space

                    // Add the appropriate SanPham object
                    if (strings[0].startsWith("TA")) {
                        sanpham[sanpham.length - 1] = new ThucAn(strings[0], strings[1], Integer.parseInt(strings[2]),
                                Double.parseDouble(strings[3]), Double.parseDouble(strings[4]), strings[5]);
                    } else if (strings[0].startsWith("NU")) {
                        sanpham[sanpham.length - 1] = new NuocUong(strings[0], strings[1], Integer.parseInt(strings[2]),
                                Double.parseDouble(strings[3]), Double.parseDouble(strings[4]), strings[5]);
                    }
                    index++;
                } catch (Exception e) {
                    System.out.println("Lỗi khi xử lý dòng: " + line);
                    e.printStackTrace();
                }
            }

            System.out.println("Đọc thành công dữ liệu sản phẩm từ file.");

        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    // Nhap method
    @Override
    public void Nhap() {
        System.out.print("Nhập mã hóa đơn: ");
        this.maHD = sc.nextLine();

        System.out.print("Nhập thời gian: ");
        this.thoiGian = sc.nextLine();

        System.out.println("Nhập SDT khách hàng: ");
        String sdtKH = sc.nextLine();
        for (KhachHang x : khachHang) {
            if (sdtKH.equalsIgnoreCase(x.getSDT())) {
                khachhangtheodon=x;
            }
        }

        int i = 0;
        while (i < sanpham.length) {
            soLuongSP=Arrays.copyOf(soLuongSP,soLuongSP.length+1);
            System.out.println("Nhập tên sản phẩm: ");
            String tenSP = sc.nextLine();
            boolean timSP = false;
            System.out.println("Nhập số lượng sản phẩm: ");
            int sl = Integer.parseInt(sc.nextLine());
            this.soLuongSP[soLuongSP.length-1]=sl;
            for (SanPham x : sanpham) {
                if (tenSP.equalsIgnoreCase(x.getTenSP())) {
                    sanphamtheodon=Arrays.copyOf(sanphamtheodon,sanphamtheodon.length+1);
                    sanphamtheodon[sanphamtheodon.length-1]=x;
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
            if( luaChon==1 ){
                sanphamtheodon=Arrays.copyOf(sanphamtheodon,sanphamtheodon.length+1);
            }
            i++;

            if (i == sanpham.length) {
                System.out.println("Danh sách sản phẩm đã đầy.");
                break;
            }
        }

        System.out.print("Nhập phương thức thanh toán: ");
        this.phuongThucThanhToan = sc.nextLine();
    }

    // Xuat method
    @Override
    public void Xuat() {
        System.out.println(toString());
    }

    // TongTien method
    public double TongTien() {
        double tongTien = 0;
        for (int i = 0; i < sanphamtheodon.length; i++) {
            if (sanphamtheodon[i] != null) {
                tongTien += sanphamtheodon[i].getGiaTien() * soLuongSP[i];
            }
        }
        return tongTien;
    }

    // Sua method
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
                setMaHD(sc.nextLine());
                break;
            case 2:
                System.out.print("Nhập lại thời gian: ");
                setThoiGian(sc.nextLine());
                break;
            case 3:
                System.out.println("Nhập lại số điện thoại khách hàng (SDT): ");
                String sdtKH = sc.nextLine();
                for (KhachHang x : khachHang) {
                    if (sdtKH.equalsIgnoreCase(x.getSDT())) {
                        khachhangtheodon=x;
                    }
                }
                break;
            case 4:
                boolean themSP = false;
                for (int i = 0; i < sanpham.length; i++) {
                    if (sanpham[i] == null) {
                        System.out.println("Nhập tên sản phẩm: ");
                        String tenSP = sc.nextLine();
                        System.out.println("Nhập số lượng sản phẩm: ");
                        soLuongSP[i] = Integer.parseInt(sc.nextLine());
                        themSP = true;
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
                    sanpham[9] = null;
                    soLuongSP[9] = 0;
                    System.out.println("Sản phẩm đã được xóa.");
                } else {
                    System.out.println("Chỉ số sản phẩm không hợp lệ.");
                }
                break;
            case 6:
                System.out.print("Nhập lại phương thức thanh toán: ");
                setPhuongThucThanhToan(sc.nextLine());
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    // toString method
    @Override
    public String toString() {
        String result = "Mã hóa đơn: " + maHD + "\n";
        result += "Thời gian: " + thoiGian + "\n";
        result += "Khách hàng: " + (getKhachhangtheodon() != null  ? getKhachhangtheodon().getTenKH() : "Chưa có") + "\n";
        result += "Sản phẩm: \n";

        if (sanphamtheodon != null && soLuongSP != null && sanphamtheodon.length == soLuongSP.length) {
            for (int i = 0; i < sanphamtheodon.length; i++) {
                if (getSanphamtheodon()[i] != null && soLuongSP[i] > 0) {
                    result += getSanphamtheodon()[i].getTenSP() + " - " + soLuongSP[i] + " x " + sanphamtheodon[i].getGiaTien()+ "\n";
                }
            }
        } else {
            result += "Sản phẩm không có trong danh sách.\n";
            System.out.println(khachhangtheodon.getTenKH());
            for (int i = 0; i < sanphamtheodon.length; i++) {
                System.out.println(sanphamtheodon[i].getTenSP());
            }
        }
        result += "Sản phẩm: "+ TongTien()+"\n";


        result += "Phương thức thanh toán: " + phuongThucThanhToan;
        return result;
    }
}
