package Project_OOP;
import java.security.PublicKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class SuKien implements  IThaoTac{
    private String MaSK;
    private String TenSK;
    private Date ThoiGianBatDau;
    private Date ThoiGianKetThuc;
    private double DoanhThu;
    private double TienVon;
    private boolean Status;

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    SuKien (String id, String ten, Date NBD, Date NKT ,double doanhthu , double von) {
        this.MaSK = id;
        this.TenSK = ten;
        this.ThoiGianBatDau = NBD;
        this.ThoiGianKetThuc = NKT;
        this.DoanhThu = doanhthu;
        this.TienVon = von;
        this.Status = true;
    }

    SuKien(){
        this.setStatus(true);
    }

    public void setMaSK() {
        System.out.printf("Nhập vào mã sự kiện : ");
        MaSK = sc.nextLine();
    }

    public void setStatus(boolean status){
        this.Status = status;
    }

    public void setTenSK() {
        System.out.printf("Nhập vào tên sự kiện : ");
        TenSK = sc.nextLine();
    }

    public void setThoiGianBatDau(){
        df.setLenient(false);
        while (true) {
            try {
                System.out.printf("Nhập vào thời gian bắt đầu (dd-mm-yyyy) : ");
                ThoiGianBatDau = df.parse(sc.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println("Sai định dạng / Ngày không hợp lệ. ");
            }
        }
    }

    public void setThoiGianKetThuc(){
        df.setLenient(false);
        while (true)
        {
            try{
                System.out.printf("Nhập vào thời gian kết thúc (dd-mm-yyyy) : ");
                ThoiGianKetThuc = df.parse(sc.nextLine());
                if (ThoiGianKetThuc.after(ThoiGianBatDau))
                    break;
                else
                    System.out.println("Thời gian kết thúc phải sau thời gian bắt đầu !! ");
            } catch (ParseException e) {
                System.out.println("Sai định dạng / Ngày không hợp lệ. ");
            }
        }
    }

    public void setDoanhThu(){
        System.out.printf("Nhập vào doanh thu : ");
        DoanhThu = sc.nextDouble();
        sc.nextLine();
    }

    public void setTienVon(){
        System.out.printf("Nhập vào tiền vốn : ");
        TienVon = sc.nextDouble();
        sc.nextLine();
    }

    public String getMaSK(){
        return MaSK;
    }

    public String getTenSK(){
        return TenSK;
    }

    public String getThoiGianBatDau(){
        return df.format(ThoiGianBatDau);
    }

    public String getThoiGianKetThuc(){
        return df.format(ThoiGianKetThuc);
    }

    public double getDoanhThu(){
        return DoanhThu;
    }

    public double getTienVon (){
        return TienVon;
    }

    public boolean getStatus(){
        return Status;
    }


    @Override
    public void Nhap(){
        this.setMaSK();
        this.setTenSK();
        this.setThoiGianBatDau();
        this.setThoiGianKetThuc();
        this.setDoanhThu();
        this.setTienVon();
    }

    public double LoiNhuan(){
        return DoanhThu - TienVon;
    }

    public String DanhGia(){
        double x = this.LoiNhuan();
        if ( x < 0 )
            return "Thiệt hại";

        else if ( x > 0 && x < 2000000)
            return "Bình thường";

        else
            return "Lời";

    }

    @Override
    public String toString (){
        return String.format("%s;%s;%s;%s;%.2f;%.2f",this.getMaSK(),this.getTenSK(),this.getThoiGianBatDau(),
                this.getThoiGianKetThuc(), this.getDoanhThu(), this.getTienVon());
    }

    @Override
    public void Xuat(){
        System.out.println("Mã sự kiện : " + this.getMaSK() );
        System.out.println("Tên sự kiện : " + this.getTenSK() );
        System.out.println("Thời gian bắt đầu : " + this.getThoiGianBatDau());
        System.out.println("Thời gian kết thúc : " + this.getThoiGianKetThuc());
        System.out.println("Doanh thu : " + this.getDoanhThu());
        System.out.println("Tiền vốn : " + this.getTienVon());
        System.out.println("Lợi nhuận : " + this.LoiNhuan() + " --> Tình trạng : "+ this.DanhGia());
    }

    @Override
    public void Sua(){
        int c;
        while (true) {
            System.out.println("Chọn thông tin cần sửa : ");
            System.out.println("1.Mã sự kiện.");
            System.out.println("2.Tên sự kiện.");
            System.out.println("3.Thời gian bắt đầu.");
            System.out.println("4.Thời gian kết thúc.");
            System.out.println("5.Doanh thu.");
            System.out.println("6.Tiền vốn.");
            System.out.println("7.Thoát.");

            do {
                System.out.printf("Nhập lựa chọn : ");
                c = sc.nextInt();
                sc.nextLine();
            }while (c < 1 || c > 7);

            switch (c){
                case 1 :
                    this.setMaSK();
                    System.out.println("Sửa thành công !");
                    break;

                case 2 :
                    this.setTenSK();
                    System.out.println("Sửa thành công !");
                    break;

                case 3 :
                    do {
                        this.setThoiGianBatDau();
                        if (ThoiGianBatDau.after(ThoiGianKetThuc))
                            System.out.println("Thời gian bắt đầu phải trước thời gian kết thúc !!");
                    }while (ThoiGianBatDau.after(ThoiGianKetThuc));
                    System.out.println("Sửa thành công !");
                    break;

                case 4 :
                    this.setThoiGianKetThuc();
                    System.out.println("Sửa thành công !");
                    break;

                case 5 :
                    this.setDoanhThu();
                    System.out.println("Sửa thành công !");
                    break;

                case 6 :
                    this.setTienVon();
                    System.out.println("Sửa thành công !");
                    break;

                case 7 :
                    return;
            }
        }

    }
}

