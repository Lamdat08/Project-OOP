package Project_OOP;

import java.util.Scanner;

public class QuanLyKhachHang {

    static Scanner sc = new Scanner(System.in);

    DanhSachKhachHang dskh = new DanhSachKhachHang();

    public void menuQLKH() {
        System.out.println("\n---------Quản lý danh sách khách hàng---------");
        System.out.println("1 - Đọc file.");
        System.out.println("2 - Thống kê từ file.");
        System.out.println("3 - Các thao tác khác.");
        System.out.println("4 - Thoát quản lý danh sách khách hàng.");
    }
    public static void menuKhachHang() {
        System.out.println("\n --------Menu các thao tác quản lý danh sách khách hàng---------");
        System.out.println("1 - Xuất danh sách khách hàng đang chỉnh sửa.");
        System.out.println("2 - Thêm khách hàng vào danh sách.");
        System.out.println("3 - Sửa khách hàng theo mã khách hàng.");
        System.out.println("4 - Xóa khách hàng theo mã.");
        System.out.println("5 - Tìm khách hàng.");
        System.out.println("6 - Ghi file.");
        System.out.println("7 - Thống kê danh sách khách hàng.");
        System.out.println("8 - Thoát menu các thao tác quản lý khách hàng.");
    }
    public void menuThoat() {
        System.out.println("Lưu ý: Nhớ ghi file !");
        System.out.println("1 - Ghi file rồi thoát.");
        System.out.println("2 - Thoát.");
        System.out.println("3 - Quay trở lại.");
    }
    public void menuQuanLyKhachHang() {
        while (true) {
            int luaChon1;
            while (true) {
                try {
                    menuQLKH();
                    System.out.println("Nhập lựa chọn quản lý khách hàng từ 1 - 4");
                    luaChon1 = Integer.parseInt(sc.nextLine());
                    break;
                }
                catch (NumberFormatException e) {
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại: ");
                }
            }
            String inputLuaChon1 = Integer.toString(luaChon1);
            String regex1 = "^[1-4]$";
            while (!inputLuaChon1.matches(regex1)) {
                menuKhachHang();
                System.out.println("Không có lựa chọn này, vui lòng nhập lại các lựa chọn từ 1 - 4: ");
                luaChon1 = Integer.parseInt(sc.nextLine().trim());
                inputLuaChon1 = Integer.toString(luaChon1);
            }
            if (luaChon1 == 1) {
                DanhSachKhachHang.docFile();
            } else if (luaChon1 == 2) {
                dskh.thongKeKhachHang();
            } else if (luaChon1 == 3) {
                while (true) {
                    int luaChon2;
                    while (true) {
                        try {
                            menuKhachHang();
                            System.out.println("Nhập lựa chọn thao tác từ 1 - 8");
                            luaChon2 = Integer.parseInt(sc.nextLine().trim());
                            break;
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại: ");
                        }
                    }
                    String inputLuaChon2 = Integer.toString(luaChon2);
                    String regex2 = "^[1-8]$";
                    while (!inputLuaChon2.matches(regex2)) {
                        menuKhachHang();
                        System.out.println("Không có lựa chọn này, vui lòng nhập lại các lựa chọn từ 1 - 8: ");
                        luaChon2 = Integer.parseInt(sc.nextLine().trim());
                        inputLuaChon2 = Integer.toString(luaChon2);
                    }

                    if (luaChon2 == 1) {
                        dskh.Xuat();
                    } else if (luaChon2 == 2) {
                        dskh.Them();
                    } else if (luaChon2 == 3) {
                        dskh.Sua();
                    } else if (luaChon2 == 4) {
                        dskh.Xoa();
                    } else if (luaChon2 == 5) {
                        dskh.TimKiem();
                    } else if (luaChon2 == 6) {
                        dskh.ghiFile();
                    } else if (luaChon2 == 7) {
                        dskh.thongKeKhachHang();
                    } else {
                        int exit;
                        while (true) {
                            try {
                                menuKhachHang();
                                System.out.println("Nhập lựa chọn từ 1 - 3");
                                exit = Integer.parseInt(sc.nextLine().trim());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại: ");
                            }
                        }
                        String inputExit = Integer.toString(exit);
                        String regexExit = "^[1-3]$";
                        while (!inputExit.matches(regexExit)) {
                            menuThoat();
                            System.out.println("Không có lựa chọn này, vui lòng nhập lại các lựa chọn từ 1 - 3: ");
                            exit = Integer.parseInt(sc.nextLine());
                            inputExit = Integer.toString(exit);
                        }

                        if (exit == 1) {
                            dskh.ghiFile();
                            System.out.println("Thoát menu các thao tác quản lý khách hàng.");
                            break;
                        } else if (exit == 2) {
                            System.out.println("Thoát menu các thao tác quản lý khách hàng.");
                            break;
                        } else {
                            System.out.println("\n Quay trở lại \n----------------------------------");
                        }
                    }
                }
            } else {
                System.out.println("Thoát quản lý danh sách khách hàng.");
                return;
            }
        }
    }
}
