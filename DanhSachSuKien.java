package Project_OOP;

import javax.xml.transform.Source;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Date;


public class DanhSachSuKien implements  IThaoTac_2 {
    private SuKien[] DSSK;
    Scanner sc = new Scanner(System.in);

    DanhSachSuKien() {
    }

    @Override
    public void Nhap() {

        if (DSSK != null){
            System.out.println("Danh sách đã được tạo rồi !! ");
            return;
        }

        System.out.printf("Nhập số lượng phần tử đầu tiên thêm vào : ");
        int sl = sc.nextInt();
        sc.nextLine();
        DSSK = new SuKien[sl];

        for (int i = 0; i < DSSK.length; i++) {
            DSSK[i] = new SuKien();
            DSSK[i].Nhap();
            System.out.println("Nhập thành công \n \t---------------------");
        }

    }

    @Override
    public void Xuat() {
        if (DSSK == null ){
            System.out.println("Vui lòng tạo danh sách trước !!");
            return;
        }

        System.out.println("\t   Thông tin của danh sách \n--------------------------");
        for (int i = 0; i < DSSK.length; i++) {
            DSSK[i].Xuat();
            System.out.println("\t--------------");
        }
    }


    @Override
    public void Them() {
        if (DSSK == null ){
            System.out.println("Vui lòng tạo danh sách trước !!");
            return;
        }
        int x;
        do {
            System.out.printf("Nhập số lượng phần tử thêm vào : ");
            x = sc.nextInt();
            sc.nextLine();
            if (x <= 0)
                System.out.println("Vui lòng nhập số lượng lớn hơn 0 !!");
        } while (x <= 0);

        int prevLength = DSSK.length;
        DSSK = Arrays.copyOf(DSSK, DSSK.length + x);

        for (int i = prevLength; i < DSSK.length; i++) {
            DSSK[i] = new SuKien();
            DSSK[i].Nhap();
            System.out.println("Nhập thành công ! \n \t ------------------");
        }
    }

    @Override
    public void Sua(){
        if (DSSK == null ){
            System.out.println("Vui lòng tạo danh sách trước !!");
            return;
        }

        System.out.printf("Nhập vào mã cần sửa : ");
        String s = sc.nextLine();
        boolean isFind = false;

        for ( int i = 0 ; i < DSSK.length ; i++ ){
            if(DSSK[i].getMaSK().equals(s)){
                DSSK[i].Sua();
                isFind = true;
                System.out.println("Sửa thành công ! \n -------------------");
            }
        }

        if ( isFind == false )
            System.out.println("Không tìm thấy mã ' " + s + " ' để sửa ! \n------------------");

    }

    @Override
    public void Xoa() {

        if (DSSK == null ){
            System.out.println("Vui lòng tạo danh sách trước !!");
            return;
        }

        if (DSSK == null || DSSK.length == 0) {
            System.out.println("Danh sách sự kiện trống.");
            return;
        }

        System.out.print("Nhập vào mã cần xóa: ");
        String x = sc.nextLine();
        boolean isFound = false;
        int index = -1;

        for (int i = 0; i < DSSK.length; i++) {
            if (DSSK[i].getMaSK().equals(x)) {
                index = i;
                isFound = true;
                break;
            }
        }

        if (isFound) {
            for (int i = index; i < DSSK.length - 1; i++) {
                DSSK[i] = DSSK[i + 1];
            }
            // Giảm kích thước mảng
            DSSK = Arrays.copyOf(DSSK, DSSK.length - 1);
            System.out.println("Xóa sự kiện thành công!\n-------------------");
        } else {
            System.out.println("Không tìm thấy mã '" + x + "' để xóa!\n------------------");
        }
    }

