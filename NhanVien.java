package Project_OOP;

import java.util.Scanner;
import java.util.regex.Pattern;

public class KhachHang implements IThaoTac {

    static Scanner sc = new Scanner(System.in);

    private String maKH;
    private String tenKH;
    private String SDT;
    private String diaChi;
    private String gioiTinh;

    private boolean status;

    public void menuSuaKhachHang() {
        System.out.println("1 - Mã khách hàng.");
        System.out.println("2 - Tên khách hàng.");
        System.out.println("3 - Số điện thoại của khách hàng.");
        System.out.println("4 - Địa chỉ của khách hàng");
        System.out.println("5 - Giới tính của khách hàng.");
        System.out.println("6 - Thoát sửa thông tin khách hàng.");
    }

    public KhachHang() {
        this.status = true;
    }

    public KhachHang(String maKH, String tenKH, String SDT, String diaChi, String gioiTinh) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.status = true;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        while (maKH == null || maKH.trim().isEmpty()) {
            System.out.println("Mã khách hàng không được để trống. Vui lòng nhập mã khách hàng: ");
            maKH = sc.nextLine().trim();
        }
        String regex = "^KH\\d+$";
        while (!Pattern.matches(regex, maKH)) {
            System.out.println("Mã khách hàng phải bắt đầu bằng KH và sau đó là các chữ số, vui lòng nhập lại mã khách hàng.");
            maKH = sc.nextLine().trim();
        }
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        while (tenKH == null || tenKH.trim().isEmpty()) {
            System.out.println("Tên khách hàng không được để trống. Vui lòng nhập tên khách hàng: ");
            tenKH = sc.nextLine().trim();
        }
        String regex = "^[a-zA-ZÀ-ỹ\\s]+$";
        while (!Pattern.matches(regex, tenKH)) {
            System.out.println("Tên khách hàng không hợp lệ. Vui lòng nhập lại: ");
            tenKH = sc.nextLine().trim();
        }
        this.tenKH = tenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        while (SDT == null || SDT.trim().isEmpty()) {
            System.out.println("Số điện thoại không được để trống. Vui lòng nhập số điện thoại: ");
            SDT = sc.nextLine().trim();
        }
        String regex = "^[0-9]{10,11}$";
        while (!Pattern.matches(regex, SDT)) {
            System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại: ");
            SDT = sc.nextLine().trim();
        }
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        if (diaChi == null || diaChi.trim().isEmpty()) {
            this.diaChi = "Không xác định";
            return;
        }
        diaChi = diaChi.trim();
        String regex = "^[a-zA-Z0-9À-ỹ\\s,./-]+$";
        while (!Pattern.matches(regex, diaChi)) {
            System.out.println("Địa chỉ không hợp lệ. Vui lòng nhập lại địa chỉ: ");
            diaChi = sc.nextLine().trim();
        }
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        while (true) {
            gioiTinh = gioiTinh.trim();
            if (gioiTinh == null || gioiTinh.isEmpty()) {
                this.gioiTinh = "Nam";
            }
            if (gioiTinh.equalsIgnoreCase("Nam") || gioiTinh.equalsIgnoreCase("Nữ") || gioiTinh.equalsIgnoreCase("Khác")) {
                this.gioiTinh = gioiTinh;
                break;
            } else {
                System.out.println("Giới tính không hợp lệ. Vui lòng nhập Nam, Nữ hoặc Khác: ");
                gioiTinh = sc.nextLine().trim();
            }
        }
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void Nhap() {
        System.out.println("Nhập mã khách hàng: ");
        setMaKH(sc.nextLine());
        System.out.println("Nhập tên khách hàng: ");
        setTenKH(sc.nextLine());
        System.out.println("Nhập số điện thoại khách hàng: ");
        setSDT(sc.nextLine());
        System.out.println("Nhập địa chỉ khách hàng: ");
        setDiaChi(sc.nextLine());
        System.out.println("Nhập giới tính khách hàng: ");
        setGioiTinh(sc.nextLine());
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s", getMaKH(), getTenKH(), getSDT(), getDiaChi(), getGioiTinh());
    }

    public void Xuat() {
        System.out.println("Mã khách hàng: " + getMaKH());
        System.out.println("Tên khách hàng: " + getTenKH());
        System.out.println("Số điện thoại khách hàng: " + getSDT());
        System.out.println("Địa chỉ khách hàng: " + getDiaChi());
        System.out.println("Giới tính khách hàng: " + getGioiTinh());
//        System.out.println("\\n-------------------\"");
    }

    public void Sua() {
        while (true) {
            menuSuaKhachHang();
            System.out.println("Nhập lựa chọn sửa thông tin khách hàng: ");
            int luaChon = Integer.parseInt(sc.nextLine());
            while (luaChon < 1 || luaChon > 6) {
                menuSuaKhachHang();
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại lựa chọn từ 1-6: ");
                luaChon = Integer.parseInt(sc.nextLine());
            }
            switch (luaChon) {
                case 1:
                    System.out.println("Nhập mã khách hàng mới: ");
                    setMaKH(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập tên khách hàng mới: ");
                    setTenKH(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Nhập số điện thoại mới: ");
                    setSDT(sc.nextLine());
                    break;
                case 4:
                    System.out.println("Nhập địa chỉ mới: ");
                    setDiaChi(sc.nextLine());
                    break;
                case 5:
                    System.out.println("Nhập giới tính mới: ");
                    setGioiTinh(sc.nextLine());
                    break;
                case 6:
                    System.out.println("Thoát sửa thông tin khách hàng");
                    return;
            }
        }
    }

}
