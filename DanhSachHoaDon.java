package Project_OOP;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachHoaDon {

    private static int soLuongHoaDon;
    private HoaDon[] DSHD;         // Đổi từ danhSachHoaDon thành DSHD
    private HoaDon[] DSHD_File;    // Đổi từ danhSachHoaDon_File thành DSHD_File

    static Scanner sc = new Scanner(System.in);



    // public DanhSachHoaDon(DanhSachSanPham dssp, DanhSachKhachHang dskh) {
    //     this.dssp = dssp;
    //     this.dskh = dskh;
    //     this.DSHD = new HoaDon[5]; // Ít nhất 5 hóa đơn
    //     this.Nhap();
    // }
    public DanhSachHoaDon() {

        this.DSHD = new HoaDon[5]; // Ít nhất 5 hóa đơn
        this.Nhap();
    }

    public HoaDon[] getDSHD() {
        return DSHD;
    }

    public void setDSHD(HoaDon[] DSHD) {
        this.DSHD = DSHD;

    }

    // Nhập danh sách hóa đơn từ file
    public void Nhap() {
        System.out.println("\n \t \t---------TẠO DANH SÁCH HÓA ĐƠN TỪ FILE HoaDon.txt---------");

        String line;
        String[] strings = new String[6];
        try {
            FileReader fr = new FileReader("HoaDon.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                if (soLuongHoaDon == DSHD.length) {
                    DSHD = Arrays.copyOf(DSHD, DSHD.length + 5);
                }

                strings = line.split(";");
                try {
                    // Code để tạo HoaDon từ dữ liệu file
                    // Bạn cần điều chỉnh phần này dựa trên cách bạn implement HoaDon
                    HoaDon hd = new HoaDon();
                    DSHD[soLuongHoaDon] = hd;
                    soLuongHoaDon++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Lỗi đọc file HoaDon.txt: ");
            e.printStackTrace();
        }

        // Thu hẹp mảng nếu mảng chưa đầy
        if (soLuongHoaDon < DSHD.length) {
            DSHD = Arrays.copyOf(DSHD, soLuongHoaDon);
        }

        // Copy mảng hiện tại vào mảng lấy dữ liệu từ File
        DSHD_File = Arrays.copyOf(DSHD, DSHD.length);
    }

    // Thêm hóa đơn mới
    public void Them() {
        System.out.println("\n \t \t---------THÊM HÓA ĐƠN---------");

        if (DSHD == null) {
            System.out.println("Danh sách hóa đơn chưa được khởi tạo. Vui lòng khởi tạo danh sách hóa đơn trước.!!! ");
            return;
        }

        int slHD;
        do {
            System.out.println("Nhập số lượng hóa đơn muốn thêm: ");
            slHD = Integer.parseInt(sc.nextLine());
            if (slHD <= 0) {
                System.out.println("Không hợp lệ, vui lòng nhập số lượng > 0: ");
            }
        } while (slHD <= 0);

        soLuongHoaDon += slHD;
        DSHD = Arrays.copyOf(DSHD, DSHD.length + slHD);

        int slHDBanDau = DSHD.length - slHD;
        for (int i = slHDBanDau; i < DSHD.length; i++) {
            HoaDon hd = new HoaDon();
            hd.Nhap(); // Giả sử HoaDon có phương thức Nhap()
            DSHD[i] = hd;
        }
    }
    // Xuất danh sách hóa đơn
   public void Xuat() {
       System.out.println("\n \t \t---------XUẤT DANH SÁCH HÓA ĐƠN---------");

       if (DSHD == null) {
           System.out.println("Danh sách hóa đơn chưa được khởi tạo.");
           return;
       }

       if (DSHD.length == 0) {
           System.out.println("Danh sách hóa đơn hiện tại đang trống.");
           return;
       }

       int count = 0;
       System.out.println("\t   Thông tin của danh sách hóa đơn \n--------------------------");
       for (int i = 0; i < DSHD.length; i++) {
           if (DSHD[i].getStatus() == true) { // Only display if the status is true
               count++;
               DSHD[i].Xuat(); // Giả sử HoaDon có phương thức Xuat()
               System.out.println("\t--------------");
           }
       }

       if (count == 0) {
           System.out.println("Không có hóa đơn nào với trạng thái 'true'.");
       }
   }

    // Sửa hóa đơn
    public void Sua() {
        System.out.println("\n \t \t---------SỬA HÓA ĐƠN---------");

        if (DSHD == null || DSHD.length == 0) {
            System.out.println("Danh sách hóa đơn trống hoặc chưa được khởi tạo.");
            return;
        }

        System.out.println("Nhập mã hóa đơn cần sửa: ");
        String maHD_Sua = sc.nextLine().trim();

        boolean timThay = false;
        for (int i = 0; i < DSHD.length; i++) {
            if (DSHD[i].getMaHD().equals(maHD_Sua)) {
                DSHD[i].Sua(); // Giả sử HoaDon có phương thức Sua()
                timThay = true;
                System.out.println("Sửa hóa đơn thành công!");
                break;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy hóa đơn có mã: " + maHD_Sua);
        }
    }

    // Xóa hóa đơn
   public void Xoa() {
       System.out.println("\n \t \t---------XÓA HÓA ĐƠN---------");

       if (DSHD == null || DSHD.length == 0) {
           System.out.println("Danh sách hóa đơn trống hoặc chưa được khởi tạo.");
           return;
       }

       System.out.println("Nhập mã hóa đơn cần xóa: ");
       String maHD_Xoa = sc.nextLine();

       boolean timThay = false;
       for (int i = 0; i < DSHD.length; i++) {
           if (DSHD[i].getMaHD().equals(maHD_Xoa)) {
               // Update the status of the HoaDon object instead of removing it
               DSHD[i].setStatus(false);  // This assumes HoaDon has a setStatus method
               timThay = true;
               System.out.println("Hóa đơn đã được đánh dấu là xóa thành công!");
               break;
           }
       }

       if (!timThay) {
           System.out.println("Không tìm thấy hóa đơn có mã: " + maHD_Xoa);
       }
   }

    // Tìm kiếm hóa đơn
    public void TimKiem() {
        System.out.println("\n \t \t---------TÌM KIẾM HÓA ĐƠN---------");

        if (DSHD == null || DSHD.length == 0) {
            System.out.println("Danh sách hóa đơn trống hoặc chưa được khởi tạo.");
            return;
        }

        System.out.println("Chọn cách tìm kiếm:");
        System.out.println("1. Tìm theo mã hóa đơn");
        System.out.println("2. Tìm theo khách hàng");
        System.out.println("3. Tìm theo ngày");

        int luaChon = Integer.parseInt(sc.nextLine());

        switch (luaChon) {
            case 1:
                timTheoMaHoaDon();
                break;
            case 2:
                timTheoKhachHang();
                break;
            case 3:
                timTheoNgay();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private void timTheoMaHoaDon() {
        System.out.println("Nhập mã hóa đơn cần tìm: ");
        String maHD = sc.nextLine();

        boolean timThay = false;
        for (HoaDon hd : DSHD) {
            if (hd.getMaHD().equals(maHD)) {
                hd.Xuat();
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy hóa đơn.");
        }
    }

    private void timTheoKhachHang() {
        System.out.println("Nhập SDT khách hàng cần tìm: ");
        String sdt = sc.nextLine();

        boolean timThay = false;
        for (HoaDon hd : DSHD) {
            if (hd.getKhachHang().getSDT().equalsIgnoreCase(sdt)) {
                hd.Xuat();
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy hóa đơn với số điện thoại khách hàng: " + sdt);
        }
    }

    private void timTheoNgay() {
        System.out.println("Nhập thời gian cần tìm: ");
        String tg = sc.nextLine();

        boolean timThay = false;
        for (HoaDon hd : DSHD) {
            if (hd.getThoiGian().equalsIgnoreCase(tg)) {
                hd.Xuat();
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy hóa đơn được tạo vào " + tg);
        }
    }

    // Thống kê hóa đơn
   public void ThongKe(int choice) {
       System.out.println("\n \t \t---------THỐNG KÊ HÓA ĐƠN---------");

       if (choice == 1) { // Thống kê từ danh sách hiện tại
           if (DSHD == null || DSHD.length == 0) {
               System.out.println("Danh sách hóa đơn trống hoặc chưa được khởi tạo.");
               return;
           }

           double tongDoanhThu = 0;
           HoaDon hoaDonCaoNhat = DSHD[0];
           HoaDon hoaDonThapNhat = DSHD[0];

           for (HoaDon hd : DSHD) {
               if (hd.getStatus()) {  // Kiểm tra chỉ thống kê hóa đơn có trạng thái 'true'
                   double tongTien = hd.TongTien();
                   tongDoanhThu += tongTien;

                   if (tongTien > hoaDonCaoNhat.TongTien()) {
                       hoaDonCaoNhat = hd;
                   }

                   if (tongTien < hoaDonThapNhat.TongTien()) {
                       hoaDonThapNhat = hd;
                   }
               }
           }

           System.out.println("Tổng doanh thu: " + tongDoanhThu);
           System.out.println("Hóa đơn có tổng tiền cao nhất:");
           hoaDonCaoNhat.Xuat();
           System.out.println("Hóa đơn có tổng tiền thấp nhất:");
           hoaDonThapNhat.Xuat();
       } else { // Thống kê từ danh sách đã lưu trong file
           if (DSHD_File.length == 0) {  // Kiểm tra nếu file trống
               System.out.println("File đang trống, vui lòng ghi dữ liệu vào file");
               return;
           }

           double tongDoanhThu = 0;
           HoaDon hoaDonCaoNhat = DSHD_File[0];
           HoaDon hoaDonThapNhat = DSHD_File[0];

           for (int i = 0; i < DSHD_File.length; i++) {
               if (DSHD_File[i].getStatus()) {  // Kiểm tra chỉ thống kê hóa đơn có trạng thái 'true'
                   double tongTien = DSHD_File[i].TongTien();
                   tongDoanhThu += tongTien;

                   if (tongTien > hoaDonCaoNhat.TongTien()) {
                       hoaDonCaoNhat = DSHD_File[i];
                   }

                   if (tongTien < hoaDonThapNhat.TongTien()) {
                       hoaDonThapNhat = DSHD_File[i];
                   }
               }
           }

           System.out.println("\n---------Thống kê từ File---------");
           System.out.println("Tổng doanh thu: " + tongDoanhThu);
           System.out.println("Hóa đơn có tổng tiền cao nhất:");
           hoaDonCaoNhat.Xuat();
           System.out.println("Hóa đơn có tổng tiền thấp nhất:");
           hoaDonThapNhat.Xuat();
       }
   }

    // Đọc file hóa đơn
    // Đọc và xuất nội dung của file HoaDon.txt
    public void docFile() {
        System.out.println("\n \t \t---------ĐỌC FILE HoaDon.txt VÀ XUẤT RA MÀN HÌNH---------");

        String line;
        String[] strings = new String[6];

        try {
            FileReader fr = new FileReader("HoaDon.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                strings = line.split(";");

                // In từng dòng dữ liệu ra màn hình
                System.out.println("Dòng dữ liệu: " + line);

                // In chi tiết thông tin của hóa đơn từ mảng strings
                System.out.println("Mã Hóa Đơn: " + strings[0] + " - Tên Khách Hàng: " + strings[1] + " - Tổng Tiền: " + strings[4]);
                // Bạn có thể điều chỉnh chỉ mục nếu cấu trúc file có sự thay đổi.
                // Ở đây tôi đang giả sử tổng tiền là phần tử ở chỉ mục 4.
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Lỗi đọc file HoaDon.txt: ");
            e.printStackTrace();
        }
    }
       public void ghiFile() {
       System.out.println("\n---------Ghi file---------");
       if (DSHD == null || DSHD.length == 0) {
           System.out.println("Vui lòng tạo danh sách hóa đơn trước !!");
           return;
       }

       try (BufferedWriter bw = new BufferedWriter(new FileWriter("HoaDon.txt"))) {
           for (HoaDon hd : DSHD) {
               if (hd.getStatus()) {  // Only write active HoaDon objects
                   bw.write(hd.toString()); // Write the string representation of HoaDon
                   bw.newLine();
               }
           }
           System.out.println("Ghi dữ liệu vào file thành công!");
           DSHD_File = Arrays.copyOf(DSHD, DSHD.length);  // Copy data to backup file array
       } catch (IOException e) {
           System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
       }
   }

}
