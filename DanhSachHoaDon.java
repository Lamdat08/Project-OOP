package Project_OOP;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DanhSachHoaDon {

    private static int soLuongHoaDon;
    private HoaDon[] DSHD;         // Mảng chứa các hóa đơn
    private HoaDon[] DSHD_File;    // Mảng lưu trữ hóa đơn lấy từ file
    static Scanner sc = new Scanner(System.in);
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    static KhachHang[] DSKH;
    static SanPham[] DSSP;

    public DanhSachHoaDon() {
        this.DSHD = new HoaDon[1]; // Khởi tạo mảng hóa đơn với dung lượng ban đầu là 5

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
        String[] strings = new String[5];
        try {
            FileReader fr = new FileReader("HoaDon.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                // Kiểm tra nếu mảng DSHD đã đầy thì tăng kích thước
                if (soLuongHoaDon == DSHD.length) {
                    DSHD = Arrays.copyOf(DSHD, DSHD.length + 5);
                }

                KhachHang n = new KhachHang();
                strings = line.split(";");
                boolean isFound = false;

                // Tìm khách hàng trong danh sách DSKhachHang
                for (KhachHang x : DSKH) {
                    if (strings[3].equals(x.getSDT())) {
                        n = x;
                        isFound = true;
                        break;
                    }
                }

                // Nếu không tìm thấy khách hàng, tạo mới khách hàng
                if (!isFound) {
                    n.setSDT(strings[3]);
                    n.setTenKH(strings[2]);
                }

                // Khởi tạo mảng chứa sản phẩm và số lượng
                SanPham[] ListSP = new SanPham[1];
                int[] SL = new int[1];
                int index = 0;

                String[] sp = strings[5].split(","); // Tách chuỗi sản phẩm từ dấu phẩy
                if (sp[sp.length - 1].isEmpty()) {
                    sp = Arrays.copyOf(sp, sp.length - 1);
                }
                for (int i = 0; i < sp.length; i++) {
                    String[] sp_details = sp[i].split("-"); // Tách sản phẩm và số lượng bằng dấu gạch ngang
                        for (SanPham x : DSSP) {
                            if (sp_details[0].equals(x.getTenSP())) {
                                if (index == ListSP.length - 1) {
                                    ListSP = Arrays.copyOf(ListSP, ListSP.length + 5);
                                    SL = Arrays.copyOf(SL, SL.length + 5);
                                }

                                // Lưu sản phẩm và số lượng vào mảng
                                ListSP[index] = x;
                                SL[index] = Integer.parseInt(sp_details[1]);
                                index++;
                                break;

                            }
                        }
                }

                // Cắt mảng sản phẩm và số lượng đúng với số lượng thực tế
                if (index < ListSP.length) {
                    ListSP = Arrays.copyOf(ListSP, index);
                    SL = Arrays.copyOf(SL, index);
                }

                // Tạo hóa đơn và thêm vào mảng DSHD
                HoaDon hd = new HoaDon(strings[0], df.parse(strings[1]), strings[2], n, ListSP, SL);
                DSHD[soLuongHoaDon] = hd;
                soLuongHoaDon++;
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Lỗi đọc file HoaDon.txt: ");
            e.printStackTrace();
        }

        // Thu hẹp mảng nếu số lượng hóa đơn ít hơn chiều dài mảng
        if (soLuongHoaDon < DSHD.length) {
            DSHD = Arrays.copyOf(DSHD, soLuongHoaDon);
        }

        // Sao chép mảng hiện tại vào mảng lấy dữ liệu từ File
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
            try {
                slHD = Integer.parseInt(sc.nextLine());
                if (slHD <= 0) {
                    System.out.println("Không hợp lệ, vui lòng nhập số lượng > 0: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
                slHD = -1; 
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
        try{

            if (DSHD == null || DSHD.length == 0) {
                System.out.println("Danh sách hóa đơn trống hoặc chưa được khởi tạo.");
                return;
            }

            System.out.println("Nhập mã hóa đơn cần sửa: ");
            String maHD_Sua = sc.nextLine().trim();
            while (maHD_Sua == null || maHD_Sua.trim().isEmpty()) {
                System.out.println("Mã hóa đơn không được để trống. Vui lòng nhập lại mã hóa đơn: ");
                maHD_Sua = sc.nextLine().trim();
            }
            String regex = "^HD\\d+$";
            while (!Pattern.matches(regex, maHD_Sua)) {
                System.out.println("Mã hóa đơn không hợp lệ. Vui lòng nhập lại mã hóa đơn (HDxxxx): ");
                maHD_Sua = sc.nextLine().trim();
            }
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
        catch (Exception e){
            System.out.println(" Vui lòng nhập đúng mã HD");
        }
    }

    // Xóa hóa đơn
    public void Xoa() {
        System.out.println("\n \t \t---------XÓA HÓA ĐƠN---------");
        try{
            if (DSHD == null || DSHD.length == 0) {
                System.out.println("Danh sách hóa đơn trống hoặc chưa được khởi tạo.");
                return;
            }

            System.out.println("Nhập mã hóa đơn cần xóa: ");

            String maHD_Xoa = sc.nextLine();
            while (maHD_Xoa == null || maHD_Xoa.trim().isEmpty()) {
                System.out.println("Mã hóa đơn không được để trống. Vui lòng nhập lại mã hóa đơn: ");
                maHD_Xoa = sc.nextLine().trim();
            }
            String regex = "^HD\\d+$";
            while (!Pattern.matches(regex, maHD_Xoa)) {
                System.out.println("Mã hóa đơn không hợp lệ. Vui lòng nhập lại mã hóa đơn (HDxxxx): ");
                maHD_Xoa = sc.nextLine().trim();
            }
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
        catch (Exception e){
            System.out.println(" Vui lòng nhập đúng Mã HD");
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
        try {
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
        catch (Exception e){
            System.out.println(" Vui lòng nhập lựa chọn từ 1-3");
        }
    }

    private void timTheoMaHoaDon() {
        System.out.println("Nhập mã hóa đơn cần tìm: ");
        String maHD = sc.nextLine();
        while (maHD == null || maHD.trim().isEmpty()) {
            System.out.println("Mã hóa đơn không được để trống. Vui lòng nhập lại mã hóa đơn: ");
            maHD = sc.nextLine().trim();
        }
        String regex = "^HD\\d+$";
        while (!Pattern.matches(regex, maHD)) {
            System.out.println("Mã hóa đơn không hợp lệ. Vui lòng nhập lại mã hóa đơn (HDxxxx): ");
            maHD = sc.nextLine().trim();
        }


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
        String regex = "^[0-9]{10,11}$";
        System.out.println("Nhập SDT khách hàng cần tìm: ");
        while(true) {
            try {
                String sdt = sc.nextLine();
                if ( sdt.isEmpty() ){
                    System.out.println("Không được để trống . Vui lòng nhâp số điện thoại");
                }
                if (!Pattern.matches(regex, sdt)) {
                    System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại (10 chữ số): ");
                    continue;  // Ask for input again
                }
                boolean timThay = false;
                for (HoaDon hd : DSHD) {
                    if (hd.getKhachhangtheodon().getSDT().equalsIgnoreCase(sdt)) {
                        hd.Xuat();
                        timThay = true;
                        break;
                    }
                }
                if (!timThay) {
                    System.out.println("Không tìm thấy hóa đơn với số điện thoại khách hàng: " + sdt);
                }
            }
            catch (Exception e){
                System.out.println(" Vui lòng chỉ nhập số");
            }
        }

    }

    private void timTheoNgay() {
        df.setLenient(false); // Set lenient to false for strict parsing
        while (true) {
            try {
                System.out.printf("Nhập vào thời gian bắt đầu (dd-mm-yyyy) : ");
                Date tg = df.parse(sc.nextLine()); // User input date

                boolean timThay = false;

                // Format the user input date into the "dd-MM-yyyy" format
                String formattedInputDate = df.format(tg);

                for (HoaDon hd : DSHD) {
                    // Format the HoaDon date into the "dd-MM-yyyy" format
                    String formattedHoaDonDate = df.format(hd.getThoiGian());

                    // Compare the formatted dates as strings
                    if (formattedHoaDonDate.equals(formattedInputDate)) {
                        hd.Xuat();  // Call Xuat() method if found
                        timThay = true;
                        break;
                    }
                }

                if (!timThay) {
                    System.out.println("Không tìm thấy hóa đơn được tạo vào " + df.format(tg));
                }
                break;
            } catch (ParseException e) {
                System.out.println("Sai định dạng / Ngày không hợp lệ.");
            }
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
                double total = 0;
                // In từng dòng dữ liệu ra màn hình
                String ChiTiet = String.format(" %-20s | %-15s | %-10s | %-10s |", "Ten san pham", "Gia tien", "SL", "Tong" );
                System.out.println("\nThong tin hoa don : ");
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("\t \t \t \t \t \t Ma hoa don : "+strings[0]);
                System.out.println("Thoi gian : " + strings[1]);
                System.out.println("Khach hang : " + strings[2] + "\t SDT : " + strings[3]);
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("\t \t \t \t \t \t CHI TIET");
                String[] p = strings[5].split(",");
                if (p[p.length - 1].isEmpty()) {
                    p = Arrays.copyOf(p, p.length - 1);
                }
                for ( int i = 0 ; i < p.length ; i++){
                    String[] pd = p[i].split("-");
                    double sum =  Double.parseDouble(pd[1]) * Double.parseDouble(pd[2]);
                    ChiTiet += "\n" + String.format(" %-20s | %-15s | %-10s | %-10s |", pd[0],
                            pd[1], pd[2], sum);
                    total += sum;
                }
                System.out.println(ChiTiet);
                System.out.println("---------------------------------------------------------------------------");
                System.out.println("Phuong thuc thanh toan : " + strings[4]);
                System.out.println("Tong cong : " + total );

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
