package QuanLyThuVienGame.models;

import java.io.Serializable;

public class Game implements Serializable {
    private String ten;
    private String theLoai;
    private String dungLuong;
    private int namSanXuat;
    private String nhaPhatHanh;
    private double gia;

    public Game() {
    }

    public Game(String ten, String theLoai, String dungLuong, int namSanXuat, String nhaPhatHanh, double gia) {
        this.ten = ten;
        this.theLoai = theLoai;
        this.dungLuong = dungLuong;
        this.namSanXuat = namSanXuat;
        this.nhaPhatHanh = nhaPhatHanh;
        this.gia = gia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(String dungLuong) {
        this.dungLuong = dungLuong;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getNhaPhatHanh() {
        return nhaPhatHanh;
    }

    public void setNhaPhatHanh(String nhaPhatHanh) {
        this.nhaPhatHanh = nhaPhatHanh;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Game{" +
                "Tên ='" + ten + '\'' +
                ", Thể loại='" + theLoai + '\'' +
                ", Dung lượng='" + dungLuong + '\'' +
                ", Năm sản xuất=" + namSanXuat +
                ", Nhà phát hành='" + nhaPhatHanh + '\'' +
                ", Giá=" + gia +
                '}';
    }
}
