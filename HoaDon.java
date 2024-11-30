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

    public HoaDon(String ma, String thoiGian, String PTTT, KhachHang KH, SanPham[] ListSP, int[] soluong){
        this.maHD = ma;
        this.thoiGian = thoiGian;
        this.phuongThucThanhToan = PTTT;
        this.khachhangtheodon = KH;
        this.sanphamtheodon = ListSP;
        this.soLuongSP =  soluong;
        this.Status = true;

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
        setMaHD(sc.nextLine().trim());

        System.out.print("Nhập thời gian: ");
        setThoiGian(sc.nextLine().trim());
        String regex = "^[0-9]{10,11}$";
        String sdtKH;
        do {
            System.out.println("Nhập SDT khách hàng: ");
            sdtKH = sc.nextLine();
            if (sdtKH == null || sdtKH.trim().isEmpty())
                System.out.println("Số điện thoại không được để trống. Vui lòng nhập số điện thoại: ");
            while (!Pattern.matches(regex, sdtKH)) {
                System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại: ");
                sdtKH = sc.nextLine().trim();
            }
        } while (sdtKH == null || sdtKH.trim().isEmpty());


        boolean isFind = false;
        // Look for the customer by their phone number
        for (KhachHang x : khachHang) {
            if (sdtKH.equalsIgnoreCase(x.getSDT())) {
                khachhangtheodon = x;
                isFind = true;
                System.out.println("Da tim thay khach hang. Ho va ten : " + khachhangtheodon.getTenKH());
                break;  // Exit the loop as soon as the customer is found
            }

        }

        if (!isFind) {
            System.out.println("Khong tim thay khach hang theo sdt. Vui long nhap vao ten khach hang : ");
            String TenKH = sc.nextLine();
            khachhangtheodon.setSDT(sdtKH);
            khachhangtheodon.setTenKH(TenKH);
        }

//            System.out.println("Nhập tên sản phẩm: ");
//            String tenSP = sc.nextLine();  // Read product name
//            boolean timSP = false;
//
//            System.out.println("Nhập số lượng sản phẩm: ");
//            int sl = Integer.parseInt(sc.nextLine());  // Read quantity
//            soLuongSP = Arrays.copyOf(soLuongSP, soLuongSP.length + 1);  // Resize quantity array to match new product
//            soLuongSP[soLuongSP.length - 1] = sl;  // Store the quantity
//
//            // Look for the product by name
//            for (SanPham x : sanpham) {
//                if (tenSP.equalsIgnoreCase(x.getTenSP())) {
//                    sanphamtheodon = Arrays.copyOf(sanphamtheodon, sanphamtheodon.length + 1);  // Resize sanphamtheodon array
//                    sanphamtheodon[sanphamtheodon.length - 1] = x;  // Add selected product to the order list
//                    timSP = true;
//                    break;
//                }
//            }
//
//            if (!timSP) {
//                System.out.println("Không tìm thấy sản phẩm.");
//            }
//
//            // Ask the user if they want to add another product
//            System.out.println("Bạn muốn thêm sản phẩm không?");
//            System.out.println("1. Có");
//            System.out.println("2. Không");
//            int luaChon = Integer.parseInt(sc.nextLine());  // Read user's choice
//
//            if (luaChon == 2) {
//                break;  // Exit the loop if the user doesn't want to add more products
//            }
//
//            // Prevent overflow if the array size exceeds the available slots
//            if (sanphamtheodon.length >= sanpham.length) {
//                System.out.println("Danh sách sản phẩm đã đầy.");
//                break;  // Exit the loop if the product list is full
//            }
        System.out.println("\n------------------------\n Chon san pham qua stt : ");
        for (int j = 0; j < sanpham.length; j++) {
            System.out.println(j + 1 + "." + sanpham[j].getMaSP() + " - " + sanpham[j].getTenSP() + " - $ : " + sanpham[j].getGiaTien() + " || ");
        }

        int index = 0;
        while (true) {
            int s = -1;
            while (s < 1 || s > sanpham.length) {
                System.out.printf("Chon san pham qua thu tu  hoac bam 0 de ket thuc : ");
                s = Integer.parseInt(sc.nextLine());
                if (s == 0)
                    break;
                if (s < 1 || s > sanpham.length)
                    System.out.println("Vui long nhap dung thu tu.");
            }
            if (s == 0) {
                break;
            }
            sanphamtheodon = Arrays.copyOf(sanphamtheodon, sanphamtheodon.length + 1);  // Resize sanphamtheodon array
            soLuongSP = Arrays.copyOf(soLuongSP, soLuongSP.length+1);
            sanphamtheodon[index] = sanpham[s-1];
//            System.out.println(sanpham[s-1]);
            int sl;
            System.out.printf("Nhap vao so luong " + sanpham[s-1].getTenSP() + " : ");
            sl = Integer.parseInt(sc.nextLine());
            soLuongSP[index] = sl;
            index++;
        }
        System.out.print("Nhập phương thức thanh toán: ");
        this.phuongThucThanhToan = sc.nextLine();

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
                while (true) {
                    System.out.println("Nhập tên sản phẩm: ");
                    String tenSP = sc.nextLine();  // Read product name
                    boolean timSP = false;

                    System.out.println("Nhập số lượng sản phẩm: ");
                    int sl = Integer.parseInt(sc.nextLine());  // Read quantity
                    soLuongSP = Arrays.copyOf(soLuongSP, soLuongSP.length + 1);  // Resize quantity array to match new product
                    soLuongSP[soLuongSP.length - 1] = sl;  // Store the quantity

                    // Look for the product by name
                    for (SanPham x : sanpham) {
                        if (tenSP.equalsIgnoreCase(x.getTenSP())) {
                            sanphamtheodon = Arrays.copyOf(sanphamtheodon, sanphamtheodon.length + 1);  // Resize sanphamtheodon array
                            sanphamtheodon[sanphamtheodon.length - 1] = x;  // Add selected product to the order list
                            timSP = true;
                            break;
                        }
                    }

                    if (!timSP) {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }

                    // Ask the user if they want to add another product
                    System.out.println("Bạn muốn thêm sản phẩm không?");
                    System.out.println("1. Có");
                    System.out.println("2. Không");
                    luaChon = Integer.parseInt(sc.nextLine());  // Read user's choice

                    if (luaChon == 2) {
                        break;  // Exit the loop if the user doesn't want to add more products
                    }
                }
                break;


            case 5:
                System.out.println("Nhập chỉ số sản phẩm cần xóa (0 - " + (sanphamtheodon.length - 1) + "): ");
                int chiSoXoa = Integer.parseInt(sc.nextLine());
                if (chiSoXoa >= 0 && chiSoXoa < sanphamtheodon.length && sanphamtheodon[chiSoXoa] != null) {
                    for (int i = chiSoXoa; i < sanphamtheodon.length - 1; i++) {
                        sanphamtheodon[i] = sanphamtheodon[i + 1];
                        soLuongSP[i] = soLuongSP[i + 1];
                    }
                    sanphamtheodon=Arrays.copyOf(sanphamtheodon,sanphamtheodon.length-1);
                    soLuongSP=Arrays.copyOf(soLuongSP,soLuongSP.length-1);
                    
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
        String result =   maHD + ";";
        result +=  thoiGian + ";";
        result +=  (getKhachhangtheodon().getTenKH() != null  ? getKhachhangtheodon().getTenKH() :khachhangtheodon.getTenKH() ) + ";" +khachhangtheodon.getSDT() + ";";
        result +=  phuongThucThanhToan +";";
        if (sanphamtheodon != null && soLuongSP != null && sanphamtheodon.length == soLuongSP.length) {
            for (int i = 0; i < sanphamtheodon.length; i++) {
                if (getSanphamtheodon()[i] != null && soLuongSP[i] > 0) {
                    result += getSanphamtheodon()[i].getTenSP() +"-" + soLuongSP[i] + "-" +sanphamtheodon[i].getGiaTien()+ ",";
                }
            }
        } else {
            result += "Sản phẩm không có trong danh sách.;";
        }


        return result;
    }

    // Xuat method
    @Override
    public void Xuat() {
        String ChiTiet = String.format(" %-20s | %-15s | %-10s | %-10s |", "Ten san pham", "Gia tien", "SL", "Tong" );
        System.out.println("\nThong tin hoa don : ");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("\t \t \t \t \t \t Ma hoa don : "+this.getMaHD());
        System.out.println("Thoi gian : " + this.getThoiGian());
        System.out.println("Khach hang : " + getKhachhangtheodon().getTenKH() + "\t SDT : " + getKhachhangtheodon().getSDT());
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("\t \t \t \t \t \t CHI TIET");

        for ( int i = 0 ; i < getSanphamtheodon().length ; i++ ){
            ChiTiet += "\n" + String.format(" %-20s | %-15s | %-10s | %-10s |", getSanphamtheodon()[i].getTenSP(),
                    getSanphamtheodon()[i].getGiaTien(), getSoLuongSP()[i], getSanphamtheodon()[i].getGiaTien()*getSoLuongSP()[i] );
        }
        System.out.println(ChiTiet);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Phuong thuc thanh toan : " + this.getPhuongThucThanhToan());
        System.out.println("Tong cong : " + this.TongTien());
    }

}
