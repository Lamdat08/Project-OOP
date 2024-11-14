//package Project_OOP;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class DanhSachHoaDon implements IThaoTac_2 {
//    static Scanner sc = new Scanner(System.in);
//
//    private HoaDon[] DSHD;  // Mảng chứa danh sách hóa đơn
//    private int soLuongHD;   // Biến lưu số lượng hóa đơn hiện tại trong mảng
//
//    // Constructor
//    public DanhSachHoaDon() {
//        this.DSHD = new HoaDon[10]; // Mảng khởi tạo ban đầu có thể chứa tối đa 10 hóa đơn
//        this.soLuongHD = 0;         // Ban đầu chưa có hóa đơn nào
//    }
//
//    @Override
//    public void Xoa() {
//        System.out.println("Nhập mã hóa đơn cần xóa: ");
//        String maHD = sc.nextLine();
//        boolean found = false;
//
//        // Tìm kiếm và xóa hóa đơn có mã tương ứng
//        for (int i = 0; i < soLuongHD; i++) {
//            if (DSHD[i].getMaHD().equals(maHD)) {
//                for (int j = i; j < soLuongHD - 1; j++) {
//                    DSHD[j] = DSHD[j + 1];  // Dịch chuyển phần tử sau lên
//                }
//                DSHD[soLuongHD - 1] = null;  // Xóa phần tử cuối cùng
//                soLuongHD--;  // Giảm số lượng hóa đơn
//                found = true;
//                System.out.println("Hóa đơn đã được xóa.");
//                break;
//            }
//        }
//
//        if (!found) {
//            System.out.println("Không tìm thấy hóa đơn có mã " + maHD);
//        }
//    }
//    @Override
//    public void Sua() {
//    System.out.println("Nhập mã hóa đơn cần sửa: ");
//    String maHD = sc.nextLine();
//    boolean found = false;
//
//    // Tìm kiếm hóa đơn theo mã
//    for (int i = 0; i < soLuongHD; i++) {
//        if (DSHD[i].getMaHD().equals(maHD)) {
//            // Hóa đơn tìm thấy, cho phép sửa thông tin của hóa đơn này
//            System.out.println("Hóa đơn tìm thấy: ");
//            DSHD[i].Xuat();  // Xuất thông tin hóa đơn
//
//            // Nhập lại thông tin cho hóa đơn
//            System.out.println("Nhập lại thông tin cho hóa đơn này: ");
//            DSHD[i].Nhap();  // Gọi phương thức Nhap() để người dùng nhập lại thông tin
//
//            found = true;
//            System.out.println("Hóa đơn đã được sửa.");
//            break;
//        }
//    }
//
//    if (!found) {
//        System.out.println("Không tìm thấy hóa đơn có mã " + maHD);
//    }
//}
//    @Override
//    public void Them() {
//        if (soLuongHD >= DSHD.length) {
//            // Nếu mảng đầy, tăng kích thước mảng
//            DSHD = Arrays.copyOf(DSHD, DSHD.length + 1);
//        }
//
//        HoaDon hoaDon = new HoaDon();  // Tạo một đối tượng HoaDon mới
//        hoaDon.Nhap();  // Nhập thông tin cho hóa đơn
//        DSHD[soLuongHD] = hoaDon;  // Thêm vào danh sách
//        soLuongHD++;  // Tăng số lượng hóa đơn
//        System.out.println("Hóa đơn đã được thêm.");
//    }
//
//    @Override
//    public void TimKiem() {
//        System.out.println("Nhập mã hóa đơn cần tìm: ");
//        String maHD = sc.nextLine();
//        boolean found = false;
//
//        // Tìm kiếm hóa đơn theo mã
//        for (int i = 0; i < soLuongHD; i++) {
//            if (DSHD[i].getMaHD().equals(maHD)) {
//                System.out.println("Hóa đơn tìm thấy: ");
//                DSHD[i].Xuat();  // Xuất thông tin hóa đơn
//                found = true;
//                break;
//            }
//        }
//
//        if (!found) {
//            System.out.println("Không tìm thấy hóa đơn có mã " + maHD);
//        }
//    }
//
//    @Override
//    public void docFile() {
//        // Implement logic to read HoaDon objects from file
//        System.out.println("Đọc danh sách hóa đơn từ file...");
//    }
//
//    @Override
//    public void ghiFile() {
//        // Implement logic to save HoaDon objects to file
//        System.out.println("Ghi danh sách hóa đơn vào file...");
//    }
//
//    @Override
//    public void Nhap() {
//        // Mỗi đối tượng DanhSachHoaDon có thể gọi phương thức Nhap của các HoaDon
//        System.out.println("Nhập số lượng hóa đơn: ");
//        soLuongHD = Integer.parseInt(sc.nextLine());
//        DSHD = new HoaDon[soLuongHD];
//        for (int i = 0; i < soLuongHD; i++) {
//            System.out.println("Nhập hóa đơn thứ " + (i + 1));
//            HoaDon hoaDon = new HoaDon();
//            hoaDon.Nhap();
//            DSHD[i] = hoaDon;  // Thêm vào mảng DSHD
//        }
//    }
//
//    @Override
//    public void Xuat() {
//        // Xuất toàn bộ danh sách hóa đơn
//        System.out.println("Danh sách hóa đơn:");
//        for (int i = 0; i < soLuongHD; i++) {
//            DSHD[i].Xuat();  // Xuất thông tin từng hóa đơn
//        }
//    }
//}