    @Override
    public void TimKiem() {
        if (DSSK == null ){
            System.out.println("Vui lòng tạo danh sách trước !!");
            return;
        }

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        while (true) {
            int x;
            System.out.println("1.Tìm kiếm theo mã sự kiện.");
            System.out.println("2.Tìm kiếm theo tên sự kiện.");
            System.out.println("3.Tìm kiếm theo thời gian bắt đầu.");
            System.out.println("4.Tìm kiếm theo thời gian kết thúc.");
            System.out.println("5.Tìm kiếm theo doanh thu.");
            System.out.println("6.Tìm kiếm theo tiền vốn.");
            System.out.println("7.Tìm kiếm theo tình trạng.");
            System.out.println("8.Thoát.");
            do {
                System.out.printf("Nhập lựa chọn : ");
                x = sc.nextInt(); sc.nextLine();
                if (x < 1 || x > 8)
                    System.out.println("Vui lòng nhập lựa từ 1 -> 8 !");
            } while (x < 1 || x > 8);

            System.out.println();

            if (x == 1) {
                System.out.printf("Nhập mã sự kiện cần tìm : ");
                String s = sc.nextLine();
                boolean isFind = false;
                for (int i = 0; i < DSSK.length; i++) {
                    if (DSSK[i].getMaSK().equals(s)) {
                        isFind = true;
                        DSSK[i].Xuat();
                        System.out.println("\n \t--------------------");
                    }
                }
                if (isFind == false)
                    System.out.println("Không tìm thấy sự kiện có mã " + s + " trong danh sách !");
            }

            else if (x == 2) {
                System.out.printf("Nhập tên sự kiện cần tìm : ");
                String s = sc.nextLine();
                boolean isFind = false;
                for (int i = 0; i < DSSK.length; i++) {
                    if (DSSK[i].getTenSK().equals(s)) {
                        isFind = true;
                        System.out.println("Sự kiện thứ " + i + 1 + " : ");
                        DSSK[i].Xuat();
                        System.out.println("\n \t--------------------");
                    }
                }
                if (isFind == false)
                    System.out.println("Không tìm thấy sự kiện có tên " + s + " trong danh sách !");

            }

            else if (x == 3) {
                df.setLenient(false);
                Date s;
                boolean isFind = false;

                while (true) {
                    try {
                        System.out.printf("Nhập vào thời gian bắt đầu cần tìm : ");
                        s = df.parse(sc.nextLine());
                        break;
                    } catch (ParseException e) {
                        System.out.println("Sai định dạng / Ngày không hợp lệ !");
                    }
                }

                for ( int i = 0 ; i < DSSK.length ; i++ ){
                    if (DSSK[i].getThoiGianBatDau().equals(df.format(s))){
                        isFind = true;
                        System.out.println("Sự kiện thứ " + i + " :");
                        DSSK[i].Xuat();
                        System.out.println("\n \t--------------------");
                    }
                }

                if ( isFind == false )
                    System.out.println("Không tìm thấy sự kiện có thời gian bắt đầu " + df.format(s) + " trong danh sách !!");

            }

            else if ( x == 4 ) {
                df.setLenient(false);
                Date s;
                boolean isFind = false;

                while (true){
                    try {
                        System.out.printf("Nhập vào thời gian kết thúc cần tìm : ");
                        s = df.parse(sc.nextLine());
                        break;
                    } catch (ParseException e){
                        System.out.println("Sai định dạng / Ngày không hợp lệ !");
                    }
                }
                for ( int i = 0 ; i < DSSK.length ; i++ ){
                    if (DSSK[i].getThoiGianKetThuc().equals(df.format(s))){
                        isFind = true;
                        System.out.println("Sự kiện thứ " + i+1 + " : ");
                        DSSK[i].Xuat();
                        System.out.println("\n \t--------------------");
                    }
                }

                if ( isFind == false)
                    System.out.println("Không tìm thấy sự kiện có thời gian kết thúc " + df.format(s) + " trong danh sách !!");

            }

            else if (x == 5){
                double s;
                boolean isFind = false;
                do {
                    System.out.printf("Nhập vào doanh thu cần tìm : ");
                    s = sc.nextDouble();
                    sc.nextLine();
                    if ( s < 0 ){
                        System.out.println("Vui lòng nhập doanh thu >= 0 !");
                    }
                }while (s < 0);

                for ( int i = 0 ; i < DSSK.length ; i++ ){
                    if (DSSK[i].getDoanhThu() == s ){
                        isFind = true;
                        System.out.println("Sự kiện thứ " + i+1 + " : ");
                        DSSK[i].Xuat();
                        System.out.println("\n \t--------------------");
                    }
                }

                if ( !isFind)
                    System.out.println("Không tìm thấy sự kiện có doanh thu = " + s + " trong danh sách !! \n");
            }

            else if (x == 6){
                double s;
                boolean isFind = false;
                do {
                    System.out.printf("Nhập vào tiền vốn cần tìm : ");
                    s = sc.nextDouble();
                    sc.nextLine();
                    if ( s < 0 ){
                        System.out.println("Vui lòng nhập tiền vốn >= 0 !");
                    }
                }while (s < 0);

                for ( int i = 0 ; i < DSSK.length ; i++ ){
                    if (DSSK[i].getTienVon() == s ){
                        isFind = true;
                        System.out.println("Sự kiện thứ " + i+1 + " : ");
                        DSSK[i].Xuat();
                        System.out.println("\n \t--------------------");
                    }
                }

                if ( !isFind)
                    System.out.println("Không tìm thấy sự kiện có tiền vốn = " + s + " trong danh sách !! \n");
            }

            else if (x == 7) {
                int s;
                boolean isFind = false;
                System.out.println("1.Thiệt hại.");
                System.out.println("2.Bình thường.");
                System.out.println("3.Lời.");
                System.out.println("4.Thoát.");
                do{
                    System.out.println("Nhập lựa chọn : ");
                    s = sc.nextInt();
                    if ( s < 0 || s > 4)
                        System.out.println("Vui lòng nhập lựa chọn từ 1 -> 4");
                }while (s < 0 || s > 4);

                if ( s == 1 ){
                    for (int i = 0 ; i < DSSK.length ; i++ ){
                        if(DSSK[i].DanhGia().equals("Thiệt hại")){
                            isFind = true;
                            System.out.println("Sự kiện thứ " + i+1 + " : ");
                            DSSK[i].Xuat();
                            System.out.println("\n \t--------------------");
                        }
                    }
                    if (!isFind)
                        System.out.println("Không có sự kiện nào thiệt hại !! ");
                }

                else if ( s == 2 ){
                    for (int i = 0 ; i < DSSK.length ; i++ ){
                        if(DSSK[i].DanhGia().equals("Bình thường")){
                            isFind = true;
                            System.out.println("Sự kiện thứ " + i+1 + " : ");
                            DSSK[i].Xuat();
                            System.out.println("\n \t--------------------");
                        }
                    }
                    if (!isFind)
                        System.out.println("Không có sự kiện nào có tình trạng bình thường !! ");
                }

                else if ( s== 3 ){
                    for (int i = 0 ; i < DSSK.length ; i++ ){
                        if(DSSK[i].DanhGia().equals("Lời")){
                            isFind = true;
                            System.out.println("Sự kiện thứ " + i+1 + " : ");
                            DSSK[i].Xuat();
                            System.out.println("\n \t--------------------");
                        }
                    }
                    if (!isFind)
                        System.out.println("Không có sự kiện nào lời !! ");
                }

                else
                    return;
            }

            else
                return;

        }
    }

    @Override
    public void ghiFile() {
        if (DSSK == null ){
            System.out.println("Vui lòng tạo danh sách trước !!");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("SuKien.txt"))) {
            for (SuKien sk : DSSK) {
                bw.write(sk.toString());
                bw.newLine();
            }
            System.out.println("Ghi dữ liệu vào file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    @Override
    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("SuKien.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

}