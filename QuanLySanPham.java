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
        System.out.println("1.Xuất danh sách sản phẩm đang chỉnh sửa.");
        System.out.println("2.Thêm sản phẩm vào danh sách.");
        System.out.println("3.Sửa sản phẩm theo mã.");
        System.out.println("4.Xóa sản phẩm theo mã.");
        System.out.println("5.Tìm sản phẩm.");
        System.out.println("6.Ghi file.");
        System.out.println("7.Thống kê danh sách sản phẩm");
        System.out.println("8.Thoát menu các thao tác quản lý sản phẩm.");
    }
    public void menuThoat(){
        System.out.println("Lưu ý: Nhớ ghi File !!!");
        System.out.println("1.Ghi file rồi thoát.");
        System.out.println("2.Thoát.");
        System.out.println("3.Quay trở lại.");
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
            if (luaChon1 == 1) {
                DanhSachSanPham.docFile();
            }
            else if (luaChon1 == 2) {
                dssp.thongKeSanPham(2);
            }
            else if (luaChon1 == 3) {
                while (true) {

                    menuSanPham();
                    System.out.print("Nhập lựa chọn : ");
                    int luaChon2 = Integer.parseInt(sc.nextLine());
                    while (luaChon2 < 1 || luaChon2 > 8) {
                        menuSanPham();
                        System.out.println("Không có lựa chọn này, vui lòng nhập lại các lựa chọn từ 1 - 8: ");
                        luaChon2 = Integer.parseInt(sc.nextLine());
                    }

                    if (luaChon2 == 1) {
                        dssp.Xuat();
                    }
                    else if (luaChon2 == 2) {
                        dssp.Them();
                    }
                    else if (luaChon2 == 3) {
                        dssp.Sua();
                    }
                    else if (luaChon2 == 4) {
                        dssp.Xoa();
                    }
                    else if (luaChon2 == 5) {
                        dssp.TimKiem();
                    }
                    else if (luaChon2 == 6) {
                        dssp.ghiFile();
                    }
                    else if (luaChon2 == 7) {
                        dssp.thongKeSanPham(1);
                    }
                    else{
                        menuThoat();
                        System.out.print("Nhập lựa chọn: ");
                        int exit = Integer.parseInt(sc.nextLine());
                        while (exit < 1 || exit > 3) {
                            menuThoat();
                            System.out.println("Không có lựa chọn này, vui lòng nhập lại các lựa chọn từ 1 - 4: ");
                            exit = Integer.parseInt(sc.nextLine());
                        }

                        if (exit == 1) {
                            dssp.ghiFile();
                            System.out.println("Thoát menu các thao tác quản lý sản phẩm.");
                            break;
                        }
                        else if (exit == 2) {
                            System.out.println("Thoát menu các thao tác quản lý sản phẩm.");
                            break;
                        }
                        else{
                            System.out.println("\n Quay trở lại \n------------------------------------");
                        }
                    }
                }
            }
            else{
                System.out.println("Thoát quản lý danh sách sản phẩm.");
                return;
            }
        }
    }
}
