package Project_OOP;

import javax.xml.transform.Source;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Date;


public class DanhSachSuKien implements  IThaoTac_2 {
    private static int sl = 0;
    private SuKien[] DSSK;
    private SuKien[] DSSK_File;

    static Scanner sc = new Scanner(System.in);
    static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    DanhSachSuKien() {
        this.DSSK = new SuKien[5];
        this.Nhap();
    }


    @Override
    public void Nhap() {  // Lay du lieu tu file !.
        String line;
        String[] list = new String[6];
        try (BufferedReader br = new BufferedReader(new FileReader("SuKien.txt"))) {
            while ( (line = br.readLine()) != null ){

                if (sl == DSSK.length) {
                    DSSK = Arrays.copyOf(DSSK, DSSK.length + 5);
                }

                list = line.split(";");
                try {
                    Date NBD = formatter.parse(list[2]);
                    Date NKT = formatter.parse(list[3]);
                    SuKien sk = new SuKien(list[0], list[1], NBD, NKT, Double.parseDouble(list[4]), Double.parseDouble(list[5]) );
                    DSSK[sl] = sk;
                    sl++;
                }catch (Exception e){}

            }
        }catch (Exception e) {
            System.out.println("Không đọc được file !\n ");
        }

        if ( sl < DSSK.length){
            DSSK = Arrays.copyOf(DSSK, sl);
        }

        DSSK_File = Arrays.copyOf(DSSK,DSSK.length);

    }

    @Override
    public void Xuat() {
        System.out.println("\n \t \t---------Xuất danh sách---------");

        if ( DSSK== null || sl == 0){
            System.out.println("Danh sách hiện tại đang trống. Vui lòng thêm sự kiện. \n");
            return;
        }

        int count = 0;
        System.out.println("\t   Thông tin của danh sách \n--------------------------");
        for (int i = 0; i < DSSK.length; i++) {
            if (DSSK[i].getStatus() == true) {
                count++;
                DSSK[i].Xuat();
                System.out.println("\t--------------");
            }
        }

    }


    @Override
    public void Them() {
        System.out.println("\n \t \t---------Thêm---------");
        String a;
        do {
            do {
                System.out.printf("Nhập số lượng phần tử thêm vào : ");
                a = sc.nextLine();
                if ( !a.matches(regNumbers))
                    System.out.println("Vui lòng chỉ nhập số !");
            }while (!a.matches(regNumbers));
            if (Integer.parseInt(a) <= 0)
                System.out.println("Vui lòng nhập số lượng lớn hơn 0 !!");

        } while (Integer.parseInt(a) <= 0);

        int x = Integer.parseInt(a);

        sl+= x;

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
        System.out.println("\n \t \t---------Sửa---------");
        if ( DSSK == null || sl == 0){
            System.out.println("Danh sách hiện tại đang trống. Vui lòng thêm sự kiện. \n");
            return;
        }
        String s;
        String regex = "^SK\\d+$";
        do {
            System.out.printf("Nhập vào mã sự kiện : ");
            s = sc.nextLine();
            if (!s.matches(regex))
                System.out.println("Mã sự kiện  phải bắt đầu bằng SK và sau đó là các chữ số, vui lòng nhập lại mã sự kiện .");
        }while (!s.matches(regex));

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
        System.out.println("\n---------Xóa---------");

        if (DSSK == null || sl == 0) {
            System.out.println("Danh sách hiện tại đang trống. Vui lòng thêm sự kiện. \n");
            return;
        }

        String x;
        String regex = "^SK\\d+$";
        do {
            System.out.printf("Nhập vào mã sự kiện : ");
            x = sc.nextLine();
            if (!x.matches(regex))
                System.out.println("Mã sự kiện  phải bắt đầu bằng SK và sau đó là các chữ số, vui lòng nhập lại mã sự kiện .");
        }while (!x.matches(regex));

        boolean isFound = false;

        for (int i = 0; i < DSSK.length; i++) {
            if (DSSK[i].getMaSK().equals(x)) {
                isFound = true;
                DSSK[i].setStatus(false);
                sl--;

                System.out.println("Xóa thành công ! \n ");
                break;
            }
        }

        if (!isFound) {
            System.out.println("Không tìm thấy mã '" + x + "' để xóa!\n------------------");
        }
    }

