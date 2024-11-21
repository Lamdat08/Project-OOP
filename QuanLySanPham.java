package Project_OOP;

import java.util.Scanner;

public class QuanLySanPham {

    static Scanner sc = new Scanner(System.in);

    DanhSachSanPham dssp = new DanhSachSanPham();

    public void menuQLSP(){
        System.out.println("\n --------Quản lý danh sách sản phẩm---------");
        System.out.println("1.Đọc file.");
        System.out.println("2.Thống kê từ file.");
        System.out.println("3.Các thao tác khác.");
        System.out.println("4.Thoát quản lý danh sách sản phẩm.");
    }
    public void menuSanPham(){
        System.out.println("\n --------Menu các thao tác quản lý sản phẩm---------");
        System.out.println("1.Tạo danh sách mới và nhập");
        System.out.println("2.Xuất danh sách sản phẩm.");
        System.out.println("3.Thêm sản phẩm vào danh sách.");
        System.out.println("4.Sửa sản phẩm theo mã.");
        System.out.println("5.Xóa sản phẩm theo mã.");
        System.out.println("6.Tìm sản phẩm.");
        System.out.println("7.Đọc file.");
        System.out.println("8.Ghi file.");
        System.out.println("9.Thống kê danh sách sản phẩm");
        System.out.println("10.Thoát menu các thao tác quản lý sản phẩm.");
    }
    public void menuThoat(){
        System.out.println("1.Ghi file rồi thoát.");
        System.out.println("2.Thoát.");
    }
    public void menuQuanLySanPham(){
        while(true){
            menuQLSP();
            System.out.print("Nhập lựa chọn : ");
            int luaChon1 = Integer.parseInt(sc.nextLine());
            while(luaChon1 < 1 || luaChon1 > 4){
                menuQLSP();
                System.out.println("Không có lựa chọn này, vui lòng nhập lại các lựa chọn từ 1 - 4: ");
                luaChon1 = Integer.parseInt(sc.nextLine());
            }
            switch (luaChon1) {
                case 1:
                    dssp.docFile();
                    break;

                case 2:
                    dssp.Xuat(); //Thống kê chưa xong
                    break;

                case 3:
                    while(true){
                        menuSanPham();
                        System.out.print("Nhập lựa chọn : ");
                        int luaChon2 = Integer.parseInt(sc.nextLine());
                        while(luaChon2 < 1 || luaChon2 > 10){
                            menuQLSP();
                            System.out.println("Không có lựa chọn này, vui lòng nhập lại các lựa chọn từ 1 - 4: ");
                            luaChon2 = Integer.parseInt(sc.nextLine());
                        }
                        switch (luaChon2){
                            case 1:
                                dssp.Nhap();
                                break;
                            case 2:
                                dssp.Xuat();
                                break;
                            case 3:
                                dssp.Them();
                                break;
                            case 4:
                                dssp.Sua();
                                break;

                            case 5:
                                dssp.Xoa();
                                break;

                            case 6 :
                                dssp.TimKiem();
                                break;

                            case 7 :
                                dssp.docFile();
                                break;

                            case 8 :
                                dssp.ghiFile();
                                break;

                            case 9:
                                System.out.println("1. Thống kê danh sách sản phẩm hiện tại");
                                System.out.println("2. Thống kê danh sách");

                                System.out.print("Nhập lựa chọn : ");
                                int luaChonThongKe = Integer.parseInt(sc.nextLine());
                                while(luaChonThongKe < 1 || luaChonThongKe > 4){
                                    menuQLSP();
                                    System.out.println("Không có lựa chọn này, vui lòng nhập lại các lựa chọn từ 1 - 4: ");
                                    luaChonThongKe = Integer.parseInt(sc.nextLine());
                                }
                                dssp.thongKeSanPham(luaChonThongKe);
                                break;

                            case 10 :
                                menuThoat();
                                System.out.print("Nhập lựa chọn: ");
                                int exit = Integer.parseInt(sc.nextLine());
                                while(exit < 1 || exit > 2){
                                    menuThoat();
                                    System.out.println("Không có lựa chọn này, vui lòng nhập lại các lựa chọn từ 1 - 4: ");
                                    exit = Integer.parseInt(sc.nextLine());
                                }
                                if(exit == 1){
                                    dssp.ghiFile();
                                    System.out.println("Thoát menu các thao tác quán lý sản phẩm.");
                                    break;
                                }
                                if(exit == 2){
                                    System.out.println("Thoát menu các thao tác quán lý sản phẩm.");
                                    break;
                                }
                        }
                        break;
                    }
                case 4:
                    System.out.println("Thoát quản lý danh sách sản phẩm.");
                    return;
            }
        }
    }
}
