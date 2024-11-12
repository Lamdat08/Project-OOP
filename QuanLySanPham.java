package Project_OOP;

import java.util.Scanner;

public class QuanLySanPham {

    static Scanner sc = new Scanner(System.in);

    public void menuSanPham(){
        System.out.println("1 - Xuat san pham");
        System.out.println("2 - Sua san pham");
        System.out.println("3 - Ghi file san pham");
        System.out.println("4 - Doc file san pham");
        System.out.println("5 - Tim kiem san pham");
        System.out.println("6 - Them san pham");
        System.out.println("7 - Xoa san pham");
        System.out.println("8 - Thoat");
    }

    public void menuQuanLySanPham(){
        menuSanPham();
        DanhSachSanPham dssp = new DanhSachSanPham();
        dssp.Nhap();
        while(true){
            int luaChon = Integer.parseInt(sc.nextLine());
            while(luaChon < 1 || luaChon > 8){
                menuSanPham();
                System.out.println("Khong co lua chon nay, moi nhap lai: ");
                luaChon = Integer.parseInt(sc.nextLine());
            }
            if(luaChon == 1){
                dssp.Xuat();
            }
            if(luaChon == 2){
                dssp.Sua();
            }
            if(luaChon == 3){
                dssp.ghiFile();
            }
            if(luaChon == 4){
                dssp.docFile();
            }
            if(luaChon == 5){
                dssp.TimKiem();
            }
            if(luaChon == 6){
                dssp.Them();
            }
            if(luaChon == 7){
                dssp.Xoa();
            }
            if(luaChon == 8){
                break;
            }
        }
    }
}