    @Override
    public void TimKiem() {
        System.out.println("\n---------Tìm kiếm---------");
        if ( sl == 0){
            System.out.println("Danh sách hiện tại đang trống. Vui lòng thêm sự kiện. \n");
            return;
        }

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        while (true) {
            System.out.println("1.Tìm kiếm theo mã sự kiện.");
            System.out.println("2.Tìm kiếm theo tên sự kiện.");
            System.out.println("3.Tìm kiếm theo thời gian bắt đầu.");
            System.out.println("4.Tìm kiếm theo thời gian kết thúc.");
            System.out.println("5.Tìm kiếm theo doanh thu.");
            System.out.println("6.Tìm kiếm theo tiền vốn.");
            System.out.println("7.Tìm kiếm theo tình trạng.");
            System.out.println("8.Thoát.");


            int b = 0;
            boolean validInput= false;
            while (!validInput)
            {
                try {
                    System.out.printf("Nhập lựa chọn : ");
                    b = Integer.parseInt(sc.nextLine());

                    if ( b < 1 || b > 8) {
                        validInput = false;
                        System.out.println("vui lòng nhập lựa chọn từ 1 -> 8");
                    }
                    else
                        validInput = true;
                } catch (Exception e) {
                    System.out.println("Vui lòng chỉ nhập số !");
                }
            }
            int x = b;
            System.out.println();

            if (x == 1) {
                String regexMaSK = "^SK||Sk||sK||sk\\d+$";
                String s;
                do {
                    System.out.printf("Nhập vào mã sự kiện : ");
                    s = sc.nextLine();
                    if (!s.matches(regexMaSK))
                        System.out.println("Mã sự kiện phải bắt đầu bằng SK và sau đó là các chữ số, vui lòng nhập lại mã sự kiện .");
                }while (!s.matches(regexMaSK));
                boolean isFind = false;
                for (int i = 0; i < DSSK.length; i++) {
                    if (DSSK[i].getMaSK().equalsIgnoreCase(s)) {
                        isFind = true;
                        DSSK[i].Xuat();
                        System.out.println("\n \t--------------------");
                    }
                }
                if (isFind == false)
                    System.out.println("Không tìm thấy sự kiện có mã " + s + " trong danh sách !");
            }

            else if (x == 2) {
                String s;
                do {
                    System.out.printf("Nhập vào tên sự kiện : ");
                    s = sc.nextLine();
                    if (!s.matches(regexLetters))
                        System.out.println("Vui lòng nhập đúng định dạng (chỉ nhập chữ) ");
                }while (!s.matches(regexLetters));
                boolean isFind = false;
                for (int i = 0; i < DSSK.length; i++) {
                    if (DSSK[i].getTenSK().equalsIgnoreCase(s)) {
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
                String DT;
                do {
                    do {
                        System.out.printf("Nhập vào doanh thu : ");
                        DT = sc.nextLine();
                        if (!DT.matches(regNumbers))
                            System.out.println("Sai dinh dang");
                    }while (!DT.matches(regNumbers));

                    if (Double.parseDouble(DT) < 0)
                        System.out.println("DT > 0");
                }while (Double.parseDouble(DT) < 0 );
                s = Double.parseDouble(DT);

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
                String TV;
                do {
                    do {
                        System.out.printf("Nhập vào tiền vốn : ");
                        TV = sc.nextLine();
                        if (!TV.matches(regNumbers))
                            System.out.println("Sai dinh dang");
                    }while (!TV.matches(regNumbers));

                    if (Double.parseDouble(TV) < 0)
                        System.out.println("DT > 0");
                }while (Double.parseDouble(TV) < 0 );
                s = Double.parseDouble(TV);
                boolean isFind = false;

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
                int s = 0;
                boolean isValid = false;
                boolean isFind = false;
                System.out.println("1.Thiệt hại.");
                System.out.println("2.Bình thường.");
                System.out.println("3.Lời.");
                System.out.println("4.Thoát.");
                while (!isValid) {
                    try {
                        System.out.println("Nhập lựa chọn : ");
                        s = Integer.parseInt(sc.nextLine());
                        if (s < 0 || s > 4) {
                            System.out.println("Vui lòng nhập lựa chọn từ 1 -> 4");
                            isValid = false;
                        }
                        else
                            isValid = true;
                    } catch (Exception e) {
                        System.out.println("Vui lòng chỉ nhập số !");
                    };
                }

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
        System.out.println("\n---------Ghi file---------");
        if (DSSK == null | sl == 0 ){
            System.out.println("Vui lòng tạo danh sách trước !!");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("SuKien.txt"))) {
            for (SuKien sk : DSSK) {
                if (sk.getStatus()) {
                    bw.write(sk.toString());
                    bw.newLine();
                }
            }
            System.out.println("Ghi dữ liệu vào file thành công!");
            DSSK_File = Arrays.copyOf(DSSK,DSSK.length);
        }catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }


    public static void docFile() {

        try (BufferedReader br = new BufferedReader(new FileReader("SuKien.txt"))) {
            String line;
            String[] list = new String[6];

            while ((line = br.readLine()) != null) {
                list = line.split(";");
                try {
                    Date NBD = formatter.parse(list[2]);
                    Date NKT = formatter.parse(list[3]);
                    SuKien sk = new SuKien(list[0], list[1], NBD, NKT, Double.parseDouble(list[4]), Double.parseDouble(list[5]));
                    sk.Xuat();
                    System.out.println("--------------------------------\n");
                }catch (Exception e) {}

            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }


    public void ThongKe(int choice){
        //Thong ke theo mang danh sach hien tai.
        if (choice == 1) {       //Kiem tra neu DSSK trong.
            if ( DSSK == null || sl == 0){
                System.out.println("Danh sách hiện tại đang trống. Vui lòng thêm sự kiện. \n");
                return;
            }


            int j = 0;
            for ( int i = 0 ; i < DSSK.length ; i++ ){
                if (DSSK[i].getStatus()){
                    j = i;
                    break;
                }
            }
            SuKien minSK = DSSK[j];
            SuKien maxSK = DSSK[j];

            double sum = 0;
            SuKien[] minList = new SuKien[1];
            int indexMin = 0;
            SuKien[] maxList = new SuKien[1];
            int indexMax = 0;

            // <----------- Phan tinh toan
            for (int i = 0; i < DSSK.length; i++) {         //Tim max min
                if (DSSK[i].getStatus()) {
                    sum += DSSK[i].LoiNhuan();
                    if (DSSK[i].LoiNhuan() > maxSK.LoiNhuan())
                        maxSK = DSSK[i];

                    if (DSSK[i].LoiNhuan() < minSK.LoiNhuan())
                        minSK = DSSK[i];
                }
            }

            for (int i = 0; i < DSSK.length; i++) {
                //Cac su kien = maxSK;
                if (DSSK[i].getStatus()) {
                    if (DSSK[i].LoiNhuan() == maxSK.LoiNhuan()) {       // Tim thay su kien co loi nhuan = maxSK.
                        if (indexMax == maxList.length)   // Mo rong maxList neu index = chieu dai mang? .
                            maxList = Arrays.copyOf(maxList, maxList.length + 1);
                        maxList[indexMax] = DSSK[i];
                        indexMax++;
                    }
                    //Cac su kien = minSK :
                    if (DSSK[i].LoiNhuan() == minSK.LoiNhuan()) {
                        if (indexMin == minList.length)
                            minList = Arrays.copyOf(minList, minList.length + 1);
                        minList[indexMin] = DSSK[i];
                        indexMin++;
                    }
                }
            }
            //-------------->
            //Phan output :
            System.out.println("\n---------Thống kê---------");
            System.out.println("1.Số lượng sự kiện hiện tại : " + sl);

            System.out.println("2.Các sự kiện có lợi nhuận cao nhất : " );
            for ( int i = 0 ; i < maxList.length ; i++ ){
                maxList[i].Xuat();
                System.out.println("-------------------------------------");
            }
            System.out.println("\t \t -----xxxxx----- ");

            System.out.println("3.Các sự kiện có lợi nhuận thấp nhất : ");
            for ( int i = 0 ; i < minList.length ; i++ ){
                minList[i].Xuat();
                System.out.println("-------------------------------------");
            }
            System.out.println("\t \t -----xxxxx----- ");

            System.out.println("4.Tổng lợi nhuận : " + sum );
            System.out.println("5.Lợi nhuận trung bình : " + sum/sl);
            System.out.println("-------------------------------------");
        }

        //Thong ke tu file
        else {
            if ( DSSK_File.length == 0){                            //Kiem tra neu DSSK_File trong.
                System.out.println("File đang trống, vui lòng ghi File");
                return;
            }
            SuKien minSK = DSSK_File[0];
            SuKien maxSK = DSSK_File[0];
            double sum = 0;
            SuKien[] minList = new SuKien[1];
            int indexMin = 0;
            SuKien[] maxList = new SuKien[1];
            int indexMax = 0;

            for (int i = 0; i < DSSK_File.length; i++) {
                sum += DSSK_File[i].LoiNhuan();
                if (DSSK_File[i].LoiNhuan() > maxSK.LoiNhuan())
                    maxSK = DSSK_File[i];

                if (DSSK_File[i].LoiNhuan() < minSK.LoiNhuan())
                    minSK = DSSK_File[i];
            }

            for (int i = 0; i < DSSK_File.length; i++) {
                //Cac su kien = maxSK;
                if (DSSK_File[i].LoiNhuan() == maxSK.LoiNhuan()) {       // Tim thay su kien co loi nhuan = maxSK.
                    if (indexMax == maxList.length)             // Mo rong maxList neu index = chieu dai mang? .
                        maxList = Arrays.copyOf(maxList, maxList.length + 1);
                    maxList[indexMax] = DSSK_File[i];
                    indexMax++;
                }
                //Cac su kien = minSK :
                if (DSSK_File[i].LoiNhuan() == minSK.LoiNhuan()) {
                    if (indexMin == minList.length)
                        minList = Arrays.copyOf(minList, minList.length + 1);
                    minList[indexMin] = DSSK_File[i];
                    indexMin++;
                }
            }
            //Phan output :
            System.out.println("\n---------Thống kê---------");
            System.out.println("1.Số lượng sự kiện hiện tại : " + DSSK_File.length);

            System.out.println("2.Các sự kiện có lợi nhuận cao nhất : " );
            for ( int i = 0 ; i < maxList.length ; i++ ){
                maxList[i].Xuat();
                System.out.println("-------------------------------------");
            }
            System.out.println("\t \t -----xxxxx----- ");

            System.out.println("3.Các sự kiện có lợi nhuận thấp nhất : ");
            for ( int i = 0 ; i < minList.length ; i++ ){
                minList[i].Xuat();
                System.out.println("-------------------------------------");
            }
            System.out.println("\t \t -----xxxxx----- ");

            System.out.println("4.Tổng lợi nhuận : " + sum );
            System.out.println("5.Lợi nhuận trung bình : " + sum/sl);
            System.out.println("-------------------------------------");
        }


    }

}
