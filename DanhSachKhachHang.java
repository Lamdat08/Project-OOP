package Project_OOP;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DanhSachKhachHang implements IThaoTac_2 {

    static Scanner sc = new Scanner(System.in);

    private static int soLuongKhachHang;
    private KhachHang[] DSKH;
    private KhachHang[] DSKH_File;

    public DanhSachKhachHang() {
        this.DSKH = new KhachHang[5]; //ít nhất 5 khách hàng
        this.Nhap();
    }

    public int getSoLuongKhachHang() {
        return soLuongKhachHang;
    }

    public void setSoLuongKhachHang(int soLuongKhachHang) {
        this.soLuongKhachHang = soLuongKhachHang;
    }

    public KhachHang[] getDSKH() {
        return DSKH;
    }

    public void setDSKH(KhachHang[] DSKH) {
        this.DSKH = DSKH;
    }

    public KhachHang[] getDSKH_File() {
        return DSKH_File;
    }

    public void setDSKH_File(KhachHang[] DSKH_File) {
        this.DSKH_File = DSKH_File;
    }


    public void menuTimKiem() {
        System.out.println("1 - Tìm kiếm theo mã khách hàng.");
        System.out.println("2 - Tìm kiếm theo tên khách hàng.");
        System.out.println("3 - Tìm kiếm theo số điện thoại.");
        System.out.println("4 - Tìm kiếm theo địa chỉ.");
        System.out.println("5 - Tìm kiếm theo giới tính.");
        System.out.println("6 - Thoát tìm kiếm khách hàng.");
    }

    //Lấy dữ liệu từ file KhachHang.txt
    public void Nhap() {
        System.out.println("\n \t \t--------TẠO DANH SÁCH KHÁCH HÀNG TỪ FILE KhachHang.txt--------");

        String line;
        String[] strings = new String[6];
        try {
            FileReader fr = new FileReader("KhachHang.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (soLuongKhachHang == DSKH.length) {
                    DSKH = Arrays.copyOf(DSKH, DSKH.length + 5);
                }

                strings = line.split(";");
                try {
                    KhachHang kh = new ThanhVien(strings[0],strings[1],strings[2],strings[3],strings[4],Integer.parseInt(strings[5]));
                    DSKH[soLuongKhachHang] = kh;
                    soLuongKhachHang++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            System.out.println("Lỗi đọc file KhachHang.txt: ");
            e.printStackTrace();
        }
        //Thu hẹp mảng nếu mảng chưa đầy
        if (soLuongKhachHang < DSKH.length) {
            DSKH = Arrays.copyOf(DSKH, soLuongKhachHang);
        }
        //Copy mảng hiện tại đang chỉnh sửa vào mảng lấy dữ liệu từ file
        DSKH_File = Arrays.copyOf(DSKH, DSKH.length);
    }

    public void Them() {
        System.out.println("\n \t \t---------THÊM KHÁCH HÀNG--------");
//
//        if (DSKH == null) {
//            System.out.println("Danh sách khách hàng chưa được khởi tạo. Vui lòng khởi tạo danh sách khách hàng trước");
//            return;
//        }
//        if (DSKH.length == 0) {
//            System.out.println("Danh sách khách hàng hiện tại đang trống. Vui lòng thêm khách hàng. \n");
//            return;
//        }

        int slKH;
        do {
            System.out.println("Nhập số lượng khách hàng muốn thêm: ");
            slKH = Integer.parseInt(sc.nextLine());
            if (slKH <= 0) {
                System.out.println("Không hợp lệ, vui lòng nhập số lượng > 0");
            }
        } while (slKH <= 0);

        soLuongKhachHang += slKH;
        DSKH = Arrays.copyOf(DSKH, DSKH.length + slKH);
        KhachHang kh;

        int slKHBanDau = DSKH.length - slKH;
        for (int i = slKHBanDau; i < DSKH.length; i++) {
            kh = new ThanhVien();
            kh.Nhap();
            DSKH[i] = kh;
        }
    }

    public void Xoa() {
        System.out.println("\n-------XÓA KHÁCH HÀNG--------");

        if (DSKH == null) {
            System.out.println("Danh sách khách hàng chưa được khởi tạo. Vui lòng khởi tạo danh sách khách hàng trước !");
            return;
        }
        if (DSKH.length == 0) {
            System.out.println("Danh sách khách hàng hiện tại đang trống. Vui lòng thêm khách hàng. \n");
            return;
        }

        System.out.println("Nhập mã khách hàng muốn xóa: ");
        String maKH_Xoa = sc.nextLine();
        boolean kq = false;
        for (int i = 0; i < DSKH.length - 1; i++) {
            if (DSKH[i].getMaKH().equalsIgnoreCase(maKH_Xoa)) {
                kq = true;
                DSKH[i].setStatus(false);
                System.out.println("Xóa khách hàng thành công !\n----------------");
                soLuongKhachHang--;
                break;
            }
        }
        if (!kq) {
            System.out.println("Không tìm thấy mã khách hàng" + maKH_Xoa + " muốn xóa");
        }
    }

    public void TimKiem() {
        System.out.println("\n---------TÌM KIẾM KHÁCH HÀNG--------");

        if (DSKH == null) {
            System.out.println("Danh sách khách hàng chưa được khởi tạo. Vui lòng tạo danh sách khách hàng trước ! !");
            return;
        }
        if (DSKH.length == 0) {
            System.out.println("Danh sách khách hàng hiện tại đang trống. Vui lòng thêm khách hàng. \n");
            return;
        }

        while (true) {
            boolean kq;
            menuTimKiem();
            int luachon = Integer.parseInt(sc.nextLine());
            while (luachon < 1 || luachon > 6) {
                System.out.println("Không có lựa chọn này, mời nhập lại lựa chọn từ 1-6");
                luachon = Integer.parseInt(sc.nextLine());
            }

            switch (luachon) {
                case 1:
                    System.out.println("Nhập mã khách hàng cần tìm: ");
                    String maKH_TimKiem = sc.nextLine().trim();
                    while (maKH_TimKiem.trim().isEmpty()) {
                        System.out.println("Mã khách hàng không được để trống, vui lòng nhập lại: ");
                        maKH_TimKiem = sc.nextLine().trim();
                    }
                    String regexMaKH = "^KH|kH|Kh|kh\\d+$";
                    while (!Pattern.matches(regexMaKH, maKH_TimKiem)) {
                        System.out.println("Mã khách hàng phải bắt đầu là KH và sau đó là các chữ số, vui lòng nhập lại: ");
                        maKH_TimKiem = sc.nextLine().trim();
                    }
                    kq = false;
                    for (int i = 0; i < DSKH.length; i++) {
                        if (DSKH[i].getStatus()) {
                            if (maKH_TimKiem.equalsIgnoreCase(DSKH[i].getMaKH())) {
                                DSKH[i].Xuat();
                                kq = true;
                                System.out.println("\n \t--------------------");
                            }
                        }
                    }
                    if (!kq) {
                        System.out.println("Không tìm thấy mã khách hàng " + maKH_TimKiem + " trong danh sách khách hàng !");
                    }
                    break;
                case 2:
                    System.out.println("Nhập tên khách hàng cần tìm: ");
                    String tenKhachHang_TimKiem = sc.nextLine().trim();
                    while (tenKhachHang_TimKiem.isEmpty()) {
                        System.out.println("Tên khách hàng không được để trống, vui lòng nhập lại: ");
                        tenKhachHang_TimKiem = sc.nextLine().trim();
                    }
                    String regexTen = "^[A-Za-zÀ-ỹ\\s]+$";
                    while (!Pattern.matches(regexTen, tenKhachHang_TimKiem)) {
                        System.out.println("Tên khách hàng không hợp lệ, vui lòng nhập lại: ");
                        tenKhachHang_TimKiem = sc.nextLine().trim();
                    }
                    kq = false;
                    for (int i = 0; i < DSKH.length; i++) {
                        if (DSKH[i].getTenKH().equalsIgnoreCase(tenKhachHang_TimKiem)) {
                            DSKH[i].Xuat();
                            kq = true;
                            System.out.println("\n \t--------------------");
                        }
                    }
                    if (!kq) {
                        System.out.println("Không tìm thấy khách hàng có tên: " + tenKhachHang_TimKiem + " trong danh sách");
                    }
                    break;
                case 3:
                    System.out.println("Nhập số điện thoại của khách hàng cần tìm: ");
                    String soDienThoaiKhachHang_TimKiem = sc.nextLine().trim();
                    while (soDienThoaiKhachHang_TimKiem.trim().isEmpty()) {
                        System.out.println("Số điện thoại không được để trống, vui lòng nhập lại: ");
                        soDienThoaiKhachHang_TimKiem = sc.nextLine().trim();
                    }
                    String regexSDT = "^[0-9]{10,11}$";
                    while (!Pattern.matches(regexSDT, soDienThoaiKhachHang_TimKiem)) {
                        System.out.println("Số điện thoại không hợp lệ, hãy nhập số điện thoại chỉ có 10 hoặc 11 chữ số");
                        soDienThoaiKhachHang_TimKiem = sc.nextLine().trim();
                    }
                    kq = false;
                    for (int i = 0; i < DSKH.length; i++) {
                        if (DSKH[i].getSDT().equals(soDienThoaiKhachHang_TimKiem)) {
                            DSKH[i].Xuat();
                            kq = true;
                            System.out.println("\n \t--------------------");
                        }
                    }
                    if (!kq) {
                        System.out.println("Không tìm thấy khách hàng có số điện thoại: " + soDienThoaiKhachHang_TimKiem);
                    }
                    break;
                case 4:
                    System.out.println("Nhập địa chỉ khách hàng cần tìm: ");
                    String diaChiKhachHang_TimKiem = sc.nextLine().trim();
                    while (diaChiKhachHang_TimKiem.trim().isEmpty()) {
                        System.out.println("Địa chỉ không được để trống, vui lòng nhập địa chỉ khách hàng: ");
                        diaChiKhachHang_TimKiem = sc.nextLine().trim();
                    }
                    String regaxDiaChi = "^[a-zA-Z0-9À-ỹ\\s,./-]+$";
                    while (!Pattern.matches(regaxDiaChi, diaChiKhachHang_TimKiem)) {
                        System.out.println("Địa chỉ bạn nhập vào không hợp lệ, chỉ được phép chứa các kí tự chữ cái và các kí tự , . / - \n");
                        System.out.println("Vui lòng nhập lại địa chỉ: ");
                        diaChiKhachHang_TimKiem = sc.nextLine().trim();
                    }
                    kq = false;
                    for (int i = 0; i < DSKH.length; i++) {
                        if (DSKH[i].getDiaChi().equalsIgnoreCase(diaChiKhachHang_TimKiem)) {
                            DSKH[i].Xuat();
                            kq = true;
                            System.out.println("\n \t--------------------");
                        }
                    }
                    if (!kq) {
                        System.out.println("Không tìm thấy khách hàng có địa chỉ: " + diaChiKhachHang_TimKiem);
                    }
                    break;
                case 5:
                    System.out.println("Nhập giới tính khách hàng cần tìm: ");
                    String gioiTinhKhachHang_TimKiem = sc.nextLine().trim();
                    while (gioiTinhKhachHang_TimKiem.isEmpty()) {
                        System.out.println("Giới tính khách hàng không được để trống, vui lòng nhập giới tính: ");
                        gioiTinhKhachHang_TimKiem = sc.nextLine().trim();
                    }

                    while (!gioiTinhKhachHang_TimKiem.equalsIgnoreCase("Nam") && !gioiTinhKhachHang_TimKiem.equalsIgnoreCase("Nữ") && !gioiTinhKhachHang_TimKiem.equalsIgnoreCase("Khác")) {
                        System.out.println("Giới tính không hợp lệ, chỉ được phép nhập vào Nam Nữ hoặc Khác");
                        gioiTinhKhachHang_TimKiem = sc.nextLine().trim();
                    }
                    kq = false;
                    for (int i = 0; i < DSKH.length; i++) {
                        if (DSKH[i].getGioiTinh().equalsIgnoreCase(gioiTinhKhachHang_TimKiem)) {
                            DSKH[i].Xuat();
                            kq = true;
                            System.out.println("\n \t--------------------");
                        }
                    }
                    if (!kq) {
                        System.out.println("Không tìm thấy khách hàng nào có giới tính: " + gioiTinhKhachHang_TimKiem);
                    }
                    break;
                case 6:
                    System.out.println("Thoát tìm kiếm khách hàng.");
                    return;
                default:
                    System.out.println("Không có lựa chọn tìm kiếm này !");
                    break;
            }
        }
    }

    public void Xuat() {
        System.out.println("\n \t \t--------XUẤT DANH SÁCH KHÁCH HÀNG--------");

        if (DSKH == null) {
            System.out.println("Danh sách khách hàng chưa được khởi tạo. Vui lòng tạo danh sách khách hàng trước !");
            return;
        }
        if (DSKH.length == 0) {
            System.out.println("Danh sách khách hàng hiện tại đang trống. Vui lòng thêm khách hàng. \n");
            return;
        }

        System.out.println("\t   Thông tin của danh sách khách hàng \n--------------------------");
        for (int i = 0; i < DSKH.length; i++) {
            if (DSKH[i].getStatus()) {
                DSKH[i].Xuat();
                System.out.println("\t--------------");
            }
        }
    }

    public void Sua() {
        System.out.println("\n \t \t---------SỬA KHÁCH HÀNG--------");

        if (DSKH == null) {
            System.out.println("Danh sách khách hàng chưa được khởi tạo.");
            return;
        }
        if (DSKH.length == 0) {
            System.out.println("Danh sách hiện tại đang trống. Vui lòng thêm khách hàng. \n");
            return;
        }

        System.out.println("Nhập mã của khách hàng cần sửa: ");
        String maKH_Sua = sc.nextLine().trim();
        while (maKH_Sua.isEmpty()) {
            System.out.println("Mã khách hàng cần sửa không được để trống, vui lòng nhập mã khách hàng !");
            maKH_Sua = sc.nextLine().trim();
        }
        String regex = "^KH|kH|Kh|kh\\d+$";
        while (!Pattern.matches(regex, maKH_Sua)) {
            System.out.println("Mã khách phải phải bắt đầu bằng KH và sau đó là các số, vui lòng nhập lại !");
            maKH_Sua = sc.nextLine().trim();
        }
        boolean kq = false;

        for (int i = 0; i < DSKH.length; i++) {
            if (DSKH[i].getStatus()) {
                if (DSKH[i].getMaKH().equalsIgnoreCase(maKH_Sua)) {
                    DSKH[i].Sua();
                    DSKH[i].Xuat();
                    kq = true;
                    System.out.println("Sửa khách hàng " + maKH_Sua + " thành công !");
                }
            }
        }
        if (!kq) {
            System.out.println("Không tìm thấy mã " + maKH_Sua + " cần sửa trong danh sách khách hàng! \\n-----------------\"");
        }
    }

    public static void docFile() {
        System.out.println("\"\\n--------ĐỌC FILE KhachHang.txt--------\"");

        String line;
        String[] strings = new String[6];
        try {
            FileReader fr = new FileReader("KhachHang.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                strings = line.split(";");
                try {
                    KhachHang kh = new ThanhVien(strings[0],strings[1],strings[2],strings[3],strings[4],Integer.parseInt(strings[5]));
                    kh.Xuat();
                    System.out.println("------------------------------\n");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Lỗi đọc file KhachHang.txt\n");
            e.printStackTrace();
        }
    }

    public void ghiFile() {
        System.out.println("\n---------Ghi file---------");
        if (DSKH == null) {
            System.out.println("Vui lòng tạo danh sách trước !");
            return;
        }
        if (DSKH.length == 0) {
            System.out.println("Danh sách hiện tại đang trống. Vui lòng thêm khách hàng. \n");
            return;
        }
        try {
            FileWriter fw = new FileWriter("KhachHang.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = DSKH_File.length; i < DSKH.length; i++) {
                bw.write(DSKH[i].toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Ghi dữ liệu vào KhachHang.txt thành công.");
            DSKH_File = Arrays.copyOf(DSKH, DSKH.length);
        } catch (IOException ioException) {
            System.out.println("Lỗi ghi file KhachHang.txt: ");
            ioException.printStackTrace();
        }
    }

    public void thongKeKhachHang() {
        System.out.println("\n--------THỐNG KÊ DANH SÁCH KHÁCH HÀNG THEO RANK--------");

        if (DSKH == null) {
            System.out.println("Danh sách khách hàng chưa được khởi tạo. Vui lòng khởi tạo danh sách khách hàng !");
            return;
        }
        if (DSKH.length == 0) {
            System.out.println("Danh sách khách hàng hiện tại đang trống. Vui lòng thêm khách hàng !");
            return;
        }

        int bronzeCount = 0;
        int silverCount = 0;
        int goldCount = 0;

        for (KhachHang kh : DSKH) {
            if (kh instanceof ThanhVien) {
                ThanhVien tv = (ThanhVien) kh;
                switch (tv.rank()) {
                    case "Bronze":
                        bronzeCount++;
                        break;
                    case "Silver":
                        silverCount++;
                        break;
                    case "Gold":
                        goldCount++;
                        break;
                }
            }
        }

        System.out.println("Số lượng thành viên rank Bronze: " + bronzeCount);
        System.out.println("Số lượng thành viên rank Silver: " + silverCount);
        System.out.println("Số lượng thành viên rank Gold: " + goldCount);

        if (bronzeCount > silverCount + goldCount) {
            System.out.println("Lượng khách hàng chủ yếu là người mới.");
        } else {
            System.out.println("Lượng khách hàng chủ yếu là người cũ.");
        }
    }
}
