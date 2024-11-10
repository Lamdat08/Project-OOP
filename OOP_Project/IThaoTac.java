package SGU_OOP_Excercises.OOP_Project;

public interface IThaoTac {

    public abstract void Nhap();
    public abstract void Xuat();
    public abstract void Sua();
}

interface IThaoTac_2 extends IThaoTac {

    void xoa();
    void them();
    void TimKiem();
    void docFile();
    void ghiFile();
    
}
