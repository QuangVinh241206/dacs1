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
public class NhanVien {

    private int MaNV, GioiTinh;
    private String TenNV, SDT, Email;
    private Date NgaySinh;

    public NhanVien(int MaNV, int GioiTinh, String TenNV, String SDT, String Email, Date NgaySinh) {
        this.MaNV = MaNV;
        this.GioiTinh = GioiTinh;
        this.TenNV = TenNV;
        this.SDT = SDT;
        this.Email = Email;
        this.NgaySinh = NgaySinh;
    }

    public NhanVien() {
    }

    public NhanVien(int GioiTinh, String TenNV, String SDT, String Email, Date NgaySinh) {
        this.GioiTinh = GioiTinh;
        this.TenNV = TenNV;
        this.SDT = SDT;
        this.Email = Email;
        this.NgaySinh = NgaySinh;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaMV) {
        this.MaNV = MaMV;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
}
