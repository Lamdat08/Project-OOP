package Project_OOP;

public interface IThaoTac {
    String regNumbers = "[0-9]+";
    String regexLetters = "^[a-zA-ZÀ-ỹ\\s]+$";
    String regDoubleNums = "^[+-]?([0-9]*[.])?[0-9]+([eE][+-]?[0-9]+)?$";

    public void Nhap();
    public void Xuat();
    public void Sua();
}




