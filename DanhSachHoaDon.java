package Project_OOP;

import java.io.*;
import java.util.*;

public class DanhSachHoaDon implements IThaoTac_2 {
    static int sl = 0; // Số lượng hóa đơn hiện tại
    private HoaDon[] DSHD; // Mảng chứa các hóa đơn
    private HoaDon[] DSHD_File; // Mảng chứa các hóa đơn đọc từ file
    Scanner sc = new Scanner(System.in);

    // Constructor
    DanhSachHoaDon() {
        this.DSHD = new HoaDon[5];
        this.Nhap(); // Nhập dữ liệu từ file khi khởi tạo
    }

    @Override
    public void Nhap() {
        String line;
        String[] list = new String[6];
        try (BufferedReader br = new BufferedReader(new FileReader("HoaDon.txt"))) {
            while ((line = br.readLine()) != null) {
                if (sl == DSHD.length) {
                    DSHD = Arrays.copyOf(DSHD, DSHD.length + 5);
                }

                list = line.split(";");
                try {
                    HoaDon hd = new HoaDon(list[0], list[1], Double.parseDouble(list[2]), Integer.parseInt(list[3]), list[4], list[5]);
                    DSHD[sl] = hd;
                    sl++;
                } catch (Exception e) {
                    System.out.println("Lỗi dữ liệu hóa đơn!");
                }
            }
        } catch (Exception e) {
            System.out.println("Không đọc được file hóa đơn!");
        }

        if (sl < DSHD.length) {
            DSHD = Arrays.copyOf(DSHD, sl);
        }

        DSHD_File = Arrays.copyOf(DSHD, DSHD.length);
    }

    @Override
    public void Xuat() {
        System.out.println("\n \t \t---------Xuất danh sách hóa đơn---------");

        if (DSHD == null) {
            System.out.println("Vui lòng tạo danh sách hóa đơn trước!!");
            return;
        }

        System.out.println("\t   Thông tin của danh sách hóa đơn \n--------------------------");
        for (int i = 0; i < DSHD.length; i++) {
            DSHD[i].Xuat();
            System.out.println("\t--------------");
        }
    }

    @Override
    public void Them() {
        System.out.println("\n \t \t---------Thêm hóa đơn---------");

        if (DSHD == null) {
            System.out.println("Vui lòng tạo danh sách hóa đơn trước!!");
            return;
        }

        int x;
        do {
            System.out.printf("Nhập số lượng hóa đơn cần thêm: ");
            x = sc.nextInt();
            sc.nextLine();
            if (x <= 0)
                System.out.println("Vui lòng nhập số lượng lớn hơn 0!!");
        } while (x <= 0);
        sl += x;

        int prevLength = DSHD.length;
        DSHD = Arrays.copyOf(DSHD, DSHD.length + x);

        for (int i = prevLength; i < DSHD.length; i++) {
            DSHD[i] = new HoaDon();
            DSHD[i].Nhap();
            System.out.println("Nhập thành công hóa đơn thứ " + (i + 1) + "!");
        }
    }

    @Override
    public void Sua() {
        System.out.println("\n \t \t---------Sửa hóa đơn---------");
        if (DSHD == null) {
            System.out.println("Vui lòng tạo danh sách hóa đơn trước!!");
            return;
        }

        System.out.printf("Nhập vào mã hóa đơn cần sửa: ");
        String s = sc.nextLine();
        boolean isFind = false;

        for (int i = 0; i < DSHD.length; i++) {
            if (DSHD[i].getMaHD().equals(s)) {
                DSHD[i].Sua();
                isFind = true;
                System.out.println("Sửa hóa đơn thành công!");
            }
        }

        if (!isFind)
            System.out.println("Không tìm thấy mã hóa đơn '" + s + "' để sửa!");
    }

    @Override
    public void Xoa() {
        System.out.println("\n---------Xóa hóa đơn---------");

        if (DSHD == null) {
            System.out.println("Vui lòng tạo danh sách hóa đơn trước!!");
            return;
        }

        if (DSHD == null || DSHD.length == 0) {
            System.out.println("Danh sách hóa đơn trống.");
            return;
        }

        System.out.print("Nhập vào mã hóa đơn cần xóa: ");
        String x = sc.nextLine();
        boolean isFound = false;
        int index = -1;

        for (int i = 0; i < DSHD.length; i++) {
            if (DSHD[i].getMaHD().equals(x)) {
                index = i;
                isFound = true;
                break;
            }
        }

        if (isFound) {
            for (int i = index; i < DSHD.length - 1; i++) {
                DSHD[i] = DSHD[i + 1];
            }
            DSHD = Arrays.copyOf(DSHD, DSHD.length - 1);
            System.out.println("Xóa hóa đơn thành công!");
            sl--;
        } else {
            System.out.println("Không tìm thấy mã hóa đơn '" + x + "' để xóa!");
        }
    }

