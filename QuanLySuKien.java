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
            int b = 0;
            boolean validInput= false;
            while (!validInput)
            {
                try {
                    System.out.printf("Nhập lựa chọn : ");
                    b = Integer.parseInt(sc.nextLine());

                    if ( b < 1 || b > 4) {
                        validInput = false;
                        System.out.println("Vui lòng nhập từ 1 -> 4");
                    }
                    else
                        validInput = true;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
             x = b;
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
                    int c = 0;
                    boolean validInput2= false;
                    while (!validInput2)
                    {
                        try {
                            System.out.printf("Nhập lựa chọn : ");
                            c = Integer.parseInt(sc.nextLine());

                            if ( c < 1 || c > 8) {
                                validInput2 = false;
                                System.out.println("vui lòng nhập lựa chọn từ 1 -> 8");
                            }
                            else
                                validInput2 = true;
                        } catch (Exception e) {
                            System.out.println("Vui lòng chỉ nhập số !");
                        }
                    }

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
                        int exit = 0;
                        boolean validInput3= false;
                        while (!validInput3)
                        {
                            try {
                                System.out.printf("Nhập lựa chọn : ");
                                exit = Integer.parseInt(sc.nextLine());

                                if ( exit < 1 || exit > 3) {
                                    validInput3 = false;
                                    System.out.println("vui lòng nhập lựa chọn từ 1 -> 3");
                                }
                                else
                                    validInput3 = true;
                            } catch (Exception e) {
                                System.out.println("Vui lòng chỉ nhập số !");
                            }
                        }

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
