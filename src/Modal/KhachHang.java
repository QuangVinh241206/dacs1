/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

import java.sql.*;

/**
 *
 * @author vinhn
 */
public class KhachHang {
    private String TenKH, DiaChi, SDT;
    private int MaKH;
    private Date NgayThamGia;
    

    public KhachHang() {
    }

    public KhachHang(String DiaChi, String SDT, Date NgayThamGia, int MaKH) {
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.NgayThamGia = NgayThamGia;
        this.MaKH = MaKH;
    }

    public KhachHang(String TenKH, String DiaChi, String SDT, Date NgayThamGia, int MaKH) {
        this.TenKH = TenKH;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.NgayThamGia = NgayThamGia;
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Date getNgayThamGia() {
        return NgayThamGia;
    }

    public void setNgayThamGia(Date NgayThamGia) {
        this.NgayThamGia = NgayThamGia;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }
    
}