    @Override
    public void TimKiem() {
        System.out.println("\n---------Tìm kiếm hóa đơn---------");
        if (DSHD == null) {
            System.out.println("Vui lòng tạo danh sách hóa đơn trước!!");
            return;
        }

        while (true) {
            int x;
            System.out.println("1.Tìm kiếm theo mã hóa đơn.");
            System.out.println("2.Tìm kiếm theo tên khách hàng.");
            System.out.println("3.Tìm kiếm theo số lượng.");
            System.out.println("4.Tìm kiếm theo tổng giá trị.");
            System.out.println("5.Thoát.");
            do {
                System.out.printf("Nhập lựa chọn: ");
                x = sc.nextInt();
                sc.nextLine();
                if (x < 1 || x > 5)
                    System.out.println("Vui lòng nhập lựa chọn từ 1 đến 5!");
            } while (x < 1 || x > 5);

            if (x == 1) {
                System.out.printf("Nhập mã hóa đơn cần tìm: ");
                String s = sc.nextLine();
                boolean isFind = false;
                for (int i = 0; i < DSHD.length; i++) {
                    if (DSHD[i].getMaHD().equals(s)) {
                        isFind = true;
                        DSHD[i].Xuat();
                    }
                }
                if (!isFind)
                    System.out.println("Không tìm thấy hóa đơn có mã '" + s + "' trong danh sách!");
            }

            else if (x == 2) {
                System.out.printf("Nhập tên khách hàng cần tìm: ");
                String s = sc.nextLine();
                boolean isFind = false;
                for (int i = 0; i < DSHD.length; i++) {
                    if (DSHD[i].getTenKH().equals(s)) {
                        isFind = true;
                        DSHD[i].Xuat();
                    }
                }
                if (!isFind)
                    System.out.println("Không tìm thấy hóa đơn có tên khách hàng '" + s + "'!");
            }

            else if (x == 3) {
                System.out.printf("Nhập số lượng cần tìm: ");
                int s = sc.nextInt();
                boolean isFind = false;
                for (int i = 0; i < DSHD.length; i++) {
                    if (DSHD[i].getSoLuong() == s) {
                        isFind = true;
                        DSHD[i].Xuat();
                    }
                }
                if (!isFind)
                    System.out.println("Không tìm thấy hóa đơn với số lượng '" + s + "'!");
            }

            else if (x == 4) {
                System.out.printf("Nhập tổng giá trị cần tìm: ");
                double s = sc.nextDouble();
                boolean isFind = false;
                for (int i = 0; i < DSHD.length; i++) {
                    if (DSHD[i].getTongGiaTri() == s) {
                        isFind = true;
                        DSHD[i].Xuat();
                    }
                }
                if (!isFind)
                    System.out.println("Không tìm thấy hóa đơn với tổng giá trị '" + s + "'!");
            }

            else
                return;
        }
    }

    @Override
    public void ghiFile() {
        System.out.println("\n---------Ghi file hóa đơn---------");
        if (DSHD == null) {
            System.out.println("Vui lòng tạo danh sách hóa đơn trước!!");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("HoaDon.txt"))) {
            for (HoaDon hd : DSHD) {
                bw.write(hd.getMaHD() + ";" + hd.getTenKH() + ";" + hd.getTongGiaTri() + ";" +
                        hd.getSoLuong() + ";" + hd.getNgayLap() + ";" + hd.getNgayThanhToan());
                bw.newLine();
            }
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file!");
        }
    }

    @Override
    public void docFile() {
        System.out.println("\n---------Đọc file hóa đơn---------");
        if (DSHD == null) {
            System.out.println("Vui lòng tạo danh sách hóa đơn trước!!");
            return;
        }

        for (HoaDon hd : DSHD_File) {
            hd.Xuat();
        }
    }
}
