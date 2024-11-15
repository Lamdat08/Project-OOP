package Project_OOP;

import java.util.Scanner;

public class QuanLySanPham {

    static Scanner sc = new Scanner(System.in);

    DanhSachSanPham dssp = new DanhSachSanPham();

    public void menuSanPham(){
        System.out.println("\n --------Quản lý danh sách sản phẩm---------");
        System.out.println("1.Tạo danh sách mới và nhập");
        System.out.println("2.Xuất danh sách.");
        System.out.println("3.Thêm sản phẩm vào danh sách.");
        System.out.println("4.Sửa sản phẩm theo mã.");
        System.out.println("5.Xóa sản phẩm theo mã.");
        System.out.println("6.Tìm sản phẩm.");
        System.out.println("7.Đọc file.");
        System.out.println("8.Ghi file.");
        System.out.println("9.Thoát.");
    }

    public void menuQuanLySanPham(){
        while(true){
            menuSanPham();
            System.out.printf("Nhập lựa chọn : ");
            int luaChon = Integer.parseInt(sc.nextLine());
            while(luaChon < 1 || luaChon > 9){
                menuSanPham();
                System.out.println("Không có lựa chọn này, mời nhập lại: ");
                luaChon = Integer.parseInt(sc.nextLine());
            }
            switch (luaChon) {
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

                case 9 :
                    System.out.println("Thoát quản lý sản phầm.");
                    return;
            }
        }
    }
}
