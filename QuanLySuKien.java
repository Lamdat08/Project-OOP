package Project_OOP;

import java.util.Scanner;

public class QuanLySuKien {
    DanhSachSuKien DSsk = new DanhSachSuKien();
    Scanner sc = new Scanner(System.in);


    public void Menu(){
        while (true) {
            System.out.println("\n --------Quản lý danh sách sự kiện---------");
            System.out.println("1.Đọc file.");
            System.out.println("2.Thống kê từ file.");
            System.out.println("3.Các thao tác khác.");
            System.out.println("4.Thoát.");
            int x;
            do {
                System.out.printf("Nhập lựa chọn : ");
                x = sc.nextInt();
                sc.nextLine();
                if ( x < 1 || x > 4 )
                    System.out.println("Nhập lựa chọn từ 1->4 !! ");
            } while (x < 1 || x > 4);

            if (x == 1)
                DanhSachSuKien.docFile();

            else if ( x == 2 )
                DSsk.ThongKe(2);

            else if (x == 3) {

                while (true) {
                    System.out.println("--------Menu các thao tác quản lý sự kiện--------");
                    System.out.println("1.Xuất danh sách đang chỉnh sửa.");
                    System.out.println("2.Thêm sự kiện vào danh sách.");
                    System.out.println("3.Sửa sự kiện theo mã.");
                    System.out.println("4.Xóa sự kiện theo mã.");
                    System.out.println("5.Tìm sự kiện.");
                    System.out.println("6.Ghi file.");
                    System.out.println("7.Thống kê danh sách đang chỉnh sửa");
                    System.out.println("8.Thoát.");
                    int c;
                    do {
                        System.out.printf("Nhập lựa chọn : ");
                        c = sc.nextInt();
                        sc.nextLine();
                        if (c < 1 || c > 8)
                            System.out.println("Nhập lựa chọn từ 1->8 !! ");
                    } while (c < 1 || c > 8);

                    if (c == 1)
                        DSsk.Xuat();


                    else if ( c == 2)
                        DSsk.Them();

                    else if (c== 3)
                        DSsk.Sua();

                    else if ( c== 4)
                        DSsk.Xoa();

                    else if(c==5)
                        DSsk.TimKiem();


                    else if(c==6) {
                        DSsk.ghiFile();
                    }

                    else if (c==7)
                        DSsk.ThongKe(1);


                    else {
                        System.out.println("Lưu ý : Nhớ ghi file !!! ");
                        System.out.println("1.Ghi file rồi thoát.");
                        System.out.println("2.Thoát.");
                        System.out.println("3.Quay trở lại.");
                        int exit;
                        do {
                            System.out.println("");
                            exit = sc.nextInt(); sc.nextLine();
                        }while (exit < 1 || exit > 3  );

                        if (exit == 1 )
                        {
                            DSsk.ghiFile();
                            break;
                        }
                        
                        else if (exit == 2)
                            break;
                        
                        else
                            System.out.println("\n Quay trở lại \n------------------------------------");

                    }
                }
            }

            else
                return;
        }
    }

}
